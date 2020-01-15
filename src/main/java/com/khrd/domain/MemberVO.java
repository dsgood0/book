package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVO {
	private String userid; // 회원 아이디
	private String userpw; // 회원 비밀번호
	private String name; // 이름
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth; // 생년월일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate; // 가입일
	private int gender; // 성별
	private int admin; // 관리자 여부
	private int withdraw; // 탈퇴여부
	private TypeVO membertype; // 회원 분류

	public MemberVO() {

	}

	public MemberVO(String userid, String userpw, String name, Date birth, int gender) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
	}

	public MemberVO(String userid, String userpw, String name, Date birth, int gender, int admin, int withdraw,
			TypeVO membertype) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.admin = admin;
		this.withdraw = withdraw;
		this.membertype = membertype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public TypeVO getMembertype() {
		return membertype;
	}

	public void setMembertype(TypeVO membertype) {
		this.membertype = membertype;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", name=" + name + ", birth=" + birth
				+ ", regdate=" + regdate + ", gender=" + gender + ", admin=" + admin + ", withdraw=" + withdraw
				+ ", membertype=" + membertype + "]";
	}

}
