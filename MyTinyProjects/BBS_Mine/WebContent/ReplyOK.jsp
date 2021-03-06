<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%
//解决 发帖 乱码问题
request.setCharacterEncoding("utf8");
int id = Integer.parseInt(request.getParameter("id"));
int rootid = Integer.parseInt(request.getParameter("rootid"));
String title = request.getParameter("title");
String cont = request.getParameter("cont");
//换行的问题，这样解决。
cont = cont.replaceAll("\n", "<br />");

Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/bbs";
Connection conn = DriverManager.getConnection(url, "root", "amigo");

//为了保证插入记录和更新   新帖子的父帖   为  非叶子    一块成功,用transaction.
conn.setAutoCommit(false);
PreparedStatement pstmt = conn.prepareStatement("insert into article values (null, ?, ?, ?, ?, now(), 0)");
Statement stmt = conn.createStatement();

pstmt.setInt(1, id);
pstmt.setInt(2, rootid);
pstmt.setString(3, title);
pstmt.setString(4, cont);
pstmt.executeUpdate();
stmt.executeUpdate("update article set isleaf = 1 where id = " + id);//父帖  更新为  非叶子


conn.commit();
conn.setAutoCommit(true);

response.sendRedirect("ShowArticleTree.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply succeed!</title>
</head>
<body>

</body>
</html>