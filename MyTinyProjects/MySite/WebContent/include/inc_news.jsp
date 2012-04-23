<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%!
String more = "";
int pageSize = 15;
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
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost/mysite?user=root&password=amigo";
Connection conn = DriverManager.getConnection(url);

Statement stmtCount = conn.createStatement();
String sql = "select * from news order by publishtime desc";
ResultSet rsCount = stmtCount.executeQuery(sql);

rsCount.next();
//total records --> total pages
int totalRecords = rsCount.getInt(1);
int totalPages = totalRecords / pageSize == 0 ? (totalRecords/pageSize) : (totalRecords/pageSize + 1);
if (pageNo > totalPages) {
	pageNo = totalPages;
}
//starts
int startPos = (pageNo-1) * pageSize;

//按分页的方式查询。
Statement stmt = conn.createStatement();
String sql2 = "select * from news order by publishtime desc limit " + startPos + ", " + pageSize;
ResultSet rs = stmt.executeQuery(sql2);
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
            
            <div id="selector1">
	            <a href="news_list.jsp?pageNo=<%= pageNo - 1 %>"> 上一页 </a>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="news_list.jsp?pageNo=<%= pageNo + 1 %>"> 下一页 </a>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <b>第<%=pageNo %>页</b>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <b>共<%=totalPages %>页</b>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            
            <div id="selector2">
	            <form name="form" action="news_list.jsp">
	            	<select name="pageNo" onchange="document.form.submit()">
		            	<% for (int i=1; i<=totalPages; i++) { %>
		            		<option value=<%=i%>  <%=(pageNo == i) ? "selected" : "" %> >第  <%=i %> 页</option>
		            	<% } %>
					</select>	            	
	            </form>
			</div>	            
          </div>
        </div>


<%
rsCount.close();
stmtCount.close();
rs.close();
stmt.close();
conn.close();
%>
</body>
</html>