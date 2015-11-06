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
	<div data-am-widget="titlebar"
		class="am-titlebar am-titlebar-button list_title">
		<div class="am-titlebar-left">
			<a href="javascript:history.go(-1)" class="am-icon-reply" title="返回"></a>
		</div>
		<h2 class="am-titlebar-title">我的虎居</h2>
		<div class="am-titlebar-right">
			<a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
		</div>
	</div>
</div>
<!--//头部-->
<!--个人信息-->
<div class="am-g center_header am-padding-vertical">
	<div class="col-sm-4 am-text-center am-vertical-align">
		<img src="<%=basePath %>assets/images/style/photo.jpg"
			class="am-vertical-align-middle am-img-circle" alt="虎居" />
	</div>
	<div class="col-sm-8">
		<ul>
			<li><button type="button" class="am-btn am-btn-danger am-fr">注销</button>dalianmao</li>
			<li>余额:￥20000</li>
			<li>优惠券:￥2555000</li>
		</ul>
	</div>
</div>
<!--//个人信息-->
<!--导航-->
<div class="am-g cente_menu am-text-center am-padding-vertical">
	<ul>
		<li class="col-sm-4"><a href="<%=basePath %>client/myfaverite"
			class="am-block" res="1" onclick="clickResponse(this)" title="我的收藏"><i
				class="am-icon-star am-btn am-padding-vertical am-text-xl am-btn-danger"></i>
			<p>我的收藏</p></a></li>
		<li class="col-sm-4"><a href="<%=basePath %>client/mytickets"
			class="am-block" res="1" onclick="clickResponse(this)" title="我的优惠券"><i
				class="am-icon-ticket am-btn am-padding-vertical am-text-xl am-btn-primary"></i>
			<p>我的优惠券</p></a></li>
		<li class="col-sm-4"><a href="<%=basePath %>client/address"
			class="am-block" res="1" onclick="clickResponse(this)" title="地址管理"><i
				class="am-icon-map-marker am-btn am-padding-vertical am-text-xl am-btn-success"></i>
			<p>地址管理</p></a></li>
	</ul>
</div>
<!--//导航-->
<!--订单列表-->
<div class="am-g center_order_list">
	<ul>
		<li class="am-padding-sm">
			<dl>
				<dt>
					<span class="am-fr">2014-08-03 12：26</span>订单号:125632569874
				</dt>
				<dd class="am-text-center">
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest01.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest02.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest01.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest02.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="am-cf"></div>
				</dd>
				<dd class="am-padding-top-sm">
					<span class="col-sm-6">金额：￥280000</span><span
						class="col-sm-3 am-text-danger">已发货</span><span
						class="col-sm-3 am-text-right"><a
						href="<%=basePath %>client/orderinfo" class="am-text-danger am-block"
						res="1" onclick="clickResponse(this)" title="查看详情">查看详情<i
							class="am-icon-angle-double-right"></i></a></span>
					<div class="am-cf"></div>
				</dd>
			</dl>
		</li>
		<li class="am-padding-sm">
			<dl>
				<dt>
					<span class="am-fr">2014-08-03 12：26</span>订单号:125632569874
				</dt>
				<dd class="am-text-center">
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest02.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="am-cf"></div>
				</dd>
				<dd class="am-padding-top-sm">
					<span class="col-sm-6">金额：￥280000</span><span
						class="col-sm-3 am-text-danger">已发货</span><span
						class="col-sm-3 am-text-right"><a
						href="<%=basePath %>client/orderinfo" class="am-text-danger am-block"
						res="1" onclick="clickResponse(this)" title="查看详情">查看详情<i
							class="am-icon-angle-double-right"></i></a></span>
					<div class="am-cf"></div>
				</dd>
			</dl>
		</li>
		<li class="am-padding-sm">
			<dl>
				<dt>
					<span class="am-fr">2014-08-03 12：26</span>订单号:125632569874
				</dt>
				<dd class="am-text-center">
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest01.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest02.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="col-sm-4">
						<a href="#" res="1" onclick="clickResponse(this)" title="#"><img
							src="<%=basePath %>assets/images/imgtest01.jpg" class="am-img-thumbnail" alt="#" /></a>
					</div>
					<div class="am-cf"></div>
				</dd>
				<dd class="am-padding-top-sm">
					<span class="col-sm-6">金额：￥280000</span><span
						class="col-sm-3 am-text-danger">已发货</span><span
						class="col-sm-3 am-text-right"><a
						href="<%=basePath %>client/orderinfo" class="am-text-danger am-block"
						res="1" onclick="clickResponse(this)" title="查看详情">查看详情<i
							class="am-icon-angle-double-right"></i></a></span>
					<div class="am-cf"></div>
				</dd>
			</dl>
		</li>
	</ul>
</div>
<!--//订单列表-->




