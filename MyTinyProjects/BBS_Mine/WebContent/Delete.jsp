<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
//Say sorry when you have not logged in.
String admin = (String)session.getAttribute("admin");
if (null != admin && admin.equals("true")) {
	out.println("bad!");
	return;
}
%>    
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
		//把自己删了。
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
//数一下article里     所有pid=?的记录    有多少条。
String sql = "select count(*) from article where pid = " + pid;
ResultSet rs = stmt.executeQuery(sql);
rs.next();//这里，肯定有一条记录（被删的   父帖）。现在选择这条记录。
int count = rs.getInt(1);//第一个字段。


//count > 0 ， 还有孩子。
//没有子帖了。就把  父帖  更新为  叶子。
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

response.sendRedirect("ShowArticleFlat.jsp");
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