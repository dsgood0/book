package com.khrd.domain;

import java.util.List;

public class BookVO {
	private String isbn; // 책 고유번호
	private String title; // 책 제목
	private String intro; // 책 소개
	private String author; // 저자
	private String publisher; // 출판사
	private String imgsrc; // 이미지 경로
	private int cnt; // 책의 갯수
	private int loancnt; // 책의 빌린 횟수
	private BookTypeVO booktype; // 책 분류
	private List<BookDetailVO> bookdetail; // 책 상세정보

	public BookVO() {
		
	}

	public BookVO(String isbn, String title, String intro, String author, String publisher, String imgsrc,
			BookTypeVO booktype) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.intro = intro;
		this.author = author;
		this.publisher = publisher;
		this.imgsrc = imgsrc;
		this.booktype = booktype;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLoancnt() {
		return loancnt;
	}

	public void setLoancnt(int loancnt) {
		this.loancnt = loancnt;
	}

	public BookTypeVO getBooktype() {
		return booktype;
	}

	public void setBooktype(BookTypeVO booktype) {
		this.booktype = booktype;
	}

	public List<BookDetailVO> getBookdetail() {
		return bookdetail;
	}

	public void setBookdetail(List<BookDetailVO> bookdetail) {
		this.bookdetail = bookdetail;
	}

	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", intro=" + intro + ", author=" + author + ", publisher="
				+ publisher + ", imgsrc=" + imgsrc + ", cnt=" + cnt + ", loancnt=" + loancnt + ", booktype=" + booktype
				+ ", bookdetail=" + bookdetail + "]";
	}

}
