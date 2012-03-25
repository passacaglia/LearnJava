<html>
<head>
<title>Request Bean</title>
</head>
<body>

<jsp:useBean id="counter" class="bean.Bean_Counter" scope="request" />
<jsp:setProperty name="counter" property="count" value="100" />
<b>setCount(100)</b>
<jsp:forward page="Request_Bean_forw.jsp" />  <!-- jsp:forward使用的是同一个request。异于sendRedirect --> 


</body>
</html>