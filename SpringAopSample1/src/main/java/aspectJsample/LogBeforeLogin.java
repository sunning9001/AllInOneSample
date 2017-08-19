package aspectJsample;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogBeforeLogin {

    @Pointcut("@annotation(aspectJsample.UseAop)")
    public void loginMethod(){}

    @Before("loginMethod()")
    public void beforeLogin(){
        System.out.println("有人要登录了。。。");
    }
}