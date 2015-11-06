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
        商品信息
      </h2>
      <div class="am-titlebar-right">
        <a href="index.html" class="am-icon-home am-icon-sm" title="首页"></a>
      </div>
    </div>
  </div>
  <!--//头部-->
  <!--更多产品信息-->
  <div class="am-g product_more">
    <div data-am-widget="tabs" class="am-tabs am-tabs-d2 product_more_title">
      <div class="am-g">
        <ul class="am-tabs-hd am-cf sm-block-grid-4">
          <li class="am-tabs-hd-active">商品介绍</li>
          <li class="">产品参数</li>
          <li class="">包装清单</li>
          <li class="">售后保障</li>
        </ul>
      </div>
      <div class="am-tabs-bd">
        <div class="am-tabs-bd-content productx_infor">
          <div class="am-tabs-bd-active"><!--商品介绍-->
            <table class="am-table am-table-bd am-table-striped am-text-center">
              <tr>
                <th colspan="4">商品名称：爱乐泉 白色亚克力 扇形水底打光按摩浴缸</th>
              </tr>
              <tr>
                <td>商品编号</td>
                <td>ALQ-5203</td>
                <td>上架时间</td>
                <td>2014-07-16</td>
              </tr>
              <tr>
                <td>价　　格</td>
                <td>0~599</td>
                <td>形　　状</td>
                <td>扇形</td>
              </tr>
              <tr>
                <td>款　　式</td>
                <td>独立式</td>
                <td>材　　质</td>
                <td>亚克力</td>
              </tr>
              <tr>
                <td>类　　别</td>
                <td>双裙边</td>
                <td>品　　牌</td>
                <td>ALQ </td>
              </tr>
            </table>
            <div class="am-g am-margin-vertical-sm">
              <img src="images/infor01.jpg" alt="#"/>
              <img src="images/infor02.jpg" alt="#"/>
              <img src="images/infor03.jpg" alt="#"/>
              <img src="images/infor04.jpg" alt="#"/>
              <img src="images/infor05.jpg" alt="#"/>
            </div>
          </div><!--//商品介绍-->
          <div class="am-padding-vertical-sm"><!--产品参数-->
            <table class="am-table am-table-bd am-table-striped ">
              <tr>
                <td class="am-text-center" width="25%">型　号</td>
                <td width="75%">ALQ-5208</td>
              </tr>
              <tr>
                <td class="am-text-center">类　　型</td>
                <td >冲浪按摩浴缸</td>
              </tr>
              <tr>
                <td class="am-text-center">是否含龙头</td>
                <td>是</td>
              </tr>
              <tr>
                <td class="am-text-center">特色卖点</td>
                <td>1、具有数码电视标准配置，享受沐浴的同时，尽情享受音频的立体感。<br/>2、搭配美思枕，更是给你全身心的放松。<br/>3、偌大的长方形设计，不仅能放松全身，更能任意伸展。</td>
              </tr>
            </table>
          </div><!--产品参数-->
          <div class="am-padding-vertical-sm"><!--包装清单-->
            <table class="am-table am-table-bd am-table-striped">
              <tr>
                <td class="am-text-center" width="25%">主机</td>
                <td>iPhone 5S*1;</td>
              </tr>
              <tr>
                <td class="am-text-center">配件</td>
                <td>具有线控功能和麦克风的 Apple EarPods*1;Lightning to USB 连接线*1；USB 电源适配器*1；保修卡*1；</td>
              </tr>
            </table>
          </div><!--包装清单-->
          <div class="am-padding-vertical-sm paddingtop"><!--售后保障-->
            本产品全国联保，享受三包服务，质保期为:一年质保
如因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！
          </div><!--售后保障-->
        </div>
      </div>
    </div>
  </div>
  <!--//更多产品信息-->