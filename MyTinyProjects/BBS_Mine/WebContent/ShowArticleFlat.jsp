<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String admin = (String)session.getAttribute("admin");
if (null != admin && admin.equals("true")) {
	login = true;
}
%>
<%!
boolean login = false;
int pageSize = 3;
%>
<%

String strPageNo = request.getParameter("pageNo");
int pageNo;
if (null == strPageNo || strPageNo.equals("")) {
	pageNo = 1;
} else {
	try {
		pageNo = Integer.parseInt(strPageNo.trim());
	} catch(NumberFormatException e) {
		pageNo = 1;
	}
	if (pageNo <= 0) {
		pageNo = 1;
	}
}
%>

<%
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/bbs";
Connection conn = DriverManager.getConnection(url, "root", "amigo");

Statement stmtCount = conn.createStatement();
String sql = "select count(*) from article where pid = 0";//pid = 0，所有的主题帖。
ResultSet rsCount = stmtCount.executeQuery(sql);
rsCount.next();

int totalRecords = rsCount.getInt(1);
int totalPages = totalRecords / pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
if (pageNo > totalPages) {
	pageNo = totalPages;
}
int startPos = (pageNo -1 ) * pageSize;

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
<a href="Post.jsp">新帖子</a>
<table border=1>
	<tr><td>id</td><td>content</td></tr>
<%	while(rs.next()) {
%>
		<tr>
			<td><%=rs.getInt("id") %></td>
			<td><%=rs.getString("title") %></td>
		</tr>	
<%
	}
login = false;
rsCount.close();
stmtCount.close();
rs.close();
stmt.close();
conn.close();
%>
</table>

共<%=totalPages %>页
第<%=pageNo %>页

</body>
</html>




















