<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息查看</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../myui/css/mana.css">
	
	<script type="text/javascript" src="../myui/js/jquery-2.1.0.js"></script>
	<script src="../layui/layui.js" charset="uft-8"></script><!-- layui.js -->
	<script type="text/javascript" src="../myui/js/progress.js"></script><!-- 进度条 -->
	<script type="text/javascript" src="../myui/js/student.js"></script><!-- 学生列表 -->
</head>
<body>

	<!-- 进度条 -->
	<div id="aa" class="layui-progress" lay-filter="demo" style="width:1500px">
	  <div id="goBar" class="layui-progress-bar" lay-percent="0%" style="width:1500px"></div>
	</div>

	<div class="allBox">
	<fieldset class="layui-elem-field  layui-field-title">
		<legend>条件查询</legend>
		<div class="layui-field-box">
			<div class="layui-form-item">
				<label class="layui-form-label">学生学号</label>
				<div class="layui-input-inline" style="width:50%">
					<input type="text" id="studentidstudent" name="studentidstudent" required lay-verify="required" placeholder="例如：20143018"
					 class="layui-input">
				</div>
				<div>
					<button class="layui-btn layui-btn-radius layui-btn-normal layui-form-mid" onclick="searchOne()" style="width:80px">
						<i class="layui-icon">&#xe615;</i>&nbsp;查询
					</button>
					
					<button class="layui-btn layui-btn-radius layui-form-mid" onclick="showAll()" style="width:120px">
						<i class="layui-icon">&#x1002;</i>&nbsp;显示全部
					</button>
				</div>
			</div>
		</div>
	</fieldset>
	
	<fieldset class="layui-elem-field  layui-field-title">
		<legend>学生列表</legend>
		<table class="layui-table" lay-skin="line" style="margin-left: 20px;margin-right: 20px;width:1250px">
			<thead>
				<tr>
					<th style="text-align: center;">
						学号
					</th>
					<th style="text-align: center;">
						姓名
					</th>
					<th style="text-align: center;">
						性别
					</th>
					<th style="text-align: center;">
						出生日期
					</th>
					<th style="text-align: center;">
						联系电话
					</th>
					<th style="text-align: center;">
						家庭住址
					</th>
					<th style="text-align: center;">
						班级编号
					</th>
					<th style="text-align: center;">
						管理
					</th>
				</tr>
			</thead>
			<tbody id="listShow">
			</tbody>
		</table>
		<div id="fenye"></div>
	</fieldset>
</div>
</body>
</html>