package com.khrd.domain;

public class ReserveVO {
	private int rvno; // 예약번호
	private int lno; // 대출번호
	private String userid; // 회원 아이디
	private int resorder; // 예약순번
	private int avail; // 대출가능여부
	private int cancel; // 예약취소여부

	public ReserveVO() {

	}

	public int getRvno() {
		return rvno;
	}

	public void setRvno(int rvno) {
		this.rvno = rvno;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getResorder() {
		return resorder;
	}

	public void setResorder(int resorder) {
		this.resorder = resorder;
	}

	public int getAvail() {
		return avail;
	}

	public void setAvail(int avail) {
		this.avail = avail;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	@Override
	public String toString() {
		return "ReserveVO [rvno=" + rvno + ", lno=" + lno + ", userid=" + userid + ", resorder=" + resorder + ", avail="
				+ avail + ", cancel=" + cancel + "]";
	}

}
