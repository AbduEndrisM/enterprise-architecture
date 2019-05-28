package mum.edu.framework;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
    
    private static final long serialVersionUID = 98279L;

	Map<String, Object> handlers = new HashMap<String, Object>();
	Map<String, ControllerMethod> handlerMethods = new HashMap<String, ControllerMethod>();


    @Override
    public void init( ) throws ServletException {
 
    	String configFile = getServletConfig().getInitParameter("configFile");
     	
      ConfigureServlet  loadServletProperties = new ConfigureServlet();
 	  loadServletProperties.loadControllers(configFile,handlers,handlerMethods);
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
         * uri is in this form: /contextName/resourceName, 
         * for example: /app10a/product_input. 
         * However, in the case of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /product_input
         */
         int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex); 
        String dispatchUrl = null;
 
        // Get controller based on URI [@RequestMapping]
         Object controller =   handlers.get(action);
 		// Get method details based on URI [@RequestMapping]
 		ControllerMethod controllerMethod = handlerMethods.get(action);

         try{ 
		
        	 // get the Method AND Method params from configuration Maps
        	 Method method = controllerMethod.getMethod();
 			 Map<String,Object> params = controllerMethod.getParams();
				
			// To be filled in with the parameters from request
			Object[] methodParams = new Object[method.getParameterTypes().length];
			
			// ORDER IS IMPORTANT [KLUDGE!!! we are taking a short cut by enforcing the order]
			int n = 0;
			if  (params.get("domainObject") != null) methodParams[n++] = params.get("domainObject");
			if  (params.get("request") != null) methodParams[n++] = request;
			if  (params.get("response") != null) methodParams[n++] = response;
	
	
	 	    // If it is a POST,  we want to BIND the request parameters to the Domain Object (e.g. Product)
	 	    if (request.getMethod().equals("POST"))  
	 	    		domainDataBinding(request,controllerMethod);
	
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

 void domainDataBinding(HttpServletRequest request, ControllerMethod controllerMethod) {
 		Method domainMethod = null;
	    Map<?, ?> parameterMap = request.getParameterMap();
	    Enumeration<?> parameterNames = request.getParameterNames();

	    Object domainObject = controllerMethod.getParams().get("domainObject");
	    Map<String,Method> domainObjectSetters = controllerMethod.getDomainObjectSetters();
	    
	    // Loop through all the request/form parameters
	    while (parameterNames.hasMoreElements()) {  
				String name = (String) parameterNames.nextElement();  
				
				// this "for example" would be the value of the form field, name,description OR price
				// in the case of the ProductForm.jsp
				Object[] value = (Object[])parameterMap.get(name);
			
					domainMethod = domainObjectSetters.get(name);

				// Might be a form field that has no setter...
				if (domainMethod != null)
				{
					// We have the domainMethod, for example, setName
					// Now, we need to determine the "arg" types 
					// we want to end up with setName (value)
					Class<?>[] parameterTypes  = domainMethod.getParameterTypes();
					
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
 	}
	
 
 }


