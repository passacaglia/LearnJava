<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="java.io.*" %>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
}
%>
<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />

<%
//get & set pageNo
String strPageNo = request.getParameter("pageNo");
int pageNo;
if ((null == strPageNo) || strPageNo.equals("")) {
	pageNo = 1;
} else {
	try {
		 pageNo = Integer.parseInt(strPageNo.trim());
	} catch(NumberFormatException e) {
		pageNo = 1;
	}
	if (pageNo <= 0) {
		pageNo = 1;
	}
}

%>
<%
int totalRecords = 1;
int totalPages = 1;
int pageSize = 20;
if(dba.createConn()) {
	String sql = "select count(*) from news order by publishtime desc";
	dba.query(sql);
	ResultSet rsCount = dba.getRs();
	if (rsCount.next()) {
		totalRecords = rsCount.getInt(1);
		totalPages = totalRecords / pageSize == 0 ? (totalRecords/pageSize) : (totalRecords/pageSize + 1);
		if (0 == totalPages) {
			totalPages = 1;
		}
		if (pageNo > totalPages) {
			pageNo = totalPages;
		}
		//starts
		int startPos = (pageNo-1) * pageSize;

		//按分页的方式查询。
		String sql2 = "select * from news order by publishtime desc limit " + startPos + ", " + pageSize;
		dba.query(sql2);
	} else {
		PrintWriter pw = response.getWriter();
		pw.println("<font color='red'>Sorry, there is no article in your db.</font>");
		pw.println("<font color='red'>Please write some thing first.</font>");
		pw.println("<a href='post.jsp'>Click me to write an article.</a>");
	}

}
%>
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Site Management Centre</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="themes/Google/common.css" media="screen" id="themes" />
		<script type="text/javascript" src="scripts/jquery.min.js"></script>
		<script type="text/javascript" src="scripts/jquery.cookie.js"></script>
		<script type="text/javascript" src="scripts/common.js"></script>
	</head>
	<body>
		
			<div id="main">
			
			<jsp:include page="../include/inc_sub/inc_selector.jsp">
            	<jsp:param name="pageNo" value="<%=pageNo %>" />
            	<jsp:param name="totalPages" value="<%=totalPages %>" />
            	<jsp:param name="whoUseMe" value="main.jsp" />
        	</jsp:include>
				
			<table border="0px" cellpadding="0px" cellspacing="0px">
				<tr>
					<th width="8%">多选</th>
					<th width="12%">ID</th>
					<th width="25%">标题</th>
					<th width="18%">发布时间</th>
					<th width="12%">发布者</th>
					<th width="25%">操作</th>
				</tr>
<% while(dba.next()) { %>
				<tr>
					<td><label><input type="checkbox" value="1" /></label></label></td>
					<td><jsp:getProperty name="dba" property="id" /></td>
					<td><a href="../include/inc_news_content.jsp?id=<jsp:getProperty name="dba" property="id" />">
							<jsp:getProperty name="dba" property="title" />
						</a></td>
					<td><jsp:getProperty name="dba" property="publishtime" /></td>
					<td><jsp:getProperty name="dba" property="username" /></td>
					<td><a href="edit.jsp?id=<%=dba.getId() %>" class="edit">编辑</a> | <a href="edit.jsp?id=<%=dba.getId() %>&action=del" class="delete">删除</a></td>
				</tr>
<% } %>
		</table>
		
		<jsp:include page="../include/inc_sub/inc_selector.jsp">
            	<jsp:param name="pageNo" value="<%=pageNo %>" />
            	<jsp:param name="totalPages" value="<%=totalPages %>" />
            	<jsp:param name="whoUseMe" value="main.jsp" />
        </jsp:include>
		
		</div>
		
		
           
	</body>
<%
dba.closeRs();
dba.closeStmt();
dba.closeConn();
%>
</html>