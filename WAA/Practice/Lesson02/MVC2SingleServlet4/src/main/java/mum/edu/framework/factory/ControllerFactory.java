package mum.edu.framework.factory;

import mum.edu.framework.controller.Controller;

public class ControllerFactory {

	private ControllerFactory() {
		
	}
	/**
	 * Automatically a "singleton" as HandlerServlet is ONLY one to call it
	 * @param controllerName
	 * @return
	 */

 	public static final Controller getInstance(String controllerName) {
		Controller controller = null;
 		
 		try {
 			// using the Reflection API get the class(forName); get the default Constructor; create an instance...
  			controller = (Controller)  Class.forName(controllerName).getConstructor().newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (controller);
 			

 	}
}
