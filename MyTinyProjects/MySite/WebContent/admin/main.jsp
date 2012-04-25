<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
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
					<th width="25%">用户名</th>
					<th width="30%">邮箱</th>
					<th width="25%">操作</th>
				</tr>
				<tr>
					<td><label><input type="checkbox" value="1" /></label></label></td>
					<td>1</td>
					<td>administrator</td>
					<td>thenbsp@gmail.com</td>
					<td><a href="#" class="edit">编辑</a> | <a href="#" class="delete">删除</a></td>
				</tr>
				<tr>
					<td><label><input type="checkbox" value="1" /></label></td>
					<td>2</td>
					<td>thenbsp</td>
					<td>thenbsp@gmail.com</td>
					<td><a href="#" class="edit">编辑</a> | <a href="#" class="delete">删除</a></td>
				</tr>
				<tr>
					<td><label><input type="checkbox" value="1" /></label></td>
					<td>3</td>
					<td>杨龙</td>
					<td>26212156@qq.com</td>
					<td><a href="#" class="edit">编辑</a> | <a href="#" class="delete">删除</a></td>
				</tr>

			</table>
		</div>
	</body>
</html>