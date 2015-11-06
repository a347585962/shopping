function getPage(pagecount, pagenow, disp, burl){
	//alert(pagecount + "," + pagenow + "," + burl);
	//alert($("#page").attr("class"));
	$("#page").paginate({
		count 		: pagecount,
		start 		: pagenow,
		display     : disp,
		border					: true,
		border_color			: '#fff',
		text_color  			: '#fff',
		background_color    	: 'black',	
		border_hover_color		: '#ccc',
		text_hover_color  		: '#000',
		background_hover_color	: '#fff', 
		images					: false,
		mouse					: 'press',
		onChange: function(page) {
	        location.href = burl + page;
	        getDataByPage(page);
	    }
	});
	/*$("#page").paginate({
		count 		: pagecount,
		start 		: pagenow,
		display     : disp,
		border					: true,
		border_color			: '#fff',
		text_color  			: '#fff',
		background_color    	: 'black',	
		border_hover_color		: '#ccc',
		text_hover_color  		: '#000',
		background_hover_color	: '#fff', 
		onChange: function(page) {
	        location.href = burl + page;
	        getDataByPage(page);
	    }
	});*/
	
}
jQuery(function(){
	$("#adduser").click(function(){
		
		$('#addUserModal').modal();
	});
	var sMenu =$("#sMenu").val();
	//alert(sMenu);
	var mMenu = $("#mMenu").val();
	var mmMenu = $("#mmMenu").val();
	switch(sMenu)
	{
	case "goods":
		jQuery("#goods").addClass("open");
		jQuery("#goods .menu").show();
		break;
	case "goodsclass":
		jQuery("#goods").addClass("open");
		jQuery("#goods .menu").show();
		break;
	case "order":
		jQuery("#order").addClass("open");
		jQuery("#order .sub-menu").show();
		break;
	case "user":
		jQuery("#user").addClass("open");
		jQuery("#user .sub-menu").show();
		break;
	case "activity":
		jQuery("#activity").addClass("open");
		jQuery("#activity .sub-menu").show();
		break;
	case "log":
		jQuery("#user").addClass("open");
		jQuery("#user .sub-menu").show();
		break;
	case "analysis":
		jQuery("#analysis").addClass("open");
		jQuery("#analysis .sub-menu").show();
		break;
	}
});