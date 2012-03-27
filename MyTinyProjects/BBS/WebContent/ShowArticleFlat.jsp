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
	try {
		pageNo = Integer.parseInt(strPageNo.trim());
	} catch (NumberFormatException e) {
		pageNo = 1;
	}
	if (pageNo <= 0) {
		pageNo = 1;
	}
	
}



Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/bbs?user=root&password=amigo";
Connection conn = DriverManager.getConnection(url);

Statement stmtCount = conn.createStatement();
ResultSet rsCount = stmtCount.executeQuery("select count(*) from article where pid = 0");
rsCount.next();
int totalRecords = rsCount.getInt(1);

int totalPages = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
if (pageNo > totalPages) { pageNo = totalPages; }
int startPos = (pageNo - 1) * pageSize;


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
共<%=totalPages %>页
第<%=pageNo %>页
<br />

<a href="ShowArticleFlat.jsp?pageNo=<%=pageNo-1%>"> < </a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
<a href="ShowArticleFlat.jsp?pageNo=<%=pageNo+1%>"> > </a>

<!-- 不写action也成功了 -->
<form name="form" action="ShowArticleFlat.jsp">
	<select name="pageNo" onchange="document.form.submit()">
		<%
		for (int i=1; i<=totalPages; i++) {
		%>
			<option value="<%=i%>"  <%=(pageNo == i) ? "selected" : "" %>>第<%=i %>页
		<%	
		}
		%>
	</select>
</form>

<form name="formGo" action="ShowArticleFlat.jsp">
	<input type="text" name="pageNo" size="3" value=<%=pageNo %> />
	<input type="submit" value="go" />
</form>

</body>
</html>



















