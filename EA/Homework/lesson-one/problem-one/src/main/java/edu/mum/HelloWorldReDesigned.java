package edu.mum;

import edu.mum.component.MessageDisplay;
import edu.mum.configuration.ConfigInMemory;

public class HelloWorldReDesigned {
    public static void main(String[] args) {

        // "Configure" application - set up HARDCODED managed beans
        ConfigInMemory configInMemory = ConfigInMemory.getInstance();

        MessageDisplay messageDisplay = (MessageDisplay) configInMemory.getBean("MessageDisplay");
        messageDisplay.display();

    }
}
