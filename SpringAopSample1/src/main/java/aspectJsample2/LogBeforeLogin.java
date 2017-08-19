package aspectJsample2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogBeforeLogin {

    @Pointcut("execution(*  aspectJsample.*.login(..))")
    public void loginMethod(){}

    @Before("loginMethod()")
    public void beforeLogin(){
        System.out.println("有人要登录了。。。");
    }
}