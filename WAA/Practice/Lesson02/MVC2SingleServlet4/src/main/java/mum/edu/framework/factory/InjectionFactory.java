package mum.edu.framework.factory;


public class  InjectionFactory {

	private InjectionFactory() {
		
	}
	/**
	 * Should use Singleton Pattern
 	 * Assumes CoC - the implementation name is an "extension" of the interface name
 	 * Also Assumes Interface & implementation are in same package
	 * @param dependencyObjectName
	 * @return
	 */

 	public static final Object getInstance(String interfaceName) {
		Object dependencyObject = null;
 		
		String classImplName = interfaceName + "Impl";
		System.out.println("classImplName: " + classImplName);

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
