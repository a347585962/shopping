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

					<tr align="center" bgcolor="#FFFFEC">
						<td style='width: 10%;' class='content_td1'>日志编号:</td>
						<td class="content_td1 ">
							<div class='newsTitle1'>
								<a title='${loginfo.logId}'
									> <span>${loginfo.logId}</span>
								</a>
							</div>
						</td>
					</tr>
					<tr>
						<td style='width: 10%;' class='content_td2'>日志操作者:</td>
						<td class="content_td2 "><a
							> <span>
									<c:if test="${not empty loginfo.admininfo }">
									   ${loginfo.admininfo.userName }
									</c:if> <c:if test="${not empty loginfo.userinfo }">
									   ${loginfo.userinfo.userPhone }
									</c:if>
							</span></a></td>
					</tr>
					<tr>
						<td style='width: 10%;' class='content_td2'>日志类型:</td>
						<td class="content_td2 "><span> ${loginfo.operaterType
								} </span></td>
					</tr>
					<tr>
						<td style='width: 10%;' class='content_td2'>ip地址:</td>

						<td class="content_td2 ">
						<span> 
						<c:if test="${fn:contains(fn:trim(loginfo.operaterIp), '0:0:0:0:0:0:0:1')}">
														127.0.0.1
						</c:if> 
						<c:if test="${!fn:contains(fn:trim(loginfo.operaterIp), '0:0:0:0:0:0:0:1')}">
														${loginfo.operaterIp }
													
						</c:if>
						</span></td>
					</tr>
					<tr>
						<td style='width: 10%;' class='content_td2'>日志内容:</td>
						<td class="content_td2 "><div class=''
								title='${loginfo.operateValue}'>${loginfo.operateValue}</div></td>
					</tr>
					<tr>
						<td style='width: 10%;' class='content_td2'>日志时间:</td>
						<td class="content_td2 "><span><fmt:formatDate
									value="${loginfo.logTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span></td>
					</tr>
					<!-- <td style='width: 10%;' class='content_td5'>操作</td> -->

				</table>
				
		</div>
	  
	</div>
</div>

</body>
</html>