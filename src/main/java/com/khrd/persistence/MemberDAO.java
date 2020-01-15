package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.MemberVO;
import com.khrd.domain.TypeVO;

public interface MemberDAO {
	public List<TypeVO> selectAllType();
	
	public void insert(MemberVO vo);
	public List<MemberVO> selectAll();
	public MemberVO selectById(String userid);
	public void update(MemberVO vo);
	public void changeType(MemberVO vo);
	public void changeAdmin(MemberVO vo);
	public void delete(String userid);
}
