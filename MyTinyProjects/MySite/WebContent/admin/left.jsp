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
		<script type="text/javascript">
			$(function() {
				$("a").focus(function() {
					$(this).blur();
				});
			
				/* 左侧菜单 */
				$("#left h5").click(function() {
					var obj = $(this).next();
					obj.is(":hidden") ? obj.slideDown("fast") : obj.slideUp("fast");
				});
				
				/* 判断浏览器 */
				if(!$.browser.msie) {
					$("#left").css({"margin-right":"3px","-moz-box-shadow":"2px 2px 3px #DDD","-webkit-box-shadow":"2px 2px 3px #DDD"});
				};
			})
		</script>
	</head>
	<body>
		<div id="left">
			<h5>主菜单</h5>
			<ul>
				<li><a href="main.jsp" target="frameRight">文章管理</a></li>
				<li><a href="setting.jsp" target="frameRight">基本设置</a></li>
			</ul>
			<h5>用户管理</h5>
			<ul>
				<li><a href="members.jsp" target="frameRight">用户管理</a></li>
			</ul>
			<h5>程序信息</h5>
			<ul>
				<li><a href="#">Others</a></li>
			</ul>
		</div>
	</body>
</html>