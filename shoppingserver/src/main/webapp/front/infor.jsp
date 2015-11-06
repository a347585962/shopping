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
        商品详情
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--产品详情图片-->
  <div data-am-widget="slider" class="am-slider am-slider-a1 am-slides_infor" data-slider-config='{&quot;directionNav&quot;:false}'>
    <ul class="am-slides tlr">
      <li>
        <img src="<%=basePath %>assets/images/5s01.jpg" alt="#" />
      </li>
      <li>
        <img src="<%=basePath %>assets/images/5s02.jpg" alt="#"  />
      </li>
      <li>
        <img src="<%=basePath %>assets/images/5s03.jpg" alt="#" />
      </li>
      <li>
        <img src="<%=basePath %>assets/images/5s04.jpg" alt="#"  />
      </li>
    </ul>
    <div class="am-g infor_price">
      <div class="am-fl">虎居价:<b class="am-text-orange">￥280000</b></div>
      <div class="am-fr">市场价:<span class="am-text-line">￥286000</span><a id="faverit" class="faverit am-icon-star-o" data-am-modal="{target: '#modal-faverit'}"></a></div>
      <div class="am-modal am-modal-no-btn faverit" tabindex="-1" id="modal-faverit">
        <div class="am-modal-dialog">
          <div class="am-modal-bd">
            <i class='am-icon-star'></i>&nbsp;&nbsp;<span class="tipsmsg"></span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--//产品详情图片-->
  <!--产品概述-->
  <div class="am-g product_desc">
    <div class="am-titlebar">
      <a href="<%=basePath %>client/moreinfo" class="am-block"><i class="am-icon-chevron-right am-fr"></i>商品信息<span class="am-text-orange">(建议在WIFI环境下查看)</span>
</a>
    </div>
    <div class="product_desc_list">
      <h1 class="am-text-default am-padding-sm">【引领时尚】爱乐泉 白色亚克力 扇形水底打光 按摩浴缸</h1>
      <div class="product_desc_choose am-padding-horizontal-sm">
        <dl>
          <dt class="am-margin-bottom-sm">尺　　寸：</dt>
          <dd><a href="#" class="am-btn am-btn-danger am-btn-sm am-active" role="button">170*190*189 </a></dd>
          <dd><a href="#" class="am-btn am-btn-default am-btn-sm" role="button">170*190*189 </a></dd>
          <dd><a href="#" class="am-btn am-btn-default am-btn-sm" role="button">170*190*189 </a></dd>
          <div class="am-cf"></div>
        </dl>
        <dl>
          <dt class="am-margin-bottom-sm">颜　　色：</dt>
          <dd><a href="#" class="am-btn am-btn-danger am-btn-sm am-active" role="button">白色</a></dd>
          <dd><a href="#" class="am-btn am-btn-default am-btn-sm" role="button">红色</a></dd>
          <dd><a href="#" class="am-btn am-btn-default am-btn-sm" role="button">蓝色</a></dd>
          <div class="am-cf"></div>
        </dl>
        <dl>
          <dt>数　　量：<span><a href="javascript:void(0)" res="1" onclick="clickResponse(this)" class="am-icon-plus-circle am-padding-horizontal-xs am-text-danger"></a><input type="text" class="am-form-field am-text-center am-input-sm" value="1" /><a  href="javascript:void(0)" res="1" onclick="clickResponse(this)"  class="am-icon-minus-circle am-padding-horizontal-xs am-text-danger"></a></span></dt>
        </dl>
      </div>
      <p class="am-padding-sm am-text-orange">促销信息：全场卫浴满999减少199</p>
    </div>
    <div class="am-titlebar">
      <a href="pingjia.html" class="am-block"><i class="am-icon-chevron-right am-fr"></i><span class="am-fr">已有<b class="am-text-orange am-padding-horizontal-xs">521566</b>人好评</span>商品评价
</a>
    </div>
    <div class="am-g tlr shop_btn am-margin-top">
      <div class="col-sm-6">
        <button class="am-btn am-btn-danger am-btn-block" href="#">
          <i class="am-icon-yen"></i>
          立即购买
        </button>
      </div>
      <div class="col-sm-6">
        <button class="am-btn am-btn-primary am-btn-block model_sendmsg" href="#">
          <i class="am-icon-shopping-cart"></i>
          加入购物车
        </button>
      </div>
    </div>
  </div>
  <!--//产品概述-->
  <!--购物成功-->
  <div class="am-modal send_freemsg" tabindex="-1" id="model_msg">
    <div class="am-modal-dialog">
      <div class="am-modal-hd am-padding-vertical-sm am-text-default"><p class="am-text-danger"><i class="am-icon-check-square-o"></i>&nbsp;添加成功！</p>商品已成功加入购物车</div>
      <p class="am-padding-bottom-sm am-text-sm am-hide" id="errmsg"><i class="am-icon-times-circle am-text-danger"></i>&nbsp;您的手机号输入错误</p><!--//出错提示-->
      <p class="am-padding-bottom-sm am-text-sm am-hide" id="successmsg"><i class="am-icon-check-circle am-text-success"></i>&nbsp;短信发送已成功，请注意查收！</p><!--//发送成功提示-->
      <div class="am-modal-footer">
        <span class="am-modal-btn modal-cancel  am-block" data-am-modal-cancel>再逛逛</span>
        <span class="am-modal-btn modal-cancel am-block" data-am-modal-cancel><a href="<%=basePath %>client/shop" class="am-block am-text-danger" title="去购物车">去购物车</a></span>
      </div>
    </div>
  </div>
  <!--//购物成功-->

