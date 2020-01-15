package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookDetailVO {
	private int bno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private int exist;
	private String isbn;
	private int loanAvail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mayEndDate;

	public BookDetailVO() {

	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getExist() {
		return exist;
	}

	public void setExist(int exist) {
		this.exist = exist;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getLoanAvail() {
		return loanAvail;
	}

	public void setLoanAvail(int loanAvail) {
		this.loanAvail = loanAvail;
	}

	public Date getMayEndDate() {
		return mayEndDate;
	}

	public void setMayEndDate(Date mayEndDate) {
		this.mayEndDate = mayEndDate;
	}

	@Override
	public String toString() {
		return "BookDetailVO [bno=" + bno + ", regdate=" + regdate + ", exist=" + exist + ", isbn=" + isbn
				+ ", loanAvail=" + loanAvail + ", mayEndDate=" + mayEndDate + "]";
	}

}
