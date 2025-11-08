package com.servlet;
import java.io.*;
import com.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter();
//			out.println(email + " " +password);
			// DAO class work
			UserDAO udoL = new UserDAO();
			boolean found = udoL.checkRecord(email, password);	// checkRecord returning true/false

			// dispatcher work
			if(found == true) {
				
				HttpSession s = request.getSession();
				s.setAttribute("email", email);
				s.setAttribute("password", password);
				
				// sending the user to its dashboard page
				RequestDispatcher rd = request.getRequestDispatcher("userDashboard.html");
				rd.forward(request, response);
				
			}
			else{
				// 'No Account Found'
				// sending user back to html, to register
//				response.sendRedirect("index.html");
				out.println("<html><body><h2>User Not Found! Please Register: "
						+ "<a href='register.html'>Register</a></body></html>");
			}
		}
		catch (Exception excp) {}
	}
}
