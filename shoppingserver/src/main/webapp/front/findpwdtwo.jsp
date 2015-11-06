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
        重设密码
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--logo-->
  <div class="am-g logo tlr am-padding-top-sm"><img src="<%=basePath %>assets/images/style/logo.png"/></div>
  <!--//logo-->
  <!--密码找回-->
  <div class="am-g am-padding-horizontal-sm am-padding-top-sm login">
    <form class="am-form">
      <div class="am-form-icon am-form-feedback">
        <input type="password" class="am-form-field" onclick="showicon(this)" placeholder="验证成功，请输入新密码"> <i class="am-icon-times-circle am-hide" onclick="clearvalue(this)"></i>
        <!--<div class="err_tips phone am-padding-sm am-hide" id="err_tips">手机号已经被注册，请换一个吧</div>//错误提示-->
      </div>
      <div class="am-form-icon am-form-feedback">
        <input type="password" class="am-form-field loginpwd" onclick="showicon(this)" placeholder="请再次输入新密码"> <i class="am-icon-times-circle am-hide" onclick="clearvalue(this)"></i>
      </div>
      <button type="submit" class="am-btn am-btn-danger am-btn-block">立即提交</button>
    </form>
  </div>
  <!--//密码找回-->