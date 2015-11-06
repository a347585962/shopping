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
        订单详情
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--订单状态-->
  <div class="am-g shop-order_infor">
    <ul>
      <li class="am-padding-sm">
        <dl>
          <dd> <a href="#" class="am-btn am-btn-danger am-fr">取消订单</a>订单状态：<span class="am-text-warning">待付款</span></dd>
          <dd> 　订单号：125632569874</dd>
          <dd> 下单时间：2014-08-05   12：26</dd>
        </dl>
      </li>
    </ul>
  </div>
  <!--//订单状态-->
  <!--付款详情-->
  <div class="am-g center_order_payfor am-padding-horizontal-sm">
    <div class="am-panel am-panel-default">
      <div class="am-panel-hd"><span class="am-fr am-text-danger">￥280000</span>应付金额</div>
      <div class="am-panel-bd">
        <ul>
          <li><span class="am-fr">￥279744</span>商品总额：</li>
          <li><span class="am-fr">￥256</span>+运费：</li>
          <li><span class="am-fr">￥0</span>-优惠：</li>
        </ul>
      </div>
    </div>
  </div>
  <!--//付款详情-->
  <!--订单列表-->
  <div class="am-list-news-bd prouduct_list am-padding-horizontal-sm">
    <ul class="am-list am-margin-bottom-sm">
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <a href="infor.html" res="1" onclick="clickResponse(this)">
          <div class="am-col col-sm-4"><img src="<%=basePath %>assets/images/imgtest01.jpg" alt="我最喜欢的一张画" /></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300
            </h3>
            <div class="am-list-item-text"><span class="am-fr am-text">X1</span>￥280000</div>
          </div>
        </a>  
      </li>
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <a href="infor.html" res="1" onclick="clickResponse(this)">
          <div class="am-col col-sm-4"><img src="<%=basePath %>assets/images/imgtest02.jpg" alt="我最喜欢的一张画" /></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300
            </h3>
            <div class="am-list-item-text"><span class="am-fr am-text">X1</span>￥280000</div>
          </div>
        </a>  
      </li>
    </ul>
  </div>
  <!--//订单列表-->
  <!--收货人-->
  <div class="am-g center_order_payfor am-padding-horizontal-sm">
    <div class="am-panel am-panel-default">
      <div class="am-panel-hd"><span class="am-fr am-text-danger">15800000000</span>张三</div>
      <div class="am-panel-bd">
        <ul>
          <li>四川省成都市高新区交子大道333号中海国际E座1203</li>
        </ul>
      </div>
    </div>
  </div>
  <!--//收货人-->
  <!-- 支付方式//第一期版本不需要 -->
  <div class="am-g center_order_payfor am-padding-horizontal-sm">
    <div class="am-panel am-panel-default">
      <div class="am-panel-bd"><span class="am-fr am-text-danger">支付宝</span>支付方式</div>
    </div>
  </div>
  <!--//支付方式
  配送方式-->
  <div class="am-g center_order_payfor am-padding-horizontal-sm">
    <div class="am-panel am-panel-default">
      <div class="am-panel-bd"><span class="am-fr am-text-danger">普通快递</span>配送方式</div>
    </div>
  </div>
  <!--//配送方式
  发票信息-->
  <div class="am-g center_order_payfor am-padding-horizontal-sm">
    <div class="am-panel am-panel-default">
      <div class="am-panel-hd"><span class="am-fr am-text-danger">普通发票</span>发票信息</div>
      <div class="am-panel-bd">
        <ul>
          <li>发票抬头：个人</li>
          <li>发票内容：明细</li>
        </ul>
      </div>
    </div>
  </div>
  <!--//发票信息 -->
