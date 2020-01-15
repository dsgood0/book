package com.khrd.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.BookVO;
import com.khrd.domain.TypeVO;

@Repository
public class BookDAOImpl implements BookDAO {

	private final static String namespace = "mappers.BookMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TypeVO> selectAllType() {
		return sqlSession.selectList(namespace + ".selectAllType");
	}

	@Override
	public void insert(BookVO vo) {
		sqlSession.insert(namespace + ".insert", vo);
	}

	@Override
	public List<BookVO> selectAll() {
		return sqlSession.selectList(namespace + ".selectAll");
	}

	@Override
	public BookVO selectByNo(int bno) {
		return sqlSession.selectOne(namespace + ".selectByNo", bno);
	}

	@Override
	public void update(BookVO vo) {
		sqlSession.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int bno) {
		sqlSession.update(namespace + ".delete", bno);
	}

	@Override
	public String selectLastIsbn() {
		return sqlSession.selectOne(namespace + ".selectLastIsbn");
	}

	@Override
	public BookVO selectByIsbn(String isbn) {
		return sqlSession.selectOne(namespace + ".selectByIsbn", isbn);
	}

	@Override
	public String findbookIsbn(BookVO vo) {
		return sqlSession.selectOne(namespace + ".findbookIsbn", vo);
	}

	@Override
	public void insertDetail(String isbn) {
		sqlSession.insert(namespace + ".insertDetail", isbn);
	}

	@Override
	public String findType(int btno) {
		return sqlSession.selectOne(namespace + ".findType", btno);
	}

	@Override
	public void updateLoanCnt(String isbn) {
		sqlSession.update(namespace + ".updateLoanCnt", isbn);
	}

	@Override
	public void updateBookCnt(String isbn) {
		sqlSession.update(namespace + ".updateBookCnt", isbn);
	}

	@Override
	public List<Integer> selectBnobyIsbn(String isbn) {
		return sqlSession.selectList(namespace + ".selectBnobyIsbn", isbn);
	}

}
