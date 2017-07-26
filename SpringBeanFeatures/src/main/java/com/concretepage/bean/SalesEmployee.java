package com.concretepage.bean;
import javax.inject.Named;
@Named("sales")
public class SalesEmployee implements IEmployee {
	@Override
	public String getEmpMsg() {
		return "Sales Employee";
	}
}
