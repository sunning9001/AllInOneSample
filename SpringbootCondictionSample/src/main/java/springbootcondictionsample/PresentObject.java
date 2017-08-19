package springbootcondictionsample;

public class PresentObject {

	private String present ="I am here";

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	@Override
	public String toString() {
		return "PresentObject [present=" + present + "]";
	}
	
	
}
