<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String rootid = request.getParameter("rootid");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reply</title>
</head>
<body>


	<form action="ReplyOK.jsp" method="post">
		<!-- 用隐藏域来传递id & rootid -->
		<input name="id" type="hidden" value=<%=id %> />
		<input name="rootid" type="hidden" value=<%=rootid %> />
			<table>
				<tr>
					<td>title</td>
					<td><input name="title" type="text" size="72" /></td>
				</tr>
				<tr>
					<td>content</td>
					<td><textarea name="cont" cols="55" rows="10"></textarea></td> 
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" /></td>
				</tr>
			</table>
	</form>


</body>
</html>