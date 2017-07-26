package com.concretepage;
import javax.inject.Inject;
import javax.inject.Named;

import com.concretepage.bean.IEmployee;
@Named
public class EmployeeService {
	private IEmployee employee;
	@Inject
	private EmployeeService(@Named("soft")IEmployee employee) {
		this.employee = employee;
	}
	public IEmployee getEmployee() {
		return employee;
	}
}
