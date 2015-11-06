<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息管理</title>
</head>
<body>

<script type="text/javascript" src="<%=basePath %>media/js/highcharts.js"></script>
<script type="text/javascript" src="<%=basePath %>media/js/exporting.js"></script>
<script type="text/javascript" src="<%=basePath %>media/js/salesanalysis.js"></script>
<div class="body" style="margin:15px;">
	<span>活动管理-活动信息管理</span>
	<div class="">
		 <div id="toptenperson" style="min-width:700px;height:400px"></div>
		 <input type="hidden" value='${jsonData }' id='data'>
	</div>
</div>
<script type="text/javascript">
$(function () {
	var data = $("#data").val();
	//alert(data);
	var member = eval("(" + data + ")"); //正确写法
	var name = "";
	var xtext = [];//X轴TEXT
	var datas = [];
	for ( var i = 0; i < member.length; i++) {
		xtext[i] = member[i].userPhone;
		datas[i] = member[i].sumgoods;
	}
	//alert(name);
    $('#toptenperson').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '购买量前十'
        },
        subtitle: {
            text: '购买最多的十位顾客'
        },
        xAxis: {
            categories: xtext
        },
        yAxis: {
            min: 0,
            title: {
                text: '购买量 (件)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.f} 件</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
            	 dataLabels:{
                     enabled:true // dataLabels设为true
                    
                 },
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '数量',
            data: datas

        }]
    });
   
});
</script>
</body>
</html>