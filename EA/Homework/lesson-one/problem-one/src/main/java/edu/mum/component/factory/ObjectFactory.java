package edu.mum.component.factory;

import edu.mum.component.MessageSource;

public class ObjectFactory {

	private ObjectFactory() {
		
	}
 
 	public static final Object getInstance(String className) {
		Object classObject = null;
 		
 		try {
 			// using the Reflection API get the class(forName); get the default Constructor; create an instance...
 			classObject =  Class.forName(className).getConstructor().newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (classObject);
 			

 	}
}
