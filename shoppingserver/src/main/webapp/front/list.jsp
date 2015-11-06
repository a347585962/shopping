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
      <h2 class="am-titlebar-title logo-list">
      </h2>
      <div class="am-titlebar-right">
        <a href="<%=basePath %>client/index" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--列表筛选-->
  <div class="am-g">
    <div data-am-widget="tabs" class="am-tabs am-tabs-d2 list_type_choose_title">
      <div class="am-g">
        <div class="col-sm-8">
          <ul class="am-tabs-hd am-cf sm-block-grid-2">
            <li class="am-tabs-hd-active">排序</li>
            <li class="">活动</li>
          </ul>
        </div>
        <div class="col-sm-4">
          <ul class="list_type_choose_more">
            <li class="tlr"><a href="#menu3" data-am-offcanvas>筛选&nbsp;<i class="am-icon-arrow-right"></i></a></li>
          </ul>
        </div>
      </div>
      <div class="am-tabs-bd">
        <div class="am-tabs-bd-content list_type_choose">
          <div class="am-tabs-bd-active">
            <div class="col-sm-4 tlr"><a href="#" class="current" title="#">价格&nbsp;<i class="am-icon-chevron-down"></i></a></div>
            <div class="col-sm-4 tlr"><a href="#" title="#">销量&nbsp;<i class="am-icon-chevron-up"></i></a></div>
            <div class="col-sm-4 tlr"><a href="#" title="#">好评&nbsp;<i class="am-icon-chevron-down"></i></a></div>
          </div>
          <div>
            <div class="col-sm-4 tlr"><a href="#" class="current" title="#">特价</a></div>
            <div class="col-sm-4 tlr"><a href="#" title="#">包邮</a></div>
            <div class="col-sm-4 tlr"><a href="#" title="#">打折</a></div>
          </div>  
       </div>
      </div>
    </div>
    <div class="am-offcanvas" id="menu3">
      <i class="am-icon-angle-double-right am-text-xl closefixed"></i>
      <div class="am-offcanvas-bar am-offcanvas-bar-flip">
        <ul data-am-widget="menu" class="sm-block-grid-1 am-menu am-menu-lv1 am-menu-offcanvas1">
          <li class="am-menu-item am-parent">
            <a href="##">品牌</a>
            <ul class="am-menu-sub am-menu-lv2 sm-block-grid-1 ">
              <li class="am-menu-item">
                <a href="##" class="current" onclick="current(this)"><i class="am-icon-check-square"></i>全部</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>科勒</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>东城百家</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>东城百家</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>科勒</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>东城百家</a>
              </li>
            </ul>
          </li>
          <li class="am-menu-item am-parent">
            <a href="##">价格</a>
            <ul class="am-menu-sub am-menu-lv2 sm-block-grid-1 " style="height:50px;overflow-y: scroll;">
              <li class="am-menu-item">
                <a href="##"  class="current" onclick="current(this)"><i class="am-icon-check-square"></i>全部</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>0~999</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>10000~9000</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>10000~9000</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>10000~9000</a>
              </li>
              <li class="am-menu-item">
                <a href="##" onclick="current(this)"><i class="am-icon-check-square"></i>10000~9000</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <!--//列表筛选-->
  <!--产品列表-->
  <div class="am-list-news-bd prouduct_list ">
    <ul class="am-list">
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <a href="<%=basePath %>client/info" res="1" onclick="clickResponse(this)">
          <div class="am-col col-sm-4"><img src="<%=basePath %>assets/images/imgtest01.jpg" alt="我最喜欢的一张画" /></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300 400Y
            </h3>
            <div class="am-list-item-text">￥280000</div>
          </div>
        </a>  
      </li>
      <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
        <a href="<%=basePath %>client/info" res="1" onclick="clickResponse(this)">
          <div class="am-col col-sm-4"><img src="<%=basePath %>assets/images/imgtest02.jpg" alt="我最喜欢的一张画" /></div>
          <div class="am-col col-sm-8 am-list-main">
            <h3 class="am-list-item-hd">
              YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300 400Y
            </h3>
            <div class="am-list-item-text">￥280000</div>
          </div>
        </a>  
      </li>
    </ul>
  </div>
  <!--//产品列表-->
  <footer class="loading am-text-center"><i class="am-icon-spinner am-icon-spin"></i>&nbsp;加载中，请稍后...</footer>
<script type="text/javascript">
$(document).ready(function() {
  $('.loading').waypoint(function(event, direction) {
    $('.loading').waypoint('remove');
    $('.prouduct_list ul').append("<li class='am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left'>"+"<a href='<%=basePath %>client/info' res='1' onclick='clickResponse(this)'><div class='am-col col-sm-4'><img src='<%=basePath %>assets/images/"+"imgtest05"+".jpg' alt='我最喜欢的一张画' /></div><div class='am-col col-sm-8 am-list-main'><h3 class='am-list-item-hd'>YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300 400Y</h3><div class='am-list-item-text'>￥280000</div></div></a>"+"</li>"+"<li class='am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left'>"+"<a href='<%=basePath %>client/info' res='1' onclick='clickResponse(this)'><div class='am-col col-sm-4'><img src='<%=basePath %>assets/images/"+"imgtest06"+".jpg' alt='我最喜欢的一张画' /></div><div class='am-col col-sm-8 am-list-main'><h3 class='am-list-item-hd'>YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300 400Y</h3><div class='am-list-item-text'>￥280000</div></div></a>"+"</li>"+"<li class='am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left'>"+"<a href='<%=basePath %>client/info' res='1' onclick='clickResponse(this)'><div class='am-col col-sm-4'><img src='<%=basePath %>assets/images/"+"imgtest07"+".jpg' alt='我最喜欢的一张画' /></div><div class='am-col col-sm-8 am-list-main'><h3 class='am-list-item-hd'>YT  欧式 虹吸式陶瓷无水箱智能马桶坑距300 400Y</h3><div class='am-list-item-text'>￥280000</div></div></a>"+"</li>");
    $('.loading').waypoint({offset: '100%'});
  }, {offset: '100%'});
});
</script>

