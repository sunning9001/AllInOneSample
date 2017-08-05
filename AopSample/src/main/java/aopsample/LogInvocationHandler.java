package aopsample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 这就是调用打印日志的切面
 * 
 * @author yanyl
 *
 */
public class LogInvocationHandler implements InvocationHandler {
	private final Object target;// 这个就是调用的目标类
	private final List<LogAspect> aspectList = new ArrayList<LogAspect>();// 所指定的切面方法

	public LogInvocationHandler(Object instance) {
		this.target = instance;
	}

	public void addAspect(LogAspect logAspect) {
		this.aspectList.add(logAspect);
	}

	/**
	 * 在这个切面调用原方法执行
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		for (int i = 0; i < aspectList.size(); i++)
			aspectList.get(i).before();// 调用方法执行前到方法

		Object ret = method.invoke(target, args);

		for (int i = aspectList.size() - 1; i >= 0; i--)
			aspectList.get(i).after();// 这里是方法执行后的方法

		return ret;
	}

}