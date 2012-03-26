<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String action = request.getParameter("action");
if (null != action && action.equals("login")) {
	String uname = request.getParameter("uname");
	String password = request.getParameter("pwd");
	if (null == uname || !uname.equals("admin") ||
			null == password || !password.equals("admin")) {
		out.println("<font color='red'>username or password not correct!</font>");
		out.println(uname);
		out.println(password);
		//return;
	} else {
		out.println(uname+ "dd");
		response.sendRedirect("ShowArticleTree.jsp");
	}
}

%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<form action="Login.jsp" method="post">
	<input type="hidden" name="action" value="login" />
		<h4>"Welcome to my tiny BBS"</h4>
		<table>
			<tr><td>username=admin"</td><td>password=admin</td></tr>
			<tr>
				<td>User Name : </td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" />
					<input type="reset" value="Reset" /></td>
			</tr>
		</table>		
	</form>
</div>

</body>
</html>