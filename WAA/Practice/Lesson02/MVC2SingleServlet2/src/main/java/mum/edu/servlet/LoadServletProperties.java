package mum.edu.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import mum.edu.controller.Controller;

public class LoadServletProperties {

	String fileName;

	LoadServletProperties(String fileName) {
		this.fileName = fileName;
	}

	public Map<String, Controller> loadControllers() {

		Properties properties = new Properties();
		InputStream input = null;

		Map<String, Controller> dispatchControllers = new HashMap<String, Controller>();

		try {

			// Use ClassLoader to find resource...
			input = getClass().getClassLoader().getResourceAsStream(fileName);
			if (input == null) {
				System.out.println("Unable to find " + fileName);
				return null;
			}

			// load in properties file data
			properties.load(input);

			Enumeration enumeration = properties.keys();
			while (enumeration.hasMoreElements()) {
				String key = (String) enumeration.nextElement();

				Controller controller = getControllerInstance((String) properties.get(key));
				dispatchControllers.put(key, controller);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dispatchControllers;
	}

	Controller getControllerInstance(String controllerName) {

		Controller controller = null;
		

		try {
			// using the Reflection API get the class(forName); get the default Constructor;
			// create an instance...
			controller = (Controller) Class.forName(controllerName).getConstructor().newInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (controller);

	}

}