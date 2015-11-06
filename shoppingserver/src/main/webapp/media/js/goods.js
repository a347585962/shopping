jQuery(function(){
	//alert("123");
	
	var base_url = $("#url_base").val();
	 $("#btn_add1").click(function(){  
		 var div = document.getElementById("imgdiv");
         var img = document.createElement("input");
         img.name='files';
         img.type='file';
         img.className = 'imgfile';
         div.appendChild(img);
        
     }); 
	 $("#import").click(function(){
		 $('#importModal').modal(); 
	 });
	function getOneClassInfo(id, secondId) {
        
		var rID = "#" + id + "";
		var secondID = "#" + secondId + "";
		if ($(rID).val() != 0) {
			provinceId = $(rID).val();
			// alert(uri);
			var uri = base_url + "/goodsmanager/" + secondId;
			//alert(uri);
			//不能要dataType=json，不然解析不出来。。。。
			$.ajax({
				type : "POST",
				url : uri,
				data : 'id=' + provinceId,
				timeout : 15 * 1000,
				success : function(data) {

					var member = eval("(" + data + ")"); //正确写法
					var second = "<option value='0'>---学校---</option>";
					for ( var i = 0; i < member.length; i++) {
						var test = "<option value='" + member[i].schoolId + "'>"
								+ member[i].schoolName + "</option>";
						second += test;
					}
					$(secondID).html(second);
				},
				error : function(result) {
					alert("ASd");
				}
			});
		}
	}
	function getTwoClassInfo(id, secondId) {
		var rID = "#" + id + "";
		var secondID = "#" + secondId + "";
		if ($(rID).val() != 0) {
			provinceId = $(rID).val();
			var uri = base_url + "/goodsmanager/" + secondId;
			//不能要dataType=json，不然解析不出来。。。。
			$.ajax({
				type : "POST",
				url : uri,
				data : 'id=' + provinceId,
				timeout : 15 * 1000,
				success : function(data) {
					var member = eval("(" + data + ")"); //正确写法
					var second = "<option value='0'>---二级分类---</option>";
					for ( var i = 0; i < member.length; i++) {
						var test = "<option value='" + member[i].level2Id + "'>"
								+ member[i].level2Name + "</option>";
						second += test;
					}
					$(secondID).html(second);
				},
				error : function(result) {
					alert("ASd");
				}
			});
		}
	}
	function getThreeInfo(id, secondId) {
		var rID = "#" + id + "";
		var secondID = "#" + secondId + "";
		if ($(rID).val() != 0) {
			provinceId = $(rID).val();
			var uri = base_url + "/goodsmanager/" + secondId;
			//不能要dataType=json，不然解析不出来。。。。
			$.ajax({
				type : "POST",
				url : uri,
				data : 'id=' + provinceId,
				timeout : 15 * 1000,
				success : function(data) {
					var member = eval("(" + data + ")"); //正确写法
					var second = "<option value='0'>---三级分类---</option>";
					for ( var i = 0; i < member.length; i++) {
						var test = "<option value='" + member[i].level3Id + "'>"
								+ member[i].level3Name + "</option>";
						second += test;
					}
					$(secondID).html(second);
				},
				error : function(result) {
					alert("ASd");
				}
			});
		}
	}
	//getOneClassInfo("traderProvince", "traderSchool");
	
	  $("#levelone").change(function(){
		  getTwoClassInfo("levelone", "leveltwo");
	   });
	  $("#leveltwo").change(function(){
		  getThreeInfo("leveltwo", "levelthree");
	   });
	  $("#levelthree").change(function(){
		  /*var levelone = $("#levelone").val();
		  var leveltwo = $("#leveltwo").val();
		  var levelthree =  $("#levelthree").val();
		  $("#goodsoneclass").val(levelone);
		  $("#goodstwoclass").val(leveltwo);
		  $("#goodsthreeclass").val(levelthree);
		  alert( $("#goodsoneclass").val() + "," +
		  $("#goodstwoclass").val() + "," + 
		  $("#goodsthreeclass").val());*/
	   });
});
$(document).ready(function() { 
	$("#importgoodsform").validate({
		//  debug:true,
		rules: {
			excelfile: {
				required:true
			}
		},
		messages: {
			excelfile: {
				required:'请选择需要批量导入的文件'
			}
		},
		errorPlacement: function(error, element) {                             //错误信息位置设置方法  
			 error.appendTo( element.parent().parent() );                            //这里的element是录入数据的对象  
		 },
		 errorElement:"span",
		 errorClass:"invalid"
		
	});
	$("#updategoodsform").validate({
		//  debug:true,
		rules: {
			goodsName: {
				required:true
			},
			goodsType:  {
				required:true
				
			} , goodsUntis:  {
				required:true
				
			} , productAddress:  {
				required:true
			} , goodsPriceIn:  {
				required:true , 
				number:true
			} , goodsPrice1: {
				required:true,
				number:true
			} , goodsPrice2: {
				required:true,
				number:true
			}, goodsPrice3: {
				required:true,
				number:true
			}
			, goodsPrice4: {
				required:true,
				number:true
			},
			goodsClass1:  {
				required:true,
				min:1
			}, goodsClass2:  {
				required:true,
				min:1
			} , goodsClass3:  {
				required:true,
				min:1
			}, goodsStock: {
				required:true,
				number:true
			}, barCode:{
				required: true	
			} 
		},
		messages: {
			goodsName: {
				required:'请填写商品名称'
			},
			goodsType:{
				required:'请填写商品型号'
			},goodsUntis:  {
				required:'请填写商品单位'
			},productAddress:  {
				required:'请填写商品出产地址'
			},goodsPriceIn:  {
				required:'请填写商品进价',
				number:"请填写正确的价格，数值"
			},goodsPrice1:  {
				required:'请填写商品零售价',
				number:"请填写正确的价格，数值"
			}
			,goodsPrice2:  {
				required:'请填写商品会员价',
				number:"请填写正确的价格，数值"
			}
			,goodsPrice3:  {
				required:'请填写商品批发价',
				number:"请填写正确的价格，数值"
			}
			,goodsPrice4:  {
				required:'请填写商品促销价',
				number:"请填写正确的价格，数值"
			},
			goodsClass1: {
				required:'请选择一级分类',
				min:'请选择一级分类'
			} , goodsStock: {
				required:"请填写商品库存",
				number:"库存为数字整型"
			} ,
			goodsClass2:{
				required:'请选择二级分类',
				min:'请选择二级分类'
			} , barCode:{
				required: "请填写条形码"	
			} , goodsClass3:{
				required:'请选择三级分类',
				min:'请选择三级分类'
			}
		},
		errorPlacement: function(error, element) {                             //错误信息位置设置方法  
			 error.appendTo( element.parent().parent() );                            //这里的element是录入数据的对象  
		 },
		 errorElement:"span",
		 errorClass:"invalid"
		
	});
	$("#addgoodsform").validate({
		//  debug:true,
		rules: {
			goodsName: {
				required:true
			},
			goodsType:  {
				required:true
				
			} , goodsUntis:  {
				required:true
				
			} , productAddress:  {
				required:true
			} , goodsPriceIn:  {
				required:true , 
				number:true
			} , goodsPrice1: {
				required:true,
				number:true
			} , goodsPrice2: {
				required:true,
				number:true
			}, goodsPrice3: {
				required:true,
				number:true
			}
			, goodsPrice4: {
				required:true,
				number:true
			},
			goodsClass1:  {
				required:true,
				min:1
			}, goodsClass2:  {
				required:true,
				min:1
			}, goodsStock: {
				required:true,
				number:true
			}, goodsClass3:  {
				required:true,
				min:1
			}, barCode:{
				required: true	
			},
			files: {
				required: true	
			}
		},
		messages: {
			goodsName: {
				required:'请填写商品名称'
			},
			goodsType:{
				required:'请填写商品型号'
			},goodsUntis:  {
				required:'请填写商品单位'
			},productAddress:  {
				required:'请填写商品出产地址'
			},goodsPriceIn:  {
				required:'请填写商品进价',
				number:"请填写正确的价格，数值"
			},goodsPrice1:  {
				required:'请填写商品零售价',
				number:"请填写正确的价格，数值"
			} , goodsStock: {
				required:"请填写商品库存",
				number:"库存为数字整型"
			}
			,goodsPrice2:  {
				required:'请填写商品会员价',
				number:"请填写正确的价格，数值"
			}
			,goodsPrice3:  {
				required:'请填写商品批发价',
				number:"请填写正确的价格，数值"
			}
			,goodsPrice4:  {
				required:'请填写商品促销价',
				number:"请填写正确的价格，数值"
			},
			goodsClass1: {
				required:'请选择一级分类',
				min:'请选择一级分类'
			},
			goodsClass2:{
				required:'请选择二级分类',
				min:'请选择二级分类'
			},goodsClass3:{
				required:'请选择三级分类',
				min:'请选择三级分类'
			} , barCode:{
				required: "请填写条形码"	
			} ,
			files: {
				required: "请选择商品照片"			
			}
		},
		errorPlacement: function(error, element) {                             //错误信息位置设置方法  
			 error.appendTo( element.parent().parent() );                            //这里的element是录入数据的对象  
		 },
		 errorElement:"span",
		 errorClass:"invalid"
		
	});
	
	$(".imgfile").change(function(evt){
        var files = evt.target.files; 
        readfile(files);
    });
    //设计一段比较流行的滑动样式  
    $('#drop_zone_home').hover(function() {  
        $(this).children('p').stop().animate({  
            top : '0px'  
        }, 200);  
    }, function() {  
        $(this).children('p').stop().animate({  
            top : '-44px'  
        }, 200);  
    });  

    //要想实现拖拽，首页需要阻止浏览器默认行为，一个四个事件。  
    $(document).on({  
        dragleave : function(e) { //拖离  
            e.preventDefault();  
            $('.dashboard_target_box').removeClass('over');  
        },  
        drop : function(e) { //拖后放  
            e.preventDefault();  
        },  
        dragenter : function(e) { //拖进  
            e.preventDefault();  
            $('.dashboard_target_box').addClass('over');  
        },  
        dragover : function(e) { //拖来拖去  
            e.preventDefault();  
            $('.dashboard_target_box').addClass('over');  
        }  
    });        
    //================上传的实现  
    /*var box = document.getElementById('target_box'); //获得到框体  
    box.addEventListener("drop", function(e) {  
        e.preventDefault(); //取消默认浏览器拖拽效果  
        
        var fileList = e.dataTransfer.files; //获取文件对象  
        //fileList.length 用来获取文件的长度（其实是获得文件数量）  
        //检测是否是拖拽文件到页面的操作    
        if (fileList.length == 0) {  
            $('.dashboard_target_box').removeClass('over');  
            return;  
        }  
        //检测文件是不是图片  
        if (fileList[0].type.indexOf('image') === -1) {  
            $('.dashboard_target_box').removeClass('over');  
            return;  
        }  
        readfile(fileList);
        //var img = window.webkitURL.createObjectURL(fileList[0]);  
        //拖拉图片到浏览器，可以实现预览功能  
        xhr = new XMLHttpRequest();  
        xhr.open("post", "/TradeBook/view/TraderBook_ControlBook/upload",
					true);
			xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

			var fd = new FormData();
			fd.append('files', fileList[0]);

			xhr.send(fd);
		}, false);*/
    function readfile(fileList)
    {
    	for (var i = 0, f; f = fileList[i]; i++) {
    		
	           if (!f.type.match('image.*')) {
	             continue;
	           }       	          
	           var reader = new FileReader();
	           reader.onload = (function(theFile) {
	             return function(e) {                                
		       //       $("#photo").attr("src",e.target.result);
		              var div = document.getElementById("photo");
		              var img = document.createElement("img");
		              img.src=e.target.result;
		              img.width =100;
		              img.height=80;
		              img.style.margin = "4px 4px 4px 0";
		              div.appendChild(img);
	             };
	           })(f);
	           reader.readAsDataURL(f);
	         }
    };
    
   
    
    
	});
jQuery(function(){
	  var levelone = $("#goodsoneclass").val();
	  var leveltwo = $("#goodstwoclass").val();
	  var levelthree =  $("#goodsthreeclass").val();
	  var status = $("#goodsstatus").val();
	  var activitytype = $("#activity_type").val();
	  $("#activityId").val(activitytype);
	  $("#goodsstatusselect").val(status);
	  $("#levelone").val(levelone);
	  $("#leveltwo").val(leveltwo);
	  $("#levelthree").val(levelthree);
	  var base_url = $("#url_base").val();
	  $(".del").each(function(){
	      	 $(this).click(function(){
	      		// alert(basePath + "------");
	      		 var backurl = $(this).attr("backurl");
	      		 var uri = $(this).attr("url");
	      		var msg = "确认删除？删除之后前台不可见！\n\n 请确认";
				if (confirm(msg) == true) {
					$.ajax({   
	      				  type: "get",  
	      				  url: uri,  
	      				  async:false,
	      				  data:"{}",
	      				  dataType : "jsonp",
	      				  jsonp: "callbackparam",//服务端用于接收callback调用的function名的参数
	      				 
	      				  jsonpCallback:"success_jsonpCallback",//callback的function名称
	      				  timeout: 15*1000,
	      				  success: function(data){ 
	      					  //alert(data.toSource())
	      					  if(data.success)
	      						
	      					  {  
	      						  alert("恭喜您删除成功，您可以到前台进行查看。");
	      						  location.href=backurl;
	      					  }else{
	      						  
	      					  }
	      				  },
	      				  error:function(result){
	      		              	alert("出现异常！请稍后再试！");
	      		              }
	      			  });
				};
	      		 
	      	 });
	      });
		$(".up").each(function(){
	      	 $(this).click(function(){
	      		// alert(basePath + "------");
	      		 var backurl = $(this).attr("backurl");
	      		 var uri = $(this).attr("url");
	      		// alert(uri);
	      		
	      		var msg = "确认上架商品？上架之后前台可见！\n\n 请确认";
				if (confirm(msg) == true) {
					$.ajax({   
	    				  type: "post",  
	    				  url: uri,  
	    				  async:false,
	    				  data:"{}",
	    				  dataType : "jsonp",
	    				  jsonp: "callbackparam",//服务端用于接收callback调用的function名的参数
	    				 
	    				  jsonpCallback:"success_jsonpCallback",//callback的function名称
	    				  timeout: 15*1000,
	    				  success: function(data) { 
	    					  if(data.success)
	    						
	    					  {  
	    						  alert("恭喜您，商品成功上架，您可以到前台进行查看。");
	    						  location.href=backurl;
	    					  }else{
	    						  
	    					  }
	    				  },
	    				  error:function(result){
	    		              	alert("出现异常！请稍后再试！");
	    		          }
	    			  });
				};
	      			 
	      	 });
	   });
		$(".down").each(function(){
		   	 $(this).click(function(){
		   		// alert(basePath + "------");
		   		 var backurl = $(this).attr("backurl");
		   		 var uri = $(this).attr("url");
		   		
		   			var msg = "确认下架商品？下架之后前台不可见！\n\n 请确认";
					if (confirm(msg) == true) {
						$.ajax({   
			   				  type: "get",  
			   				  url: uri,  
			   				  async:false,
			   				  data:"{}",
			   				  dataType : "jsonp",
			   				  jsonp: "callbackparam",//服务端用于接收callback调用的function名的参数
			   				  jsonpCallback:"success_jsonpCallback",//callback的function名称
			   				  timeout: 15*1000,
			   				  success: function(data){ 
			   					  //alert(data.toSource())
			   					  if(data.success)
			   					  {  
			   						  alert("恭喜您下架成功，您可以到前台进行查看。");
			   						  location.href=backurl;
			   					  }else{
			   						  
			   					  }
			   				  },
			   				  error:function(result){
			   		              	alert("出现异常！请稍后再试！");
			   		              }
			   			  });
					}
		   			 
		   			 
		   	 });
		 });
});