<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
int id = Integer.parseInt(request.getParameter("id"));
int rootid = Integer.parseInt(request.getParameter("rootid"));
out.println("reply: " + id);
out.println("topic: " + rootid);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply</title>
</head>
<body>

<div>

	<form action="ReplyOK.jsp" method="post">
		<input type="hidden" name="id" value="<%=id %>" />
		<input type="hidden" name="rootid" value="<%=rootid %>" />
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


















