<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>异常处理页面</title>
<link href="<%=basePath%>bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<div class='container-fluid' align="center" style='margin-top:300px;'>
   <div class='row-fluid'>
      <div class='span12'>
         <img alt="出错页面" src="<%=basePath%>images/error.jpg">
         <h1>很抱歉 您要访问的页面出现异常</h1>
      </div>
      <div class='span12' style='margin-top:200px;'><h2>版权：西华大学<a href='http://mc.xhu.edu.cn/'>数学与计算机学院</a></h2></div>
   </div>
</div>

</body>
</html>