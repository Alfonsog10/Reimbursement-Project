package com.alfonso.Connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

import com.alfonso.Dao.EmpDao;
import com.alfonso.Dao.EmpDaoImp;
import com.alfonso.Dao.ReimbDao;
import com.alfonso.Dao.ReimbDaoImp;

public class ConnectionUtility {

	public static Connection getConnection() throws SQLException {
		
		Driver PostgresDriver = new Driver();
		DriverManager.registerDriver(PostgresDriver);

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String manager_username = "postgres";
		String manager_password = "1Alfonsog@";
		return DriverManager.getConnection(url, manager_username, manager_password);
	}
	

	public static void main(String[] args) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			System.out.println("Connection successful.");
		} catch(SQLException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	public static EmpDao getEmpDao() {
		return new EmpDaoImp();
	}
	
	public static ReimbDao getReimbDao() {
		return new ReimbDaoImp();
	}
}