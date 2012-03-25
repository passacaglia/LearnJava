<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
		//与<%@include调用这个页面的   页面 使用的是同样的参数。  （把这个页面原封不动的放过去）   
		float dividend = Float.parseFloat(request.getParameter("number1")); 
		float dividor = Float.parseFloat(request.getParameter("number2"));
		double result = dividend/dividor; 
%>
		<%= result %>
<%	
%>

</body>
</html>

















