package com.gopivotal.soleng.examples.springannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.gopivotal.soleng.examples.springannotation.config.EnableExampleImportBeanDefinitionRegistrar;
/**
 *   Enable 注解事例
 * @author sunning
 *
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//Enable 时,执行register
@Import({ EnableExampleImportBeanDefinitionRegistrar.class })
public @interface EnableExample {

	Class<?> value() default SimpleExampleRegistry.class;

}
