
<jsp:useBean id="counter" 
			 class="bean.Bean_Counter" 
			 scope="session" />
<%-- <% 
	bean.Bean_Counter counter2 = (bean.Bean_Counter)session.getAttribute("counter2");
	if (null == counter2) {
		counter2 = new bean.Bean_Counter();
		session.setAttribute("counter2", counter2);
	}
%> --%>

<html>
<head>
<title>Session Bean</title>
</head>
<body>

<div>Session Bean </div>
<div><jsp:getProperty name="counter" property="count" /></div>


</body>
</html>