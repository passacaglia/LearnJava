<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
request.setCharacterEncoding("utf8");
String s = request.getParameter("action");
if (null != s && s.equals("post")) {
	String title = request.getParameter("title");
	String cont = request.getParameter("cont");
	cont = cont.replaceAll("\n", "<br />");

	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/bbs?user=root&password=amigo";
	Connection conn = DriverManager.getConnection(url);

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

	stmt.close();
	prstmt.close();
	conn.close();

	response.sendRedirect("ShowArticleTree.jsp");
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply</title>
</head>
<body>

<div>

	<form action="Post.jsp" method="post">
		<input type="hidden" name="action" value="post" />
		<table>
			<tr><td>
				<input type="text" name="title" size="90" />
			</td></tr>
			<tr><td>
				<textarea name="cont" rows="10" cols="70" ></textarea>
			</td></tr>
			<tr><td>
				<input type="submit" name="submit" value="submit"/>
			</td></tr>
		</table>	
	</form>

</div>


</body>
</html>


















