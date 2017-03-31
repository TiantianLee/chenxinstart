<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CAF管理系统</title>
<link rel="stylesheet" type="text/css" href="css/amazeui.min.css">
<style type="text/css">
	header{
		height: 120px;
		color: white;
		background-color: #0C79B1;
		font-family: "微软雅黑";
		font-size: 30px;
		line-height: 120px;
	}
	
	#container{
		width:100%;
		
	}
	
	#mainTable {
		
	}
</style>
</head>
<body>
<header>
CAF-宸信分布式管理框架
</header>
<table>
	<tr>
		<td></td>
	</tr>
</table>
<section id="container">
	<section id="mainTable">
		<table class="am-table am-table-bordered am-table-striped am-table-compact" id="tablelist">
		  <thead>
		  <tr>
		    <th>主机</th>
		    <th>服务名</th>
		    <th>版本</th>
		    <th>端口</th>
		    <th>状态</th>
		    <th>详情</th>
		  </tr>
		  </thead>
		  <tbody>
		  </tbody>
		</table>
	</section>
</section>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>
<script type="text/javascript"  src="js/amazeui.ie8polyfill.min.js"></script>
<script type="text/javascript" src="js/amazeui.widgets.helper.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	initList();
	function initList(){
		$.ajax({
			url : '${webapp}/caf/main/getServiceList',
			dataType : 'json',
			type : 'get',
			async : false,
			success : function(d) {
				var dataObj = d.data;
				$.each(dataObj,function(index,ele) {
					var str = "";
					str += "<tr><td>"+ele.ip+"</td><td>"+ele.servicename+"</td><td>"+ele.version+"</td><td>"+ele.port+"</td><td>正常</td><td><a href='#'>详情</a></td></tr>";
					$("#tablelist").append(str);
				});
			},
			error : function(xhr) {
				alert("error");

			}
		});
	}
});
</script>
</body>
</html>