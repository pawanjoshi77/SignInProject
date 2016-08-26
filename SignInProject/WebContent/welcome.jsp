<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="loginService" class="com.pawanjoshi.service.LoginService"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(loginService.authenticate(request)) {
		%>
	<h3>Login Successful!!!</h3>
	<h4>
		Hello,
		<%=session.getAttribute("name") %></h4>
		<% 			
		} else {
			out.println("Invalid username/password");
		}
	%>
</body>
</html>
