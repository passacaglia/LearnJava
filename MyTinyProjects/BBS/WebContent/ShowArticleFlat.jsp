<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%
int pageSize = 3;

String strPageNo = request.getParameter("pageNo");
int pageNo;
if (null == strPageNo || strPageNo.equals("")) {
	pageNo = 1;
} else {
	pageNo = Integer.parseInt(strPageNo.trim());
}

int startPos = (pageNo - 1) * pageSize;


Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/bbs?user=root&password=amigo";
Connection conn = DriverManager.getConnection(url);

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from article where pid = 0 order by pdate desc limit " + startPos + ", " + pageSize);

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Article Flat</title>
</head>
<body>
<a href='Post.jsp'>发新帖</a>
<a href="Login.jsp">登录</a>

<table border="1">
<%
while (rs.next()) {
%>
	<tr>
		<td>
			<%=rs.getInt("id") %>
		</td>
		<td>
			<%=rs.getString("title") %>
		</td>	
	</tr>
<%
}
rs.close();
stmt.close();
conn.close();
%>
</table>
</body>
</html>



















