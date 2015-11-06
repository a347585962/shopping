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
        搜索
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--搜索&分类-->
  <div class="am-g search-list am-padding-sm">
    <!--搜索-->
    <div class="am-g search" id="search">
      <div class="am-g">
        <form action="search.html" class="am-form am-input-sm">
          <div class="col-sm-10"><input type="text" class="am-form-field" placeholder="请输入您的关键字"></div>
          <div class="col-sm-2"><input type="submit" class="am-form-field"  value="" /></div>
        </form>
      </div>
    </div>
    <!--//搜索-->
    <!--分类-->
    <div class="am-g am-margin-top-sm menu_list">
      <section data-am-widget="accordion" class="am-accordion am-accordion-gapped"
      data-accordion-settings='{  }'>
        <dl class="am-accordion-item am-active">
          <dt class="am-accordion-title">服饰鞋帽</dt>
          <dd class="am-accordion-content">
            <p>女装</p>
            <ul>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">衬衫</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">卫衣</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">T恤</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">小西装</a></li>
            </ul>
            <p>男装</p>
            <ul>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">衬衫</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">卫衣</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">T恤</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">牛仔裤</a></li>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">衬衫</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">烟灶消套装（油烟机、燃气灶）</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">T恤</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">牛仔裤</a></li>
            </ul>
            <p>品牌</p>
            <ul class="brands">
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">格雷仕</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">朗司</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">科勒</a></li>
            </ul>
          </dd>
        </dl>
        <dl class="am-accordion-item">
          <dt class="am-accordion-title">居家生活</dt>
          <dd class="am-accordion-content">
            <p>男装</p>
            <ul>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">书房</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">儿童房</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">户外家具</a><a href="<%=basePath%>client/list" title="#">餐厅</a></li>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">卧室</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">客厅</a></li>
            </ul>
            <p>品牌</p>
            <ul class="brands">
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">三木印象</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">贝乐美佳</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">米图</a></li>
            </ul>
          </dd>
        </dl>
        <dl class="am-accordion-item">
          <dt class="am-accordion-title">食品酒水</dt>
          <dd class="am-accordion-content">
            <p>男装</p>
            <ul>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">家居饰品</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">居家日用</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">床上用品</a><a href="<%=basePath%>client/list" title="#">布艺织物</a></li>
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">创意礼品</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">创意家居</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">家饰家纺</a><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">卫浴配件</a></li>
            </ul>
            <p>品牌</p>
            <ul class="brands">
              <li><a href="<%=basePath%>client/list" res="1" onclick="clickResponse(this)" title="#">振湖家纺</a></li>
            </ul>
          </dd>
        </dl>
      </section>
    </div>
    <!--//分类-->
  </div>
  <!--//搜索&分类-->

