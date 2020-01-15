package com.khrd.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.LoanVO;

@Repository
public class LoanDAOImpl implements LoanDAO {

	private final static String namespace = "mappers.LoanMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public LoanVO selectByLno(int lno) {
		return sqlSession.selectOne(namespace + ".selectByLno", lno);
	}

	@Override
	public LoanVO selectByIsbn(int bno) {
		return sqlSession.selectOne(namespace + ".selectByIsbn", bno);
	}

	@Override
	public List<LoanVO> selectByEndDateNotNull(String userid) {
		return sqlSession.selectList(namespace + ".selectByEndDateNotNull", userid);
	}

	@Override
	public List<LoanVO> selectByEndDateNull(String userid) {
		return sqlSession.selectList(namespace + ".selectByEndDateNull", userid);
	}

	@Override
	public void insert(String userid, int bno) {
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("bno", bno);
		sqlSession.insert(namespace + ".insert", map);
	}

	@Override
	public void updateExtend(int lno) {
		sqlSession.update(namespace + ".updateExtend", lno);
	}

	@Override
	public void updateEndDate(int lno) {
		sqlSession.update(namespace + ".updateEndDate", lno);
	}

	@Override
	public void delete(int lno) {
		sqlSession.delete(namespace + ".delete", lno);
	}

}
