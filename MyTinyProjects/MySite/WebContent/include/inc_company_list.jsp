<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%!
int pageSize = 15;
SimpleDateFormat pt = new SimpleDateFormat("yyyy-MM-dd");
String date;
%>

<%
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

<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
dba.createConn();
Connection conn = dba.getConn();

Statement stmtCount = conn.createStatement();
String sql = "select count(*) from company order by publishtime desc";
ResultSet rsCount = stmtCount.executeQuery(sql);

int totalRecords = 0;
if (rsCount.next()) {
	//total records --> total pages
	totalRecords = rsCount.getInt(1);
}
int totalPages = totalRecords / pageSize == 0 ? (totalRecords/pageSize) : (totalRecords/pageSize + 1);
if (0 == totalPages) {
	totalPages = 1;
}
if (pageNo > totalPages) {
	pageNo = totalPages;
}
//starts
int startPos = (pageNo-1) * pageSize;

//按分页的方式查询。
Statement stmt = conn.createStatement();
String sql2 = "select * from company order by publishtime desc limit " + startPos + ", " + pageSize;
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
          <h2><span>企业介绍</span></h2>
          <div class="box_con">
            <ul>
<% 
while(rs.next()) {
	count--;//只有index.jsp传过来的是8,大于0。有可能通过自减，到0.
	date = pt.format(rs.getDate("publishtime"));
%>
              <li><a href="company_content.jsp?id=<%=rs.getInt("id") %>"><%=rs.getString("title") %></a><span><%=date %></span></li>
<% 
	if (0 == count) {
		break;
	}
} 
%>
            </ul>
            
            <jsp:include page="inc_sub/inc_selector.jsp">
            	<jsp:param name="pageNo" value="<%=pageNo %>" />
            	<jsp:param name="totalPages" value="<%=totalPages %>" />
            	<jsp:param name="whoUseMe" value="company_list.jsp" />
            </jsp:include>
                        
          </div>
        </div>


<%
rsCount.close();
stmtCount.close();
rs.close();
stmt.close();
conn.close();
dba.closeConn();
%>
</body>
</html>