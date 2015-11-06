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
<title>商品信息管理</title>
</head>
<body>
<div class="body" style="margin:15px;">
	<span>活动管理-活动信息管理</span>
	<div class="">
		<!--  -->
		<c:if test="${not empty success}">
		  <div class="success-hint">
						<p align="left" style="margin-left: 40px;">温馨提示：</p>
						<p align="center">
							尊敬的 &nbsp;&nbsp;<strong style='color: #990000;'>${admin.userName
								}</strong>&nbsp;&nbsp;用户
						</p>
						<p align="center">${success }</p> 
						
					</div> 
		</c:if>
		<div class="table" style="border:1px solid;height:800px;margin-top:15px;">
			<table style="width: 100%;" class="table table-hover article-table">
					<c:choose>
						<c:when test="${empty activities }">
							<tr>
								<td colspan="3" style="color: red" align="center">暂时没有活动信息</td>
							</tr>
						</c:when>
						<c:when test="${not empty activities}">
							<tr align="center" bgcolor="#FFFFEC">
								<td style='width: 10%;' class='content_td1'>活动编号</td>
								<td style='width: 10%;' class='content_td2'>活动名称</td>
								<td style='width: 10%;' class='content_td2'>活动类型</td>
								<td style='width: 10%;' class='content_td2'>开始时间</td>
								<td style='width: 10%;' class='content_td2'>结束时间</td>
								
								<td style='width: 10%;' class='content_td5'>操作</td>
							</tr>
							<c:forEach items="${activities }" var="activity" varStatus="status">
								<tr class='discuss'>
									<td class="content_td1 ">
										<div class='newsTitle1'>
											<a title='${activity.activityId}' href="<%=basePath%>activity/updateui/${activity.activityId}"> <span>${activity.activityId}</span>
											</a>
										</div>
									</td>
									<td class="content_td2 "><a href="<%=basePath%>activity/updateui/${activity.activityId}"><span>${activity.activityName}</span></a>
									</td>
									<td class="content_td2 "><span>${activity.activityTypeO.activitytypeName}</span></td>
									<td class="content_td2 "><span><fmt:formatDate value="${activity.activityStart}" pattern="yyyy-MM-dd" /></span></td>
									<td class="content_td2 "><span><fmt:formatDate value="${activity.activityEnd}" pattern="yyyy-MM-dd" /></span>
									</td>
									
									<td class="content_td5">
										<!-- <a href='#'>
								<button te='${news.yzId }' backurl='leadermag' style='width:80px;'
								 url='deleader' class='del btn btn-danger'>删除</button></a>
								  |	 --> <a href='<%=basePath%>activity/updateui/${activity.activityId}'
										style='width: 80px;' class="update btn btn-warning"> 修改 </a> <!-- Modal -->

									</td>
							</c:forEach>

						</c:when>
					</c:choose>
				</table>
				<div id="page" class='container'></div>
				<input type="hidden" id="pagecount" value="${pagecount }"> <input
				type="hidden" id="pagenow" value="${pagenow }">
		</div>
	<script src="<%=basePath%>media/js/activity.js" type="text/javascript"></script>
	</div>
</div>
</body>
</html>