<html>
<head>
<title>forward_param</title>
</head>
<body>

<div align="center">forward_param</div>

<jsp:forward page="target_param.jsp" >
	<jsp:param name="p1" value="p1_value" />
	<jsp:param name="p2" value='<%=request.getParameter("p1")%>' />
	<jsp:param name="rst" value="rst_value" />
</jsp:forward>

<!-- Append the parameter name and value in the end of the URL -->
<% out.println("pu"); %>

</body>
</html>