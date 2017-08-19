package sample2;

import org.springframework.stereotype.Component;

@Component("BObj")
public class BSubObj extends Obj{
	private String s = "BObj";

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "BObj [s=" + s + "]";
	}

}
