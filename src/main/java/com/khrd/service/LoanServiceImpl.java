package com.khrd.service;

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


}
