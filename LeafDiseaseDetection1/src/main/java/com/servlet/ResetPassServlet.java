package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDAO;

@WebServlet("/changePass")
public class ResetPassServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			
			String newPass = request.getParameter("nPass");
			
			HttpSession s = request.getSession();
			String email = (String) s.getAttribute("email");

			UserDAO cp = new UserDAO();
			cp.updatePassword(newPass, email);
			out.println("Password updated successfully!");
		}
		catch(Exception e) {}
	}
}