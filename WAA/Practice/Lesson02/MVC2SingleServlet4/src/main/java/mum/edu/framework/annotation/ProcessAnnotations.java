package mum.edu.framework.annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import mum.edu.framework.controller.Controller;
import mum.edu.framework.factory.InjectionFactory;

public class ProcessAnnotations {

	/*
	 * Loop through Controllers looking for Annotations [@Autowired)
	 */
	public static void handleAnnotations(Map<String, Controller> controllers) {

		Set<String> keys = (Set<String>) controllers.keySet();

		for (String key : keys) {
			System.out.println(key + "=================");

			Controller controller = controllers.get(key);

			Field[] fields = controller.getClass().getDeclaredFields();
			for (Field field : fields) {

				// If Autowired, Create instance of Object and set it in Controller

				if (field.isAnnotationPresent(AutoWired.class)) {
					AutoWired dependency = field.getAnnotation(AutoWired.class);

					if (dependency != null) {
						try {
							Class<?> fieldClass = field.getType();
							System.out.println("fieldClass: " + fieldClass.getName());
							Object setter = InjectionFactory.getInstance(fieldClass.getName());
							field.setAccessible(true);
							field.set(controller, setter);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
	}
}
