<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"  
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer>
	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="footer-inner">2015 &copy; 南瑞集团</div>
		<div class="footer-tools">
			<span class="go-top"> <i class="icon-angle-up"></i>
			</span>
		</div>
	</div>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->


	<!-- BEGIN CORE PLUGINS -->



	<script src="<%=basePath%>media/js/jquery.ztree.all-3.5.min.js"
		type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery.ztree.core-3.5.min.js"
		type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery.ztree.excheck-3.5.min.js"
		type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery.ztree.exhide-3.5.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="<%=basePath%>media/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>


	<script src="<%=basePath%>media/js/jquery.paginate.js"
		type="text/javascript"></script>
	<script src="<%=basePath%>media/js/common.js" type="text/javascript"></script>





	<!-- END CORE PLUGINS -->



	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="<%=basePath%>media/js/app.js" type="text/javascript"></script>



	<!-- END PAGE LEVEL SCRIPTS -->

	<script>
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
		});
	</script>

	<!-- END JAVASCRIPTS -->
</footer>
