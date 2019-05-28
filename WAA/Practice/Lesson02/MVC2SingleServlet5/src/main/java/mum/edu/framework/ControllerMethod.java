package mum.edu.framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 * Class to hold Controller method information gathered through Reflection
 *  Stores Method class
 *         Map of method parameters
 *         Map of getter/setter Method classes for [possible] domain object
 */
public class ControllerMethod {
	
	private Method method;
	private Map<String,Object> params = new HashMap<String, Object>();
 	private Map<String,Method> domainObjectSetters = new HashMap<String, Method>();

	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
 	public Map<String, Method> getDomainObjectSetters() {
		return domainObjectSetters;
	}
	public void setDomainObjectSetters(Map<String, Method> domainObjectSetters) {
		this.domainObjectSetters = domainObjectSetters;
	}
	
	

}
