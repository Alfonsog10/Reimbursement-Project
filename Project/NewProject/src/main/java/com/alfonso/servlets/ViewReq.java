package com.alfonso.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alfonso.Dao.*;
import com.alfonso.models.*;

/**
 * Servlet implementation class ViewRequests
 */
public class ViewReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbDaoImp view = new ReimbDaoImp();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		List<Reimburs> requests = view.selectAllRequests();

		String success = "<head>\n"
				+ "<meta charset=\"ISO-8859-1\">\n"
				+ "<title>Manager Home</title>\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<h1>MANAGER HP</h1>\n"
				+ "<div>\n"
				+ "<h3>MENU</h3>\n"
				+ "<form action=\"viewman\" method=\"post\"> <!-- done -->\n"
				+ "<input type=\"submit\" value=\"View My Information\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"UpdateMan.html\" method=\"post\"> <!-- done -->\n"
				+ "<input type=\"submit\" value=\"Update My Information\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"viewemps\" method=\"post\">\n"
				+ "<input type=\"submit\" value=\"View All Employees' Information\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"viewreqs\" method=\"post\">\n"
				+ "<input type=\"submit\" value=\"View All Reimbursement Requests\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"EmpReq.html\" method=\"post\">\n"
				+ "<input type=\"submit\" value=\"View One Employee's Requests\"/>\n"
				+ "</form>\n"
				+ "<br>\n"
				+ "<form action=\"AppDen.html\" method=\"post\">\n"
				+ "<input type=\"submit\" value=\"Approve or Deny a Request\"/>\n"
				+ "</form>\n"
				+ "<br/>\n"
				+ "<br/>\n"
				+ "<form action=\"HomePage.html\" method=\"post\">\n"
				+ "<input type=\"submit\" value=\"Log Out\">\n"
				+ "</form>\n"
				+ "</div>\n"
				+ "</body>\r\n";
				
		out.print(success);
		for (Reimburs r: requests) {
			out.print("Request ID: " + r.getReimb_id() + ", Employee ID: " + r.getEmp_id() + ", Amount: $" + r.getAmount() + ", Reason: " + r.getReason() + ", Status: " + r.getStatus()+"<br>");
		}
		out.print("</div>" + "</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}