<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%!
private void del(Connection conn, int id) {
	Statement stmt = null;
	ResultSet rs = null;
	try {
		stmt = conn.createStatement();
		String sql = "select * from article where pid = " + id;
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			del(conn, rs.getInt("id"));
		}
		stmt.executeUpdate("delete from article where id = " + id);
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			} 
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
%>

<%
int id = Integer.parseInt(request.getParameter("id"));
int pid = Integer.parseInt(request.getParameter("pid"));

Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/bbs";
Connection conn = DriverManager.getConnection(url, "root", "amigo");

conn.setAutoCommit(false);
del(conn, id);

//把要删除的帖子的父贴的isleaf设为0(是叶子)，如果父贴没有其它子贴的话。
Statement stmt = conn.createStatement();
String sql = "select count(*) from article where pid = " + pid;
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int count = rs.getInt(1);

if (count <= 0) {
	Statement stmtUpdate = conn.createStatement();
	stmtUpdate.executeUpdate("update article set isleaf = 0 where id = " + pid);
	stmtUpdate.close();
}

//here commit 
conn.commit();
conn.setAutoCommit(true);

rs.close();
stmt.close();
conn.close();

response.sendRedirect("ShowArticleTree.jsp");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>