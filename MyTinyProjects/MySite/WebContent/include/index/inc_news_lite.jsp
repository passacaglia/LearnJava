<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
SimpleDateFormat pt = new SimpleDateFormat("MM-dd");
String date;
%>

<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
dba.createConn();
Connection conn = dba.getConn();

Statement stmt = conn.createStatement();
String sql = "select * from news order by publishtime desc";
ResultSet rs = stmt.executeQuery(sql);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

        <div class="box">
          <h2><a class='more' href='news_list.jsp'>更多..</a><span>新闻中心</span></h2>
          <div class="box_con">
            <ul>
<%
int count = 8;//不能写到全局变量里。(<%!)
while(rs.next()) { 
	count--;
	date = pt.format(rs.getDate("publishtime"));
%>
              <li><a href="news_content.jsp?id=<%= rs.getInt("id") %>"><%=rs.getString("title") %></a><span><%=date %></span></li>
<% 
	if (0 == count) {
		break;
	}
} 
%>
            </ul>
            
          </div>
        </div>


<%
rs.close();
stmt.close();
conn.close();
dba.closeConn();
%>
</body>
</html>