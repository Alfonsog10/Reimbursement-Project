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
 * Servlet implementation class SubmitRequest
 */
public class SubmitReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		EmpDaoImp eDao = new EmpDaoImp();
		Employees employee = eDao.selectEmployees(username);
		
		ReimbDaoImp submit = new ReimbDaoImp();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Integer emp_id = employee.getEmp_id();
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String reason = request.getParameter("reason");
		
		Integer reimb_id = null;
		String status = "Pending";
		
		Reimburs requests = new Reimburs(reimb_id, emp_id, amount, reason, status);
		submit.insertIntoReimbursements(requests);
		
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
				+ "<title>Request Form</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Reimbursement Request Form</h3>\r\n"
				+ "<div>"
				+ "<h4 sytle=\"color: red\">An error occurred, please try again.</h4>"
				+ "<form action=\"submitrequest\" method=\"post\">\r\n"
				+ "Please Enter The Amount You Would Like Reimbursed:<input type=\"text\" name=\"amount\"/>\r\n"
				+ "<br/>\r\n"
				+ "Please Enter Your Reason For This Request:<input type=\"text\" name=\"reason\"/>\r\n"
				+ "<br/>\r\n"
				+ "<input type=\"submit\" value=\"Submit My Request\"/>\r\n"
				+ "</form>\r\n"
				+ "<br/>\r\n"
				+ "<br/>\r\n"
				+ "<form action=\"EmpHome.html\" method=\"post\">\r\n"
				+ "<input type=\"Submit\" value=\"Go Back\">\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "</div>"
				+ "</body>";
		if(submit.insertIntoReimbursements(requests) != false) {
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