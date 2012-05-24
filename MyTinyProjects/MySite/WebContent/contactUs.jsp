<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dba" class="org.test.javabean.DBAccess" />
<%
String sql = "select * from company where id=2";
if (dba.createConn()) {
	dba.query(sql);
	if (!dba.next()) {
		PrintWriter pw = response.getWriter();
		pw.println("Please insert into the table company values whoes id should be 2.");
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title>新闻内容</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/content.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">
	<!-- header -->
	<jsp:include page="include/inc_header.jsp" />
	  
	<div id="nav">
	  	<div id="nav_l"></div>
	    	<div id="nav_r"></div>
	    	<div class="nav_main">
			<ul>
	    	    <li><a href="index.jsp"><span>首页</span></a></li>
		        <li><a href="news_list.jsp"><span>企业新闻</span></a></li>
		        <li><a href="company_list.jsp"><span>企业简介</span></a></li>
	        	<li><a href="product_list.jsp"><span>产品展厅</span></a></li>
	        	<li><a href="#"><span>订单跟踪</span></a></li>
	        	<li><a href="contactUs.jsp" id="nav_current"><span>联系我们</span></a></li>
			</ul>
	    </div>
	</div>
  
	<div class="clearfloat"></div>
  
  
  <!-- main content -->
	<div id="maincontent">
	  	
	    <div id="main">
	        <div id="index_box">
	        	<div class="box">
         			  <h2><span>联系我们</span></h2>
			          <div class="box_con">
							<h3><jsp:getProperty name="dba" property="title" /></h3>
							
							<jsp:getProperty name="dba" property="content" />
			          </div>
        		</div>
			</div>
		</div>
	    
		<jsp:include page="include/inc_side.jsp" />
	    
	</div>
  
	<!-- footer -->
	<jsp:include page="include/inc_footer.jsp" />
</div>
</body>
</html>
