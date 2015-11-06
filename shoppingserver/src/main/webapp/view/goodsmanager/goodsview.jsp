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
<title>商品上线管理</title>
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
							尊敬的 &nbsp;&nbsp;<strong style='color: #990000;'>${admin.userName
								}</strong>&nbsp;&nbsp;用户
						</p>
						<p align="center">下面的信息将作为商品的基本信息,请认真填写</p>
						<p align="center">为了您更加好的卖出，请尽可能的填详细！'<font style="color: red;">*</font>'代表必填项！</p>
					</div>
				</div>
        
         -->
				
				<form action="<%=basePath%>goodsmanager/update" 
						method="post" id='updategoodsform'  enctype="multipart/form-data">
					<input type="hidden" name="goodsoneclass" id="goodsoneclass" value='${oneclass }'>
					<input type="hidden" name="goodstwoclass" id="goodstwoclass" value='${twoclass }'>
					<input type="hidden" name="goodsthreeclass" id="goodsthreeclass" value='${threeeclass }'>
					<input type="hidden" name="goodsId" id="goodsId" value='${goodsinfo.goodsId }'>
					<input type="hidden" name="" id="goodsstatus" value='${goodsinfo.status }'>
					<input type="hidden" name="" id="activity_type" value='${goodsinfo.activityId }'>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">商品名称</span> 
								<input class="span2" style="width: 200px;" type="text" name="goodsName" value="${goodsinfo.goodsName }"
									placeholder="商品名称" /> 
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class='span6'>
							<div class="input-prepend">
								<span class="add-on">商品型号</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="商品型号" value="${goodsinfo.goodsType }"
									name="goodsType" /> 
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">商品单位</span> 
								<input class="span2" style="width: 200px;" type="text" 
								placeholder="商品单位" name="goodsUntis" value="${goodsinfo.goodsUntis }" />
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class='span6'>
							<div class="input-prepend">
								<span class="add-on">商品产地</span>
								<input class="span2" style="width: 200px;" type="text" value="${goodsinfo.productAddress }" placeholder="商品产地" name="productAddress" />
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
								<span class="add-on">商品进价</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="商品进价" name="goodsPriceIn" value="${goodsinfo.goodsPriceIn }" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class='span6'>
							<div class="input-prepend">
								<span class="add-on">&nbsp;零&nbsp;售&nbsp;价</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="零 售 价" name="goodsPrice1" value="${goodsinfo.goodsPrice1 }" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
						        <span class="add-on">&nbsp;会&nbsp;员&nbsp;价</span><span></span>
								<input class="span2" style="width: 200px;" type="text" placeholder="会 员 价" name="goodsPrice2" value="${goodsinfo.goodsPrice2 }" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						<div class='span6'>
							<div class="input-prepend">
								<span class="add-on">&nbsp;批&nbsp;发&nbsp;价</span>
								<input class="span2" style="width: 200px;" type="text" placeholder="零 批 发 价 价" name="goodsPrice3" value="${goodsinfo.goodsPrice3 }" />
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="input-prepend">
						        <span class="add-on">&nbsp;促&nbsp;销&nbsp;价</span><span></span>
						
								<input class="span2" style="width: 200px;" type="text" placeholder="促 销 价" name="goodsPrice4" value="${goodsinfo.goodsPrice4 }" />
								
								<span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
						
					</div>
					<div class="row-fluid">
							<div class="span6">
								<div class="input-prepend">
									<span class="add-on">一级分类</span> 
									<select name="goodsClass1" id='levelone' style="width: 198px;" >
						          <option value="0" >---请选择---</option>
						          <c:forEach items="${levelones }" var="levelone">
											<option value="${levelone.level1Id }">${levelone.level1Name}</option>
										</c:forEach>
						   </select>
						    <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
								</div>
							</div>
							<div class="span6">
								<div class="span6">
								<div class="input-prepend">
									<span class="add-on">商品状态</span> 
									<select name="status" id='goodsstatusselect' style="width: 198px;">
									<option value="1">上架</option>
									<option value="0">暂不上架</option>
									</select>
						    <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
								</div>
							</div>
								
							</div>
					</div>
					<div class="row-fluid">
					  <div class="span6">
						<div class="input-prepend">
									<span class="add-on">二级分类</span> 
									<select name="goodsClass2" id='leveltwo' style="width: 198px;">
                                     
						          <option value="0" >---请选择---</option>
						          <c:forEach items="${leveltwos }" var="leveltwo">
											<option value="${leveltwo.level2Id }">${leveltwo.level2Name}</option>
										</c:forEach>
						  
                                    </select>
									 <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
									</div>	
								</div>
						    <div class="span6">
								<div class="input-prepend">
									<span class="add-on">活动类型</span> 
									<select name="activityId" id='activityId' style="width: 198px;"><option value="0">---请选择---</option>
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
								<span class="add-on">三级分类</span> <select name="goodsClass3"
									id='levelthree' style="width: 198px;">

									<option value="0">---请选择---</option>
									<c:forEach items="${levelthrees }" var="levelthree">
										<option value="${levelthree.level3Id }">${levelthree.level3Name}</option>
									</c:forEach>

								</select> <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
							</div>
						</div>
							
							<div class="span6">
								<div class="input-prepend">
									<span class="add-on">&nbsp;库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</span> 
									<input class="span2" style="width: 198px;" type="text" placeholder="库存" name="goodsStock" value='${goodsinfo.goodsStock }' />
								</div>
							</div>
						</div>
						<div class="row-fluid">
							
							<div class="span6">
								<div class="input-prepend">
									<span class="add-on">&nbsp;条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span> 
									<input class="span2" style="width: 198px;" type="text" placeholder="条码" name="barCode" value='${goodsinfo.barCode }' />
								</div>
							</div>
							<div class="span6">
								<div class="input-prepend">
									<span class="add-on">&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</span> 
									<input class="span2" style="width: 198px;" type="text" placeholder="备注" name="remark" />
								</div>
							</div>
						</div>
						<div class="row-fluid" id='imgdiv'>
						
						<div class="span6" id="photo">
							<font color="red">你添加了的图片：</font> <br>
							<c:forEach items="${imgs }" var="img">
								<img src="<%=basePath %>${img}" width="100" height="80">
							</c:forEach>
						</div>
					</div>

			

		</form>
        </div>
     </div>

	</div>

<script src="<%=basePath%>media/js/goods.js" type="text/javascript"></script>
</body>
</html>