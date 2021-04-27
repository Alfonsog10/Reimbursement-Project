package com.alfonso.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alfonso.Dao.*;
import com.alfonso.models.*;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		EmpDaoImp login = new EmpDaoImp();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String emp_username = request.getParameter("un");
		String emp_password = request.getParameter("pw");
		
		session.setAttribute("username", emp_username);
		
		Employees employee = new Employees();
		employee = login.getEmployeeByLogin(emp_username, emp_password);

		
		String invalid = "<head>\n"
				+ "<meta charset=\"ISO-8859-1\">\n"
				+ "<title>Employee Login</title>\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h3>Employee Login:</h3>\n"
				+ "<div>\n"
				+ "<form action=\"elog\" method=\"post\">\n"
				+ "USERNAME: <input type=\"text\" name=\"un\"/>\n"
				+ "<br/>\n"
				+ "PASSWORD: <input type=\"password\" name=\"pw\"/>\n"
				+ "<br/>\n"
				+ "<input type=\"submit\" value=\"Log In\"/>\n"
				+ "</form>\n"
				+ "<form action=\"HomePage.html\">\n"
				+ "<input type=\"submit\" value=\"Go Back\"/>\n"
				+ "</form>\n"
				+ "</div>\n"
				+ "</body>";
		if (employee != null) {
			response.sendRedirect("EmployeeHome.html");
		} else {
			out.print(invalid);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}