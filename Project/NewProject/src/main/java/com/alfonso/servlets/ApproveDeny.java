package com.alfonso.servlets;

import com.alfonso.Dao.ReimbDaoImp;
import com.alfonso.models.Reimburs; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ApproveDeny
 */
public class ApproveDeny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveDeny() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbDaoImp update = new ReimbDaoImp();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Integer reimb_id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		
		Reimburs req = new Reimburs(reimb_id, null, null, null, status);
		Boolean result = update.updateReimbursements(req);
		
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
				+ "</body>";
		String invalid = "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Request Approval and Denial</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Styling.css\">"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h3>Approve or Deny Requests</h3>"
				+ "<div>"
				+ "<h4 style=\"color: red;\">An error occured, please try again.</h4>"
				+ "<form action=\"approvedeny\" method=\"post\">\r\n"
				+ "Please indicate the ID of the Reimbursement Request you would like to update: <input type=\"number\" name=\"id\">\r\n"
				+ "<br>\r\n"
				+ "Approved or Denied? <input type=\"text\" name=\"status\">\r\n"
				+ "<br> \r\n"
				+ "<input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form>\r\n"
				+ "<br>\r\n"
				+ "<br>\r\n"
				+ "<form action=\"Manager.html\" method=\"post\">\r\n"
				+ "<input type=\"submit\" value=\"Go Back\">\r\n"
				+ "</form>\r\n"
				+ "</div>"
				+ "</body>";
		
		if (result != false) {
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