package edu.mum.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import edu.mum.component.MessageDisplay;
import edu.mum.component.MessageSource;
import edu.mum.component.factory.ObjectFactory;
import edu.mum.configuration.annotation.ProcessAnnotations;

/*
 * Implemented as a Singleton...
 */
public class MessageConfiguration {
    // Is invoked only once [since final] ... happens when we call getInstance() below
    private static final MessageConfiguration instance = new MessageConfiguration();

    Map<String, Object> beans = new HashMap<String, Object>();

    private Properties properties;

    // PRIVATE: No other classes can create an instance...
    private MessageConfiguration() {
        properties = new Properties();
        InputStream input = null;

        String fileName = "HelloWorld.properties";
        try {
            // Use ClassLoader to find resource...
            input = this.getClass().getClassLoader().getResourceAsStream(fileName);
            if (input == null) {
                System.out.println("Unable to find " + fileName);
                return;
            }
            //load in properties file data
            properties.load(input);
            // Enumerate through declared components
            Object bean = null;
            Enumeration enumeration = properties.keys();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                bean = ObjectFactory.getInstance((String) properties.get(key));
                beans.put(key, bean);
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
        // Process Annotations
        ProcessAnnotations.handleAnnotations(beans);
    }

    // Access Singleton instance
    public static MessageConfiguration getInstance() {
        return instance;
    }

    public Object getBean(String key) {
        return beans.get(key);
    }

}

