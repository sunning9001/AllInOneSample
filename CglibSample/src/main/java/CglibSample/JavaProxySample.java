package CglibSample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaProxySample {
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
		Class proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), new Class[] { Foo.class });

		Foo f = (Foo) proxyClass.getConstructor(new Class[] { InvocationHandler.class })
				.newInstance(new Object[] { handler });
		
		System.out.println(f.getFoo());

	}
}
