<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%!
String more = ""; 
%>

<%
String who = request.getParameter("who");
if ((null != who) && ("" != who) && who.equals("index")) {
	more = "<a class='more' href='news_list.jsp'>更多..</a>";
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

        <div class="box box1">
          <h2><%=more %><% more=""; %><span>企业介绍</span></h2>
          <div class="box_con">
            <ul>
              <li><a href="#">纯CSS实现三列DIV等高布局</a></li>
              <li><a href="#">HTML元素的ID和Name属性的区别</a></li>
              <li><a href="#">完美兼容ie6,ie7,ie8以及firefox的css透明滤镜</a></li>
              <li><a href="#">DIV+CSS实现放大镜效果的分页样式</a></li>
              <li><a href="#">javascript为FF设置首页</a></li>
              <li><a href="#">复制到系统剪贴板之IE,ff兼容版</a></li>
              <li><a href="#">DIV+CSS实现放大镜效果的分页样式</a></li>
            </ul>
          </div>
        </div>


</body>
</html>