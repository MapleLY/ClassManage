var str;//列表显示文本
var strItem = "";
var idcount = 0;
var strItemOne = "";

//layer引用 
layui.use(['layer','form'], function(){
	var layer = layui.layer,
	form = layui.form();
});              
	
//页面运行完成时
$(function(){
	showAll();
});
//添加+
function addItem(){
	form = layui.form();
	idcount++;
	strItemOne = "<div class='layui-form-item' id='last" + idcount + "'>" +
						"<div class='layui-input-inline' style='width: 100px'>" +
							"<select lay-verify='required' id='boolselect" + idcount + "'>" +
								"<option value='and'>并且</option>" +
								"<option value='or'>或者</option>" +
							"</select>" +
						"</div>" +
						"<div class='layui-input-inline' style='width: 100px'>" +
							"<select lay-verify='required' id='varselect" + idcount + "'>" +
								"<option value='idclass'>编号</option>" +
								"<option value='name'>名称</option>" +
							"</select>" +
						"</div>" +
						"<div class='layui-input-inline' style='width:50%'>" +
							"<input type='text' required lay-verify='required' class='layui-input' id='varinput" + idcount + "'>" +
						"</div>" +
					"</div>";
	$('#searchList').append(strItemOne);
	form.render();
}
//删除-
function deleteItem(){
	var size = $("#searchList").children().length;
	var deleteOne = $("#last"+size);
	deleteOne.remove();
	if(idcount>0){
		idcount--;
	}
}

//查询信息
function searchOne(){
	
	var size = $("#searchList").children().length;
	var listsearchList = new Array();
	
	var var0= $("#varselect0 option:selected").val();
	var varInput0 = $("#varinput0").val();
	if(varInput0==""){varInput0="NONE"}
	var searchList0 = new Array(0, var0, varInput0);
	listsearchList[0] = searchList0;
	for(var i = 1;i <= size;i++){
		var boolOne = $("#boolselect"+i+" option:selected").val();
		var varOne = $("#varselect"+i+" option:selected").val();
		var varInput = $("#varinput"+i).val();
		if(varInput==""){varInput="NONE"}
		var searchListOne = new Array(boolOne, varOne, varInput);
		listsearchList[i] = searchListOne;
	}
	var strsearchList = listsearchList.toString();
	alert(strsearchList);
	
	$.ajax({
		url:"sclass_searchOneInfoByName",
		data:{searchList:strsearchList},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			str = "";
			var showStr = "<td>" + data.idclass + "</td>" +
						  "<td>" + data.name + "</td>" + 
						  "<td>" +
							  "<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idclass + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
							  "<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
						  "</td>";
			
			$('#listShow').html(str+=showStr);
			
			layer.close(index); 
		}
	});
}

//显示班级列表
function showAll(){
	$.ajax({
		url:"sclass_getAllInfo",
		data:{},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			str = "";
			for(var i=0;i<data.length;i++){
				var showStr = "<tr>" +
									"<td>" + data[i].idclass + "</td>" +
									"<td>" + data[i].name + "</td>" + 
									"<td>" +
										"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data[i].idclass + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
										"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this," + '"' + data[i].idclass + '"' + ")'><i class='layui-icon'>&#xe640;</i></button>" +
									"</td>" +
							  "<tr>";
				$('#listShow').html(str+=showStr);
			}
		}
	});
}




//修改其中一行，（√，×）
function editOneIng(obj,idclass){
	var text_idclass = obj.parentNode.parentNode.children[0].innerHTML;
	var text_name = obj.parentNode.parentNode.children[1].innerHTML;
	
	var editing = "<td>" + idclass + "</td>" +
			  	  "<td><div class='layui-input-inline'><input value='"+ text_name +"' type='text' required lay-verify='required' class='layui-input' style='width:100px;height:22px;text-align:center;'></div></td>" + 
			      "<td>" +
					  "<button class='layui-btn layui-btn-normal layui-btn-radius layui-btn-mini' " + "onclick='saveOne(this)'><i class='layui-icon'>&#xe605;</i></button>" +
					  "<button class='layui-btn layui-btn-warm layui-btn-radius layui-btn-mini' " + "onclick='reOne(this," + '"' + idclass + '"' + ")'><i class='layui-icon'>&#x1006;</i></button>" +
				  "</td>";
	
	
	obj.parentNode.parentNode.innerHTML = editing;
	
}

//删除其中一行
function deleteOne(obj, text_idclass){
	
	layer.confirm('是否删除？', {
		  icon: 3, 
		  title:'询问',
		  offset:['200px','450px']
		}, function(index){
		    layer.close(index);
			
			$.ajax({
				url:"sclass_deleteOneInfo",
				data:{idclass:text_idclass},
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
	var text_idclass = obj.parentNode.parentNode.children[0].innerHTML;
	var text_name = obj.parentNode.parentNode.children[1].children[0].children[0].value;

	
	$.ajax({
		url:"sclass_updateOneInfo",
		data:{idclass:text_idclass, name:text_name},
		type:"post",
		success:function(result){
			if(result=="false"){
				layer.msg('修改失败',{
					time:1500
				});
			}else{
				var data = eval("("+result+")");
				var restr = "<td>" + data.idclass + "</td>" +
							"<td>" + data.name + "</td>" + 
							"<td>" +
								"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idclass + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
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
function reOne(obj,stridclass){
	$.ajax({
		url:"sclass_getOneInfo",
		data:{idclass:stridclass},
		type:"post",
		success:function(result){
			var data = eval("("+result+")");
			var restr = "<td>" + data.idclass + "</td>" +
						"<td>" + data.name + "</td>" + 
						"<td>" +
							"<button class='layui-btn layui-btn-mini' " + "onclick='editOneIng(this," + '"' + data.idclass + '"' + ")'><i class='layui-icon'>&#xe642;</i></button>" +
							"<button class='layui-btn layui-btn-danger layui-btn-mini' " + "onclick='deleteOne(this)'><i class='layui-icon'>&#xe640;</i></button>" +
						"</td>";
			obj.parentNode.parentNode.innerHTML = restr;
		}
	});
}



