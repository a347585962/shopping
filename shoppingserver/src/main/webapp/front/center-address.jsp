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
        收货地址管理
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--收货地址列表-->
  <div class="am-g center_address_list am-padding-horizontal-sm" id="center_address_list">
    <ul>
      <li class="on">
        <div class="am-panel am-panel-default am-margin-top-sm">
          <div class="am-panel-hd"><a href="#" res="1" onclick="clickResponse(this)" class="am-fr setdaulft"><i class="am-icon-map-marker"></i>&nbsp;默认地址</a>丁建<span class="am-text-danger am-padding-left">18980453110</span></div>
          <div class="am-panel-bd">
            四川成都市高新区三环与绕城环线之间交子大道333号中海国际中心E座12楼1203号
            <p class="am-text-right"><a href="#" res="1" onclick="clickResponse(this)" title="#">编辑</a><span class="am-padding-horizontal-sm">|</span><a href="#" res="1" onclick="clickResponse(this)" title="#">删除&nbsp;&nbsp;</a></p>
          </div>
        </div>
      </li>
      <li>
        <div class="am-panel am-panel-default am-margin-top-sm">
          <div class="am-panel-hd"><a href="#" res="1" onclick="clickResponse(this)" class="am-fr setdaulft"><i class="am-icon-map-marker"></i>&nbsp;默认地址</a>丁建<span class="am-text-danger am-padding-left">18980453110</span></div>
          <div class="am-panel-bd">
            四川成都市成华区三环以内建设路56号新东方小区4栋2单元602
            <p class="am-text-right"><a href="#" res="1" onclick="clickResponse(this)" title="#">编辑</a><span class="am-padding-horizontal-sm">|</span><a href="#" res="1" onclick="clickResponse(this)" title="#">删除&nbsp;&nbsp;</a></p>
          </div>
        </div>
      </li>
    </ul>
  </div>
  <!--//收货地址列表-->
  <div class="am-g am-text-center am-margin-vertical-sm am-padding-horizontal-sm"><a href="<%=basePath %>client/addressadd" class="am-btn am-btn-danger col-sm-12"><i class="am-icon-plus"></i>&nbsp;新增收货地址</a></div><!--//新增地址-->
  




