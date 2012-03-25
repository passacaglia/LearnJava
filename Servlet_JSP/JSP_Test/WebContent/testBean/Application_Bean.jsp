<jsp:useBean id="counter" class="bean.Bean_Counter" scope="application" />



<html>
<head>
<title>Application Bean</title>
</head>
<body>

<div> Application Bean </div>
	<jsp:getProperty name="counter" property="count" />


</body>
</html>