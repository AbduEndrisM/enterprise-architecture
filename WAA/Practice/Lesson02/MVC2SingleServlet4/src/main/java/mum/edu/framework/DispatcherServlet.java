package mum.edu.framework;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.framework.controller.Controller;
import mum.edu.framework.factory.DomainObjectFactory;

public class DispatcherServlet extends HttpServlet {
    
    private static final long serialVersionUID = 98279L;

 	Map<String, Controller> controllers = new HashMap<String, Controller>();
	Map<String, Controller> handlers = new HashMap<String, Controller>();
	Map<String, String> handlerMethods = new HashMap<String, String>();


    @Override
    public void init( ) throws ServletException {
 
    	String configFile = getServletConfig().getInitParameter("configFile");
     	
      ConfigureServlet  loadServletProperties = new ConfigureServlet();
 	  loadServletProperties.loadControllers(configFile,controllers,handlers,handlerMethods);
    }	
    
    
    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        /*
         * uri has this form
         * /resourceName, e.g.: /product_input
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex); 
        String dispatchUrl = null;
 
        // Get controller
         Controller controller =  (Controller) handlers.get(action);
         // Get method to invoke
     	String methodName = handlerMethods.get(action);
   	
	try{ 
		//TODO: Performance Consideration: 
		// Move as much Reflection to "Configuration" - LoadServletProperties  as possible
		
		// Find Controller method... ASSUMES: only one method with this name
 		Class classObject = controller.getClass();
		Method method = null;
		for(Method m : classObject.getMethods()) {
		    if (m.getName().equals(methodName)) {
		    	method = m;
 		    	break;
		    }
		}
		 
		// Get the parameters...ASSUMES if NOT HTTP arguments then create ONE...
		Object[] methodParams = new Object[method.getParameterTypes().length];
		int n = 0;
		// We will bind to the domain object on a POST
		Object domainObject = null;
	    for (int i = 0; i < method.getParameterTypes().length; i ++) {
	         Class<?> paramClass = method.getParameterTypes()[i];
	  
	         if (paramClass == HttpServletRequest.class) {
	        	 methodParams[n++] = request;
	         }
	         else if (paramClass == HttpServletResponse.class) {
	        	 methodParams[n++] = response;
	         }
	         else {
	        	 // Save extra parameter as this is our domain object ASSUMES: ONLY ONE
 	  			domainObject =  DomainObjectFactory.getInstance(paramClass);
 	        	methodParams[n++] = domainObject;
	         }
	     }
		
	    // If it is a POST,  we want to BIND the request parameters to the Domain Object (e.g. Product)
 	    if (request.getMethod().equals("POST"))  
 	    		domainDataBinding(request,domainObject);

 	    // call the controller method with the appropriate "args"
 	    // for example, productController.saveProduct(product,request,response)
 		dispatchUrl = (String) method.invoke(controller, methodParams);
	}
	catch (Exception e){
		//   System.out.println("BAD REQUEST: " + e.getMessage());  
	
	}
     
        // forward to a view
        if (dispatchUrl != null) {
            RequestDispatcher requestDispatcher = 
                    request.getRequestDispatcher(dispatchUrl);
            requestDispatcher.forward(request, response);
        }
    }
 
/*
 *  Takes the parameters from the form [ via the request object]
 *  and binds them to the domain object. "For Example", the fields from the
 *  the ProductForm.jsp would be mapped to mum.edu.domain.Product.
 */

 void domainDataBinding(HttpServletRequest request, Object domainObject) {
 		Method domainMethod = null;
	    Map parameterMap = request.getParameterMap();
	    Enumeration parameterNames = request.getParameterNames();

	    // Loop through all the request/form parameters
	    while (parameterNames.hasMoreElements()) {  
				String name = (String) parameterNames.nextElement();  
				
				// this "for example" would be the value of the form field, name,description OR price
				// in the case of the ProductForm.jsp
				Object[] value = (Object[])parameterMap.get(name);
				
					name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
					String domainObjectSetter = "set" + name;
		
					// Loop through domainObject Methods looking for Setter 
					// "for example" looking through Product for setName,SetDescription, setPrice
					Class<?>[] parameterTypes = null;
					for(Method m : domainObject.getClass().getMethods()) {
					    if (m.getName().equals(domainObjectSetter)) {
					    	domainMethod = m;
					    	break;
					    }
					}
					
					// We have the domainMethod, for example, setName
					// Now, we need to determine the "arg" types 
					// we want to end up with setName (value)
					parameterTypes = domainMethod.getParameterTypes();
					
					try{ 

						if (parameterTypes[0]  == String.class) {
							domainMethod.invoke(domainObject, value[0] );
						}
						else if (parameterTypes[0]  == Double.class) {
							String strVal = ((String)value[0]).trim();
							Double val = null;
							if (!strVal.isEmpty())  
							 	val = Double.valueOf(strVal);
							domainMethod.invoke(domainObject, val);
						}
						else if (parameterTypes[0]  == Integer.class) {
							String strVal = ((String)value[0]).trim();
							Integer val = null;
							if (!strVal.isEmpty())  
							 	val = Integer.valueOf(strVal);
							domainMethod.invoke(domainObject, val);
						}
					}
					catch (Exception e){
						   System.out.println("BAD Data Binding: " + e.getMessage());  
					}

		}
 	}
	
 
	void formDataBinding(HttpServletRequest request) {
		
		Object domainObject = request.getAttribute("model");
		Object formObject = null;
		String formName = domainObject.getClass().getName();
		formName = Character.toUpperCase(formName.charAt(0)) + formName.substring(1) + "Form";
		 try {
			formObject = Class.forName(formName).getConstructor().newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
		 // Loop through domain object - move to form object....
			Field[] domainfields = domainObject.getClass().getDeclaredFields();
			Field[] formfields = formObject.getClass().getDeclaredFields();

			for (Field domainField : domainfields) {
//				Class<?> domainFieldClass = domainField.getType();
				
				Field formField = null;
				for (Field fField : formfields) {
					if (domainField.getType().equals(fField.getType())) {
						formField = fField;
						break;
					}
				}

					
				try{ 

					if (domainField.getType()  == String.class) {
						formField.setAccessible(true); 
						formField.set(formObject, domainField.get(domainObject));
					}
					else if (domainField.getType()  == Double.class) {
						formField.setAccessible(true); 
						formField.setDouble(formObject,domainField.getDouble(domainObject)) ;
						}
				}
				catch (Exception e){
					   System.out.println("BAD Data Bindind: " + e.getMessage());  
				}


			}

		 
	}
 
 }


