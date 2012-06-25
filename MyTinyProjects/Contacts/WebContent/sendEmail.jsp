<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>

<jsp:useBean id="con" class="com.az.javabean.Contacts"></jsp:useBean>
<%
HashMap<String, String> contacts = null;
contacts = con.getContacts();

String name = null;
String email = null;

for (Map.Entry<String, String> entry : contacts.entrySet() ) {
	name = entry.getKey();
	email = entry.getValue();
	
	System.out.println(name + "   " + email);
}


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Send email to them</title>
<style type="text/css">
<!--
-->
</style>
</head>
<body>
<form id="send" name="send" method="post" action="do.it">
	<input type="hidden" name="dowhat" value="send"/>
  <table width="200" border="1">
	<tr>
      <td>收件人</td>
      <td>
      <input type="checkbox" name="cb" id="checkbox" >复选框暂时无效，默认给所有人发邮件</input><br />
<%
int x = 0;
String cb = "cb";
for (Map.Entry<String, String> entry : contacts.entrySet() ) {
	name = entry.getKey();
	email = entry.getValue();
	cb = cb + (++x);
%>
		<input type="checkbox" name="<%=cb %>" id="checkbox" ><%= name + " --- " + email %></input><br />
<%
}
%>
        
      </td>
    </tr>
    <tr>
      <td>主题</td>
      <td><label>
        <input type="text" name="subject" id="subject" size="55"/>
      </label></td>
    </tr>
    <tr>
      <td>正文</td>
      <td><label>
        <textarea name="emailCont" id="emailCont" cols="45" rows="5"></textarea>
      </label></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><label>
        <input type="submit" name="button" id="button" value="发送" />
      </label></td>
    </tr>
  </table>
</form>
</body>
</html>