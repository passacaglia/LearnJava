<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
//这里不用检查，自已传过来的东西。
int id = Integer.parseInt(request.getParameter("id"));
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/bbs";
Connection conn = DriverManager.getConnection(url, "root", "amigo");

Statement stmt = conn.createStatement();
String sql = "select * from article where id = " + id;
ResultSet rs = stmt.executeQuery(sql);
String str = "";
if (rs.next()) {
	str = "<tr><td>id</td><td>" + rs.getInt("id") + "</td></tr>" +
		  "<tr><td>title</td><td>" + rs.getString("title") + "</td></tr>" +
		  "<tr><td>content</td><td>" + rs.getString("cont") + "</td></tr>";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=rs.getString("title") %></title>
</head>
<body>
<table border="1">
<%=str %>
</table>
<a href="Reply.jsp?id=<%=rs.getInt("id")%>&rootid=<%=rs.getInt("rootid") %>">Reply</a>

<%
rs.close();
stmt.close();
conn.close();
%>
</body>
</html>