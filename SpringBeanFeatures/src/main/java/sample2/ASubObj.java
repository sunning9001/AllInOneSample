package sample2;

import org.springframework.stereotype.Component;

@Component("AObj")
public class ASubObj extends Obj{
	private String s = "ASubObj";

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "ASubObj [s=" + s + "]";
	}

}
