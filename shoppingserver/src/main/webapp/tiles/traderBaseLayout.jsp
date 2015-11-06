<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div id="traderCenterBaseLayout">
 <div class="span3"  id="left">
  <tiles:insertAttribute name="left"/>
</div>
<div class="span9" id="right">
  <tiles:insertAttribute name="right" />
</div>
</div>