package aopsample;

public class PrintLogAspect implements LogAspect {
	public void before()
	{
		System.out.println("Log:before invoke");
	}
	
	public void after()
	{
		System.out.println("after invoke");
	}
}