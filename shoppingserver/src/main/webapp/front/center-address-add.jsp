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
        新增收货地址
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--新增收货地址-->
  <div class="am-g shop-order_infor">
    <ul>
      <li class="am-padding-horizontal-sm am-padding-vertical-sm">
        <dl>
          <dd><input type="text" class="am-form-field" placeholder="请输入收货人姓名"/></dd>
          <dd><input type="tel" class="am-form-field am-margin-top-sm" placeholder="请输入联系电话"/></dd>
          <dd class="am-margin-top-sm">
            <select name="" class="dropdown" data-settings='{"cutOff": 6}'>
              <option class="label" value="">请选择所在省</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
              <option value="">四川</option>
              <option value="">北京</option>
              <option value="">上海</option>
              <option value="">广东</option>
            </select>
          </dd>
          <dd class="am-margin-top-sm">
            <select name="" class="dropdown" data-settings='{"cutOff": 6}'>
              <option class="label" value="">请选择所在市</option>
              <option value="">成都市</option>
              <option value="">自贡市</option>
              <option value="">绵阳市</option>
            </select>
          </dd>
          <dd class="am-margin-top-sm">
            <select name="" class="dropdown" data-settings='{"cutOff": 6}'>
              <option class="label" value="">请选择所在区/县</option>
              <option value="">成华区</option>
              <option value="">锦江区</option>
              <option value="">温江区</option>
              <option value="">青羊区</option>
            </select>
          </dd>
          <dd><textarea class="am-form-field am-margin-top-sm" rows="5" id="doc-ta-1" placeholder="请输入详细收货地址：如：XX街XX栋XX号"></textarea></dd>
        </dl>
      </li>
    </ul>
  </div>
  <!--//新增收货地址-->
  <div class="am-g am-text-center am-padding-horizontal-sm"><a href="<%=basePath %>client/shop" class="am-btn am-btn-danger col-sm-12"><i class="am-icon-save"></i>&nbsp;保存地址</a></div>


