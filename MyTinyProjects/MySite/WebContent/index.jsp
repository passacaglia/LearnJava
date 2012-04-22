<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title>主页</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">
  <jsp:include page="inc_header.jsp" />
  
  <div id="maincontent">
  	<div id="content_head">
	  <script language='javascript' type="text/javascript">
        linkarr = new Array();
        picarr = new Array();
        textarr = new Array();
        var swf_width=900;
        var swf_height=300;
        var files = "images/pic.jpg|images/pic1.jpg|images/pic2.jpg|images/pic3.jpg";
        var links = "#|#|#|#";
        var texts = "";
        for(i=1;i<picarr.length;i++){
          if(files=="") files = picarr[i];
          else files += "|"+picarr[i];
        }
        for(i=1;i<linkarr.length;i++){
          if(links=="") links = linkarr[i];
          else links += "|"+linkarr[i];
        }
        for(i=1;i<textarr.length;i++){
          if(texts=="") texts = textarr[i];
          else texts += "|"+textarr[i];
        }
        document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ swf_width +'" height="'+ swf_height +'">');
        document.write('<param name="movie" value="images/indexpic.swf"><param name="quality" value="high">');
        document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
        document.write('<param name="FlashVars" value="bcastr_file='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'">');
        document.write('<embed src="images/indexpic.swf" wmode="opaque" FlashVars="bcastr_file='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'& menu="false" quality="high" width="'+ swf_width +'" height="'+ swf_height +'" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />'); document.write('</object>');
      </script>
    </div>
    <div id="main">

      <div id="index_pic">
        <h2><span></span></h2>
        <ul>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
          <li><a href="#"><img src="images/pic4.gif" alt="产品名称" width="107" height="87" />产品名称</a></li>
        </ul>
      </div>
      <div id="index_box">
        <div class="box">
          <h2><a class="more" href="#">更多..</a><span>新闻中心</span></h2>
          <div class="box_con">
            <dl>
              <dt><a href="#"><img src="images/pic5.gif" alt="多角度对比 苹果iPod系列真机" width="91" height="70" /></a></dt>
              <dd><a href="#"><strong>多角度对比 苹果iPod系列真机</strong></a>
              导言：北京时间9月2日凌晨1点苹果在旧金山举行新品发布会，数码特派记者在美国现场直播&hellip;</dd>
            </dl>
            <ul>
            	<li><a href="#">纯CSS实现三列DIV等高布局</a></li>
              <li><a href="#">HTML元素的ID和Name属性的区别</a></li>
              <li><a href="#">完美兼容ie6,ie7,ie8以及firefox的css透明滤镜</a></li>
              <li><a href="#">DIV+CSS实现放大镜效果的分页样式</a></li>
              <li><a href="#">javascript为FF设置首页</a></li>
              <li><a href="#">复制到系统剪贴板之IE,ff兼容版</a></li>
              <li><a href="#">DIV+CSS实现放大镜效果的分页样式</a></li>
            </ul>
          </div>
        </div>
        <div class="box box1">
          <h2><a class="more" href="#">更多..</a><span>企业介绍</span></h2>
          <div class="box_con">
            <ul>
              <li><a href="#">纯CSS实现三列DIV等高布局</a></li>
              <li><a href="#">HTML元素的ID和Name属性的区别</a></li>
              <li><a href="#">完美兼容ie6,ie7,ie8以及firefox的css透明滤镜</a></li>
              <li><a href="#">DIV+CSS实现放大镜效果的分页样式</a></li>
              <li><a href="#">javascript为FF设置首页</a></li>
              <li><a href="#">复制到系统剪贴板之IE,ff兼容版</a></li>
              <li><a href="#">DIV+CSS实现放大镜效果的分页样式</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    
	<jsp:include page="inc_side.jsp" />
    
  </div>
  
  <jsp:include page="inc_footer.jsp" />
</div>
</body>
</html>
