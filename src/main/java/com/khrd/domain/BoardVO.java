package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVO {
	private int bdno; // 게시판번호
	private String title; // 게시판 제목
	private String content; // 게시판 내용
	private String writer; // 작성자
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate; // 등록날짜
	private int viewcnt; // 조회수
	private int replycnt; // 댓글수
	private TypeVO boardtype; // 게시판종류
	private String userid; // 회원번호

	public BoardVO() {

	}

	public int getBdno() {
		return bdno;
	}

	public void setBdno(int bdno) {
		this.bdno = bdno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public TypeVO getBoardtype() {
		return boardtype;
	}

	public void setBoardtype(TypeVO boardtype) {
		this.boardtype = boardtype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BoardVO [bdno=" + bdno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", viewcnt=" + viewcnt + ", replycnt=" + replycnt + ", boardtype="
				+ boardtype + ", userid=" + userid + "]";
	}

}
