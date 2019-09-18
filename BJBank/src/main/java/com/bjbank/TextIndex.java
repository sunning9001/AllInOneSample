package com.bjbank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TextIndex {

	   /**
	    *   标记在Text文本中的顺序
	    * @return
	    */
	   int index() default 99999;
}
