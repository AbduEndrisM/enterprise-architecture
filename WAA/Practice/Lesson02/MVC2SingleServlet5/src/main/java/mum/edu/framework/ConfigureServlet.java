package mum.edu.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import mum.edu.framework.annotation.ProcessAnnotations;
import mum.edu.framework.factory.ControllerFactory;

public class ConfigureServlet {
	
	// Map of controllers based on key of controller name
	// extracted from package
 	Map<String, Object> packageControllers = new HashMap<String, Object>();

	/*
 	 * handlers - Map of controllers based on URL[s] - from @RequestMapping on METHODS
 	 * handlerMethods - Map of controller methods based on URL[s] - from @RequestMapping on METHODS
 	 */
	  public void  loadControllers(String configFile,Map<String, Object> handlers,Map<String, ControllerMethod> handlerMethods) {
			 
		  	SequencedProperties properties = new SequencedProperties();
	    	InputStream input = null;
 	    	try {
	 
 	    		// Use ClassLoader to search all of classpath
	    		input = getClass().getClassLoader().getResourceAsStream(configFile);
 	    		if(input==null){
	    	            System.out.println("Unable to find " + configFile);
	    		    return;
	    		}
	 
		    		//load a properties file from class path
		    		properties.load(input);
		 
	 	    		// Enumerate through Controllers, Then handlers,  then handlerMethods...
  	    			
  	    			String type = null;
	    			Enumeration  enumeration = properties.keys();  
	    			while (enumeration.hasMoreElements()) {  
 	    				String key = (String) enumeration.nextElement();  
  
	    				if (properties.get(key).equals("Start")) {
	    					type = key;
	    					continue;
	    				}
	    					
		    		    if (type.equals("Controllers")) {
		    		 	  // Get list of controllers based on package name from properties file
		    		    	getControllers((String)properties.get(key),packageControllers);
		    		    }
/*		    		    else if (type.equals("handlers")) {
		    		    	controller = controllers.get((String)properties.get(key));
		    		    	handlers.put(key, controller);
		    		    }
		    		    else if (type.equals("Methods")) {
	 	    		    	String temp = (String) properties.get(key);
		    		    	key = key.substring(1);
		    		    	handlerMethods.put(key, temp);
		    		    }
*/
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
 	    	ProcessAnnotations.handleAnnotations(packageControllers,handlers,handlerMethods);
    	
	    	return ;
	  }

	  /*
	   * Get list of controllers based on package name from properties file
	   */
	  void getControllers(String pckgname,Map<String, Object> packageControllers) {
		  try{
 		      // Get a File object for the package 
		      File directory=null; 
		      try { 
		        directory=new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile()); 
		      } catch(NullPointerException x) { 
 		        throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
		      } 
 
		      
		      // Get the list of the files contained in the package 
		        String[] files=directory.list(); 
		        for(int i=0; i<files.length; i++) { 
				  // we are only interested in .class files 
				  if(files[i].endsWith(".class")) { 
				    // removes the .class extension 
					String key =   files[i].substring(0, files[i].length()-6);
					
					// Load up the controller Map
    		    	Object controller = ControllerFactory.getInstance(pckgname+'.'+ key);
    		    	packageControllers.put(key, controller);

 				    
				  } 
		        } 
		        
 		        return;
		        
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
	  }	  

}