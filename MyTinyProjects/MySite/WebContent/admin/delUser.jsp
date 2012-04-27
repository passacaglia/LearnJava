<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
}
%>
<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
int id = Integer.parseInt((String)request.getParameter("id"));
String str = "";
if (1 == id) {
	str = "<font color='red'>You should not delete admin.</font>";
	return;
}
String sql = "delete from user where id=" + id;
if (dba.createConn()) {
	if (dba.update(sql)) {
		dba.closeStmt();
		dba.closeConn();
		str = "删除成功！";
	}
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>删除用户</title>

<style type="text/css">
<!--
body {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 14px;
	line-height: 1.5px;
	font-weight: bold;
	color: #333;
	text-decoration: none;
}
#main {
	background-color: #CCC;
	display: block;
	height: auto;
	width: 200px;
	padding: 20px;
	margin-top: 30px;
	margin-right: auto;
	margin-bottom: auto;
	margin-left: 30px;
	font-family: Verdana, Geneva, sans-serif;
	font-weight: bold;
	font-size: 14px;
}
-->
</style>
</head>

<body>
<div id="main">
	<%=str %>
</div>
<div id="main">
    <a href="members.jsp">返回</a></div>    
</body>
</html>