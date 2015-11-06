
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN HEADER -->

<div class="header navbar navbar-inverse navbar-fixed-top">

	<!-- BEGIN TOP NAVIGATION BAR -->

	<div class="navbar-inner">

		<div class="container-fluid">

			<!-- BEGIN LOGO -->

			<a class="brand" href="Uindex.jsp"> <img
				src="<%=basePath%>media/image/logo1.png" alt="" />

			</a>

			<!-- END LOGO -->


			<!-- BEGIN TOP NAVIGATION MENU -->

			<ul class="nav pull-right">

				<!-- BEGIN USER LOGIN DROPDOWN -->

				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <img alt=""
						src="<%=basePath%>media/image/avatar1_small.jpg" /> <span
						class="username">当前用户：${admin.userName }</span>

				</a></li>

				<!-- END USER LOGIN DROPDOWN -->

			</ul>

			<!-- END TOP NAVIGATION MENU -->

		</div>

	</div>

	<!-- END TOP NAVIGATION BAR -->

</div>

<!-- END HEADER -->
<input type="hidden" id="sMenu" value="${sMenu }" />
<input type="hidden" id="mMenu" value="${mMenu }" />
<input type="hidden" id="mmMenu" value="${mmMenu }">
<input type="hidden" id="basePath" value="<%=basePath%>">