<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${success==true }">
   <div class="ts" style='height:40px;padding:1px;width:90%;'>
	  <div style='margin-top:15px;'><p align="center" style='color:'>添加成功</p></div>
	</div>
</c:if>
<c:if test="${success==false }">
   <div class="ts" style='height:40px;padding:1px;width:90%;'>
	  <div style='margin-top:15px;'><p align="center" style='color:'>添加失败</p></div>
	</div>
</c:if>

<div>
    <button class='btn  btn-info' id='adduser' style='margin-top:10px;'>新增用户</button>
	<table style="width: 100%; border:1px solid;" class="table table-hover article-table">
	          <c:choose> 
					<c:when test="${empty users }">
						<tr>
							<td colspan="3" style="color: red" align="center">暂时没有专业信息</a></td>
						</tr>
					</c:when>
					<c:when test="${not empty users}">
					    <tr style="background-color:#414451; color:#fff">
					       <td style='' class=''>日志名</td>
					      <td style='' class=''>密码</td>
					       <td  class=''>操作</td>
					    </tr>
						<c:forEach items="${users }" var="user" varStatus="status">
							<tr class='discuss'>
								<td class=" ">
								    <div class=''><a
									title='${user.userName}'>
									<span >${user.userName}</span>
									</a></div>
								</td>
								<td class=" ">
								    <div class=''><a
									title='${user.password}'>
									<span >${user.password}</span>
									</a></div>
								</td>
								
								<td class=""><a href='#'><button te='${user.adminId }' url='deluser' backurl='usermag' style='width:80px;' class='del btn btn-danger'>删除</button></a>
								  |	<button  userid='${user.adminId }'   username="${user.userName}" password="${user.password}"
								   style='width:80px;' class="update btn btn-warning"  >
                                                                                                                     修改
                                   </button>
                                   <!-- Modal -->
                           
								</td>
						</c:forEach>
						
					</c:when>
				</c:choose>
				</table>
	<div id="addUserModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">添加管理员用户</h3>
		</div>

		<div class="modal-body">
			<div style="padding: 20px;">
				<div class="row" style='margin-top: 10px;'>
					<form action="<%=basePath%>user/adduser" id='adduserform'
						class='form-horizontal' method="post">
						<div class="row div-common" style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">用户名称</label>
								<div class="controls">
									<input class="" name="userName" type="text" />
								</div>
							</div>
							<div class="clearfix visible-xs"></div>
						</div>
						<div class='row div-common' style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">密&nbsp;&nbsp;&nbsp;码</label>
								<div class="controls">
									<input name="password" type="password" id='password' />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">重复密码</label>
								<div class="controls">
									<input name="repassword" type="password" />

								</div>
								<span></span>
							</div>
						</div>
						<button class="btn" style='float: right; margin-right: 100px;'
							type="submit">提交</button>
					</form>
				</div>
			</div>

		</div>
		<div class="modal-footer">

			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>

	</div>
	<div id="updateUserModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">修改用户信息</h3>
		</div>

		<div class="modal-body">
			<div style="padding: 20px;">
				<div class="row" style='margin-top: 10px;'>
					<form action="<%=basePath%>user/updateuser" id='updateuserform'
						class='form-horizontal' method="post">
						<div class="row div-common" style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">管理员id</label>
								<div class="controls">
									<input class="" name="" id='update_userid' type="text" disabled="true" />
								</div>
							</div>
							<div class="clearfix visible-xs"></div>
						</div>
						<div class="row div-common" style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">日志名称</label>
								<div class="controls">
									<input class="" id='update_username' name="userName" type="text" />
								</div>
							</div>
							<div class="clearfix visible-xs"></div>
						</div>
						<div class='row div-common' style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">原密&nbsp;&nbsp;&nbsp;码</label>
								<div class="controls">
									<input name="" id='update_password' type="text"  />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">新密&nbsp;&nbsp;&nbsp;码</label>
								<div class="controls">
									<input name="password" id='updatepassword1' type="password"  />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">重复密码</label>
								<div class="controls">
									<input name="repassword" type="password" />

								</div>
								<span></span>
							</div>
						</div>
						<input type="hidden" id='userid' name='adminId'>
						<button class="btn" style='float: right; margin-right: 100px;'
							type="submit">提交</button>
					</form>
				</div>
			</div>

		</div>
		<div class="modal-footer">

			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>

	</div>

</div>
<script src="<%=basePath%>media/js/user.js" type="text/javascript"></script>