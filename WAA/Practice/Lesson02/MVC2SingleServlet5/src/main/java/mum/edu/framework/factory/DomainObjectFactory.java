package mum.edu.framework.factory;

 
public class DomainObjectFactory {

	private DomainObjectFactory() {
		
	}
 
 	public static final Object getInstance(Class domain) {
		Object domainObject = null;
 		
 		try {
 			// using the Reflection API; create an instance...
  			domainObject = (Object)  domain.newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (domainObject);
 			

 	}
}
