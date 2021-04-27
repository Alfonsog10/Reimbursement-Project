package com.alfonso.Dao;

import java.util.List;

import com.alfonso.models.Reimburs;

public interface ReimbDao {
	public Reimburs selectRequestById(Integer reimb_id);
	public List<Reimburs> selectRequestsByEmployee(Integer emp_id);
	public Boolean insertIntoReimbursements (Reimburs request);
	public List<Reimburs> selectAllRequests();
	public Boolean updateReimbursements (Reimburs req);
	
}