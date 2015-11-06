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
        订单信息
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--订单信息-->
  <div class="am-g shop-order_infor">
    <ul>
      <li class="am-padding-sm">
        <dl>
          <dd> <a href="<%=basePath %>client/changeaddress" class="am-btn am-btn-danger am-fr">修改</a>收货人：张三</dd>
          <dd> 电　话：15800000000</dd>
          <dd> 地　址：四川省成都市高新区交子大道0号</dd>
        </dl>
      </li>
      <!-- <li class="am-padding-sm">//第一期不需要-->
        <dl>
          <dt>付款方式</dt>
          <dd><label><input type="radio" name="payfor" checked/>&nbsp;余额支付</label></dd>
          <dd><label><input type="radio" name="payfor"/>&nbsp;支付宝</label></dd>
          <dd><label><input type="radio" name="payfor"/>&nbsp;公司转账</label></dd>
        </dl>
      </li>
      <li class="am-padding-sm">
        <dl>
          <dt>快递</dt>
          <dd>普通快递</dd>
        </dl>
      </li>
      <li class="am-padding-sm">
        <dl>
          <dt>是否需要发票：<label><input type="radio" name="tticketyes" checked/>&nbsp;需要&nbsp;</label><label><input type="radio" name="tticketyes"/>&nbsp;不需要</label></dt>
          <dd>发票类型：普通发票</dd>
          <dd>发票抬头：</dd>
          <dd><label><input type="radio" name="tickets" checked/>&nbsp;个人</label></dd>
          <dd><label><input type="radio" name="tickets"/>&nbsp;单位&nbsp;</label><input type="text" class="am-form-field" placeholder="请输入单位名称"/></dd>
          <dd>发票内容：明细</dd>
        </dl>
      </li>
      <li class="am-padding-sm">
        <dl>
          <dd>商品金额：￥280000</dd>
          <dd>商品金额：￥256</dd>
          <dd>商品金额：￥280000</dd>
      </li>
    </ul>
  </div>
  <!--//订单信息-->
  <div class="am-g am-text-center am-padding-horizontal-sm "><a href="<%=basePath %>client/shopsuccess" class="am-btn am-btn-danger col-sm-12">提交订单</a></div>