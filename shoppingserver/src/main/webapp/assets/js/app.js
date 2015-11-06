Zepto(function($){
  //收藏商品
  $("#faverit").click(function(){
    clearTimeout(timer);
    //定时器
    var timer = setTimeout(function(){
      $('#modal-faverit').modal('close');
      },800);
    //判断是否是收藏的商品，如果是，则把星星点亮,反之则熄灭星星；
    if($(this).hasClass("on")){
      $(this).removeClass("on");
      $('#modal-faverit .tipsmsg').text("取消成功");
      timer
    } else {
      $(this).addClass("on");
      $('#modal-faverit .tipsmsg').text("关注成功");
      timer
    }
  });//收藏商品--end
  //体验馆发送短信弹窗
  $('.model_sendmsg').on('click', function() {
    $(".am-dimmer").removeClass();
    $('#model_msg').modal({
      relatedElement: this,
      onConfirm: function(data) {
        clearTimeout(timer);
        //(点击发送)后执行的动作，先执行判断，判断通过后点击发送才执行关闭事件
        if($(".am-modal-bd input").val().length<11){//做了一个简单，为了说明实现过程，具体的判断需要程序要实现
          $("#errmsg").removeClass("am-hide");
          $("#successmsg").addClass("am-hide");
        }
        else
        {
          $("#errmsg").addClass("am-hide");
          $("#successmsg").removeClass("am-hide");
          //定时器
          var timer = setTimeout(function(){
            $('#model_msg').modal('close');
            $("#successmsg").addClass("am-hide");
            $(".am-modal-bd input").val("")
            },1000);
        }
      },
      onCancel: function() {
        //取消后执行的动作
        $("#successmsg ,#errmsg").addClass("am-hide");
        $(".am-modal-bd input").val("")
      }
    });
  });
  //体验馆发送短信弹窗---end
});
$(document).ready(function(){
  //搜索按钮和搜索框高度相等
  window.onload =window.onresize = function(){
    $("#search input[type='submit']").height($("#search input[type='text']").height());//搜索等高
    $("#yzm button[type='button']").height($("#yzm input[type='text']").height());//验证码等高
    $("#yzm input[type='text']").width($("#yzm input[type='text']").parent().width()-60)//验证码间隔
  }
  //设置默认地址
  $("#center_address_list ul li a.setdaulft").click(function(){
    $(this).parents("li").addClass("on");
    $(this).parents("li").siblings().removeClass("on")
  });
//自定义radio checkbox
  $("input[type='radio'] , input[type='checkbox']").iCheck({
    checkboxClass: 'icheckbox_square-red',
    radioClass: 'iradio_square-red',
    increaseArea: '20%' // optional
  });
});
//交互反馈
function clickResponse(obj){
	$('[res]').removeClass('on');
	$(obj).addClass('on');
	setTimeout(function(){
    $(obj).removeClass('on');
  },700);
}
//状态修改
function current(obj){
  $(obj).parent().parent().find("a").removeClass('current');
  $(obj).addClass('current')
}
//登录注册显示删除图标
function showicon(obj){
  $(obj).parent().find("i").removeClass('am-hide');
}
//登录注册清空内容
function clearvalue(obj){
  $(obj).parent().find("input").val("");
  $(obj).parent().find("i").addClass('am-hide')
}
