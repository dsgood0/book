package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LoanVO {
	private int lno; // 대출번호
	private int bno; // 게시판 번호
	private String userid; // 회원 아이디
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate; // 대출일시
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enddate; // 반납일시
	private int extend; // 연장여부
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ex_sdate; // 연장시작날짜
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ex_edate; // 연장종료날짜
	private String isbn;

	public LoanVO() {

	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getExtend() {
		return extend;
	}

	public void setExtend(int extend) {
		this.extend = extend;
	}

	public Date getEx_sdate() {
		return ex_sdate;
	}

	public void setEx_sdate(Date ex_sdate) {
		this.ex_sdate = ex_sdate;
	}

	public Date getEx_edate() {
		return ex_edate;
	}

	public void setEx_edate(Date ex_edate) {
		this.ex_edate = ex_edate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "LoanVO [lno=" + lno + ", bno=" + bno + ", userid=" + userid + ", regdate=" + regdate + ", enddate="
				+ enddate + ", extend=" + extend + ", ex_sdate=" + ex_sdate + ", ex_edate=" + ex_edate + ", isbn="
				+ isbn + "]";
	}

}
