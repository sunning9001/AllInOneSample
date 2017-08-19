package springbootcondictionsample;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

	private String s = " hello world";

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "HelloWorld [s=" + s + "]";
	}

}
