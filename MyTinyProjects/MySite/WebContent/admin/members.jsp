<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
}
%>

<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
if(dba.createConn()) {
	String sql = "select * from user";
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
			<div class="menu_type">
				<ul>
					<li><a href="#">用户列表</a></li>
					<li><a href="#">添加新用户</a></li>
					<li><a href="#">已禁止用户</a></li>
					<li><a href="#">用户权限设置</a></li>
				</ul>
			</div>
			<h5><span class="fl">用户列表</span><span class="fr">共 3450 条记录 | <a href="javascript:window.location.reload()">刷新本页</a></span></h5>
			<table border="0px" cellpadding="0px" cellspacing="0px">
				<tr>
					<th width="8%">多选</th>
					<th width="12%">ID</th>
					<th width="25%">用户名</th>
					<th width="30%">邮箱</th>
					<th width="25%">操作</th>
				</tr>
<% while(dba.next()) { %>
				<tr>
					<td><label><input type="checkbox" value="1" /></label></label></td>
					<td><jsp:getProperty name="dba" property="id" /></td>
					<td><jsp:getProperty name="dba" property="username" /></td>
					<td><jsp:getProperty name="dba" property="email" /></td>
					<td><a href="#" class="edit">编辑</a> | <a href="#" class="delete">删除</a></td>
				</tr>
<% } %>
<%
dba.closeRs();
dba.closeStmt();
dba.closeConn();
%>
				
			</table>
			<p class="pager">
				<span class="fl"><input type="button" value="操作 ▼" class="bnCss" /> 每页 10 条，共分 4 页</span>
				<span class="fr"><a href="#">上一页</a><a href="#">1</a><a href="#">2</a><a href="#">3</a><a href="#">下一页</a></span>
			</p>
		</div>
	</body>
</html>