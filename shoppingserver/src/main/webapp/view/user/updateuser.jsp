<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<form action="<%=basePath %>user/updateuser" class='form-horizontal' method="post" id='teacherForm' enctype="multipart/form-data">

	<div style="padding: 20px;">
		<div class="row" style='margin-top: 10px;'>
			<div class="row div-common" style='margin-top: 10px;'>
				<div class="span5 input-prepend">
					<span class="add-on">日志名称：</span> <input class="  input-medium"
						name="userName" type="text" value='${user.userName }'/>
				</div>
				<div class="clearfix visible-xs"></div>

			</div>
			
			<div class='row div-common' style='margin-top: 10px;'>
				<div class="span5 input-prepend">
					<span class="add-on">密码：</span> <input name="password"
						type="text" value='${user.password }'/>
				</div>
				

			</div>
			<input name="adminId" value="${user.adminId }" type="hidden">
			<input type="submit" value="完成"
				style="margin-left: 500px; margin-top: 10px;" class="btn btn-info"
				/>
		</div>
	</div>
</form>
