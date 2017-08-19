package autoproxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeLogin  implements MethodBeforeAdvice {
	public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("有人要登录了。。。");
    }
}