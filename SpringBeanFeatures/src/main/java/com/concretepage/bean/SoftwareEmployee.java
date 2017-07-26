package com.concretepage.bean;
import javax.inject.Named;
@Named("soft")
public class SoftwareEmployee implements IEmployee {
	@Override
	public String getEmpMsg() {
		return "Software Employee";
	}

}
