package CglibSample;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;

public class SampleClass {
	public String test(String input) {
		return "Hello world!";
	}

	public static void main(String[] args) {
		test2() ;
	}

	public static void test2() {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
					return "Hello cglib!";
				} else {
					throw new RuntimeException("Do not know what to do.");
				}
			}
		});
		SampleClass proxy = (SampleClass) enhancer.create();
		System.out.println(proxy.test("sunning"));
	}

	public static void test1() {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SampleClass.class);
		enhancer.setCallback(new FixedValue() {
			@Override
			public Object loadObject() throws Exception {
				return "Hello cglib!";
			}
		});
		SampleClass proxy = (SampleClass) enhancer.create();
		System.out.println(proxy.test("sunning"));
	}
}