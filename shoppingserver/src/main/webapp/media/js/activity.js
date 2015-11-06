jQuery(function(){
	//alert("123");
	jQuery(function(){
		 var pagecount = $("#pagecount").val();
		   var pagenow = $("#pagenow").val();
		   var basePath = $("#url_base").val();
		   var burl = basePath + "activity/manager/";
		   getPage(pagecount, pagenow, 10, burl);
	});
	var base_url = $("#url_base").val();
	 $("#btn_add1").click(function(){  
		 var div = document.getElementById("imgdiv");
         var img = document.createElement("input");
         img.name='files';
         img.type='file';
         img.className = 'imgfile';
         div.appendChild(img);
        
     }); 
	
});
$(document).ready(function() { 
	$(function(){
		  $('#rangeA').daterangepicker({
			presetRanges:[
				//{text:'最近一周', dateStart:'yesterday-7days', dateEnd:'yesterday' },
				//{text:'最近一月', dateStart:'yesterday-1month', dateEnd:'yesterday' },
				//{text:'最近一年', dateStart:'yesterday-1year', dateEnd:'yesterday' }
			],
			presets:{
				dateRange:'自定义时间'
			},
			rangeStartTitle:'起始日期',
			rangeEndTitle:'结束日期',
			nextLinkText:'下月',
			prevLinkText:'上月',
			doneButtonText:'确定',
			cancelButtonText:'取消',
			earliestDate:'',
			latestDate:Date.parse('today'),
			constrainDates:true,
			rangeSplitter:'/',
			dateFormat:'yy-mm-dd',
			closeOnSelect:false,
			onOpen:function(){
				$('.ui-daterangepicker-dateRange').click().parent().hide();
			}}
		); 
		 
});
	$("#addactivityform").validate({
		//  debug:true,
		rules: {
			activityName: {
				required:true
			},
			rangetime:  {
				required:true
				
			} ,
			activityType:  {
				required:true,
				min:1
			},
			files: {
				required: true	
			}
		},
		messages: {
			activityName: {
				required:'请填写活动名称'
			},
			rangetime:{
				required:'请选择活动区间'
			},
			activityType: {
				required:'请选择活动类型',
				min:'请选择活动类型'
			},
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
	$("#updateactivityform").validate({
		//  debug:true,
		rules: {
			activityName: {
				required:true
			},
			
			activityType:  {
				required:true,
				min:1
			}
		},
		messages: {
			activityName: {
				required:'请填写活动名称'
			},
			activityType: {
				required:'请选择活动类型',
				min:'请选择活动类型'
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
	var status = $("#status").val();
	  var type = $("#type").val();
	 // alert(status + "," + type);
	  $("#activityStatus").val(status);
	  $("#activityType").val(type);
});