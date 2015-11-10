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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
   .head{
      margin-top:10px;
   }
</style>
<title>商品信息管理</title>

</head>
<body>
<div class="body" style="margin:15px;">
	<span style="font-size:20px;color:#414451;">商品管理-商品信息管理</span>
	<div class="">
		<div class="head">
				
				<form action="<%=basePath%>goodsmanager/search/1" method="post">
					<div class="row-fluid">
						<div class="span4">
							<div class="input-prepend">
								<span class="add-on">商品编码</span> <input type="text"
									name='goodsid' />
							</div>
						</div>
						<div class="span4">
							<div class="input-prepend">
								<span class="add-on">商品名称</span> <input type="text"
									name='goodsname' />
							</div>
						</div>
						<!-- <div class="span4">
							<div class="input-prepend">
								<span class="add-on">活动状态</span> 
								<span style='margin:20%;'><input type="radio" name="activity" id="activityon" value="已参加活动" checked><font color=''>已参加活动</font></span>
								<span style='margin-left:20%;'><input type="radio" name="activity" id="activityoff" value="未参加活动" >未参加活动</span>
							</div>
						</div>
						 -->
					</div>
					<div class='row-fluid'>
						<div class="span4">
							<div class="input-prepend">
								<span class="add-on">商品条码</span> <input type="text"
									name='barcode' />
							</div>
						</div>
						<div class="span4">
							<div class="input-prepend">

								<span class="add-on">上线状态</span> <select name='isup'><option
										value="1">上架</option>
									<option value="0">下架</option></select>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span4">
							<div class="input-prepend">
								<span class="add-on">一级分类</span> <select name="levelone"
									id='levelone'>
									<option value="0">---请选择---</option>
									<c:forEach items="${level1s }" var="levelone">
										<option value="${levelone.level1Id }">${levelone.level1Name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="span4">
							<div class="input-prepend">
								<span class="add-on">二级分类</span> <select name="leveltwo"
									id='leveltwo'><option value="0">---请选择---</option></select>
							</div>
						</div>
						<div class="span4">
							<div class="input-prepend">
								<span class="add-on">三级分类</span> <select name="levelthree"
									id='levelthree'><option value="0">---请选择---</option></select> <span
									style="color: red; padding: 4px;"><font size="3px;">*</font></span>
							</div>
							<button type="submit" class='btn btn-info'
								style="width: 100px; margin-left:;">查询</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 
		<c:if test="${not empty success}">
		  <div class="success-hint">
						<p align="left" style="margin-left: 40px;">温馨提示：</p>
						<p align="center">
							尊敬的 &nbsp;&nbsp;<strong style='color: #990000;'>${admin.userName
								}</strong>&nbsp;&nbsp;用户
						</p>
						<p align="center">${success }</p> 
						
					</div> 
		</c:if>   -->
		<div class="table" style="border:2px solid #82aec0;height:100%;">
			<table style="width:100%;" class="table table-hover article-table">
					<c:choose>
						<c:when test="${empty goodsinfos }">
							<tr>
								<td colspan="3" style="color: red" align="center">暂时没有商品信息</td>
							</tr>
						</c:when>
						<c:when test="${not empty goodsinfos}">
							<tr align="center" bgcolor="#FFFFEC">
								<td style='width: 10%;' class='content_td1'>商品编号</td>
								<td style='width: 10%;' class='content_td2'>商品名称</td>
								<td style='width: 10%;' class='content_td2'>商品进价</td>
								<!-- <td style='width: 10%;' class='content_td2'>一级分类</td>
								<td style='width: 10%;' class='content_td2'>二级分类</td> -->
								<td style='width: 10%;' class='content_td2'>三级分类</td>
								<td style='width: 10%;' class='content_td2'>商品规格</td>
								<td style='width: 10%;' class='content_td2'>商品单位</td>
								<td style='width: 10%;' class='content_td2'>上架时间</td>
								<td style='width: 30%;' class='content_td5'>操作</td>
							</tr>
							<c:forEach items="${goodsinfos }" var="goodsinfo" varStatus="status">
								<tr class='discuss'>
									<td class="content_td1 ">
										<div class='newsTitle1'>
											<a title='${goodsinfo.shopgoodsId}' href="<%=basePath%>goodsmanager/updateview/${goodsinfo.shopgoodsId}"> <span>${goodsinfo.shopgoodsId}</span>
											</a>
										</div>
									</td>
									<td class="content_td2 "><a href="<%=basePath%>goodsmanager/updateview/${goodsinfo.shopgoodsId}"><span>${goodsinfo.goodsinfo.goodsName}</span></a>
									</td>
									<td class="content_td2 "><span>${goodsinfo.goodsinfo.goodsPriceIn}</span></td>
									
									<td class="content_td2 "><span>${goodsinfo.goodsinfo.goodsClass3}</span></td>
									<td class="content_td2 "><span>${goodsinfo.goodsinfo.goodsType}</span></td>
									<td class="content_td2 "><span>${goodsinfo.goodsinfo.goodsUntis}</span>
									</td>
									<td class="content_td2 "><span><fmt:formatDate value="${goodsinfo.date}" pattern="yyyy-MM-dd" /></span></td>
									<td class="content_td5">
										 
								<button  url="<%=basePath %>goodsmanager/delete/${goodsinfo.shopgoodsId }"  style='width:60px;'
								backurl="<%=basePath %>goodsmanager/goodsinfoview/1" class='del btn btn-danger'>删除</button>|
								  <c:if test="${goodsinfo.shopgoodsStatus == 1}">
								 <button  url="<%=basePath %>goodsmanager/down/${goodsinfo.shopgoodsId }" 
								 backurl="<%=basePath %>goodsmanager/goodsinfoview/1" class='down btn btn-danger'>下架</button>
								 
								 </c:if>
								 <c:if test="${goodsinfo.shopgoodsStatus == 0}">
								 <a  url="<%=basePath %>goodsmanager/up/${goodsinfo.shopgoodsId}" 
								 backurl="<%=basePath %>goodsmanager/goodsinfoview/1" class='up btn btn-danger'>上架</a>
								 
								 </c:if>
								  |	  <a href='<%=basePath%>goodsmanager/updateview/${goodsinfo.shopgoodsId}'
										style='width: 40px;' class="update btn btn-warning"> 修改 </a> <!-- Modal -->

									</td>
							</c:forEach>

						</c:when>
					</c:choose>
				</table>
				<div id="page" class='container'></div>
				<input type="hidden" id="pagecount" value="${pagecount }"> <input
				type="hidden" id="pagenow" value="${pagenow }">
		</div>
	<script src="<%=basePath%>media/js/goods.js" type="text/javascript"></script>
	<script type="text/javascript">
	jQuery(function(){
		 var pagecount = $("#pagecount").val();
		   var pagenow = $("#pagenow").val();
		   var basePath = $("#url_base").val();
		   var burl = basePath + "goodsmanager/goodsinfoview/";
		   //alert(pagenow + "," + pagecount);
		   getPage(pagecount, pagenow, 10, burl);
	});
	</script>
	</div>
</div>
</body>
</html>