<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="<%=basePath %>media/js/jquery-ui-1.7.1.custom.min.js"></script>
<script type="text/javascript" src="<%=basePath %>media/js/daterangepicker.jQuery.js"></script>
<link rel="stylesheet" href="<%=basePath %>media/css/ui.daterangepicker.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>media/css/jquery-ui-1.7.1.custom.css" type="text/css" title="ui-theme" />
<style>
   .total{
     border:2px solid #82aec0;
     padding:25px;
  }
</style>
</head>
<body>
	<div class="body container-fluid" style="margin: 15px;">
		<span style="font-size:20px;color:#414451;">商品管理-商品上线管理</span>

     <div class='total' style='margin-top:10px;'>
        <div class='row-fluid'>
        <!-- 
				<div class='span12'>
					<div class="ts">
						<p align="left" style="margin-left: 40px;">温馨提示：</p>
						<p align="center">
							尊敬的 &nbsp;&nbsp;<strong style='color: #990000;'>${trader.traderNikename
								}</strong>&nbsp;&nbsp;用户
						</p>
						<p align="center">下面的信息将作为商品的基本信息,请认真填写</p>
						<p align="center">为了您更加好的卖出，请尽可能的填详细！'<font style="color: red;">*</font>'代表必填项！</p>
					</div> -->
				</div>
				<form action="<%=basePath%>activity/add" 
						method="post" id='addactivityform'  enctype="multipart/form-data">
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">活动名称</span> 
								<input class="span2" style="width: 200px;" type="text" name="activityName"
									placeholder="活动名称" /> 
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class='span6'>
							<div class="input-prepend">
								<span class="add-on">活动状态</span>
								<select name="activityStatus" style="width: 200px;">
								  <option value="1">启用</option>
								  <option value="0">停用</option>
								</select>
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">活动时间</span>
								<input type="text" value="" id="rangeA" name='rangetime' style="width: 186px;"/>	

								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">活动类型</span> <select name="activityType"
									id='activityType' style="width: 200px;">
									<option value="0">---请选择---</option>
									<c:forEach items="${activitytypes }" var="activitytype">
										<option value="${activitytype.activitytypeId }">${activitytype.activitytypeName}</option>
									</c:forEach>
								</select> <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<!-- 
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">活动类型</span> <select name="activityType"
									id='activityType'>
									<option value="0">---请选择---</option>
									<c:forEach items="${activitytypes }" var="activitytype">
										<option value="${activitytype.activitytypeId }">${activitytype.activitytypeName}</option>
									</c:forEach>
								</select> <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					 -->
					<div class="row-fluid" id='imgdiv'>
						<div class='span6'>
							<div class="span12" style='margin-left: 0px;'>
								<div class="input-prepend">
									<span class="add-on">图片上传</span> <input type="file"
										class='imgfile' name="files" id="picture" value="图片上传" /> 
										<span style="color: red; padding: 0px; "><font size="3px;">*</font></span>
								</div>
							</div>
							<div class="span12" id="photo"  style='width:100px;height:100px;'>
								<font color="#000000" size='3px;'>已添加图片</font> <br>
							</div>
						</div>
						
					</div>


					<input type="submit" value="添加" id="" class="btn btn-info"
				style="width: 100px; margin-left: 500px;" />

		</form>
        </div>
     </div>

	</div>
	


	<script src="<%=basePath%>media/js/activity.js" type="text/javascript"></script>
</body>
</html>