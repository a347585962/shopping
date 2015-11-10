<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar nav-collapse collapse">
		<!-- BEGIN SIDEBAR MENU -->
		<ul class="page-sidebar-menu">
			<li>
				<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				<div class="sidebar-toggler hidden-phone">
				</div> 
				<!-- END SIDEBAR TOGGLER BUTTON -->
			</li>
			<li>
			
			</li>
			<li class="start active "><a href="##"> <i
					class="icon-home"></i>	群祥后台管理
			</a></li>
			

			<li  id='goods'><a class="active" href=""> <i class="icon-lemon"></i>
				<span class="title">商品管理</span><span class="arrow "></span></a>
				<ul class="sub-menu menu" >
					<li><a href="<%=basePath %>goodsmanager/addview">商品上线管理</a></li>
					<li><a href="<%=basePath %>goodsmanager/goodsinfoview/1"> 商品信息管理</a></li>
					<li><a href="<%=basePath %>goodsclass/goodsclassmagview"> 商品类别管理</a></li>
					<li><a href="<%=basePath %>property/show"> 商品属性管理</a></li>
				</ul>
			</li>
			
			<li class="" id='order'><a href="javascript:;"> <i class="icon-th"></i>
					<span class="title">订单管理</span> <span class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a href='<%=basePath%>order/manager/1'> 订单管理</a></li>
				</ul>
			</li>
			<li class="" id='activity'><a href="javascript:;"> <i
					class="icon-bar-chart"></i> <span class="title">活动管理</span> <span
					class="arrow "></span> 
			</a>
				<ul class="sub-menu">
                    <li><a href="<%=basePath%>activity/addui"> 添加活动</a></li>
					<li><a href="<%=basePath%>activity/manager/1"> 活动管理</a></li>
					
				</ul></li>
			<li class=" "><a href="#"> <i class="icon-file-text"></i>
					<span class="title">客服管理 </span>
			</a></li>
			
			<li class="" id='user'><a href="javascript:;"> <i class="icon-user"></i>
					<span class="title">用户管理</span> <span class="arrow "></span>
			</a>
				<ul class="sub-menu">	
				    <c:if test="${admin.shopId != 0 }">
				      <li><a href="<%=basePath %>user/usermag"
						> 用户查看</a></li>
				    </c:if>
				    <c:if test="${admin.shopId == 0 }">
				      <li><a href="<%=basePath %>user/allusermag"
						> 用户查看</a></li>
				    </c:if>			
					
					<li><a href="<%=basePath %>log/look/1"
						> 日志查看</a></li>
					<c:if test="${admin.shopId == 0 }">
					  <li><a href="<%=basePath %>user/shopmag"
						> 商家管理</a></li>
					</c:if>
				</ul></li>
			
			<li class="" id='analysis'><a href="javascript:;"> <i class="icon-user"></i>
					<span class="title">销售状况统计分析</span> <span class="arrow "></span>
			</a>
				<ul class="sub-menu">
				   <li><a href="<%=basePath %>analysis/toptenperson"
						> 购买量前十</a></li>
					<li><a href="<%=basePath %>analysis/toptengoods"
						> 销售量前十</a></li>
				</ul>
			</li>	
		</ul>
	</div>
	<!-- END SIDEBAR MENU -->
</div>
<!-- END SIDEBAR -->