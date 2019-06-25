package edu.mum.configuration;

import java.util.HashMap;
import java.util.Map;

import edu.mum.component.factory.ObjectFactory;
import edu.mum.component.impl.HelloWorldMessageSource;
import edu.mum.component.impl.StandardOutMessageDisplay;

public class ConfigInMemory {

	// Singleton Instance
	private static final ConfigInMemory instance = new ConfigInMemory();

 	Map<String, Object> beans = new HashMap<String, Object>();
 	
    // PRIVATE constructor -  No other classes can create an instance...
    private ConfigInMemory() {

    	// HARD Code the "managed" beans
    	StandardOutMessageDisplay standardOutMessageDisplay = new StandardOutMessageDisplay();
    	HelloWorldMessageSource helloWorldMessageSource = new HelloWorldMessageSource();
    	// Manually DI
    	standardOutMessageDisplay.setMessageSource(helloWorldMessageSource);
    	
    	beans.put("MessageDisplay", standardOutMessageDisplay);
    	beans.put("MessageSource", helloWorldMessageSource);
    }
    
    // Access Singleton instance
    public static ConfigInMemory getInstance() {
        return instance;
    }
    
    public Object getBean(String key) {
        return beans.get(key);
    }
}
