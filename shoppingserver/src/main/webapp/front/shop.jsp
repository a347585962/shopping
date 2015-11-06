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
        购物车
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <div class="am-g am-padding-sm shop_order_total">
    共<strong>13</strong>件商品，总计:<span class="am-text-danger">￥2800000</span><a href="<%=basePath %>client/shopsubmit" type="button" class="am-btn am-btn-danger am-btn-sm">去结算</a>
  </div>
  <!--订单列表-->
  <div class="am-g shop_order_checkall am-padding-sm">
    <label><input type="checkbox" />&nbsp;全选&nbsp;</label><a href="#" class="am-icon-times-circle am-text-danger delebtn" title="删除"></a>
  </div>
  <div class="am-list-news-bd shop_order_list ">
    <ul class="am-list">
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <div class="am-block order_choose"><input type="checkbox" /></div>
        <div class="shop_order_infor">
          <div class="am-col col-sm-4"> <a href="infor.html"><img src="<%=basePath %>assets/images/imgtest01.jpg" alt="我最喜欢的一张画" /></a></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              <a href="infor.html" title="#">YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300</a>
            </h3>
            <div class="am-list-item-text"><a href="#" class="am-icon-times-circle am-text-danger am-fr delebtn" title="删除"></a>￥280000<i class="am-icon-times am-padding-horizontal-xs am-text-danger"></i><input type="tel" class="am-form-field am-text-center am-input-sm" value="1" /></div>
          </div>
        </div> 
      </li>
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <div class="am-block order_choose"><input type="checkbox" /></div>
        <div class="shop_order_infor">
          <div class="am-col col-sm-4"> <a href="infor.html"><img src="<%=basePath %>assets/images/imgtest02.jpg" alt="我最喜欢的一张画" /></a></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              <a href="infor.html" title="#">YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300</a>
            </h3>
            <div class="am-list-item-text"><a href="#" class="am-icon-times-circle am-text-danger am-fr delebtn" title="删除"></a>￥280000<i class="am-icon-times am-padding-horizontal-xs am-text-danger"></i><input type="tel" class="am-form-field am-text-center am-input-sm" value="1" /></div>
          </div>
        </div> 
      </li>
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <div class="am-block order_choose"><input type="checkbox" /></div>
        <div class="shop_order_infor">
          <div class="am-col col-sm-4"> <a href="infor.html"><img src="<%=basePath %>assets/images/imgtest03.jpg" alt="我最喜欢的一张画" /></a></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              <a href="infor.html" title="#">YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300</a>
            </h3>
            <div class="am-list-item-text"><a href="#" class="am-icon-times-circle am-text-danger am-fr delebtn" title="删除"></a>￥280000<i class="am-icon-times am-padding-horizontal-xs am-text-danger"></i><input type="tel" class="am-form-field am-text-center am-input-sm" value="1" /></div>
          </div>
        </div> 
      </li>
    </ul>
  </div>
  <!--//订单列表-->