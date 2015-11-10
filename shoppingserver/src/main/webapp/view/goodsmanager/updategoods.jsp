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
													name="${property.propertyName }" id='${property.propertyName }'
													placeholder="${property.propertyShowname }"  /> 
													<span
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
											<c:if test="${!fn:contains(fn:trim(property.propertyName), 'goodsClass2')}">
											  <c:if test="${!fn:contains(fn:trim(property.propertyName), 'goodsClass3')}">
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
												<c:if test="${fn:contains(fn:trim(property.propertyName), 'goodsClass3')}">
											    <div class="span6">
												<div class="input-prepend">
													<span class="add-on test">${property.propertyShowname}</span> 
													<select
														name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;"><option
															value="0">---请选择---</option>
															<c:forEach items="${levelthrees }" var="levelthree">
																<option value="${levelthree.level3Id }">${levelthree.level3Name}</option>
															</c:forEach>
														</select> <span
														style="color: red; padding: 8px;"><font size="3px;">*</font></span>
													</div>
												</div>
												</c:if>
											</c:if>
											<c:if test="${fn:contains(fn:trim(property.propertyName), 'goodsClass2')}">
											    <div class="span6">
												<div class="input-prepend">
													<span class="add-on test">${property.propertyShowname}</span> 
													<select
														name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;"><option
															value="0">---请选择---</option>
															<c:forEach items="${leveltwos }" var="leveltwo">
												               <option value="${leveltwo.level2Id }">${leveltwo.level2Name}</option>
											                 </c:forEach>
														</select> <span
														style="color: red; padding: 8px;"><font size="3px;">*</font></span>
												</div>
											</div>
											</c:if>
											</c:if>
											<c:if test="${fn:contains(fn:trim(property.propertyName), 'goodsClass1')}">
											  <div class="span6">
												<div class="input-prepend">
													<span class="add-on test">${property.propertyShowname}</span> 
													<select
														name="${property.propertyName }" id='${property.propertyName }' style="width: 200px;"><option
															value="0">---请选择---</option>
															<c:forEach items="${levelones }" var="levelone">
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
						<div class="row-fluid" id='imgdiv'>
						<div class='span6'>
							<div class="span12" style='margin-left: 0px;'>
								<div class="input-prepend">
									<span class="add-on">图片上传</span> <input type="file"
										class='imgfile' name="files" id="picture" value="图片上传" /> 
									 <span style="color: red; padding: 8px; "><font size="3px;">*</font></span>
								</div>
							</div>
							<div class="span12" style='margin-left: 0px;'>
								<div class="input-prepend">
									<span class="add-on">图片上传</span> <input type="file"
										class='imgfile' name="files" id="" value="图片上传" />
								</div>
							</div>
							<div class="span12" style='margin-left: 0px;'>
								<div class="input-prepend">
									<span class="add-on">图片上传</span> <input type="file"
										class='imgfile' name="files" id="" value="图片上传" />
								</div>
							</div>
							<div class="span12" style='margin-left: 0px;'>
								<div class="input-prepend">
									<span class="add-on">图片上传</span> <input type="file"
										class='imgfile' name="files" id="" value="图片上传" />
								</div>
							</div>
							<div class="span12" style='margin-left: 0px;'>
								<div class="input-prepend">
									<span class="add-on">图片上传</span> <input type="file"
										class='imgfile' name="files" id="" value="图片上传" />
								</div>
							</div>
						</div>
						<div class="span6" id="photo">
							<font color="red">你添加了的图片：</font> <br>
							<c:forEach items="${imgs }" var="img">
								<img src="<%=basePath %>${img}" width="100" height="80">
							</c:forEach>
						</div>
					</div>
			<input name="goodsId" value="${goodsinfo.goodsinfo.goodsId }" type="hidden">
            <input name="shopgoodsId" value="${goodsinfo.shopgoodsId }" type="hidden">
			<input type="submit" value="提交" id="" class="btn btn-info"
				style="width: 80px; margin-left: 520px;" />

		</form>
        </div>
     </div>

	</div>
<script type="text/javascript">
$(function(){
	var data = ${json};
	var map = ${propertymap};
	//alert(map);
	for(var o in data.goodsinfo){  
        //alert(o);  
       // alert(data.goodsinfo[o]);  
        var id = "#" + o;
        $(id).val(data.goodsinfo[o]);
        //alert("text:"+data[o].name+" value:"+data[o].age );  
      };
	for(var o in map){ 
		
		var id = "#" + o;
		
        $(id).val(map[o]);
        //alert(id + "," + map[o]);
      };
	
});
</script>
<script src="<%=basePath%>media/js/goods.js" type="text/javascript"></script>
</body>
</html>