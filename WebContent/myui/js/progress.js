layui.use('element', function(){
		  var element = layui.element();
		});
	
document.onreadystatechange = function(){
var n = 0, timer = setInterval(function(){
    n = n + 50;  
    if(n>100){
      n = 100;
      clearInterval(timer);
    }
    layui.element().progress('demo', n+'%');
  }, 290+1);
}