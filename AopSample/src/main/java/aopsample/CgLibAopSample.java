package aopsample;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CgLibAopSample {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(StudentImpl.class);// 设置需要继承的父类 也就是需要切入的类
		enhancer.setCallback(new LogMethodInterceptor(new PrintLogAspect()));// 设置拦截器
																				// 这里顺带设置切面
		enhancer.setUseCache(true);
		StudentImpl studentImpl = (StudentImpl) enhancer.create();// 创建切入的子类
		studentImpl.sayHello();// 这里直接对类进行了切入 使用原来的类就可以了

	}

	/**
	 * 日志方法拦截器 这里的MethodInterceptor是继承net.sf.cglib.proxy.Callback的
	 * 
	 * @author yanyl
	 *
	 */
	public static class LogMethodInterceptor implements MethodInterceptor {

		private LogAspect logAspect;

		public LogMethodInterceptor(LogAspect logAspect) {
			this.logAspect = logAspect;
		}

		@Override
		public Object intercept(Object instance, Method method, Object[] args, MethodProxy methodProxy)
				throws Throwable {
			Object ret = null;
			if (instance != null && methodProxy != null) {
				logAspect.before();// 进行切入
				ret = methodProxy.invokeSuper(instance, args);// 注意，这里一定是要执行这个proxy的method
																// 并且是invokeSuper
				logAspect.after();
			}
			return ret;
		}

	}

}
