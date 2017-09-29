package objenesissample;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

public class InstanceObject {

	private int a;
	private String b;
	private long c;

	public InstanceObject(int a, String b, long c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public String getB() {
		return b;
	}


	public void setB(String b) {
		this.b = b;
	}


	public long getC() {
		return c;
	}


	public void setC(long c) {
		this.c = c;
	}


	public static void main(String[] args) {

		Objenesis objenesis = new ObjenesisStd(); 
		
		ObjectInstantiator thingyInstantiator = objenesis.getInstantiatorOf(InstanceObject.class);
		
		InstanceObject iObject = (InstanceObject)thingyInstantiator.newInstance();
		
		iObject.setA(1);
	}
}
