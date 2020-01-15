package com.khrd.service;

import java.util.List;

import com.khrd.domain.MemberVO;
import com.khrd.domain.TypeVO;

public interface MemberService {
	public List<TypeVO> showMemberType();
	
	public void regist(MemberVO vo);
	public List<MemberVO> selectAll();
	public MemberVO selectById(String userid);
	public void modify(MemberVO vo);
	public void changeMemberType(MemberVO vo);
	public void changeAdmin(MemberVO vo);
	public void withdraw(String userid);
}
