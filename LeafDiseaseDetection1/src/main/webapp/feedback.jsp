<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dao.UserDAO" %>
    <%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Feedback</h1>
<% 
	HttpSession s = request.getSession();
	UserDAO u = new UserDAO();
	
	// fetching values from session
	String email = (String) s.getAttribute("email");
	String pass = (String) s.getAttribute("password");
	
	// displaying name on feedback screen
	ResultSet rs = u.profileUser(email, pass);
	if(rs.next()){
		out.println("Hello "+rs.getString(1)+" Please provide your valuable feedback!<br>");	
	}
	
	// getting feedback from user
	String fdb = request.getParameter("fdb");
	
	// adding feedback to the datbase	
	u.addFeedback(fdb, email);
%>
<form action="feedback.jsp" method="post">
	Feedback: <input type="textarea", name="fdb", rows=5, cols=10 /><br>
	<input type="submit" />
</form>

</body>
</html>