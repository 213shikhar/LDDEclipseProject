<%@page import="javax.naming.ldap.Rdn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dao.AdminDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<form action="adminReg.jsp" method="post">
		Name: <input type="text" name="name"/><br>
		Email: <input type="email" name="email"/><br>
		Password: <input type="password" name="password"/><br><br>
		<input type="submit"/>
	</form>

<% 
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	AdminDAO a = new AdminDAO();
	a.addAdmin(name, password, email);
%>
</body>
</html>