var str;//列表显示文本
var datalength;//列表长度
var nums = 1;//每页出现的数据量

//页面运行完成时
$(function(){

	getAlllength();
});

function getAlllength(){
	$.ajax({
		url:"student_getAllInfo",
		data:{},
		type:"post",
		async:false,
		success:function(result){
			var data = eval("("+result+")");
			dlength = data.length;
		}
	});
}

//layer引用 
layui.use(['layer','laypage'], function(){
	var layer = layui.layer,
	laypage = layui.laypage;

	laypage({
		cont:$('#fenye'),
		pages:Math.ceil(dlength/nums),
		jump:function(obj){
			var firstItem = obj.curr*nums-nums;
			
			$.ajax({
				url:"student_getSomeInfo",
				data:{first:firstItem,datalength:nums},
				type:"post",
				success:function(result){
					var data = eval("("+result+")");
					
					str = "";
					for(var i=0;i<data.length;i++){
						var showStr = "<tr>" +
											"<td>" + data[i].idstudent + "</td>" +
											"<td>" + data[i].name + "</td>" + 
											"<td>" + data[i].sex + "</td>" + 
											"<td>" + data[i].birthday + "</td>" + 
											"<td>" + data[i].phone + "</td>" + 
											"<td>" + data[i].address + "</td>" + 
											"<td>" + data[i].idclass + "</td>" + 
											"<td>" +
												"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data[i].idstudent  + '","' + data[i].name + '"'+ ")'><i class='layui-icon'>&#xe629;</i></button>" +
												"<button class='layui-btn layui-btn-mini' " + "onclick='showUpdateGrade(" +'"'+ data[i].idstudent  + '","' + data[i].name + '"'+ ")'><i class='layui-icon'>&#xe639;</i></button>" +
												"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data[i].idstudent + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
												"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this," + '"' + data[i].idstudent + '"' + ")'><i class='layui-icon'>&#xe640;</i></button>" +
											"</td>" +
									  "</tr>";
						str+=showStr;
					}
					$('#listShow').html(str);
				}
			});
		}
	});
});              



//显示学生列表
function showAll(){
	$.ajax({
		url:"student_getAllInfo",
		data:{},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			str = "";
			for(var i=0;i<data.length;i++){
				var showStr = "<tr>" +
									"<td>" + data[i].idstudent + "</td>" +
									"<td>" + data[i].name + "</td>" + 
									"<td>" + data[i].sex + "</td>" + 
									"<td>" + data[i].birthday + "</td>" + 
									"<td>" + data[i].phone + "</td>" + 
									"<td>" + data[i].address + "</td>" + 
									"<td>" + data[i].idclass + "</td>" + 
									"<td>" +
										"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data[i].idstudent  + '","' + data[i].name + '"'+ ")'><i class='layui-icon'>&#xe629;</i></button>" +
										"<button class='layui-btn layui-btn-mini' " + "onclick='showUpdateGrade(" +'"'+ data[i].idstudent  + '","' + data[i].name + '"'+ ")'><i class='layui-icon'>&#xe639;</i></button>" +
										"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data[i].idstudent + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
										"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this," + '"' + data[i].idstudent + '"' + ")'><i class='layui-icon'>&#xe640;</i></button>" +
									"</td>" +
							  "</tr>";
				$('#listShow').html(str+=showStr);
			}
		}
	});
}

//弹窗统计某一个学生的所修课程信息、汇总出学分、不及格课程（标红）
function showResult(stridstudent, strname){
	//弹出层显示
	layer.open({
		  type: 2,
		  title: false,
		  skin: 'layui-layer-demo', //样式类名
		  closeBtn: 1, //不显示关闭按钮
		  anim: 2,
		  area: ['700px', '240px'],
		  shadeClose: true, //开启遮罩关闭
		  content: 'student_inResultPage?idstudent=' + stridstudent + '&name=' + strname
	})
}

//弹窗成绩录入
function showUpdateGrade(stridstudent, strname){
	//弹出层显示
	layer.open({
		  type: 2,
		  title: false,
		  skin: 'layui-layer-demo', //样式类名
		  closeBtn: 1, //显示关闭按钮
		  anim: 4,
		  area: ['700px', '270px'],
		  shadeClose: false, //关闭遮罩关闭
		  content: 'student_inUpdateGradePage?idstudent=' + stridstudent + '&name=' + strname,
	})
}

//查询一个学生信息
function searchOne(){
	
	var index;
	var strname = $('#studentidstudent').val();
	if(strname!=""){
		index = layer.load(0,{
			time:10*1000
		})
	}
	
	$.ajax({
		url:"student_getOneInfo",
		data:{idstudent:strname},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			str = "";
			var showStr = "<td>" + data.idstudent + "</td>" +
						  "<td>" + data.name + "</td>" + 
						  "<td>" + data.sex + "</td>" + 
						  "<td>" + data.birthday + "</td>" + 
						  "<td>" + data.phone + "</td>" + 
						  "<td>" + data.address + "</td>" + 
						  "<td>" + data.idclass + "</td>" + 
						  "<td>" +
						  	  "<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data.idstudent  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe629;</i></button>" +
						  	  "<button class='layui-btn layui-btn-mini' " + "onclick='showUpdateGrade(" +'"'+ data.idstudent  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe639;</i></button>" +
						  	  "<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idstudent + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
							  "<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
						  "</td>";
			
			$('#listShow').html(str+=showStr);
			
			layer.close(index); 
		}
	});
}

//修改其中一行，（√，×）
function editOneIng(obj,idstudent){
	var text_idstudent = obj.parentNode.parentNode.children[0].innerHTML;
	var text_name = obj.parentNode.parentNode.children[1].innerHTML;
	var text_sex = obj.parentNode.parentNode.children[2].innerHTML;
	var text_birthday = obj.parentNode.parentNode.children[3].innerHTML;
	var text_phone = obj.parentNode.parentNode.children[4].innerHTML;
	var text_address = obj.parentNode.parentNode.children[5].innerHTML;
	var text_idclass = obj.parentNode.parentNode.children[6].innerHTML;
	
	var editing = "<td>" + idstudent + "</td>" +
			  	  "<td><div class='layui-input-inline'><input value='"+ text_name +"' type='text' required lay-verify='required' class='layui-input' style='width:60px;height:22px;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_sex +"' type='text' required lay-verify='required' class='layui-input' style='width:30px;height:22px;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_birthday +"' type='text' required lay-verify='required' class='layui-input' style='width:80px;height:22px;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_phone +"' type='text' required lay-verify='required' class='layui-input' style='width:60px;height:22px;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_address +"' type='text' required lay-verify='required' class='layui-input' style='width:60px;height:22px;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_idclass +"' type='text' required lay-verify='required' class='layui-input' style='width:60px;height:22px;'></div></td>" + 
			      "<td>" +
					  "<button class='layui-btn layui-btn-normal layui-btn-radius layui-btn-mini' " + "onclick='saveOne(this)'><i class='layui-icon'>&#xe605;</i></button>" +
					  "<button class='layui-btn layui-btn-warm layui-btn-radius layui-btn-mini' " + "onclick='reOne(this," + '"' + idstudent + '"' + ")'><i class='layui-icon'>&#x1006;</i></button>" +
				  "</td>";
	
	
	obj.parentNode.parentNode.innerHTML = editing;
	
}

//删除其中一行
function deleteOne(obj, stridstudent){
	
	layer.confirm('是否删除？', {
		  icon: 3, 
		  title:'询问',
		  offset:['200px','450px']
		}, function(index){
		    layer.close(index);
			
			$.ajax({
				url:"student_deleteOneInfo",
				data:{idstudent:stridstudent},
				type:"post",
				success:function(result){
					if(result=="false"){
						layer.msg('删除失败',{
							time:1500
						});
					}else{
						var tr = obj.parentNode.parentNode;
						var tbody = tr.parentNode;
						tbody.removeChild(tr);
						
						layer.msg('删除成功',{
							time:1500
						})
					}
				}
			});
		});
}

//保存其中一行（修改确认）
function saveOne(obj){
	var text_idstudent = obj.parentNode.parentNode.children[0].innerHTML;
	var text_name = obj.parentNode.parentNode.children[1].children[0].children[0].value;
	var text_sex = obj.parentNode.parentNode.children[2].children[0].children[0].value;
	var text_birthday = obj.parentNode.parentNode.children[3].children[0].children[0].value;
	var text_phone = obj.parentNode.parentNode.children[4].children[0].children[0].value;
	var text_address = obj.parentNode.parentNode.children[5].children[0].children[0].value;
	var text_idclass = obj.parentNode.parentNode.children[6].children[0].children[0].value;

	
	$.ajax({
		url:"student_updateOneInfo",
		data:{idstudent:text_idstudent, name:text_name, sex:text_sex, birthday:text_birthday, phone:text_phone, address:text_address, idclass:text_idclass},
		type:"post",
		success:function(result){
			if(result=="false"){
				layer.msg('修改失败',{
					time:1500
				});
			}else{
				var data = eval("("+result+")");
				var restr = "<td>" + data.idstudent + "</td>" +
							"<td>" + data.name + "</td>" + 
							"<td>" + data.sex + "</td>" + 
							"<td>" + data.birthday + "</td>" + 
							"<td>" + data.phone + "</td>" + 
							"<td>" + data.address + "</td>" + 
							"<td>" + data.idclass + "</td>" + 
							"<td>" +
								"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data.idstudent  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe629;</i></button>" +
								"<button class='layui-btn layui-btn-mini' " + "onclick='showUpdateGrade(" +'"'+ data.idstudent  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe639;</i></button>" +
								"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idstudent + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
								"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
							"</td>";
				obj.parentNode.parentNode.innerHTML = restr;
				//弹窗反馈
				layer.msg('修改成功',{
					time:1500
				});           
			}
		}
	});
}


//不变其中一行（修改取消)
function reOne(obj,stridstudent){
	$.ajax({
		url:"student_getOneInfo",
		data:{idstudent:stridstudent},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			var restr = "<td>" + data.idstudent + "</td>" +
						"<td>" + data.name + "</td>" + 
						"<td>" + data.sex + "</td>" + 
						"<td>" + data.birthday + "</td>" + 
						"<td>" + data.phone + "</td>" + 
						"<td>" + data.address + "</td>" + 
						"<td>" + data.idclass + "</td>" + 
						"<td>" +
							"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data.idstudent  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe629;</i></button>" +
							"<button class='layui-btn layui-btn-mini' " + "onclick='showUpdateGrade(" +'"'+ data.idstudent  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe639;</i></button>" +
							"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idstudent + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
							"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
						"</td>";
			obj.parentNode.parentNode.innerHTML = restr;
		}
	});
}

