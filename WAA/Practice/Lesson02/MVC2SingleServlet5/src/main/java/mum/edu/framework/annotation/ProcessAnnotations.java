package mum.edu.framework.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.framework.ControllerMethod;
import mum.edu.framework.factory.DomainObjectFactory;
import mum.edu.framework.factory.InjectionFactory;

public class ProcessAnnotations {

	/*
	 * Loop through Package List of Controllers looking for Annotations [@Autowired,@RequestMapping]
	 * Save as handler based on URL from @RequestMapping
	 */
	public static void handleAnnotations(Map<String,Object> packageControllers, Map<String,Object> handlers, Map<String, ControllerMethod> handlerMethods) {
		
		Set<String> keys = (Set<String>) packageControllers.keySet();
		
		for ( String key : keys) {
			
			Object possibleController = packageControllers.get(key);
 			
			// Check to actually see if it is a Controller
			// if NOT ignore
 			if (!possibleController.getClass().isAnnotationPresent(mum.edu.framework.annotation.Controller.class)) {
				packageControllers.remove(key);
				continue;
			}
			
			Object controller =   possibleController;
			//Request Mapping annotation
			Method[] methods = controller.getClass().getMethods();
			
			for (Method method : methods) {
				if(method.isAnnotationPresent(RequestMapping.class)){
					RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
					 
						String[] uriList = requestMapping.value();
 						
						ControllerMethod controllerMethod = getMethodDetails(method);
						
 						for (String uri : uriList) {
		    		    	handlers.put(uri, controller);
		    		    	
						    handlerMethods.put(uri, controllerMethod);
						}
						
				}
			}
			
			// If Autowired, Create instance of Object and set it in Controller
			Field[] fields = controller.getClass().getDeclaredFields();	    
			for (Field field : fields) {
 					AutoWired dependency =   field.getAnnotation(AutoWired.class);
					if (dependency != null) {
						try {
							Class<?> fieldClass =	field.getType();
							Object setter =  InjectionFactory.getInstance(fieldClass.getName());
 							field.setAccessible(true);
							field.set(controller,setter);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
 			}

		}
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

	private static ControllerMethod  getMethodDetails(Method method) {
		ControllerMethod controllerMethod = new ControllerMethod();
		controllerMethod.setMethod(method);
		
	    for (int i = 0; i < method.getParameterTypes().length; i ++) {
	         Class<?> paramClass = method.getParameterTypes()[i];
	  
	         if (paramClass == HttpServletRequest.class) {
	        	 controllerMethod.getParams().put("request", "true");
	         }
	         else if (paramClass == HttpServletResponse.class) {
	        	 controllerMethod.getParams().put("response", "true");
	         }
	         else {
	        	 // Save extra parameter as this is our domain object ASSUMES: ONLY ONE
	  			Object domainObject =  DomainObjectFactory.getInstance(paramClass);
	        	 controllerMethod.getParams().put("domainObject", domainObject);

	        	 Map<String,Method> domainObjectSetters = controllerMethod.getDomainObjectSetters();	
	        	 for(Method domainMethod : domainObject.getClass().getMethods()) {
	        		 if (domainMethod.getName().startsWith("set")) {
						String name = domainMethod.getName().substring("set".length());
 		        		name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
	
		        		domainObjectSetters.put(name, domainMethod);
	        		 }
				}

	        	 
	         }
	     }

		
		return controllerMethod;
	}
}
