<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>   
<% request.setCharacterEncoding("gbk"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String num1 = request.getParameter("number1");
String num2 = request.getParameter("number2");
%>

<!-- 两种include的方式 -->
<% if ((num1.length() < 1) || (num2.length() < 1)) {
	out.println("Please input the right number!");
%>
<% } else if (request.getParameter("compute").equals("divide")) { %>
<%@ include file="divide.jsp" %>
<% } else { %>
<jsp:include page="multiply.jsp" >
	<jsp:param name="n1" value="<%=num1 %>" />
	<jsp:param name="n2" value="<%=num2 %>" />
</jsp:include>
<% } %>




</body>
</html>

