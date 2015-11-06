<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><tiles:insertAttribute name="title" /></title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent">
<link rel="apple-touch-startup-image" href="startup.png">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="Expires" CONTENT="-1">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<link rel="icon" type="image/png"
	href="<%=basePath%>assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=basePath%>assets/i/app-icon72x72_402x.png">
<meta name="apple-mobile-web-app-title" content="虎居网" />
<link rel="stylesheet" href="<%=basePath%>assets/css/amui.all.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/app.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/easydropdown.css">
<script type="text/javascript" src="<%=basePath%>assets/js/zepto.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>assets/js/jquery-latest.js"></script>
<script type="text/javascript"
	src="<%=basePath%>assets/js/waypoints.min.js"></script>
<!--//循环加载插件-->

</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="am-container">
		<tiles:insertAttribute name="content" />
	</div>

	<input type="hidden" id='url_base' value="<%=basePath%>">
	<tiles:insertAttribute name="footer" />
</body>
</html>