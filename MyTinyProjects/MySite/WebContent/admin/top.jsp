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
	<body id="top_page">
		<div id="top">
			<div class="logo fl"><h1>网站管理系统</h1><p>Site Management Centre</p></div>
			<div class="nav">
				<div class="top_menu">
					<p class="fl lh32">您好，<span class="red fwb">Administrator</span> [ <a href="logout.jsp" onclick="parent.location.reload()">退出</a> ]</p>
					<p class="fr lh32"><a href="#">Maps</a> | <a href="../" target="_blank">网站首页</a> | <a href="#">管理后台</a> | <a href="#">帮助中心</a></p>
				</div>

				<div class="themes tr">
				当前主题： <select id="change_themes">
					<option value="Google" selected>Google</option>
					<option value="Default">Default</option>
				</select>
				</div>

			</div>
		</div>
	</body>
</html>