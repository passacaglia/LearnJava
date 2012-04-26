<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
}
%>
<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
if(dba.createConn()) {
	String sql = "select * from news order by publishtime desc";
	dba.query(sql);
	
}
%>
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Site Management Centre</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="themes/Google/common.css" media="screen" id="themes" />
		<script type="text/javascript" src="scripts/jquery.min.js"></script>
		<script type="text/javascript" src="scripts/jquery.cookie.js"></script>
		<script type="text/javascript" src="scripts/common.js"></script>
	</head>
	<body>
		<div id="main">
			
			<table border="0px" cellpadding="0px" cellspacing="0px">
				<tr>
					<th width="8%">多选</th>
					<th width="12%">ID</th>
					<th width="25%">标题</th>
					<th width="18%">发布时间</th>
					<th width="12%">发布者</th>
					<th width="25%">操作</th>
				</tr>
<% while(dba.next()) { %>
				<tr>
					<td><label><input type="checkbox" value="1" /></label></label></td>
					<td><jsp:getProperty name="dba" property="id" /></td>
					<td><jsp:getProperty name="dba" property="title" /></td>
					<td><jsp:getProperty name="dba" property="publishtime" /></td>
					<td><jsp:getProperty name="dba" property="username" /></td>
					<td><a href="#" class="edit">编辑</a> | <a href="#" class="delete">删除</a></td>
				</tr>
<% } %>
					
					
					
				
<%
dba.closeRs();
dba.closeStmt();
dba.closeConn();
%>
			</table>
		</div>
	</body>
</html>