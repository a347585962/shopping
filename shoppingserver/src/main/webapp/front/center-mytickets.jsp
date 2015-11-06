<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 <!--头部-->
  <div class="am-g">
    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-button list_title">
      <div class="am-titlebar-left">
        <a href="javascript:history.go(-1)" class="am-icon-reply" title="返回"></a>
      </div>
      <h2 class="am-titlebar-title">
        我的优惠券
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--优惠券列表-->
  <div class="mytickets_list am-text-center">
    <ul>
      <li>
        <div class="col-sm-6"><img src="<%=basePath %>assets/images/10yuan.jpg" alt="10"/></div>
        <div class="col-sm-6"><img src="<%=basePath %>assets/images/20yuan.jpg" alt="20"/></div>
        <div class="am-cf"></div>
      </li>
      <li>
        <div class="col-sm-6"><img src="<%=basePath %>assets/images/50yuan.jpg" alt="50"/></div>
        <div class="am-cf"></div>
      </li>
    </ul>
    
  </div>
  <!--//优惠券列表-->

