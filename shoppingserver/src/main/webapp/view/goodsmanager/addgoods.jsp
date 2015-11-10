<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>商品上线管理</title>
<style>

  body{

  }
  .add-on.test{

  }
  .total{
     margin-top:10px;
     margin-left:0px;
     padding:25px;
     background-color: #ddd;
     padding:10px;
     border: 1px dotted #414451;
  }
  hr{
     height:2px;
     border:none;
     border-top:2px solid #faa73f;
  }
</style>
</head>
<body>
	<div class="body container-fluid" style="margin: 15px;">
		<div style='text-align:center;'><span style="font-size:14px;color:#414451;text-align: center;">亲！添加商品哦。</span></div>
       <!--  <button id='import' class='btn btn-info'>批量导入</button>  -->
     <div class='total '> 
     <div class='' style='margin-left:50px;' >
        <div class=''>
        <!-- 
				<div class='span12'>
					<div class="ts">
						<p align="left" style="margin-left: 40px;">温馨提示：</p>
						<p align="center">
							尊敬的 &nbsp;&nbsp;<strong style='color: #990000;'>${admin.userName
								}</strong>&nbsp;&nbsp;用户
						</p>
						<p align="center">下面的信息将作为商品的基本信息,请认真填写</p>
						<p align="center">为了您更加好的卖出，请尽可能的填详细！'<font style="color: red;">*</font>'代表必填项！</p>
					</div>
				</div>
				 -->
				<div id="importModal" class="modal hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">批量上传商品</h3>
					</div>
					<div class="modal-body">
						<div style="padding: 20px;margin-left:100px;">
							<div class="row" style='margin-top: 10px;'>
								<form action="<%=basePath%>goodsmanager/importview" id='importgoodsform'
									method="post" id='' enctype="multipart/form-data">
									<div class="row-fluid">
										<div class="span6">
											<div class="input-prepend">
												<span class="add-on">文件选择</span> <input type="file"
													name="excelfile"> 
													<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
											</div>
										</div>
									</div>
									<button  class="btn btn-info" style='float: center; margin-left: 70%;color:bule;'
										type="submit">提&nbsp;&nbsp;交</button>
								</form>
							</div>
						</div>

					</div>
					<div class="modal-footer">

						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					</div>

				</div>
				
				<form action="<%=basePath%>goodsmanager/submitview" 
						method="post" id='addgoodsform'  enctype="multipart/form-data">
					<input type="hidden" name="goodsoneclass" id="goodsoneclass">
					<input type="hidden" name="goodstwoclass" id="goodstwoclass">
					<input type="hidden" name="goodsthreeclass" id="goodsthreeclass">
					<c:forEach begin="1" end="${fn:length(properties)}" step="2" varStatus="status">
						<div class="row-fluid">
						<c:forEach items="${properties }" var="property"
						         begin="${(status.count-1)*2 }" end="${(status.count)*2-1 }" varStatus="status1" >
									<c:if test="${fn:contains(fn:trim(property.propertyType), 'input')}">
									  <c:if test="${!fn:contains(fn:trim(property.propertyName), 'photoUrl')}">
										<div class="span6">
											<div class="input-prepend">
												<span class="add-on test">${property.propertyShowname}</span>
												 <input class="span2" style="width: 200px;" type="text"
													name="${property.propertyName }"
													placeholder="${property.propertyShowname }" /> <span
													style="color: red; padding: 8px;"><font size="3px;">*</font></span>
											</div>
										</div>
										</c:if>
									</c:if>
									<c:if test="${fn:contains(fn:trim(property.propertyType), 'select')}">
										<c:if test="${fn:contains(fn:trim(property.propertyName), 'activityId')}">
											<div class="span6">
												<div class="input-prepend">
													<span class="add-on test">${property.propertyShowname}</span> 
													<select
														name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;"><option
															value="0">---请选择---</option>
															<c:forEach items="${activities }" var="activity">
													          <option value="${activity.activityId }">${activity.activityName}</option>
										                    </c:forEach>	
													</select> <span
														style="color: red; padding: 8px;"><font size="3px;">*</font></span>
												</div>
											</div>
										</c:if>
										<c:if test="${!fn:contains(fn:trim(property.propertyName), 'activityId')}">
										  <c:if test="${!fn:contains(fn:trim(property.propertyName), 'goodsClass1')}">
											<c:if test="${!fn:contains(fn:trim(property.propertyName), 'status')}">
												  <div class="span6">
													<div class="input-prepend">
														<span class="add-on test">${property.propertyShowname}</span> 
														<select
															name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;"><option
																value="0">---请选择---</option></select> <span
															style="color: red; padding: 8px;"><font size="3px;">*</font></span>
													</div>
												</div>
												</c:if>
												<c:if test="${fn:contains(fn:trim(property.propertyName), 'status')}">
												 <div class="span6">
													<div class="input-prepend">
														<span class="add-on test">${property.propertyShowname}</span> 
														<select
															name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;">
															<option
																value="1">上架</option>
																<option
																value="0">暂不上架</option>
																</select> <span
															style="color: red; padding: 8px;"><font size="3px;">*</font></span>
														</div>
													</div>
												</c:if>
											
											</c:if>
											<c:if test="${fn:contains(fn:trim(property.propertyName), 'goodsClass1')}">
											  <div class="span6">
												<div class="input-prepend">
													<span class="add-on test">${property.propertyShowname}</span> <select
														name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;"><option
															value="0">---请选择---</option>
															<c:forEach items="${level1s }" var="levelone">
																<option value="${levelone.level1Id }">${levelone.level1Name}</option>
															</c:forEach>
														</select> <span
														style="color: red; padding: 8px;"><font size="3px;">*</font></span>
												</div>
											</div>
											</c:if>
										</c:if>
									</c:if>
								</c:forEach>
						</div>
					</c:forEach>
					<!-- <div class="row-fluid">
					    <div class="span6">
								<div class="input-prepend">
									<span class="add-on test">条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span> 
									<input class="span2" style="width: 200px;" type="text" placeholder="条码" name="barCode" />
									<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
								</div>
						</div>
						<div class="span6">
								<div class="input-prepend">
									<span class="add-on test">二级分类</span> 
									<select name="goodsClass2" id='leveltwo' style="width:200px;"><option value="0">---请选择---</option></select>
									 <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
										
								</div>
								
						</div>
						
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on test">商品单位</span> 
								<input class="span2" style="width: 200px;" type="text" 
								placeholder="商品单位" name="goodsUntis" />
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class="span6">
								<div class="input-prepend">
									<span class="add-on test">三级分类</span> 
									<select name="goodsClass3" id='levelthree' style="width:200px;"><option value="0">---请选择---</option></select>
						    <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
								</div>
						</div>
						
					</div>
					<div class="row-fluid">
					    <div class='span6'>
							<div class="input-prepend">
								<span class="add-on test">商品产地</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="商品产地" name="productAddress" />
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					    
						
						<div class="span6">
								<div class="input-prepend">
									<span class="add-on test">商品状态</span> 
									<select name="status" id='levelthree' style="width:200px;">
									<option value="1">上架</option>
									<option value="0">暂不上架</option>
									</select>
						    <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
								</div>
							</div>
						
						
					</div>
					<div class="row-fluid">
					    <div class='span6'>
							<div class="input-prepend">
								<span class="add-on test">商品型号</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="商品型号"
									name="goodsType" /> 
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					    
						
						<div class="span6">
								<div class="input-prepend">
									<span class="add-on test">活动类型</span> 
									<select name="activityId" id='activityId' style="width:200px;"><option value="0">---请选择---</option>
						            <c:forEach items="${activities }" var="activity">
											<option value="${activity.activityId }">${activity.activityName}</option>
								    </c:forEach>
								    </select>
								</div>
						</div>
					</div>
					<div class="row-fluid">
					    <div class="span6">
							<div class="input-prepend">
								<span class="add-on test">商品进价</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="商品进价" name="goodsPriceIn" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class='span6'>
							<div class="input-prepend">
								<span class="add-on test">批&nbsp;&nbsp;发&nbsp;&nbsp;价</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="零 批 发 价 价" name="goodsPrice3" />
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>		
					</div>
					<div class="row-fluid">
					    <div class="span6">
							<div class="input-prepend">
						        <span class="add-on test">促&nbsp;&nbsp;销&nbsp;&nbsp;价</span><span></span>
						
								<input class="span2" style="width: 200px;" type="text" placeholder="促 销 价" name="goodsPrice4" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
							<div class='span6'>
							<div class="input-prepend">
								<span class="add-on test">零&nbsp;&nbsp;售&nbsp;&nbsp;价</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="零 售 价" name="goodsPrice1" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
					    <div class="span6">
							   <div class="input-prepend">
						        <span class="add-on test">会&nbsp;&nbsp;员&nbsp;&nbsp;价</span><span></span>
								<input class="span2" style="width: 200px;" type="text" placeholder="会 员 价" name="goodsPrice2" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							   </div>
						</div>
						<div class="span6">
								<div class="input-prepend">
									<span class="add-on test">库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</span> 
									<input class="span2" style="width: 200px;" type="text" placeholder="库存" name="goodsStock" />
								</div>
						</div>
					</div>
					<div class="row-fluid">
					    <div class="span6">
								<div class="input-prepend">
									<span class="add-on test">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span> 
									<input class="span2" style="width: 200px;" type="text" placeholder="备注" name="remark" />
								</div>
							</div>
					</div>
					</div>
				 -->	
				<div class="row-fluid" id='imgdiv'>
				<div class='span6'>
					<div class="span12" style='margin-left: 0px;'>
						<div class="input-prepend">
							<span class="add-on test">图片上传</span> <input type="file"
								class='imgfile' name="files" id="picture" value="图片上传" />

						</div>
					</div>
					<div class="span12" style='margin-left: 0px;'>
						<div class="input-prepend">
							<span class="add-on test">图片上传</span> <input type="file"
								class='imgfile' name="files" id="" value="图片上传" /> 

						</div>


					</div>
					<div class="span12" style='margin-left: 0px;'>
						<div class="input-prepend">
							<span class="add-on test">图片上传</span> <input type="file"
								class='imgfile' name="files" id="" value="图片上传" /> 

						</div>


					</div>
					<div class="span12" style='margin-left: 0px;'>
						<div class="input-prepend">
							<span class="add-on test">图片上传</span> <input type="file"
								class='imgfile' name="files" id="" value="图片上传" /> 

						</div>


					</div>
					<div class="span12" style='margin-left: 0px;'>
						<div class="input-prepend">
							<span class="add-on test">图片上传</span> <input type="file"
								class='imgfile' name="files" id="" value="图片上传" />

						</div>


					</div>
				</div>

				<div class="span6" id="photo">
					<font color="red">你添加了的图片：</font> <br>
				</div>


			</div>
			<input type="submit" value="添加" id="" class="btn btn-info"
				style="width: 100px; margin-left: 500px;" />
			<button id='import' class='btn btn-info'
			    style="width: 100px; margin-left: 20px;">批量导入</button>

		</form>
        </div>
        </div>
     </div>



<script src="<%=basePath%>media/js/goods.js" type="text/javascript"></script>
</body>
</html>