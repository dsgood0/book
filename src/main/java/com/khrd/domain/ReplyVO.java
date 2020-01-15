package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReplyVO {
	private int rpno; // 댓글번호
	private int bno; // 게시판 번호
	private String userid; // 회원 아이디
	private String title; // 제목
	private String content; // 내용
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate; // 등록날짜

	public ReplyVO() {

	}

	public int getRpno() {
		return rpno;
	}

	public void setRpno(int rpno) {
		this.rpno = rpno;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [rpno=" + rpno + ", bno=" + bno + ", userid=" + userid + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + "]";
	}

}
