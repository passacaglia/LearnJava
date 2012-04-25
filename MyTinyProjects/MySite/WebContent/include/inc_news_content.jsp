<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
//get & set id
String strId = request.getParameter("id");
int id;
if ((null == strId) || strId.equals("")) {
	id = 1;
} else {
	id  = Integer.parseInt(strId.trim());
}
%>

<%
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/mysite?user=root&password=amigo";
Connection conn = DriverManager.getConnection(url);

Statement stmt = conn.createStatement();
String sql = "select * from news where id = " + id;
ResultSet rs = stmt.executeQuery(sql);
rs.next();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

        <div class="box">
          <h2><span>新闻中心</span></h2>
          <div class="box_con">
            <ul>

              <table>
              	<tr>
              		<td><h1><%=rs.getString("title") %></h1></td>
              	</tr>
              	<tr>
              		<td><%=rs.getString("publishtime") %></td>
              	</tr>
              	<tr>
              		<td><%=rs.getString("content") %></td>
              	</tr>
              </table>

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