package mum.edu.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*
 * We want to process the key/values pair in the properties file sequentially
 * Since the Properties class stores the info in a Map, we cannot satisfy our requirement.
 * We need to subclass Properties and provide a "sequenced" data structure AKA a List...
 */
		
public class SequencedProperties extends Properties {

    private static final long serialVersionUID = -7032434592318855760L;

    // List is ordered or "sequenced"
    // We will disallow duplicates...to "mimic" Properties/Hash Table
    private List<Object> keyList = new ArrayList<Object>();

    @Override
    public synchronized Enumeration keys() {
        return Collections.enumeration(keyList);
    }

    @Override
    public synchronized Object put(Object key, Object value) {
        if (! containsKey(key)) {
            keyList.add(key);
        }

        return super.put(key, value);
    }

    @Override
    public synchronized Object remove(Object key) {
        keyList.remove(key);

        return super.remove(key);
    }

    @Override
    public synchronized void putAll(Map values) {
        for (Object key : values.keySet()) {
            if (! containsKey(key)) {
                keyList.add(key);
            }
        }
        
    }
}