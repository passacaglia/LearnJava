<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
request.setCharacterEncoding("utf8");
int id = Integer.parseInt(request.getParameter("id"));
int rootid = Integer.parseInt(request.getParameter("rootid"));
String title = request.getParameter("title");
String cont = request.getParameter("cont");

cont = cont.replaceAll("\n", "<br />");


Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/bbs?user=root&password=amigo";
Connection conn = DriverManager.getConnection(url);

conn.setAutoCommit(false);
String sql = "insert into article values (null, ?, ?, ?, ?, now(), 0)";
PreparedStatement prstmt = conn.prepareStatement(sql);
Statement stmt = conn.createStatement();

prstmt.setInt(1, id);
prstmt.setInt(2, rootid);
prstmt.setString(3, title);
prstmt.setString(4, cont);
prstmt.executeUpdate();
stmt.executeUpdate("update article set isleaf = 1 where id = " + id);

conn.commit();
conn.setAutoCommit(true);

stmt.close();
prstmt.close();
conn.close();

response.sendRedirect("ShowArticleTree.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply OK</title>
</head>
<body>

</body>
</html>