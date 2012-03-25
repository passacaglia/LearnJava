
<jsp:useBean id="counter" class="bean.Bean_Counter" scope="request" />    
<jsp:getProperty name="counter" property="count" />
<%=counter.getCount() %>

<html>
<head>
<title>Request_Bean_forw</title>
</head>
<body>
	
	<div>Request Bean forward</div>
	
</body>
</html>