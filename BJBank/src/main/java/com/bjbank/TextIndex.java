package com.bjbank;

public @interface TextIndex {

	   /**
	    *   标记在Text文本中的顺序
	    * @return
	    */
	   int index() default 99999;
}
