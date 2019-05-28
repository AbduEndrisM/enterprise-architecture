package mum.edu.framework;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import mum.edu.framework.annotation.ProcessAnnotations;
import mum.edu.framework.controller.Controller;
import mum.edu.framework.factory.ControllerFactory;

public class ConfigureServlet {
	
	  public void  loadControllers(String configFile,Map<String, Controller> controllers,Map<String, Controller> handlers,Map<String, String> handlerMethods) {
			 
		  	SequencedProperties prop = new SequencedProperties();
	    	InputStream input = null;
 	    	try {
	 
 	    		// Use ClassLoader to search all of classpath
	    		input = getClass().getClassLoader().getResourceAsStream(configFile);
//	    		input = LoadServletProperties.class.getResourceAsStream(filename);
	    		if(input==null){
	    	            System.out.println("Unable to find " + configFile);
	    		    return;
	    		}
	 
		    		//load a properties file from class path
		    		prop.load(input);
		 
	 	    		// Enumerate through Controllers, Then Handlers,  then HandlerMethods...
  	    			Controller controller = null;
 	    			
  	    			String type = null;
	    			Enumeration  enumeration = prop.keys();  
	    			while (enumeration.hasMoreElements()) {  
 	    				String key = (String) enumeration.nextElement();  
  
	    				if (prop.get(key).equals("Start")) {
	    					type = key;
	    					continue;
	    				}
	    					
		    		    if (type.equals("Controllers")) {
		    		    	controller = ControllerFactory.getInstance((String)prop.get(key));
 		    		    	controllers.put(key, controller);
		    		    }
		    		    else if (type.equals("Handlers")) {
		    		    	controller = controllers.get((String)prop.get(key));
		    		    	handlers.put(key, controller);
		    		    }
		    		    else if (type.equals("Methods")) {
	 	    		    	String temp = (String) prop.get(key);
		    		    	key = key.substring(1);
		    		    	handlerMethods.put(key, temp);
		    		    }

	    			}  
	    	} catch (IOException e) {  
	    		   System.out.println(e.getMessage());  
	    	}  
 	        finally{
	        
	        	if(input!=null){
	        		try {
	        				input.close();
					    } catch (IOException e) {
					    	e.printStackTrace();
					  }
	        	}
	        }
	    	
 	    	
 	    	// Process Annotations
 	    	ProcessAnnotations.handleAnnotations(controllers);
    	
	    	return ;
	  }


 	
}