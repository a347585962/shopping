<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.property {
  margin-bottom:10px;
}
  .property a {
  width: 80%;
  height: 35px;
  line-height: 35px;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
  color: rgba(0, 0, 0, 0.6);
  display: block;
  text-align: center;
  float: left;
  margin: 1%;
  border: 1px solid rgba(181, 181, 181, 0.6);
}
.tip{
   text-align: center;
   border:1px dotted #990000;
   background-color: #ddd;
   padding:10px;
   margin-bottom:10px;
}
.property-title {
margin-left:0px;
padding:10px;
background: #ddd;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
</head>
<body>

	<div class="body" style="margin: 15px;">
		<span style="font-size:20px;color:#414451;">商品管理-属性设置</span>
    </div>
    <div class='tip'>
       <p><span>温馨提示：亲爱的<span class="text-success">${admin.userName }</span>，您好</span></p>
       <p class='text-warning'><span>点击属性，您将执行删除商品该属性操作，请慎重！</span></p>
       <p class="text-info"><span>点击"+"，您将执行添加商品属性操作哦！</span></p>
    </div>
    
    
	<div class='span12 property-title' >
       <span>已有的商品属性，点击<span class='text-warning'>删除</span></span>
    </div>
    <div>
	<c:forEach begin="1" end="${fn:length(properties)}" step="6"
		varStatus="status">
		<div class="row-fluid">
			<c:forEach items="${properties }" var="property"
				begin="${(status.count-1)*6 }" end="${(status.count)*6-1 }"
				varStatus="status1">
				
				<c:if test="${(status.count-1)*6 + status1.count == fn:length(properties) }">
				   <div class='span2 property '>
                   <a href="#" 
                   class='pro' url='<%=basePath %>property/delete/${property.propertyId }'
                   backurl="<%=basePath %>property/show"
                   res="1" title="${property.propertyShowname }">
                     ${property.propertyShowname }
                   </a>
                 </div>
                 <c:if test="${fn:length(properties) % 6 != 0}">
                 <div class='span2 property'>
                   <a href="#"  id='addpropertymodel'
                   res="1"  title="+">
                     +
                   </a>
                 </div>
                 </c:if>
                 <c:if test="${fn:length(properties) % 6 == 0}">
                 <div class='span2 property' style='margin-left:0px;'>
                   <a href="#"  id='addpropertymodel'
                   res="1"  title="+">
                     +
                   </a>
                 </div>
                 </c:if>
				</c:if>
				<c:if test="${(status.count-1)*6 + status1.count != fn:length(properties) }">
                 <div class='span2 property'>
                   <a href="#"   class='pro' url='<%=basePath %>property/delete/${property.propertyId }'
                   backurl="<%=basePath %>property/show"
                   res="1" title="${property.propertyShowname }">
                     ${property.propertyShowname }
                   </a>
                 </div>
                 </c:if>
			</c:forEach>
			
		</div>
	</c:forEach>
	</div>
	<div class='span12 property-title' >
       <span>已删除的商品属性，点击<span class='text-info'>恢复</span></span>
    </div>
    <div>
	<c:forEach begin="1" end="${fn:length(nonactiveproperties)}" step="6"
		varStatus="status">
		<div class="row-fluid">
			<c:forEach items="${nonactiveproperties }" var="property"
				begin="${(status.count-1)*6 }" end="${(status.count)*6-1 }"
				varStatus="status1">
                 <div class='span2 property'>
                   <a href="#"   class='activepro' url='<%=basePath %>property/active/${property.propertyId }'
                   backurl="<%=basePath %>property/show"
                   res="1" title="${property.propertyShowname }">
                     ${property.propertyShowname }
                   </a>
                 </div>
			</c:forEach>
		</div>
	</c:forEach>
	</div>
	<!-- Modal -->
	<div id="addPropertyModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">添加商品属性</h3>
		</div>
		<div class="modal-body">
			<form id='addPropertyForm' class="form-horizontal" 
			action="<%=basePath %>property/add" 
			 method="post">
			   <div class="control-group">
					<label class="control-label" for="shopId">商家名称</label>
					<div class="controls">
						<input type="text" id="shopId" name='shopId' disabled="true" value=${shop.shopName }>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="propertyName">商品属性</label>
					<div class="controls">
						<input type="text" id="propertyName" name="propertyName"
							placeholder="商品属性名称" >
					</div>
				</div>
				
				
				
				<div class="control-group">
					<div class="controls">

						<button type="submit" id="addclass" class="btn btn-info" style='margin-left:50%;'>提交</button>
					</div>
				</div>
				<input type="hidden" id="updateidstr" name='ordid'>
			</form>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath %>media/js/property.js"></script>
</body>
</html>