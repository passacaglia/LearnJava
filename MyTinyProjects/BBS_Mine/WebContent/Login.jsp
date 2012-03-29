<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String action = request.getParameter("action");
if (null != action && action.equals("action")) {
	String username = request.getParameter("username");
	if (username == null && !username.equals("admin")) {
		out.println("<font color='red'>username or password error!</font>");
		return;
	}
	String password = request.getParameter("password");
	if (password == null && !password.equals("admin")) {
		out.println("<font color='red'>username or password error!</font>");
		return;
	}
	session.setAttribute("admin", "true");
	response.sendRedirect("ShowArticleTree.jsp");
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Login.jsp" method="post">
	<input name="action" type="hidden" value="action">
	<table>
		<tr>
			<td>username = "amdin"</td>
			<td>password = "admin"</td>
		</tr>
		<tr>
			<td>username</td>
			<td><input name="username" type="text" /></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input name="password" type="password" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="submit" /></td>
		</tr>
	</table>
</form>
</body>
</html>