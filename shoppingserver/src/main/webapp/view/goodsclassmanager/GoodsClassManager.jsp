<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别管理</title>
<style type="text/css">
div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	text-align: left;
	padding: 2px;
}

div#rMenu ul li {
	margin: 1px 0;
	padding: 0 5px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #DFDFDF;
}
</style>
</head>
<body>
	<div class="body" style="margin: 15px;">
		<span style="font-size: 20px; color: #414451;">商品管理-商品类别管理</span>
		<div class="">
			<div class="head"></div>

			<div class="table"
				style="border: 2px solid #82aec0; height: 800px; margin-top: 15px;">

				<div class="content_wrap">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>

				</div>
				<div id="rMenu">
					<ul>
						<li id="m_add" onclick="addTreeNode();">增加节点</li>
						<li id="m_del" onclick="removeTreeNode();">删除节点</li>
						<li id="m_check" onclick="updateTreeNode();">更新节点</li>
						<li id="m_unCheck" onclick="checkTreeNode(false);">unCheck节点</li>
						<li id="m_reset" onclick="resetTree();">恢复zTree</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="right span8"
			style='background-color: #fff; margin-top: 20px; height: 600px;'>
			<table class="table table-hover" id='treeRight'>
				<thead>
					<tr>
						<td>文件名</td>
						<td>文件路径</td>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">模式对话框</h3>
		</div>
		<div class="modal-body">
			<form id='addclassform' class="form-horizontal"
				action="<%=basePath %>goodsclass/add" method="post"
				enctype="multipart/form-data">
				<div class="control-group">
					<label class="control-label" for="inputEmail">节点id</label>
					<div class="controls">
						<input type="text" id="parentId" name="id" placeholder="父节点id"
							disabled="true">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="levelName">节点名称</label>
					<div class="controls">
						<input type="text" id="levelName" name='levelName'>
					</div>
				</div>
				<div class="control-group" id='imgdiv'>
					<label class="control-label" for="levelName">商品分类图片</label>
					<div class="controls">
						<input type="file" class='imgfile' name="files" id="picture"
							value="图片上传" />
					</div>
				</div>
				<div class="control-group" id='imgdiv'>
					<font color="red">你添加了的图片：</font> <br>
					<div class="span6 controls" id="photo"></div>
				</div>
				<div class="control-group">
					<div class="controls">

						<button type="submit" id="addclass" class="btn">提交</button>
					</div>
				</div>
				<input type="hidden" id="idstr" name='parentid'>
			</form>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	</div>

	<!-- Modal -->
	<div id="updateModal" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">模式对话框</h3>
		</div>
		<div class="modal-body">
			<form id='addclassform' class="form-horizontal"
				action="<%=basePath %>goodsclass/update" method="post"
				enctype="multipart/form-data">
				<div class="control-group">
					<label class="control-label" for="inputEmail">节点id</label>
					<div class="controls">
						<input type="text" id="updateparentId" name="id"
							placeholder="父节点id" disabled="true">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="levelName">节点名称</label>
					<div class="controls">
						<input type="text" id="updatelevelName" name='levelName'>
					</div>
				</div>
				<div class="control-group" id='imgdiv'>
					<label class="control-label" for="levelName">商品分类图片</label>
					<div class="controls">
						<input type="file" class='imgfile' name="files" id="picture1"
							value="图片上传" />
					</div>
				</div>
				<div class="control-group" id='imgdiv'>
					<font color="red">你添加了的图片：</font> <br>
					<div class="span6 controls" id="photo1">
						<img alt="" src="" id='imgshow' width="100" height="80">
					</div>
				</div>


				<div class="control-group">
					<div class="controls">

						<button type="submit" id="addclass" class="btn">提交</button>
					</div>
				</div>
				<input type="hidden" id="updateidstr" name='parentid'>
			</form>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	</div>

	<SCRIPT type="text/javascript">
	<!--
		var setting = {
			view : {
				dblClickExpand : false
			},
			check : {
				enable : true
			},
			callback : {
				onRightClick : OnRightClick,
				onClick :click
			}
		};
	function click(event, treeId, treeNode)
	{
		var html = "<thead><tr><td>文件名</td><td>文件路径</td></tr></thead>";
		//alert(treeNode.children);
		if ("" == treeNode.children || "undefined" == typeof(treeNode.children))
		{
			//$(".right").hide(); 
			$("#treeRight").html(html);
			return;
		}
		for(var i=0;i<treeNode.children.length;i++) {
		    var childNode = treeNode.children[i];
		    //alert('childNode.name: '+childNode.name);
		    html += "<tr><td>" + childNode.name +"</td><td>" + childNode.id +"</td>" + "</tr>" 
		}
		
		$("#treeRight").html(html);
		//$(".right").show();
	}
		var zNodes = ${levelsJson};
		//var zNodes ;
		//alert(zNodes);
		function OnRightClick(event, treeId, treeNode) {
			if (!treeNode && event.target.tagName.toLowerCase() != "button"
					&& $(event.target).parents("a").length == 0) {
				zTree.cancelSelectedNode();
				showRMenu("root", event.clientX, event.clientY);
			} else if (treeNode && !treeNode.noR) {
				zTree.selectNode(treeNode);
				showRMenu("node", event.clientX, event.clientY);
			}
		}

		
		
		function showRMenu(type, x, y) {
			$("#rMenu ul").show();
			if (type == "root") {
				$("#m_del").hide();
				$("#m_check").hide();
				$("#m_unCheck").hide();
			} else {
				$("#m_del").show();
				$("#m_check").show();
				$("#m_unCheck").show();
			}
			rMenu.css({
				"top" : y + "px",
				"left" : x + "px",
				"visibility" : "visible"
			});

			$("body").bind("mousedown", onBodyMouseDown);
		}
		function hideRMenu() {
			if (rMenu)
				rMenu.css({
					"visibility" : "hidden"
				});
			$("body").unbind("mousedown", onBodyMouseDown);
		}
		function onBodyMouseDown(event) {
			if (!(event.target.id == "rMenu" || $(event.target).parents(
					"#rMenu").length > 0)) {
				rMenu.css({
					"visibility" : "hidden"
				});
			}
		}
		var addCount = 1;
		function addTreeNode() {
			//alert("add");
			hideRMenu();
			/*该节点有父节点*/
			if (zTree.getSelectedNodes()[0]) {
				//newNode.checked = zTree.getSelectedNodes()[0].checked;
				//zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
				var selectedNodes = zTree.getSelectedNodes()[0];
				$("#parentId").val(selectedNodes.id);
				$("#idstr").val(selectedNodes.id);
				$('#myModal').modal();
			}
			/*该节点没有父节点*/
			else {
				//zTree.addNodes(null, newNode);
				$('#myModal').modal();
			}
		}
		function removeTreeNode() {
			hideRMenu();
			var nodes = zTree.getSelectedNodes();
			var url_base = $("#url_base").val();
			//alert(url_base);
			var url = url_base + "goodsclass/remove";
			if (nodes && nodes.length > 0) {
				if (nodes[0].children && nodes[0].children.length > 0) {
					var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
					if (confirm(msg) == true) {
						dealwithNode(url, nodes[0].id, nodes);
					}
				} else {
					var msg = "要删除的节点。\n\n请确认！";
					if (confirm(msg) == true) {
						
						dealwithNode(url, nodes[0].id, nodes);
					}
					
					
				}
			}
		}
		function dealwithNode(url, id, nodes)
		{
			//alert(url + "," + id);
			$.ajax({   
				  type: "POST",  
				  url: url, 
				  data: 'parentId=' + id,  
				  timeout: 15*1000,
				  success: function(data){	
					  //alert(data);
					  if(data == "true")
					  {
						  //alert("truefalse");
						  zTree.removeNode(nodes[0]); 
					  } else{
					    
					  };
				  },
				  error:function(result){		           
					  alert("ajax删除出错");
		            }
			  });
		}
		function updateTreeNode()
		{
			//alert("update");
			hideRMenu();
			var url_base = $("#url_base").val();
			/*该节点有父节点*/
			if (zTree.getSelectedNodes()[0]) {
				//newNode.checked = zTree.getSelectedNodes()[0].checked;
				//zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
				var selectedNodes = zTree.getSelectedNodes()[0];
				$("#updateparentId").val(selectedNodes.id);
				$("#updateidstr").val(selectedNodes.id);
				$("#updatelevelName").val(selectedNodes.name);
				$("#imgshow").attr("src", url_base + selectedNodes.img);
				$('#updateModal').modal();
			}
			/*该节点没有父节点*/
			else {
				
			}
		}
		function checkTreeNode(checked) {
			var nodes = zTree.getSelectedNodes();
			if (nodes && nodes.length > 0) {
				zTree.checkNode(nodes[0], checked, true);
			}
			hideRMenu();
		}
		function resetTree() {
			hideRMenu();
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}

		var zTree, rMenu;
		jQuery(document).ready(function() {
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			zTree = $.fn.zTree.getZTreeObj("treeDemo");
			rMenu = $("#rMenu");
		});
		function toSubmit(){
			//alert("addclass");
			if ($("#levelName").val() == '' || $("#levelName").val() == null)
			{
				return false;
			}
			
			return true;
			
		};
	//-->
	</SCRIPT>
	<script src="<%=basePath%>media/js/goodsclass.js"
		type="text/javascript"></script>
</body>
</html>