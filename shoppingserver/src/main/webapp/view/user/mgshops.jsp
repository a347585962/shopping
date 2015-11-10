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
    <button class='btn  btn-info' id='addshop' style='margin-top:10px;'>新增商家</button>
	<table style="width: 100%; border:1px solid;" class="table table-hover article-table">
	          <c:choose> 
					<c:when test="${empty shops }">
						<tr>
							<td colspan="3" style="color: red;text-align:center" >暂时没有商家信息</td>
						</tr>
					</c:when>
					<c:when test="${not empty shops}">
					    <tr style="background-color:#414451; color:#fff">
					       <td style='' class=''>商家名称</td>
					      <td style='' class=''>商家法人</td>
					       <td style='' class=''>联系方式</td>
					       <td  class=''>操作</td>
					    </tr>
						<c:forEach items="${shops }" var="shop" varStatus="status">
							<tr class='discuss'>
								<td class=" ">
								    <div class=''><a
									title='${shop.shopName}'>
									<span >${shop.shopName}</span>
									</a></div>
								</td>
								<td class=" ">
								    <div class=''><a
									title='${shop.shopPeople}'>
									<span >${shop.shopPeople}</span>
									</a></div>
								</td>
								<td class=" ">
								    <div class=''><a
									title='${shop.shopPhone}'>
									<span >${shop.shopPhone}</span>
									</a></div>
								</td>
								<td class=""><a href='<%=basePath %>user/delshop/${shop.shopPhone}'>
								<button  style='width:80px;' class='del btn btn-danger'>删除</button></a>
								  |	<button  shopid='${shop.shopId }'   shopname="${shop.shopName}" 
								      shopphone="${shop.shopPhone}"  shoppeople="${shop.shopPeople}"
								      shopstatus="${shop.shopStatus}"
								   style='width:80px;' class="shopupdate btn btn-warning"  >
                                                                                                                     修改
                                   </button>
                                   <!-- Modal -->
                           
								</td>
						</c:forEach>
						
					</c:when>
				</c:choose>
				</table>
	<div id="addShopModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">添加商家</h3>
		</div>

		<div class="modal-body">
			<div style="padding: 20px;">
				<div class="row" style='margin-top: 10px;'>
					<form action="<%=basePath%>user/addshop" id='adduserform'
						class='form-horizontal' method="post">
						<div class="row div-common" style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">商家名称</label>
								<div class="controls">
									<input class="" name="shopName" type="text" />
								</div>
							</div>
							<div class="clearfix visible-xs"></div>
						</div>
						<div class='row div-common' style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">联系方式</label>
								<div class="controls">
									<input name="shopPhone" type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">商家法人</label>
								<div class="controls">
									<input name="shopPeople" type="text" />

								</div>
								<span></span>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">商家状态</label>
								<div class="controls">
									<select name='shopStatus'>
									  <option value="0">待激活</option>
									  <option value="1">激活</option>
									</select>

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
	<div id="updateShopModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">修改用户信息</h3>
		</div>

		<div class="modal-body">
			<div style="padding: 20px;">
				<div class="row" style='margin-top: 10px;'>
					<form action="<%=basePath%>user/updateshop" id='updateuserform'
						class='form-horizontal' method="post">
						<div class="row div-common" style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">商家名称</label>
								<div class="controls">
									<input class="" name="shopName" id='shopName' type="text" />
								</div>
							</div>
							<div class="clearfix visible-xs"></div>
						</div>
						<div class='row div-common' style='margin-top: 10px;'>
							<div class="control-group">
								<label class="control-label" for="inputEmail">联系方式</label>
								<div class="controls">
									<input name="shopPhone" id='shopPhone' type="text" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">商家法人</label>
								<div class="controls">
									<input name="shopPeople" id='shopPeople' type="text" />

								</div>
								<span></span>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">商家状态</label>
								<div class="controls">
									<select name='shopStatus'>
									  <option value="0">待激活</option>
									  <option value="1">激活</option>
									</select>

								</div>
								<span></span>
							</div>
						</div>
						<input type="hidden" id='shopid' name='shopId'>
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