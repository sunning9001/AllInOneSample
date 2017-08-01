package CglibSample;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaProxySample1 {
	public static void main(String[] args) throws Exception {
		InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				if (method.getName().equals("getFoo")) {
					return "sunning";
				} else {
					throw new Exception("proxy method not find");
				}
			}
		};
		Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[] { Foo.class },
                handler);

		
		System.out.println(f.getFoo());
		
		

		for (Method m :  Foo.class.getDeclaredMethods()) {
			 System.out.println(m.getName());
		}
	    System.out.println(Foo.class.getConstructors().length);
		System.out.println("-------");

		for (Method m : f.getClass().getDeclaredMethods()) {
			 System.out.println(m.getName());
		}
	    System.out.println(f.getClass().getConstructors().length);
	}
}
