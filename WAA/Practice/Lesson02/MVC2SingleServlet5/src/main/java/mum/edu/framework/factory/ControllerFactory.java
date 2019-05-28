package mum.edu.framework.factory;

public class ControllerFactory {

	private ControllerFactory() {
		
	}
	/**
	 * Automatically a "singleton" as DispatcherServlet is ONLY one to call it
	 * @param controllerName
	 * @return
	 */

 	public static final Object getInstance(String controllerName) {
		Object controller = null;
 		
 		try {
 			// using the Reflection API get the class(forName); get the default Constructor; create an instance...
  			controller =   Class.forName(controllerName).getConstructor().newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (controller);
 			

 	}
}
