<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左选项窗</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<script src="../layui/layui.js" charset="uft-8"></script>
	<script>
	layui.use('element', function(){
		  var element = layui.element();
		});
	</script>
</head>
<body>
	<ul class="layui-nav layui-nav-tree layui-nav-side">
		<!-- 班级信息 -->
		<li class="layui-nav-item layui-nav-itemed">
			<a href="javascript:;">班级信息</a>
			<dl class="layui-nav-child">
				<dd><a href="sclass_inInfoPage" target="iframe2">查看</a></dd>
			</dl>
		</li>
		
		<!-- 学生信息 -->
		<li class="layui-nav-item layui-nav-itemed">
			<a href="javascript:;">学生信息</a>
			<dl class="layui-nav-child">
				<dd><a href="student_inInfoPage" target="iframe2">查看</a></dd>
			</dl>
		</li>
		
		<!-- 课程信息 -->
		<li class="layui-nav-item layui-nav-itemed">
			<a href="javascript:;">课程信息</a>
			<dl class="layui-nav-child">
				<dd><a href="course_inInfoPage" target="iframe2">查看</a></dd>
			</dl>
		</li>
	</ul>
</body>
</html>