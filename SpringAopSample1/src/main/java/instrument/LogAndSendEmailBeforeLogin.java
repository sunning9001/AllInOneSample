package instrument;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LogAndSendEmailBeforeLogin extends DelegatingIntroductionInterceptor implements SendEmailService {


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("有人要登录了。。。");
        return super.invoke(mi);
    }

    public void sendEmail() {
        System.out.println("发送邮件。。。。");
    }
}