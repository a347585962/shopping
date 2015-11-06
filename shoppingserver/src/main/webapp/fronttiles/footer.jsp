<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"  
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="am-g cont_tel tlr">
	<a href="tel_3A400-0162-899" res="1" onclick="clickResponse(this)"
		title="虎居客服"><i class="am-icon-phone-square"></i>400-0162-899</a>
</div>
<div class="am-g copyrt tlr">m.aihuju.com</div>
<!--工具栏-->
<div class="am-navbar am-navbar-default footer_fixed">
	<ul>
		<li res="1" onclick="clickResponse(this)"><a href="<%=basePath %>client/search"
			tile="#"></a></li>
		<li res="1" onclick="clickResponse(this)"><a href="<%=basePath %>client/loginui"
			tile="#"></a></li>
		<li res="1" onclick="clickResponse(this)"><a href="<%=basePath %>client/shop"
			tile="#"></a></li>
		<li res="1" onclick="clickResponse(this)" data-am-widget="gotop"
			class="am-gotop"><a href="#top" tile="#"></a></li>
	</ul>
</div>
<!--//工具栏-->
<script type="text/javascript" src="<%=basePath %>assets/js/icheck.js"></script>
<!--自定义选择框-->
<script type="text/javascript" src="assets/js/jquery.easydropdown.js"></script><!--自定义下拉列表-->

<!--自定义下拉列表-->
<script type="text/javascript" src="<%=basePath %>assets/js/amui.js"></script>
<script type="text/javascript" src="<%=basePath %>assets/js/app.js"></script>
