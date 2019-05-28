package mum.edu.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.controller.Controller;

public class LoadServletProperties {
	
 	Map<String, Controller> controllers = new HashMap<String, Controller>();

 	/*
 	 * handlers - Map of controllers based on URL[s] - from @RequestMapping on METHODS
 	 * handlerMethods - Map of controller methods based on URL[s] - from @RequestMapping on METHODS
 	 */
	public void loadControllers(String configFile, Map<String, Controller> handlers,
			Map<String, ControllerMethod> handlerMethods) {

		SequencedProperties prop = new SequencedProperties();
		InputStream input = null;
		try {

			// Use ClassLoader to search all of classpath
			input = getClass().getClassLoader().getResourceAsStream(configFile);
			if (input == null) {
				System.out.println("Unable to find " + configFile);
				return;
			}

			// load a properties file from class path
			prop.load(input);

			// Enumerate through Controllers, Then Handlers, then HandlerMethods...
			Controller controller = null;

			String type = null;
			Enumeration enumeration = prop.keys();
			while (enumeration.hasMoreElements()) {
				String key = (String) enumeration.nextElement();

				if (prop.get(key).equals("Start")) {
					type = key;
					continue;
				}

				if (type.equals("Controllers")) {
					controller = getControllerInstance((String) prop.get(key));
					controllers.put(key, controller);
				} else if (type.equals("Handlers")) {
					controller = controllers.get((String) prop.get(key));
					handlers.put(key, controller);
				} else if (type.equals("Methods")) {
					String temp = (String) prop.get(key);
					key = key.substring(1);
					ControllerMethod controllerMethod = getMethodDetails(controller, temp);
					handlerMethods.put(key, controllerMethod);
				}

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return;
	}

	Controller getControllerInstance(String controllerName) {

		Controller controller = null;

		try {
			// using the Reflection API get the class(forName); get the default Constructor;
			// create an instance...
			// TODO: Looks like Factory [Method} Pattern - Should it be "Formalized"
			controller = (Controller) Class.forName(controllerName).getConstructor().newInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (controller);

	}
 	
	/*
	 *  Get Controller method parameters
	 *  Look up based on Method name
	 *  Store method & parameters & domani object getters/setters in ControllerMethod object
	 *  Assumes parameters are:
	 *      Request
	 *      Response
	 *      & optional domain object
	 */
  
	private static ControllerMethod getMethodDetails(Controller controller, String methodName) {
		ControllerMethod controllerMethod = new ControllerMethod();

		// Reflection: get methods
		Method[] methods = controller.getClass().getMethods();

		for (Method method : methods) {
			System.out.println(method.getName() + "-----");

			if (method.getName().equals(methodName)) {

				controllerMethod.setMethod(method);

				for (int i = 0; i < method.getParameterTypes().length; i++) {
					Class<?> paramClass = method.getParameterTypes()[i];
					System.out.println(paramClass.getName());

					if (paramClass == HttpServletRequest.class) {
						controllerMethod.getParams().put("request", "true");
					} else if (paramClass == HttpServletResponse.class) {
						controllerMethod.getParams().put("response", "true");
					} else {
						// Save extra parameter as this is our domain object ASSUMES: ONLY ONE
						Object domainObject = null;
						try {
							domainObject = paramClass.getConstructor().newInstance();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						controllerMethod.getParams().put("domainObject", domainObject); //only one domainobject

						Map<String, Method> domainObjectSetters = controllerMethod.getDomainObjectSetters();
						for (Method domainMethod : domainObject.getClass().getMethods()) {
							if (domainMethod.getName().startsWith("set")) {
								String name = domainMethod.getName().substring("set".length());
								name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
								System.out.println(name + "****" + domainMethod.getName());
								domainObjectSetters.put(name, domainMethod);
							}
						}
						
//						domainObjectSetters.forEach((k, v) -> System.out.println(k + ", " + v)); 

					}
				}

				return controllerMethod;

			}
		}
		return null;

	}
}