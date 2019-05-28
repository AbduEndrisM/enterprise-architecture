package mum.edu.framework.factory;


public class  InjectionFactory {

	private InjectionFactory() {
		
	}
	/**
	 * Should use  Singleton pattern
 	 * Assumes CoC - the implementation name is an "extension" of the interface name
 	 * Also Assumes Interface & implementation are in same package
	 * @param interfaceName
	 * @return
	 */

 	public static final Object getInstance(String interfaceName) {
		Object dependencyObject = null;
 		
		String classImplName = interfaceName + "Impl";

 		try {
 			// using the Reflection API get the class(forName); get the default Constructor; create an instance...
 			dependencyObject = (Object)  Class.forName(classImplName).getConstructor().newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (dependencyObject);
 			

 	}
}
