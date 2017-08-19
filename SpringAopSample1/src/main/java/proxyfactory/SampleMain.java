package proxyfactory;

import org.springframework.aop.framework.ProxyFactory;

public class SampleMain {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();// 创建代理工厂
		proxyFactory.setTarget(new LoginServiceImpl());// 设置目标对象
		proxyFactory.addAdvice(new LogBeforeLogin());// 前置增强

		LoginServiceImpl loginService = (LoginServiceImpl) proxyFactory.getProxy();// 从代理工厂中获取代理
		loginService.login("x");
	}
}
