http://docs.spring.io/spring-framework/docs/1.1.1/reference/aop.html#aop-introduction-proxies


1.
Spring defaults to using J2SE dynamic proxies for AOP proxies. 

This enables any interface or set of interfaces to be proxied.


2.Spring can also use CGLIB proxies. This is necessary to proxy classes, rather than interfaces.

CGLIB is used by default if a business object doesn't implement an interface.
s it's good practice to program to interfaces rather than classes, business objects normally will implement one or more business interfaces.


http://maven.springframework.org/release/org/springframework/spring-aop/