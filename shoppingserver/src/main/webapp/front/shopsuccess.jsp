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
        订单提交成功
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--订单信息-->
  <div class="am-g shop-order_success am-padding-top">
    <h2 class="am-text-center am-text-lg am-text-success"><i class="am-icon-check-circle"></i>&nbsp;订单提交成功，稍后客服会联系您！</h2>
    <ul>
      <li><span class="col-sm-4 am-text-right">订单号：</span><span class="col-sm-8 am-text-danger">456122596645696</span></li>
      <li><span class="col-sm-4 am-text-right">应付金额：</span><span class="col-sm-8 am-text-danger">￥280000</span></li>
    </ul>
  </div>
  <!--//订单信息-->
  <div class="am-g am-text-center am-padding-horizontal-sm am-margin-top-sm"><a href="<%=basePath %>client/orderinfo" class="am-btn am-btn-danger col-sm-12">查看订单</a></div>