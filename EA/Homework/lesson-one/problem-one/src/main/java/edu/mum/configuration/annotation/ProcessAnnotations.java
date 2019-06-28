package edu.mum.configuration.annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class ProcessAnnotations {

	/*
	 * Loop through Managed Components/beans looking for Annotations [@Autowired)
	 */
	public static void handleAnnotations(Map<String,Object> beans ) {
		
		Set<String> keys = (Set<String>) beans.keySet();
		
		for ( String key : keys) {
			
			Object bean = beans.get(key);
			
			Field[] fields = bean.getClass().getDeclaredFields();	    
			for (Field field : fields) {

				// If Autowired exists, get instance of dependency from Map of managed beans  and inject it!

				if (field.isAnnotationPresent(AutoWired.class)) {
						 AutoWired dependency =   field.getAnnotation(AutoWired.class);

						if (dependency != null) {
							try {
								Class<?> fieldClass =	field.getType();
								
								// Just want component/class name WITHOUT package
								String simpleName = fieldClass.getName();							
								simpleName = simpleName.substring(simpleName.lastIndexOf(".") + 1);
								
								// get it from Map of managed beans...
								Object setter = beans.get(simpleName) ;
										
								// INJECT it!!!
	 							field.setAccessible(true);
								field.set(bean,setter);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
				}
			}

		}
	}
}
