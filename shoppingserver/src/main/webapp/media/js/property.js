
jQuery(function(){
	jQuery("#addpropertymodel").click(function(){
		//alert("add");
		jQuery("#addPropertyModal").modal();
	});
	$(document).ready(function() { 
		$("#addPropertyForm").validate({
			//  debug:true,
			rules: {
				propertyName: {
					required:true
				}
			},
			messages: {
				propertyName: {
					required:'请填写需要添加商品属性名称！'
				}
			},
			errorPlacement: function(error, element) {                             //错误信息位置设置方法  
				 error.appendTo( element.parent().parent() );                            //这里的element是录入数据的对象  
			 },
			 errorElement:"span",
			 errorClass:"invalid"
			
		});
	});
	jQuery(".pro").each(function(){
		jQuery(this).click(function(){
			var backurl = $(this).attr("backurl");
      		var uri = $(this).attr("url");
      		//alert(uri + "\n" + backurl);
      		var msg = "确认删除属性？删除之后添加商品将不可添加该属性值！\n\n 请确认";
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
	jQuery(".activepro").each(function(){
		jQuery(this).click(function(){
			var backurl = $(this).attr("backurl");
      		var uri = $(this).attr("url");
      		//alert(uri + "\n" + backurl);
      		var msg = "确认恢复属性？恢复之后添加商品将可添加该属性值！\n\n 请确认";
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
});