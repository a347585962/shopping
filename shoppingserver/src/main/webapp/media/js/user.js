jQuery(function(){
	
	$("#adduserform").validate({
		//  debug:true,
		rules: {
			userName: {
				required:true
			},
			password:  {
				required:true
				
			} ,
			repassword:  {
				required:true,
				equalTo: "#password"
			}
		},
		messages: {
			password: {
				required:'请填写用户名称'
			},
			password:{
				required:'请输入密码'
			},
			repassword: {
				required:'请重复输入密码',
				equalTo:'两次输入密码不一致'
			}
		},
		errorPlacement: function(error, element) {                             //错误信息位置设置方法  
			 error.appendTo( element.parent().parent() );                            //这里的element是录入数据的对象  
		 },
		 errorElement:"span",
		 errorClass:"invalid"
		
	});
	$("#updateuserform").validate({
		//  debug:true,
		rules: {
			userName: {
				required:true
			},
			password:  {
				required:true
				
			} ,
			repassword:  {
				required:true,
				equalTo: "#updatepassword1"
			}
		},
		messages: {
			password: {
				required:'请填写用户名称'
			},
			password:{
				required:'请输入密码'
			},
			repassword: {
				required:'请重复输入密码',
				equalTo:'两次输入密码不一致'
			}
		},
		errorPlacement: function(error, element) {                             //错误信息位置设置方法  
			 error.appendTo( element.parent().parent() );                            //这里的element是录入数据的对象  
		 },
		 errorElement:"span",
		 errorClass:"invalid"
		
	});
	$(".update").each(function(){
	   	 $(this).click(function(){
	   		 var userid = $(this).attr("userid");
	   	     var username = $(this).attr("username");
	   	     var password = $(this).attr("password");
	   	     $("#userid").val(userid);
	   	     $("#update_userid").val(userid);
	   	     $("#update_username").val(username);
	   	     $("#update_password").val(password);
	   	     $("#updateUserModal").modal();
	   	 });
	 });
});