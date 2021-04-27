package com.alfonso.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alfonso.Connection.ConnectionUtility;
import com.alfonso.models.Employees;

public class EmpDaoImp implements EmpDao {
	
	
	public Employees selectEmployees(String emp_username) {

		Employees employee = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.employees WHERE emp_username=?");
			ps.setString(1, emp_username);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				employee = new Employees(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),	
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}
	
	

	public List<Employees> selectAllEmployees() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employees> emps = new ArrayList<Employees>();
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "select emp_id, emp_firstname, emp_lastname, emp_title from ers.employees;";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Employees emp = new Employees();
				emp.setEmp_id(rs.getInt(1));
				emp.setEmp_firstname(rs.getString(2));
				emp.setEmp_lastname(rs.getString(3));
				emp.setEmp_title(rs.getString(4));
				
				emps.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emps;
	}


	
	
	
	public Employees updateEmployees(String emp_username, Employees employee) {

		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE ers.employees SET emp_firstname=?, emp_lastname=?, emp_username=?, emp_password=? WHERE emp_username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmp_firstname());
			ps.setString(2, employee.getEmp_lastname());
			ps.setString(3, employee.getEmp_username());
			ps.setString(4, employee.getEmp_password());
			ps.setString(5, emp_username);

			
			if (ps.executeUpdate() == 0)
				return null;
			else
				return employee;
		} catch (SQLException e) {
			return null;
		}
	}


	public Employees getEmployeeByLogin(String emp_username, String emp_password) {
		Employees employee = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.employees WHERE emp_username=? AND emp_password=? AND emp_title='employee'");
			ps.setString(1, emp_username);
			ps.setString(2, emp_password);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				employee = new Employees(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),	
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}
	
	
	public Employees getManagerByLogin(String emp_username, String emp_password) {
		Employees manager = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM ers.employees WHERE emp_username=? AND emp_password=? AND emp_title='manager'");
			ps.setString(1, emp_username);
			ps.setString(2, emp_password);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				manager = new Employees(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),	
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return manager;
	}

}
