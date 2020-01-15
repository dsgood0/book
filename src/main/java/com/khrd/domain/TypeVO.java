package com.khrd.domain;

public class TypeVO {
	private int no;
	private String divname;

	public TypeVO() {

	}

	public TypeVO(int no) {
		super();
		this.no = no;
	}

	public TypeVO(int no, String divname) {
		super();
		this.no = no;
		this.divname = divname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDivname() {
		return divname;
	}

	public void setDivname(String divname) {
		this.divname = divname;
	}

	@Override
	public String toString() {
		return "TypeVO [no=" + no + ", divname=" + divname + "]";
	}

}
