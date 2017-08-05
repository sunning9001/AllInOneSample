package aopsample;

import java.lang.reflect.Proxy;

public class SimpleProxyFactory {

private SimpleProxyFactory(){};//不公开构造方法
	
	public static Object newInstance(Object instance,LogAspect logAspect)
	{
		LogInvocationHandler h=new LogInvocationHandler(instance);
		h.addAspect(logAspect);
		
		//这里是直接返回创建的代理类
		return Proxy.newProxyInstance(instance.getClass().getClassLoader(), 
							instance.getClass().getInterfaces(), h);
				
	}
	public static void main(String[] args) {
		//这里创建一个打印的切面
		LogAspect logAspect=new PrintLogAspect();
		//使用简单的代理工厂生产具体的接口
		Student s=(Student)SimpleProxyFactory.newInstance(new StudentImpl(), logAspect);
		//接口调用方法 可以发现已经带上了需要切入的面
		s.sayHello();
	}
}
