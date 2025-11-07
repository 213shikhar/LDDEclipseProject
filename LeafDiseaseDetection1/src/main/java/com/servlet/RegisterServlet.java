package com.servlet;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.UserDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// adding record to the database
			UserDAO udo = new UserDAO();
			udo.addRecord(name, password, email);
			
			PrintWriter out = response.getWriter();
			out.println("Record Added Successfully: "+name+" "+email+" "+password);
		}
		catch(Exception excp){}
	}
}
