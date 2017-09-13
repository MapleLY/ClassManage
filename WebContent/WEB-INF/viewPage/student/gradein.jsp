<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩录入</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../myui/css/mana.css">

	<script type="text/javascript" src="../myui/js/jquery-2.1.0.js"></script>
	<script src="../layui/layui.js" charset="uft-8"></script><!-- layui.js -->
	<script type="text/javascript" src="../myui/js/progress.js"></script><!-- 进度条 -->
	<script>
	//layer引用 
	layui.use('layer', function(){
		var layer = layui.layer;
	});              

	//页面运行完成时
	$(function(){
		var stridstudent = $('#valu').val();
		showResult(stridstudent);
	});
	//显示成绩结果
	function showResult(stridstudent){
		var str = "";
		$.ajax({
			url:"student_searchStudentCourseGrade",
			data:{idstudent:stridstudent},
			type:"post",
			success:function(result){
				var data = eval("("+result+")");
				if(data.length!=0){
					for(var i=0;i<data.length;i++){
						strShow = "<tr>" +
										"<td style='text-align: center;'>" + data[i].idcourse + "</td>" +
										"<td style='text-align: center;'>" + data[i].name + "</td>" + 
										"<td style='text-align: center;'><div class='layui-input-inline'><input value='"+ data[i].grade +"' type='text' required lay-verify='required' class='layui-input' style='width:60px;height:22px;'></div></td>" + 
								  "</tr>";
						$('#listShow').html(str+=strShow);
					}
				}else{
					$("#btn").css('display','none');
				}
				
			}
		});
	}
	
	//确认修改
	function updateResult(obj){
		var stridstudent = $('#valu').val();
		var size =  obj.parentNode.parentNode.children[1].children[1].rows.length;//tr行个数
		var liststudentcourseList = new Array(size);
		
		for(var i = 0;i < size;i++){
			var text_idcourse = obj.parentNode.parentNode.children[1].children[1].children[i].children[0].innerHTML;
			var text_grade = obj.parentNode.parentNode.children[1].children[1].children[i].children[2].children[0].children[0].value;
			var studentcourseOne = new Array(stridstudent,text_idcourse, text_grade);
			liststudentcourseList[i] = studentcourseOne;
		}
		var strstudentcourseList = liststudentcourseList.toString();
		$.ajax({
			url:"student_updateStudentCourseGrade",
			data:{studentcourseList:strstudentcourseList},
			type:"post",
			success:function(result){
				if(result=="false"){
					layer.msg('保存失败',{
						time:1500
					});
				}else{
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.layer.msg('保存成功',{
						time:1500
					});	

				}
			}
		});
		
	}
	
	//关闭页面
	function cancel(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
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
							学生成绩
						</th>
					</tr>
				</thead>
				<tbody id="listShow">
				</tbody>
			</table>
			<div id="btn" style="margin-left: 230px">
				<button class="layui-btn layui-btn-radius layui-btn-normal layui-form-mid" onclick="updateResult(this)" style="width:80px">
					<i class="layui-icon">&#xe605;</i>&nbsp;保存
				</button>
				
				<button class="layui-btn layui-btn-radius layui-form-mid" onclick="cancel()" style="width:80px">
					<i class="layui-icon">&#x1006;</i>&nbsp;取消
				</button>
			</div>
		</fieldset>
</body>
</html>