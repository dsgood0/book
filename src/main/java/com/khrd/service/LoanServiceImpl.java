package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khrd.domain.LoanVO;
import com.khrd.persistence.LoanDAO;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDAO dao;

	@Override
	public LoanVO read(int bno) {
		return dao.selectByIsbn(bno);
	}

	@Override
	public List<LoanVO> readPastLoan(String userid) {
		return dao.selectByEndDateNotNull(userid);
	}

	@Override
	public List<LoanVO> readLoaning(String userid) {
		return dao.selectByEndDateNull(userid);
	}

	@Override
	public void extendLoan(int lno) {
		dao.updateExtend(lno);
	}

	@Override
	public void returnBook(int lno) {
		dao.updateEndDate(lno);
	}

	@Override
	public void deleteLoan(int lno) {
		dao.delete(lno);
	}


}
