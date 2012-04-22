<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title>新闻</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/list.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">
	<!-- header -->
	<jsp:include page="inc_header.jsp" />
	  
	<div id="nav">
	  	<div id="nav_l"></div>
	    	<div id="nav_r"></div>
	    	<div class="nav_main">
			<ul>
	    	    <li><a href="index.jsp"><span>首页</span></a></li>
		        <li><a href="news_list.jsp" id="nav_current"><span>企业新闻</span></a></li>
		        <li><a href="#"><span>企业简介</span></a></li>
	        	<li><a href="#"><span>产品展厅</span></a></li>
	        	<li><a href="#"><span>订单跟踪</span></a></li>
	        	<li><a href="#"><span>联系我们</span></a></li>
			</ul>
	    </div>
	</div>
  
	<div class="clearfloat"></div>
  
  
  <!-- main content -->
	<div id="maincontent">
	  	
	    <div id="main">
	        <div id="index_box">
				<jsp:include page="inc_news.jsp" />
			</div>
		</div>
	    
		<jsp:include page="inc_side.jsp" />
	    
	</div>
  
	<!-- footer -->
	<jsp:include page="inc_footer.jsp" />
</div>
</body>
</html>