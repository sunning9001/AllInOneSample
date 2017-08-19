https://github.com/zakyalvan/learn-spring-config


https://github.com/swilliams-pivotal/simple-spring-enable-annotation


https://www.javacodegeeks.com/2015/04/spring-enable-annotation-writing-a-custom-enable-annotation.html

http://blog.csdn.net/mn960mn/article/details/51190590


https://segmentfault.com/a/1190000007350794
https://www.togglz.org/#example

http://www.java-allandsundry.com/2013/09/spring-4-conditional.html

https://my.oschina.net/kevinair/blog/703994

https://my.oschina.net/u/1024107/blog/879456

http://blog.csdn.net/catoop/article/details/50558333


BeanDefinitionRegistryPostProcessor
https://www.ibm.com/developerworks/cn/java/j-lo-beanannotation/index.html

http://blog.csdn.net/bubaxiu/article/details/41415685



Spring Version2.0 :Spring 2.0 was announced in December 2005 at the Spring Experience conference in Florida.

JDK Version : The Spring Framework continues to be totally compatible with all versions of Java since (and including) Java 1.3. This means that 1.3, 1.4, and 1.5 are supported.


@Required
The @Required annotation in the org.springframework.beans.factory.annotation package can be used to mark a property as being 'required-to-be-set' 
(i.e. an annotated (setter) method of a class must be configured to be dependency injected with a value), else an Exception will be thrown by the container at runtime.




Spring Version2.5:Spring 2.0, released in October 2006, and Spring 2.5, released in November 2007.

JDK Version : JDK5  ,JDK6 
This means that Java 1.4.2, Java 5 and Java 6 are supported, although some advanced functionality of the Spring Framework will not be available to you if you are committed to using Java 1.4.2. Spring 2.5 introduces dedicated support for Java 6, after Spring 2.0's in-depth support for Java 5 throughout the framework.

Annotation-driven configuration

Spring 2.0 introduced support for various annotations for configuration purposes, such as @Transactional, @Required and @PersistenceContext /@PersistenceUnit.

Spring 2.5 introduces support for a complete set of configuration annotations: @Autowired in combination with support for the JSR-250 annotations @Resource, @PostConstruct and @PreDestroy .


Spring 2.0, released in October 2006, and Spring 2.5, released in November 2007. It is now time 2009 for a third overhaul resulting in Spring 3.0.

The Spring Framework is now based on Java 5, and Java 6 is fully supported.