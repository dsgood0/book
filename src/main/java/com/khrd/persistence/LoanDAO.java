package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.LoanVO;

public interface LoanDAO {
	public LoanVO selectByLno(int lno);
	public LoanVO selectByIsbn(int bno);
	public List<LoanVO> selectByEndDateNotNull(String userid);
	public List<LoanVO> selectByEndDateNull(String userid);
	public void insert(String userid, int bno);
	public void updateExtend(int lno);
	public void updateEndDate(int lno);
	public void delete(int lno);
}
