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

String c = request.getParameter("count");
int count = -1;//不传参数过来。就是-1。
if ((null != c) && ("" != c)) {
	count = Integer.parseInt(c);
//System.out.println(c);
}

%>

<%
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/mysite?user=root&password=amigo";
Connection conn = DriverManager.getConnection(url);

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
          <h2><%=more %><% more=""; %><span>新闻中心</span></h2>
          <div class="box_con">
            <ul>
<% 
while(rs.next()) {
	count--;//只有index.jsp传过来的是8,大于0。有可能通过自减，到0.
%>
              <li><a href="#"><%=rs.getString("title") %></a><span><%=rs.getInt("publishtime") %></span></li>
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
%>
</body>
</html>