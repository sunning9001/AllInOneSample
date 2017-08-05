package aopsample;

/**
 * 定义日志切面的接口
 * @author yanyl
 *
 */
public interface LogAspect {
	void before();//方法调用前执行
	void after();//方法调用后执行
}
