package mum.edu.framework.annotation;

 
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// Shows up in Javadoc of annotated element
@Documented
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
// relevant for Class Level
@Inherited
 
public @interface Controller {}
