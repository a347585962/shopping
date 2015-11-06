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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
</head>
<body>

	<div class="body" style="margin: 15px;">
		<span style="font-size:20px;color:#414451;">订单管理-订单管理</span>
		<div class="">
			<div class="head ">
						<form class="form-search" action="<%=basePath%>order/search/1" method="post">
							<div class="row-fluid">
								<div class="span4">
									<div class="input-prepend">
										<span class="add-on">订单编号</span> <input type="text"
											name='orderid' />
									</div>
								</div>
								<div class="span4">
									<div class="input-prepend">
										<span class="add-on">用户名</span> <input type="text"
											name='username' />
									</div>
								</div>
							</div>
							<div class="row-fluid">
								<div class="span4">
									<div class="input-prepend">
										<span class="add-on">送货状态</span> 
										<select name='ordersendstatus' >
										    <option value="">--请选择--</option>
											<option value="1">已送-已收</option>
											<option value="2">未送</option>
											<option value="3">已送-未收</option>
										</select>
									</div>
								</div>
								<div class="span4">
									<div class="input-prepend">
										<span class="add-on">支付状态</span> 
										<select name='orderpaystatus'>
											<option value="">--请选择--</option>
											<option value="1">已付</option>
											<option value="2">未付</option>
										</select>
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-info">查&nbsp;&nbsp;&nbsp;找</button>
						</form>
			</div>
			
			<div class="table"
				style="border: 1px solid; height: 800px; margin-top: 15px;">
				<table class="td-void order-tb">
					<c:forEach items="${orders }" var="order" varStatus="status">
						<tbody id="tb-9331544789">
							<tr class="sep-row">
								<td colspan="5"></td>
							</tr>

							<tr class="tr-th">
								<td colspan="5"><span class="gap"></span> <span
									class="dealtime" title="<fmt:formatDate value="${order.orderTime }" pattern="yyyy/MM/dd  HH:mm:ss" />">
									 <fmt:formatDate value="${order.orderTime }" pattern="yyyy/MM/dd  HH:mm:ss" />
									</span> <input type="hidden" id="datasubmit-9331544789"
									value="2015-05-11 00:19:38"> <span class="number">订单号：<a
										name="orderIdLinks" id="idUrl9331544789" target="_blank"
										href="//order.jd.com/normal/item.action?orderid=9331544789&amp;PassKey=2284AF3EB0CD62C15424267E6DA497F0"
										clstag="click|keycount|orderinfo|order_num">${order.orderId }</a>

								</span>

									<div class="tr-operate">
										<span class="order-shop"> <a
											href="#" >群祥</a> 
										</span> <span class="tel"> <i class="tel-icon venderTel87333"
											style="display: none;"></i>
										</span> <a href="#none"
											clstag="click|keycount|orderlist|dingdanshanchu"
											class="order-del" _orderid="9331544789"
											_passkey="6F2182BA18B70DEBC96B212BDE358AC0"></a>

									</div></td>
							</tr>



							<c:forEach items="${order.suborder }" var="suborder"
								varStatus="substatus">
								<c:if test="${substatus.count == 1 }">
									<tr class="tr-bd" id="track9331544789" oty="22,1,70">
										<td style='text-align: center;'>
											<div class="goods-item">
												<div class="p-img" data-lazy-img-install="1">
													<a href="<%=basePath %>goodsmanager/view/${suborder.goodsinfo.goodsId}"
														clstag="click|keycount|orderinfo|order_product"
														target="_blank"> 
														<c:if test="${ not empty fn:split(suborder.goodsinfo.photoUrl, ',')[0]}">
														<img class="err-product"
														src="<%=basePath %>${fn:split(suborder.goodsinfo.photoUrl, ',')[0] }"
														title="${suborder.goodsinfo.goodsName}"
														
														width="60" height="60">
														</c:if>
														<c:if test="${  empty fn:split(suborder.goodsinfo.photoUrl, ',')[0]}">
														<img class="err-product"
														src="<%=basePath %>media/image/avatar.png"
														title="${suborder.goodsinfo.goodsName}"
														
														width="60" height="60">
														</c:if>
													</a>
												</div>
												<div class="p-msg">
													<div class="p-name">
														<a href="<%=basePath %>goodsmanager/view/${suborder.goodsinfo.goodsId}"
															class="a-link"
															clstag="click|keycount|orderinfo|order_product"
															target="_blank" title="${suborder.goodsinfo.goodsName}">${suborder.goodsinfo.goodsName}
														</a>
													</div>
												</div>
											</div>
											<div class="goods-number">x${suborder.goodsNum}</div>

											<div class="goods-repair">
												￥${suborder.goodsPrice}
											</div>
											<div class="clr"></div>
										</td>

										<td rowspan="3" style='text-align: center;'>
											<div class="">
												<span class="txt">${order.userinfo.userPhone }</span><b></b>
												<div class="prompt-01 prompt-02">
													<div class="pc">
														<strong>${order.userinfo.userNickName }</strong>
														<p>${order.orderAddress }</p>
														<p>${order.userinfo.userPhone }</p>
													</div>
													<div class="p-arrow p-arrow-left"></div>
												</div>
											</div>
										</td>
										<td rowspan="3" style='text-align: center;'>
											<div class="amount">
												<strong>¥${order.totalPrice }</strong> <br> <span class="ftx-13">
												
													
												 <c:if
														test="${fn:contains(fn:trim(order.payType), '1')}">
														  货到付款       
													</c:if>
													<c:if
														test="${fn:contains(fn:trim(order.payType), '2')}">
														 上门自提
													</c:if>
												</span><br>
												<a class="cellphone-icon" href="http://app.jd.com/"
													target="_blank"></a>
											</div>
										</td>
										<td rowspan="3" style='text-align: center;'>
											<div class="status">
											<span class="order-status ftx-03"> 
												<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.paystatus), '1')}">
														  已付
													</c:if>
													<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.paystatus), '2')}">
														  未付
													</c:if>
												 </span>
												 <br>
												<span class="order-status ftx-03"> 
												    <c:if
														test="${fn:contains(fn:trim(order.orderstatuses.sendstatus), '1')}">
														 已送-已收
													</c:if>
													<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.sendstatus), '2')}">
														  未送
													</c:if>
													<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.sendstatus), '3')}">
														  已送-未收
													</c:if>
												 </span> 
											</div>
										</td>
										<td rowspan="3" id="operate9331544789" style='text-align: center;'>
											<div class="operate">
												<div id="pay-button-9331544789"></div>
												<button class='btn btn-warning updateorder' id=''
													class="btn-again" orderid='${order.orderId }' address='${order.orderAddress }' account='${order.totalPrice }'
													><b></b>订单修改</button><br><br><br>
													<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.sendstatus), '2')}">
														  <a class='btn btn-info orderconfirm' href="<%=basePath %>order/orderconfirm_${pagenow }/${order.orderId }" ><b>订单确认</b></a>
													</c:if>
													<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.sendstatus), '1')}">
														 
														  <button class='btn' disabled="disabled" id='' uri='' orderid='${order.orderId }'><b>订单完成</b></button>
													</c:if>
													<c:if
														test="${fn:contains(fn:trim(order.orderstatuses.sendstatus), '3')}">
														<a class='btn btn-info ' href="<%=basePath %>order/ordersuccess_${pagenow }/${order.orderId }" ><b>订单送达</b></a>
														 
													</c:if>
													
											</div>
										</td>
									</tr>
								</c:if>
								<c:if test="${substatus.count != 1 }">
									<tr class="tr-bd" id="track9331544789" oty="22,1,70">
										<td>
											<div class="goods-item">
												<div class="p-img" data-lazy-img-install="1">
													<a href="<%=basePath %>goodsmanager/view/${suborder.goodsinfo.goodsId}"
														clstag="click|keycount|orderinfo|order_product"
														target="_blank"> 
														<c:if test="${ not empty fn:split(suborder.goodsinfo.photoUrl, ',')[0]}">
														<img class="err-product"
														src="<%=basePath %>${fn:split(suborder.goodsinfo.photoUrl, ',')[0] }"
														title="${suborder.goodsinfo.goodsName}"
														
														width="60" height="60">
														</c:if>
														<c:if test="${  empty fn:split(suborder.goodsinfo.photoUrl, ',')[0]}">
														<img class="err-product"
														src="<%=basePath %>media/image/avatar.png"
														title="${suborder.goodsinfo.goodsName}"
														
														width="60" height="60">
														</c:if>
													</a>
												</div>
												<div class="p-msg">
													<div class="p-name">
														<a href="<%=basePath %>goodsmanager/view/${suborder.goodsinfo.goodsId}"
															class="a-link"
															clstag="click|keycount|orderinfo|order_product"
															target="_blank" title="${suborder.goodsinfo.goodsName}">${suborder.goodsinfo.goodsName}</a>
													</div>
												</div>
											</div>
											<div class="goods-number">x${suborder.goodsNum}</div>
											<div class="goods-repair">
												￥${suborder.goodsPrice}
											</div>
										</td>
									</tr>

								</c:if>

							</c:forEach>
						</tbody>
					</c:forEach>
				</table>

				<div id="page" class='container'></div>
			</div>
			<input type="hidden" id="pagecount" value="${pagecount }"> <input
				type="hidden" id="pagenow" value="${pagenow }">
		</div>
	</div>
	<!-- Modal -->
	<div id="updateModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">修改订单信息</h3>
		</div>
		<div class="modal-body">
			<form id='addclassform' class="form-horizontal" 
			action="<%=basePath %>order/update" 
			 method="post">
				<div class="control-group">
					<label class="control-label" for="inputEmail">订单id</label>
					<div class="controls">
						<input type="text" id="orderid" name="id"
							placeholder="父节点id" disabled="true">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="levelName">订单价格</label>
					<div class="controls">
						<input type="text" id="money" name='money'>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label" for="levelName">地址</label>
					<div class="controls">
						<input type="text" id="adress" name='adress'>
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
<script src="<%=basePath%>media/js/order.js" type="text/javascript"></script>
<script type="text/javascript">
jQuery(function(){
	 var pagecount = $("#pagecount").val();
	   var pagenow = $("#pagenow").val();
	   var basePath = $("#url_base").val();
	   var burl = basePath + "order/manager/";
	   //alert(pagenow + "," + pagecount);
	   getPage(pagecount, pagenow, 10, burl);
});
</script>
</body>
</html>