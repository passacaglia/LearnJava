<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
//解决 发帖 乱码问题
request.setCharacterEncoding("utf8");
String action = request.getParameter("action");
if (null != action && action.equals("post")) {
	
	String title = request.getParameter("title");
	String cont = request.getParameter("cont");
	//换行的问题，这样解决。
	cont = cont.replaceAll("\n", "<br />");

	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/bbs";
	Connection conn = DriverManager.getConnection(url, "root", "amigo");

	//为了保证插入记录和更新   新帖子的父帖   为  非叶子    一块成功,用transaction.
	conn.setAutoCommit(false);
	String sql = "insert into article values (null, 0, ?, ?, ?, now(), 0)";
	PreparedStatement prstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	Statement stmt = conn.createStatement();

	prstmt.setInt(1, -1);
	prstmt.setString(2, title);
	prstmt.setString(3, cont);
	prstmt.executeUpdate();

	ResultSet rsKey = prstmt.getGeneratedKeys();
	rsKey.next();
	int key = rsKey.getInt(1);
	rsKey.close();
	stmt.executeUpdate("update article set rootid = " + key + " where id = " + key);


	conn.commit();
	conn.setAutoCommit(true);

	response.sendRedirect("ShowArticleFlat.jsp");

}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply</title>
</head>
<body>


<form action="Post.jsp" method="post">
	<input name="action" type="hidden" value="post" />
	<table>
		<tr>
			<td>title</td>
			<td><input name="title" type="text" size="72" /></td>
		</tr>
		<tr>
			<td>content</td>
			<td><textarea name="cont" cols="55" rows="10"></textarea></td> 
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="submit" /></td>
		</tr>
	</table>
</form>


</body>
</html>