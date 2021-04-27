package com.alfonso.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alfonso.Connection.ConnectionUtility;
import com.alfonso.models.Reimburs;

public class ReimbDaoImp implements ReimbDao {

	

	public Reimburs selectRequestById(Integer reimb_id) {
		Reimburs request = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.reimbursements WHERE reimb_id=?");
			ps.setInt(1, reimb_id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				request = new Reimburs(
						rs.getInt(1),
						rs.getInt(2),
						rs.getDouble(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return request;
	}
	
	public List<Reimburs> selectRequestsByEmployee(Integer emp_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Reimburs> requests = new ArrayList<Reimburs>();
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.reimbursements WHERE emp_id=?");
			ps.setInt(1, emp_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reimburs reimb = new Reimburs();
				reimb.setReimb_id(rs.getInt(1));
				reimb.setEmp_id(rs.getInt(2));
				reimb.setAmount(rs.getDouble(3));
				reimb.setReason(rs.getString(4));
				reimb.setStatus(rs.getString(5));
				
				requests.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return requests;
	}
	

	@Override
	public Boolean insertIntoReimbursements(Reimburs request) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO ers.reimbursements VALUES(DEFAULT, ?, ?, ?, ?)");

			ps.setInt(1, request.getEmp_id());
			ps.setDouble(2, request.getAmount());
			ps.setString(3, request.getReason());
			ps.setString(4, "Pending");
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public List<Reimburs> selectAllRequests() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Reimburs> requests = new ArrayList<Reimburs>();
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM ers.reimbursements";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Reimburs request = new Reimburs();
				request.setReimb_id(rs.getInt(1));
				request.setEmp_id(rs.getInt(2));
				request.setAmount(rs.getDouble(3));
				request.setReason(rs.getString(4));
				request.setStatus(rs.getString(5));
				
				requests.add(request);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return requests;
	}



	public Boolean updateReimbursements(Reimburs req) {

		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE ers.reimbursements SET status=? WHERE reimb_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, req.getStatus());
			ps.setInt(2, req.getReimb_id());
			
			if (ps.executeUpdate() == 0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			return false;
		}
	}
}

