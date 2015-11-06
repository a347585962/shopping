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
        会员登录
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
  <!--登录-->
  <div class="am-g am-padding-horizontal-sm am-padding-top-sm login">
    <form class="am-form">
      <div class="am-form-icon am-form-feedback">
        <input type="tel" class="am-form-field" focus="false" onclick="showicon(this)" placeholder="请输入您的手机号"> <i class="am-icon-times-circle am-hide" onclick="clearvalue(this)"></i>
        <div class="err_tips phone am-padding-sm" id="err_tips">手机号已经被注册，请换一个吧</div><!--//错误提示-->
      </div>
      <div class="am-form-icon am-form-feedback">
        <input type="password" class="am-form-field loginpwd" focus="false" onclick="showicon(this)" placeholder="请设置你的密码"> <i class="am-icon-times-circle am-hide" onclick="clearvalue(this)"></i>
      </div>
      <a href="<%=basePath %>client/center" class="am-btn am-btn-danger am-btn-block">立即登录</a>
    </form>
    <div class="am-g am-padding-top-sm"><span class="am-fl"><a href="<%=basePath %>client/findpwshow" class="am-text-danger"  res="1" onclick="clickResponse(this)"  title="忘记密码">忘记密码？</a></span><span class="am-fr">没有帐号?<a href="<%=basePath %>client/register" class="am-text-danger"  res="1" onclick="clickResponse(this)"  title="立即注册">立即注册</a></span></div>
  </div>
  <!--//登录-->
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