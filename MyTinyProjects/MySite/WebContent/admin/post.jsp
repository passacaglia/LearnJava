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
<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%

//解决 发帖 乱码问题
request.setCharacterEncoding("utf8");
String action = request.getParameter("action");
if (null != action && action.equals("post")) {

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	//换行的问题，这样解决。
	content = content.replaceAll("\n", "<br />");

	dba.createConn();
	Connection conn = dba.getConn();

	//为了保证插入记录和更新   新帖子的父帖   为  非叶子    一块成功,用transaction.
	conn.setAutoCommit(false);
	String sql = "insert into news values (null, ?, ?, now(), ?)";
	PreparedStatement prstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	Statement stmt = conn.createStatement();

	prstmt.setString(1, title);
	prstmt.setString(2, content);
	prstmt.setString(3, username);
	prstmt.executeUpdate();

	ResultSet rsKey = prstmt.getGeneratedKeys();
	rsKey.next();
	int key = rsKey.getInt(1);
	rsKey.close();

	conn.commit();
	conn.setAutoCommit(true);

	stmt.close();
	prstmt.close();
	conn.close();
	dba.closeConn();
	
	response.sendRedirect("../include/inc_news_content.jsp?id=" + key);

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
	<form name="form" action="post.jsp" method="post" onsubmit="return checkdata()">
	<input name="action" type="hidden" value="post" />
	<table>
		<tr>
			<td>标题 : </td>
			<td><input name="title" type="text" size="72"/></td>
		</tr>
		<tr>
			<td></td>
			<td><span id="errorTitle">标题不少于5个字不多于20个字，可使用中文，英文字母，数字，下横线。内容至少一个字。</span></td>
		</tr>
		<tr>
			<td>内容 : </td>
			<td><textarea name="content" class="xheditor" cols="85" rows="20"  onblur="return checkdata()"></textarea></td> 
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="保存"  /></td>
		</tr>
	</table>
</form>
	
</div>


<%

%>
</body>
</html>