package mum.edu.framework.annotation;

 
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// Shows up in Javadoc of annotated element
@Documented
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
// relevant for Class Level
@Inherited
 
public @interface AutoWired {}
