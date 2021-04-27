package com.alfonso.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alfonso.Dao.*;
import com.alfonso.models.*;

/**
 * Servlet implementation class MyRequests
 */
public class Requests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Requests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emp_username = (String) session.getAttribute("username");
		
		ReimbDaoImp view = new ReimbDaoImp();
		EmpDaoImp eDao = new EmpDaoImp();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Employees employee = eDao.selectEmployees(emp_username);
		
		Integer emp_id = employee.getEmp_id();

		List<Reimburs> requests = view.selectRequestsByEmployee(emp_id);

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
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<h4>My Requests: </h4>";

		out.print(success);
		for (Reimburs r: requests) {
			out.print("Request ID: " + r.getReimb_id() + ", Employee ID: " + r.getEmp_id() + ", Amount: $" + r.getAmount() + ", Reason: " + r.getReason() + ", Status: " + r.getStatus()+"<br>");
		}
		out.print("</div></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}