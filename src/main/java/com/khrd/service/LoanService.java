package com.khrd.service;

import java.util.List;

import com.khrd.domain.LoanVO;

public interface LoanService {
	public LoanVO read(int bno);
	public List<LoanVO> readPastLoan(String userid);
	public List<LoanVO> readLoaning(String userid);
	public void extendLoan(int lno);
	public void returnBook(int lno);
	public void deleteLoan(int lno);	
	
}
