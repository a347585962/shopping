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
        注册会员
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--logo-->
  <div class="am-g logo tlr am-padding-top-sm"><img src="images/style/logo.png"/></div>
  <!--//logo-->
  <!--注册-->
  <div class="am-g am-padding-horizontal-sm am-padding-top-sm login">
    <form class="am-form">
      <div class="am-form-icon am-form-feedback">
        <input type="tel" class="am-form-field" onclick="showicon(this)" placeholder="请输入您的手机号"> <i class="am-icon-times-circle am-hide" onclick="clearvalue(this)"></i>
        <div class="err_tips phone am-padding-sm" id="err_tips">手机号已经被注册，请换一个吧</div><!--//错误提示-->
      </div>
      <div class="am-form-icon am-form-feedback">
        <input type="password" class="am-form-field loginpwd" onclick="showicon(this)" placeholder="请设置你的密码"> <i class="am-icon-times-circle am-hide" onclick="clearvalue(this)"></i>
      </div>
      <button type="submit" class="am-btn am-btn-danger am-btn-block">注册账号</button>
    </form>
    <div class="am-g am-padding-top-sm"><span class="am-fr">已有帐号?<a href="login.html" class="am-text-danger"  res="1" onclick="clickResponse(this)"  title="直接登录">直接登录</a></span></div>
  </div>
  <!--//注册-->
  <!--快捷登录-->
  <div class="login-app am-padding-horizontal-sm">
    <p class="am-padding-bottom-sm">使用合作网站账号登录</p>
    <ul>
      <li class="am-fl"><a href="#" class="am-block" title="QQ"></a></li>
      <li class="am-fl"><a href="#" class="am-block" title="微博"></a></li>
      <li class="am-fl"><a href="#" class="am-block" title="微信"></a></li>
      <li class="am-fl"><a href="#" class="am-block" title="支付宝"></a></li>
    </ul>
    <div class="am-cf"></div>
  </div>
  <!--//快捷登录-->
