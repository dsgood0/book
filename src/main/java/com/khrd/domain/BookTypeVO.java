package com.khrd.domain;

public class BookTypeVO extends TypeVO {
	private String type;

	public BookTypeVO() {
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BooktypeVO [type=" + type + "]";
	}

}
