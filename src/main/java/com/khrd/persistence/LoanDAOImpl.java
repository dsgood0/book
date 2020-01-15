package com.khrd.persistence;

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

}
