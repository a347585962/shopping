jQuery(function(){
	$("#picture").change(function(evt){
        var files = evt.target.files; 
        readfile(files);
    });
	$("#picture1").change(function(evt){
        var files = evt.target.files; 
        readfile2(files);
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
    function readfile2(fileList)
    {
    	for (var i = 0, f; f = fileList[i]; i++) {
    		
	           if (!f.type.match('image.*')) {
	             continue;
	           }       	          
	           var reader = new FileReader();
	           reader.onload = (function(theFile) {
	             return function(e) {                                
		       //       $("#photo").attr("src",e.target.result);
		              var div = document.getElementById("photo1");
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