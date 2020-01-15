package com.khrd.persistence;

import com.khrd.domain.LoanVO;

public interface LoanDAO {
	public LoanVO selectByLno(int lno);
	public LoanVO selectByIsbn(int bno);
}
