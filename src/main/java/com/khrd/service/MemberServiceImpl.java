package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khrd.domain.MemberVO;
import com.khrd.domain.TypeVO;
import com.khrd.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public void regist(MemberVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public MemberVO selectById(String userid) {
		return dao.selectById(userid);
	}

	@Override
	public void modify(MemberVO vo) {
		dao.update(vo);
	}

	@Override
	public void changeMemberType(MemberVO vo) {
		dao.changeType(vo);
	}

	@Override
	public void changeAdmin(MemberVO vo) {
		dao.changeAdmin(vo);
	}

	@Override
	public void withdraw(String userid) {
		dao.delete(userid);
	}

	@Override
	public List<TypeVO> showMemberType() {
		return dao.selectAllType();
	}

}
