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

//算出总页数、起始页数
int totalRecords = rsCount.getInt(1);
int totalPages = totalRecords / pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;
if (pageNo > totalPages) {
	pageNo = totalPages;
}
int startPos = (pageNo -1 ) * pageSize;

//按  日期 的逆序、  分页的方式查询。
//日期的逆序：order by pdate desc 
//mysql里的分页用 : limit startPosition, pageSize
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

<%	while(rs.next()) {
%>
		<tr>
			<td><%=rs.getInt("id") %></td>
			<td><a href="ShowArticleCont.jsp?id=<%=rs.getInt("id") %>">
				<%=rs.getString("title") %></a>
				</td>
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
&nbsp;&nbsp;

<br />
<a href="ShowArticleFlat.jsp?pageNo=<%=pageNo-1 %>"> < </a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="ShowArticleFlat.jsp?pageNo=<%=pageNo+1 %>"> > </a>
<br />
<br />

<!-- doucment.formName.submit() -->
<form name="form" action="ShowArticleFlat.jsp" method="post">
	<select name="pageNo" onchange="document.form.submit()">
		<%
			for (int i=1; i<=totalPages; i++) {
		%>				
				<option value="<%=i %>" <%=(pageNo == i) ? "selected" : "" %> > 第 &nbsp; <%=i %> &nbsp; 页 
		<%	
			}
		%>
	</select>
</form>

<br />
<br />

<form name="form_go">
	<input type="text" name="pageNo" size="3">
	<input type="submit" value="go">
</form>



<br />
<br />

<p>
只是简单地表现了分页、树状展示。
</p>
</body>
</html>




















