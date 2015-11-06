<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


  <!--图片滚动-->
  <div data-am-widget="slider" class="am-slider am-slider-a1" data-slider-config='{&quot;directionNav&quot;:false}'>
    <ul class="am-slides main_banner">
      <li>
          <a href="#" title="#"><img src="<%=basePath %>assets/images/01.jpg" alt="#" /></a>
        </li>
        <li>
          <a href="#" title="#"><img src="<%=basePath %>assets/images/02.jpg" alt="#"  /></a>
        </li>
        <li>
          <a href="#" title="#"><img src="<%=basePath %>assets/images/03.jpg" alt="#" /></a>
        </li>
    </ul>
  </div>
  <!--//图片滚动-->
  <!--logo-->
  <div class="am-g logo tlr"><img src="<%=basePath %>assets/images/style/logo.png"/></div>
  <!--//logo-->
  <!--搜索-->
  <div class="am-g search" id="search">
    <div class="col-sm-11 col-sm-centered">
      <form action="search.html" class="am-form am-input-sm">
        <div class="col-sm-10"><input type="text" class="am-form-field" placeholder="请输入您的关键字"></div>
        <div class="col-sm-2"><input type="submit" class="am-form-field"  value="" /></div>
      </form>
    </div>
  </div>
  <!--//搜索-->
  <!--推荐产品-->
  <div class="am-g prou_list tlr">
    <div class="col-sm-6 list_left">
      <a href="infor.html" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest01.jpg" alt="#"/>
        <aside class="price">￥4851</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_right">
      <a href="infor.html" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest02.jpg" alt="#"/>
        <aside class="price">￥4852</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_left">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest03.jpg" alt="#"/>
        <aside class="price">￥4853</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_right">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest04.jpg" alt="#"/>
        <aside class="price">￥4854</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_left">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest05.jpg" alt="#"/>
        <aside class="price">￥4855</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_right">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest06.jpg" alt="#"/>
        <aside class="price">￥4856</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_left">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest07.jpg" alt="#"/>
        <aside class="price">￥4857</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_right">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest08.jpg" alt="#"/>
        <aside class="price">￥4858</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_left">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest09.jpg" alt="#"/>
        <aside class="price">￥4859</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_right">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest10.jpg" alt="#"/>
        <aside class="price">￥48510</aside>
        <p>时尚简约陶瓷圆形红心台上盆</p>
      </a>
    </div>
    <div class="col-sm-6 list_left">
      <a href="#" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest11.jpg" alt="#"/>
        <aside class="price">￥48511</aside>
        <p>超级保温的贵妃木浴缸，传统与现代</p>
      </a>
    </div>
    <div class="col-sm-6 list_right">
      <a href="../../www.baidu.com/default.htm" res="1" onclick="clickResponse(this)" title="#">
        <img src="<%=basePath %>assets/images/imgtest12.jpg" alt="#"/>
        <aside class="price">￥48512</aside>
        <p>爱乐泉 白色亚克力 扇形水</p>
      </a>
    </div>
  </div>
  <!--//推荐产品-->
  <!--体验馆-->
  <div class="am-g">
    <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default expr_title">
      <h2 class="am-titlebar-title"><a href="expr_addr.html" class="am-block" title="体验馆">体验馆</a></h2>
    </div>
    <!--图片滚动-->
    <div data-am-widget="slider" class="am-slider am-slider-a1" data-slider-config='{&quot;directionNav&quot;:false}'>
      <ul class="am-slides main_banner">
        <li>
          <a href="expr_city-store.html" title="#"><img src="<%=basePath %>assets/images/ty01.jpg" alt="#" /></a>
        </li>
        <li>
          <a href="expr_city-store.html" title="#"><img src="<%=basePath %>assets/images/ty02.jpg" alt="#"  /></a>
        </li>
        <li>
          <a href="expr_city-store.html" title="#"><img src="<%=basePath %>assets/images/ty03.jpg" alt="#" /></a>
        </li>
        <li>
          <a href="expr_city-store.html" title="#"><img src="<%=basePath %>assets/images/ty04.jpg" alt="#"  /></a>
        </li>
      </ul>
    </div>
    <!--//图片滚动-->
  </div>
  <!--//体验馆-->
  <div class="am-g cont_tel tlr"><a href="tel_3A400-0162-899"  res="1" onclick="clickResponse(this)"  title="虎居客服"><i class="am-icon-phone-square"></i>400-0162-899</a></div>
  <div class="am-g copyrt tlr">m.aihuju.com</div>
  

<div class="am-hide"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1252987380'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/stat.php%3Fid%3D1252987380%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script></div>
