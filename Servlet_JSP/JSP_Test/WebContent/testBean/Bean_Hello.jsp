<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bean_Hello.jsp</title>
</head>
<body>

<jsp:useBean id="hello" class="bean.Bean_Hello" scope="request"></jsp:useBean>


<div align="center">
	<p>
	<!-- property=*:有前一个页面提交到这个页面的时候，form里面的值，挨个儿调用setXXX()。 -->
	<!-- form和Bean里的值一一对应就行，用的很少。struts里用的多 -->
	<jsp:setProperty name="hello" property="*" />    
	<% out.println("set"); %>
	<br />
	<jsp:getProperty name="hello" property="gender" />
	<jsp:getProperty name="hello" property="name" />
	<br />
	<% out.println("welcome"); %>
	
	</p>
</div>



</body>
</html>