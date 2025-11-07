package com.servlet;
import com.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.dao.UserDAO;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session work
		try {
			PrintWriter out = response.getWriter();
			
			HttpSession s = request.getSession();
			String email = (String) s.getAttribute("email");
			String password = (String) s.getAttribute("password");
			
			UserDAO d = new UserDAO();
			ResultSet rs = d.profileUser(email, password);
		
			out.println("<table border=2>");
			if(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+"<td>"+rs.getString(2)+"<td>"+rs.getString(3));
			}
		}
		catch(Exception e) {}
		
	}
}