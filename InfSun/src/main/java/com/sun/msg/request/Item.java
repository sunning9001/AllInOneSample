package com.sun.msg.request;

public class Item {
	private String item_code; // 项目识别码
	private String item_name; // 收费项目名称
	private String item_amount;// 金额,单位元
	private String unit; // 计量单位个
	private String num; // 数量
	private String stdtype;// 标准类型 无限制
	private String standard; // 收费标准 0.0 -0.0

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_amount() {
		return item_amount;
	}

	public void setItem_amount(String item_amount) {
		this.item_amount = item_amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getStdtype() {
		return stdtype;
	}

	public void setStdtype(String stdtype) {
		this.stdtype = stdtype;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "Item [item_code=" + item_code + ", item_name=" + item_name + ", item_amount=" + item_amount + ", unit="
				+ unit + ", num=" + num + ", stdtype=" + stdtype + ", standard=" + standard + "]";
	}

}
