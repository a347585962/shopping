<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>登录</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="<%=basePath%>media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
    <link href="<%=basePath%>media/css/login-soft.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login" style='background-color: #fff;'>
	<!-- BEGIN LOGO -->
	<div class="logo" style='margin-left:200px;margin-top:10px;margin-bottom:10px;'>
		<img src="<%=basePath%>media/image/logo.png" alt="" />
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div style="background-color:  rgba(12, 23, 36, 1) !important;padding-top:30px;padding-bottom:80px;">
	<div class="content" style="margin-right:150px;background-color: #990000;">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="<%=basePath %>login" method="POST">
			<h3 class="form-title" style='text-align: '>登录你的账号</h3>        
            <!-- 提示信息 -->
			<div class="alert alert-error hide">
				<button class="close" data-dismiss="alert"></button>
                <span>请输入任意的用户名和密码.</span>			
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="controls">
					<div class="input-icon left">					
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="username" >
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password"/>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox" style='margin-left:20px;'>
			<input type="checkbox" name="remember" value="1"/> 记住账号

				</label>

				<input type="submit" class="btn-info span2 blue pull-right" style="margin-right:-15px;" value='登录 '>

				<i class="m-icon-swapright m-icon-white"></i>

				        

			</div>
            
			<div class="forget-password" style='margin-left: auto;margin-right: auto;text-align: center;'>

				<h4>忘记密码了吗 ?</h4>

				<p>

					点击 <a href="javascript:;" class="" id="forget-password">这里</a>

					找回密码

				</p>

			</div>

			

		</form>
		<c:if test="${not empty fail}">
		  <div class="control-group">
			
			<div class="controls">
				<div class="input-icon left">
					<i class="icon-ban-circle"></i> 
				   <span> ${fail }</span> 
				</div>
			</div>
		</div>
		</c:if>
		<!-- END LOGIN FORM -->        

		<!-- BEGIN FORGOT PASSWORD FORM -->

		<form class="form-vertical forget-form" action="index.html">

			<h3 class="">忘记密码 ?</h3>

			<p>输入你的邮箱地址，找回密码。</p>

			<div class="control-group">

				<div class="controls">

					<div class="input-icon left">

						<i class="icon-envelope"></i>

						<input class="m-wrap placeholder-no-fix" type="text" placeholder="邮箱" name="email" />

					</div>

				</div>

			</div>

			<div class="form-actions">

				<button type="button" id="back-btn" class="btn">

				<i class="m-icon-swapleft"></i> 返回

				</button>

				<button type="submit" class="btn blue pull-right">

				找回密码 <i class="m-icon-swapright m-icon-white"></i>

				</button>            

			</div>

		</form>

		<!-- END FORGOT PASSWORD FORM -->

		
	</div>
	</div>

	<!-- END LOGIN -->

	<!-- BEGIN COPYRIGHT -->

	<div class="copyright">

		2015 &copy; 群祥超市

	</div>

	<!-- END COPYRIGHT -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="<%=basePath%>media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="<%=basePath%>media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="<%=basePath%>media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->   


	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="<%=basePath%>media/js/jquery.validate.js"
		type="text/javascript"></script>

	<script src="<%=basePath%>media/js/jquery.backstretch.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="<%=basePath%>media/js/app.js" type="text/javascript"></script>

	<script src="<%=basePath%>media/js/login-soft.js" type="text/javascript"></script>      
    <!-- END PAGE LEVEL SCRIPTS --> 

	<script>

		jQuery(document).ready(function() {       

		   // initiate layout and plugins

		   App.init();
		  // Login.init();

		});

	</script>
    

	
</body>

<!-- END BODY -->

</html>