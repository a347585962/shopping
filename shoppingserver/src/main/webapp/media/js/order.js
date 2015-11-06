
jQuery(function(){
	jQuery(".updateorder").click(function(){
		jQuery("#orderid").val(jQuery(this).attr("orderid"));
		jQuery("#adress").val(jQuery(this).attr("address"));
		jQuery("#money").val(jQuery(this).attr("account"));
		jQuery("#updateidstr").val(jQuery(this).attr("orderid"));
		jQuery("#updateModal").modal();
	});
	jQuery("#").change(function(){
		
	});
	jQuery(".ordersuccess").click(function(){
		
	});
});