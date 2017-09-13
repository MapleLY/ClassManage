<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩结果查询</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../myui/css/mana.css">

	<script type="text/javascript" src="../myui/js/jquery-2.1.0.js"></script>
	<script src="../layui/layui.js" charset="uft-8"></script><!-- layui.js -->
	<script type="text/javascript" src="../myui/js/progress.js"></script><!-- 进度条 -->
	<script>
	
	//页面运行完成时
	$(function(){
		var stridstudent = $('#valu').val();
		showResult(stridstudent);
	});
	function showResult(stridstudent){
		var str = "";
		$.ajax({
			url:"student_searchOneGradeResult",
			data:{idstudent:stridstudent},
			type:"post",
			success:function(result){
				var data = eval("("+result+")");
				for(var i=0;i<data.length;i++){
					if(data[i].passornot=="不及格"){
						strShow = "<tr style='color:red'>" +
										"<td style='text-align: center;'>" + data[i].idcourse + "</td>" +
										"<td style='text-align: center;'>" + data[i].coursename + "</td>" + 
										"<td style='text-align: center;'>" + data[i].style + "</td>" + 
										"<td style='text-align: center;'>" + data[i].coursescore + "</td>" + 
										"<td style='text-align: center;'>" + data[i].grade + "</td>" + 
										"<td style='text-align: center;'>" + data[i].studentscore + "</td>" + 
										"<td style='text-align: center;'>" + data[i].passornot + "</td>" + 
				 				  "<tr>";
						$('#listShow').html(str+=strShow);
						continue;
					}
					strShow = "<tr>" +
									"<td style='text-align: center;'>" + data[i].idcourse + "</td>" +
									"<td style='text-align: center;'>" + data[i].coursename + "</td>" + 
									"<td style='text-align: center;'>" + data[i].style + "</td>" + 
									"<td style='text-align: center;'>" + data[i].coursescore + "</td>" + 
									"<td style='text-align: center;'>" + data[i].grade + "</td>" + 
									"<td style='text-align: center;'>" + data[i].studentscore + "</td>" + 
									"<td style='text-align: center;'>" + data[i].passornot + "</td>" + 
							 "<tr>";
					$('#listShow').html(str+=strShow);
				}
			}
		});
	}
	</script>
</head>
<body>
		<input type="hidden" id="valu" value="${idstudent}">				
		<fieldset class="layui-elem-field  layui-field-title" style="margin-left: 20px;margin-right: 20px;width: 650px">
			<legend id="studentname">${name}</legend>
			<table class="layui-table" lay-skin="line" style="margin-right: 20px;">
				<thead>
					<tr>
						<th style="text-align: center;">
							课程编号
						</th>
						<th style="text-align: center;">
							课程名称
						</th>
						<th style="text-align: center;">
							课程性质
						</th>
						<th style="text-align: center;">
							课程学分
						</th>
						<th style="text-align: center;">
							学生成绩
						</th>
						<th style="text-align: center;">
							所得学分
						</th>
						<th style="text-align: center;">
							及格状态
						</th>
					</tr>
				</thead>
				<tbody id="listShow">
				</tbody>
			</table>
			<br>
		</fieldset>
</body>
</html>