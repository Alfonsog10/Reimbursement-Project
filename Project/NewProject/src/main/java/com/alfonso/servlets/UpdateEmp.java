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
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		EmpDaoImp update = new EmpDaoImp();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String emp_firstname = request.getParameter("first");
		String emp_lastname = request.getParameter("last");
		String emp_username = request.getParameter("username");
		String emp_password = request.getParameter("pass");
		
		session.setAttribute("username", emp_username);
		
		String success = "<head>\n"
				+ "<meta charset=\"ISO-8859-1\">\n"
				+ "<title>Employee Home</title>\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h1>Employee HP</h1>\n"
				+ "<div>\n"
				+ "<h3>MENU</h3>\n"
				+ "<form action=\"viewme\" method=\"post\"> <!-- done -->\n"
				+ "<input type=\"submit\" class=\"button\" value=\"View My Information\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"UpdateEmp.html\" method=\"post\"> <!-- done -->\n"
				+ "<input type=\"submit\" class=\"button\" value=\"Update My Information\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"viewmine\" method=\"post\">  <!-- done -->\n"
				+ "<input type=\"submit\" class=\"button\" value=\"View My Reimbursement Requests\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"SubmitRequest.html\" method=\"post\"> <!-- done -->\n"
				+ "<input type=\"submit\" class=\"button\" value=\"Submit a Reimbursement Request\"/>\n"
				+ "</form>\n"
				+ "<br/>\n"
				+ "<br/>\n"
				+ "<form action=\"HomePage.html\" method=\"post\">\n"
				+ "<input type=\"submit\" value=\"Log Out\">\n"
				+ "</form>\n"
				+ "</div>\n"
				+ "</body>";
		String invalid = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Employee Update</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Update My Information</h3"
				+ "<div>"
				+ "<h4 style=\"color: red\">An error occurred, please try again.</h4>"
				+ "<form action=\"updateEmp\" method=\"post\">\r\n"
				+ "Please enter your new information as follows:\r\n"
				+ "<br>\r\n"
				+ "First Name: <input type=\"text\" name=\"first\">\r\n"
				+ "<br>\r\n"
				+ "Last Name: <input type=\"text\" name=\"last\">\r\n"
				+ "<br>\r\n"
				+ "Username: <input type=\"text\" name=\"username\">\r\n"
				+ "<br>\r\n"
				+ "Password: <input type=\"password\" name=\"pass\">\r\n"
				+ "<br>\r\n"
				+ "<input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"EmpHome.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Go Back\">\r\n"
				+ "</form>"
				+ "</div>"
				+ "</body>";
				
		Employees employee = new Employees(null, emp_firstname, emp_lastname, emp_username, emp_password, "Employee");
		employee = update.updateEmployees(username, employee);
		
		if (employee != null) {
			out.print(success);
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