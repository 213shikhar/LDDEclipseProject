<%@page import="javax.naming.ldap.Rdn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dao.AdminDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>
    <form action="adminLog.jsp" method="post">
        Email: <input type="email" name="email"/><br>
        Password: <input type="password" name="password"/><br><br>
        <input type="submit"/>
    </form>
<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	AdminDAO b = new AdminDAO();
	boolean found = b.checkAdmin(email, password);
	if(found == true){
		// creating a session
		HttpSession s = request.getSession();
		s.setAttribute("email", email);
		s.setAttribute("password", password);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
		rd.forward(request, response);
	}
	// ASK ABOUT WHY ELSE CONDITION IS RUNNING!
	else{
		out.println("<html><body><h2>User Not Found! Please Register: "
				+ "<a href='register.html'>Register</a></body></html>");
		// response.sendRedirect("index.html");
	}
%>
</body>
</html>