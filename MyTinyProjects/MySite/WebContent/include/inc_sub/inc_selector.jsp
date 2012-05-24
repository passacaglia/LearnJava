<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//get pageNo & totalPages

int pageNo = Integer.parseInt(request.getParameter("pageNo"));
int totalPages = Integer.parseInt(request.getParameter("totalPages"));
%>

<%
String whoUseMe = (String)request.getParameter("whoUseMe");
String str = whoUseMe;
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

			<div id="selector1">
	            <a href="<%=str %>?pageNo=<%= pageNo - 1 %>"> 上一页 </a>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="<%=str %>?pageNo=<%= pageNo + 1 %>"> 下一页 </a>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <b>第<%=pageNo %>页</b>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <b>共<%=totalPages %>页</b>
	            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            
            <div id="selector2">
	            <form name="form" action="<%=str %>">
	            	<select name="pageNo" onchange="form.submit()">
		            	<% for (int i=1; i<=totalPages; i++) { %>
		            		<option value=<%=i%>  <%=(pageNo == i) ? "selected" : "" %> >第  <%=i %> 页</option>
		            	<% } %>
					</select>	            	
	            </form>
			</div>

</body>
</html>