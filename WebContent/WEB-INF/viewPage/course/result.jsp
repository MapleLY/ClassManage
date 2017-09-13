<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../myui/css/mana.css">

	<script type="text/javascript" src="../myui/js/jquery-2.1.0.js"></script>
	<script src="../layui/layui.js" charset="uft-8"></script><!-- layui.js -->
	<script type="text/javascript" src="../myui/js/progress.js"></script><!-- 进度条 -->
	<script>
	
	//页面运行完成时
	$(function(){
		var stridcourse = $('#valu').val();
		showResult(stridcourse);
	});
	function showResult(stridcourse){
		var str = "";
		$.ajax({
			url:"course_searchOneGradeResult",
			data:{idcourse:stridcourse},
			type:"post",
			success:function(result){
				var data = eval("("+result+")");
					strShow = "<tr>" +
									"<td style='text-align: center;'>" + data.maxgrade + "</td>" +
									"<td style='text-align: center;'>" + data.mingrade + "</td>" + 
									"<td style='text-align: center;'>" + data.averagegrade + "</td>" + 
							 "<tr>";
					$('#listShow').html(str+=strShow);
			}
		});
	}
	</script>
</head>
<body>
		<input type="hidden" id="valu" value="${idcourse}">				
		<fieldset class="layui-elem-field  layui-field-title" style="margin-left: 20px;margin-right: 20px;width: 400px;height:10px">
			<legend id="studentname">${name}</legend>
			<table class="layui-table" lay-skin="line" style="margin-right: 20px;" >
				<thead>
					<tr>
						<th style="text-align: center;">
							最高分
						</th>
						<th style="text-align: center;">
							最低分
						</th>
						<th style="text-align: center;">
							平均分
						</th>
					</tr>
				</thead>
				<tbody id="listShow">
				</tbody>
			</table>
		</fieldset>
</body>
</html>