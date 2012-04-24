<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录</title>
<link href="themes/login/css/login_layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main_content">
	<form action="" method="post">
		  <div id="btn">
			  <ul>
	                <li>Company Name : </li>
    			</ul>
          </div>
          <div id="user_passwd">
              <ul>
              	  <li>用户名：<span><input name="username" type="text" size="20" maxlength="20" /></span></li>
                  <li>密&nbsp;&nbsp;&nbsp;码：<span><input name="passwd" type="password" size="20" maxlength="20" /></span></li>
              </ul>
          </div>
			
 		 <div id="btn">
			  <ul>
	                <li><input name="remember" type="checkbox" value="" />Remember me
                	<span><input id="sbm" type="submit" value="登录" /></span></li>
    			</ul>
          </div>

    </form>
</div>
</body>
</html>