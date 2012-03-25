<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="counter" class="bean.Bean_Counter" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page_Bean</title>
</head>
<body>

<div align="center">
	<p> Page_Bean scope="page"
	</p>
	<jsp:setProperty name="counter" property="count" value="1"/>
	
	<p>visit count : </p>
	<jsp:getProperty name="counter" property="count" />
</div>

</body>
</html>