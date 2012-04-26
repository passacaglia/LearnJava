<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
}
%>

<%
String strId = (String)request.getParameter("id");
int id = Integer.parseInt(strId);

%>

<% 
//解决 发帖 乱码问题
request.setCharacterEncoding("utf8");
String action = request.getParameter("action");
if (null != action && action.equals("edit")) {

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	//换行的问题，这样解决。
	content = content.replaceAll("\n", "<br />");

	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/mysite";
	Connection conn = DriverManager.getConnection(url, "root", "amigo");

	Statement stmt = conn.createStatement();
	String sql = "update news set title='" + title + "', content='" + content + "' where id=" + id;
	stmt.execute(sql);
	
	stmt.close();
	conn.close();

	
	response.sendRedirect("../include/inc_news_content.jsp?id=" + id);

}

%>


<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
if(dba.createConn()) {
	String sql = "select * from news where id=" + id;
	dba.query(sql);
	dba.next();
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="../js/xheditor-1.1.13-zh-cn.min.js"></script>
<script type="text/javascript" src="scripts/checkdata.js"></script>

<title>Insert title here</title>
</head>
<body>

<div>
	<form name="form" action="edit.jsp?id=<%=id %>" method="post" onsubmit="return checkdata()">
	<input name="action" type="hidden" value="edit" />
	<table>
		<tr>
			<td>标题 : </td>
			<td>
				<input name="title" type="text" size="72" 
						value="<jsp:getProperty name="dba" property="title" />"   >
				</input>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><span id="errorTitle">标题不少于5个字不多于20个字，可使用中文，英文字母，数字，下横线。内容至少一个字。</span></td>
		</tr>
		<tr>
			<td>内容 : </td>
			<td>
				<textarea name="content" class="xheditor" cols="85" rows="20" onblur="return checkdata()">
					<jsp:getProperty name="dba" property="title" />
				</textarea>
			</td> 
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="submit" /></td>
		</tr>
	</table>
</form>
	
</div>


<%
dba.closeRs();
dba.closeStmt();
dba.closeConn();
%>
</body>
</html>