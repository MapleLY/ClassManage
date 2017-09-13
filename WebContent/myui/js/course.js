var str;//列表显示文本

//layer引用 
layui.use('layer', function(){
	var layer = layui.layer;
});              

//页面运行完成时
$(function(){
	showAll();
});

//显示课程列表
function showAll(){
	$.ajax({
		url:"course_getAllInfo",
		data:{},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			str = "";
			for(var i=0;i<data.length;i++){
				var showStr = "<tr>" +
									"<td>" + data[i].idcourse + "</td>" +
									"<td>" + data[i].name + "</td>" + 
									"<td>" + data[i].style + "</td>" + 
									"<td>" + data[i].score + "</td>" + 
									"<td>" +
										"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data[i].idcourse  + '","' + data[i].name + '"'+ ")'><i class='layui-icon'>&#xe63c;</i></button>" +
										"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data[i].idcourse + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
										"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this," + '"' + data[i].idcourse + '"' + ")'><i class='layui-icon'>&#xe640;</i></button>" +
									"</td>" +
							  "</tr>";
				$('#listShow').html(str+=showStr);
			}
		}
	});
};

//弹窗统计每一门课程的最高分、最低分和平均分
function showResult(stridcourse, strname){
	//弹出层显示
	layer.open({
		  type: 2,
		  title: false,
		  skin: 'layui-layer-demo', //样式类名
		  closeBtn: 1, //不显示关闭按钮
		  anim: 2,
		  area: ['440px', '150px'],
		  shadeClose: true, //开启遮罩关闭
		  content: 'course_inResultPage?idcourse=' + stridcourse + '&name=' + strname
	})
}

//查询一个课程信息
function searchOne(){
	
	var index;
	var strname = $('#coursename').val();
	if(strname!=""){
		index = layer.load(0,{
			time:10*1000
		})
	}
	
	$.ajax({
		url:"course_searchOneInfoByName",
		data:{name:strname},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			str = "";
			var showStr = "<td>" + data.idcourse + "</td>" +
						  "<td>" + data.name + "</td>" + 
						  "<td>" + data.style + "</td>" + 
						  "<td>" + data.score + "</td>" + 
						  "<td>" +
						  	  "<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data.idcourse  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe63c;</i></button>" +
							  "<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idcourse + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
							  "<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
						  "</td>";
			
			$('#listShow').html(str+=showStr);
			
			layer.close(index); 
		}
	});
};

//修改其中一行，（√，×）
function editOneIng(obj,idcourse){
	var text_idcourse = obj.parentNode.parentNode.children[0].innerHTML;
	var text_name = obj.parentNode.parentNode.children[1].innerHTML;
	var text_style = obj.parentNode.parentNode.children[2].innerHTML;
	var text_score = obj.parentNode.parentNode.children[3].innerHTML;
	
	var editing = "<td>" + idcourse + "</td>" +
			  	  "<td><div class='layui-input-inline'><input value='"+ text_name +"' type='text' required lay-verify='required' class='layui-input' style='width:80px;height:22px;text-align:center;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_style +"' type='text' required lay-verify='required' class='layui-input' style='width:50px;height:22px;text-align:center;'></div></td>" + 
			  	  "<td><div class='layui-input-inline'><input value='"+ text_score +"' type='text' required lay-verify='required' class='layui-input' style='width:30px;height:22px;text-align:center;'></div></td>" + 
			  	  "<td>" +
					  "<button class='layui-btn layui-btn-normal layui-btn-radius layui-btn-mini' " + "onclick='saveOne(this)'><i class='layui-icon'>&#xe605;</i></button>" +
					  "<button class='layui-btn layui-btn-warm layui-btn-radius layui-btn-mini' " + "onclick='reOne(this," + '"' +idcourse + '"' + ")'><i class='layui-icon'>&#x1006;</i></button>" +
				  "</td>";
	
	
	obj.parentNode.parentNode.innerHTML = editing;
	
};

//删除其中一行
function deleteOne(obj, stridcourse){
	
	layer.confirm('是否删除？', {
		  icon: 3, 
		  title:'询问',
		  offset:['200px','450px']
		}, function(index){
		    layer.close(index);
			
			$.ajax({
				url:"course_deleteOneInfo",
				data:{idcourse:stridcourse},
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
};

//保存其中一行（修改确认）
function saveOne(obj){
	var text_idcourse = obj.parentNode.parentNode.children[0].innerHTML;
	var text_name = obj.parentNode.parentNode.children[1].children[0].children[0].value;
	var text_style = obj.parentNode.parentNode.children[2].children[0].children[0].value;
	var text_score = obj.parentNode.parentNode.children[3].children[0].children[0].value;

	
	$.ajax({
		url:"course_updateOneInfo",
		data:{idcourse:text_idcourse, name:text_name, style:text_style, score:text_score},
		type:"post",
		success:function(result){
			if(result=="false"){
				layer.msg('修改失败',{
					time:1500
				});
			}else{
				var data = eval("("+result+")");
				var restr = "<td>" + data.idcourse + "</td>" +
							"<td>" + data.name + "</td>" + 
							"<td>" + data.style + "</td>" + 
							"<td>" + data.score + "</td>" +  
							"<td>" +
								"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data.idcourse  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe63c;</i></button>" +
								"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idcourse + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
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
};


//不变其中一行（修改取消)
function reOne(obj,stridcourse){
	$.ajax({
		url:"course_getOneInfo",
		data:{idcourse:stridcourse},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			var restr = "<td>" + data.idcourse + "</td>" +
						"<td>" + data.name + "</td>" + 
						"<td>" + data.style + "</td>" + 
						"<td>" + data.score + "</td>" + 
						"<td>" +
							"<button class='layui-btn layui-btn-normal layui-btn-mini' " + "onclick='showResult(" +'"'+ data.idcourse  + '","' + data.name + '"'+ ")'><i class='layui-icon'>&#xe63c;</i></button>" +
							"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idcourse + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
							"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
						"</td>";
			obj.parentNode.parentNode.innerHTML = restr;
		}
	});
};



