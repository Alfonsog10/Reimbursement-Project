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
 * Servlet implementation class ManLogin
 */
public class ManLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManLogin() {
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
		Employees manager = new Employees();
		manager = login.getManagerByLogin(emp_username, emp_password);
		String invalid = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Manager Login</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Manager Login:</h3>\r\n"
				+ "<div>"
				+ "<h4 style=\"color: red;\">Your username or password was not correct, please try again.</h4>"
				+ "<br>"
				+ "<br>"
				+ "<form action=\"mlog\" method=\"post\">\r\n"
				+ "Please enter your Username:<input type=\"text\" name=\"un\"/>\r\n"
				+ "<br/>\r\n"
				+ "Please enter your Password:<input type=\"password\" name=\"pw\"/>\r\n"
				+ "<br/>\r\n"
				+ "<input type=\"submit\" value=\"Log In\"/>\r\n"
				+ "</form>\r\n"
				+ "<form action=\"HomePage.html\">\r\n"
				+ "<input type=\"submit\" value=\"Go Back\"/>\r\n"
				+ "</form>\r\n"
				+ "</div>"
				+ "</body>";
		if (manager != null) {
			response.sendRedirect("Manager.html");
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