package CglibSample;

public class SampleBean {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static void main(String[] args) {

		SampleBean bean = new SampleBean();
		bean.setValue("Hello world!");
		SampleBean immutableBean = (SampleBean)  net.sf.cglib.beans.ImmutableBean.create(bean);
	   
		bean.setValue("Hello world, again!");
		
		immutableBean.setValue("Hello cglib!"); // Causes exception.
	}
}
