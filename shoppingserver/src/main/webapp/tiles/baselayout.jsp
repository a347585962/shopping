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
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="群祥超市购物" />
<meta name="description"
	content="群祥超市位于遂宁市" />
<meta content="INDEX,FOLLOW" name="ROBOTS">

<title><tiles:insertAttribute name="title" /></title>

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="<%=basePath%>media/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="<%=basePath%>media/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>media/css/order.css" rel="stylesheet"
	type="text/css"  />
<link href="<%=basePath%>media/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />

<link href="<%=basePath%>media/css/style.css" rel="stylesheet"
	type="text/css" />

<link href="<%=basePath%>media/css/style-responsive.css"
	rel="stylesheet" type="text/css" />

<link href="<%=basePath%>media/css/default.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="<%=basePath%>media/css/zTreeStyle.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="<%=basePath%>media/css/pagenate.style.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="<%=basePath%>media/css/common.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="<%=basePath%>media/css/addgoods.css" rel="stylesheet"
	type="text/css" id="style_color" />
<!-- END GLOBAL MANDATORY STYLES -->
<script src="<%=basePath%>media/js/jquery-1.10.1.min.js"
		type="text/javascript"></script>
<script src="<%=basePath%>media/js/bootstrap.min.js"
		type="text/javascript"></script>
<script src="<%=basePath%>media/js/jquery.validate.js"
		type="text/javascript"></script>



</head>
<body class="page-header-fixed">

	<header class="masthead">
		<tiles:insertAttribute name="header" />
	</header>
	<tiles:insertAttribute name="left" />
	<!-- BEGIN PAGE -->
	<div class="page-content" style="background-color:#e1e1e1">
		<!-- BEGIN PAGE CONTAINER-->
		<div class="container-fluid">
			<div id="dashboard">
				  
				<tiles:insertAttribute name="content" />
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
	</div>
	<!-- END PAGE -->
	<input type="hidden" id='url_base' value="<%=basePath %>">
	<tiles:insertAttribute name="footer" />
</body>
</html>