<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>欢迎来到班级管理系统</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../myui/css/login.css">
</head>
<body>
	<div class="allBox">
		<div style="text-align: center;">班级管理系统</div>
		<form class="layui-form" action="login_checkLogin">
			<!-- 账户框 -->
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-block textBox">
					<input type="text" name="idstudent" required lay-verify="required" placeholder="请输入账户"
					 class="layui-input">
				</div>
			</div>
			
			<!-- 密码框 -->
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block textBox">
					<input type="password" name="password" required lay-verify="required" placeholder="请输入密码"
					 autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<!-- 登录 -->
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn submitBox" lay-submit>登录</button>
				</div>
			</div>
			
		</form>
	</div>
</body>
</html>