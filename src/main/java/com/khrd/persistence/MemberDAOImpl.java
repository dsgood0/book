package com.khrd.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.MemberVO;
import com.khrd.domain.TypeVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private final static String namespace = "mappers.MemberMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(MemberVO vo) {
		sqlSession.insert(namespace + ".insert", vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		return sqlSession.selectList(namespace + ".selectAll");
	}

	@Override
	public MemberVO selectById(String userid) {
		return sqlSession.selectOne(namespace + ".selectById", userid);
	}

	@Override
	public void update(MemberVO vo) {
		sqlSession.update(namespace + ".update", vo);
	}

	@Override
	public void changeType(MemberVO vo) {
		sqlSession.update(namespace + ".changeType", vo);
	}

	@Override
	public void changeAdmin(MemberVO vo) {
		sqlSession.update(namespace + ".changeAdmin", vo);
	}

	@Override
	public void delete(String userid) {
		sqlSession.delete(namespace + ".delete", userid);
	}

	@Override
	public List<TypeVO> selectAllType() {
		return sqlSession.selectList(namespace + ".selectAllType");
	}

}
