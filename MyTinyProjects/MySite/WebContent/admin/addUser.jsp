<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%
String username = (String)session.getAttribute("username");
if (null == username) {
	response.sendRedirect("login.jsp");
}
%>

<jsp:useBean id="newUser" class="org.test.javabean.UserBean" />

<%
String str = "";
String error = (String)request.getParameter("error");
if (null == error) {
	str = "用户名6-16位，A word character: [a-zA-Z_0-9]";
} else {
	str = "<font color='red'>用户名已经存在，请使用其它用户名。</font>";
}

String addUser = (String)request.getParameter("action");
if ((null != addUser) && (addUser.equals("addUser"))) {
	String usern = (String)request.getParameter("username");
	String passwd = (String)request.getParameter("password");
	String email = (String)request.getParameter("email");
	if ((null == email) || (email.equals(""))) {
		email = "@";
	}
	if (newUser.isExist(usern)) {
		response.sendRedirect("addUser.jsp?error=1");
	} else {
		newUser.add(usern, passwd, email);
		response.sendRedirect("members.jsp");
	}
} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加用户</title>
<link href="themes/addUser.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function check() {
	if (checkUN()) {
		if (checkPWD()) {
			return true;
		}
	}
	return false;
}

function checkUN() {
	var re = /^[a-zA-Z0-9_]{6,16}$/;
	var un = document.form.username.value;
	if (un.length > 5) {
		if (re.test(un)) {
			document.getElementById("errorUN").innerHTML = "用户名6-16位，A word character: [a-zA-Z_0-9]";
			return true;
		}
	}
	
	document.getElementById("errorUN").innerHTML = "<font color='red'>用户名6-16位，A word character: [a-zA-Z_0-9]</font>";
	return false;
	
}
function checkPWD() {
	var re = /^[a-zA-Z0-9_]{6,16}$/;
	var pwd = document.form.password.value;
	if (pwd.length > 5) {
		if (re.test(pwd)) {
			document.getElementById("errorPWD").innerHTML = "密码6-16位，A word character: [a-zA-Z_0-9]";
			return true;
		}
	}
	
	document.getElementById("errorPWD").innerHTML = "<font color='red'>密码6-16位，A word character: [a-zA-Z_0-9]</font>";
	return false;
	
}
</script>
</head>

<body>
	<div id="addUser">
	<label>新增用户：</label>
	<br />
		<form action="addUser.jsp" method="post" name="form" onsubmit="return check()">
			<input name="action" type="hidden" value="addUser" />
			<ul>
				<li><label>用户名：</label><input type="text"  name="username" onblur="return checkUN()"/><span id="errorUN"><%=str %></span></li>
				<li><label>密&nbsp;&nbsp;&nbsp;码：</label><input type="password"  name="password" onblur="return checkPWD()"/><span id="errorPWD">密码6-16位，A word character: [a-zA-Z_0-9]</span></li>
				<li><label>邮&nbsp;&nbsp;&nbsp;箱：</label><input type="text" name="email" /></li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="submit" value="保存" /></li>
			</ul>
		</form>
	</div>
</body>
</html>