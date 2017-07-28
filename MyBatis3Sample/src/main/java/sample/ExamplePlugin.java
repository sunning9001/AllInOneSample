package sample;

import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({@Signature( type= ParameterHandler.class,  method = "getParameterObject", args = {  })})
public class ExamplePlugin implements Interceptor {
	public Object intercept(Invocation invocation) throws Throwable {
		
		System.out.println("====1=======");
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		System.out.println("=====2======");
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		System.out.println("=====2======");
	}
}