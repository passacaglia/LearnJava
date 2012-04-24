<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<title>Site Management Centre</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	</head>
	<frameset rows="60px,*,24px" cols="*" name="frameAll" id="frameAll" frameborder="0" framespacing="0">
		<!--框架上部分-->
		<frame src="top.html" name="frameTop" id="frameTop" scrolling="no" noresize />
		<!--框架右侧和左侧-->
		<frameset cols="180px,*" name="frameMain" id="frameMain" frameborder="0" framespacing="0" >
			<!--框架左侧-->
			<frame src="left.html" name="frameLeft" id="frameLeft" scrolling="no" noresize />
			<!--框架右侧-->
			<frame src="main.html" name="frameRight" id="frameRight" scrolling="yes" noresize style="overflow-x:hidden" />
		</frameset>
		<!--框架下部分-->
		<frame src="bottom.html" name="frameButtom" id="frameButtom" scrolling="no" frameborder="0" noresize />
	</frameset>
	<noframes>
		<body><h1>您的浏览器不支持框架，该升级您的浏览器了！</h1></body>
	</noframes>
</html>