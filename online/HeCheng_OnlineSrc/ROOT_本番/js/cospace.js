function checkBrowser(){
var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        if (window.ActiveXObject)
            Sys.ie = ua.match(/msie ([\d.]+)/)[1]
        else if (document.getBoxObjectFor)
            Sys.firefox = ua.match(/firefox\/([\d.]+)/)[1]
        else if (window.MessageEvent && !document.getBoxObjectFor)
            Sys.chrome = ua.match(/chrome\/([\d.]+)/)[1]
        else if (window.opera)
            Sys.opera = ua.match(/opera.([\d.]+)/)[1]
        else if (window.openDatabase)
            Sys.safari = ua.match(/version\/([\d.]+)/)[1];
        
        //以下进行测试
        //if(Sys.ie) alert("");
        //if(Sys.firefox)alert("我们检测出您使用的FIREFOX浏览器\n，但是建议您使用IE浏览器获得最佳效果");
        //if(Sys.chrome)alert("我们检测出您使用的GOOGLE浏览器\n，但是建议您使用IE浏览器获得最佳效果");
        if(Sys.opera)alert("我们检测出您使用的OPERA浏览器\n，但是建议您使用IE浏览器获得最佳效果");
        if(Sys.safari)alert("我们检测出您使用的SAFARI浏览器\n，但是建议您使用IE浏览器获得最佳效果");
}


function click(){ 
if(event.button==2){ 
alert( '本网站欢迎您 !!'); 
} 
} 
document.onmousedown=click;

function resize(){
	document.getElementById("leftdiv").style.height = 639+"px";
	document.getElementById("rightdiv").style.height = 639+"px";
	var adjustHeight = 56;
	
	
	var oClientHeight = document.documentElement.scrollHeight;
	//alert(oClientHeight);
	var resizeheight = oClientHeight - 116 - 30 - adjustHeight//;
	//alert(resizeheight);
		
		document.getElementById("leftdiv").style.height=resizeheight+"px";
		document.getElementById("rightdiv").style.height=resizeheight+"px";
		//document.getElementById('leftdiv').scrollTop = document.getElementById('leftdiv').scrollHeight;
		winLoad();
   }

function SetCookie(sName, sValue)
{
   date = new Date();
   s = date.getDate();
   date.setDate(s+1);    //设置cookie的有效期
   document.cookie = sName + "=" + escape(sValue) + "; expires=" + date.toGMTString();//创建cookie
}
function GetCookie(sName)
{
   var aCookie = document.cookie.split("; "); //将cookie中的数据切割成数组，方便遍历
   for (var i=0; i < aCookie.length; i++)      //遍历cookie中的数据
   {
   var aCrumb = aCookie[i].split("=");         //将键和值分开
   if (sName == aCrumb[0]) {                   //判断是否是指定的键
    return unescape(aCrumb[1]);}            //返回键对应的值
   }
   return null;
}
function winLoad()
{
   //document.getElementById("leftdiv").scrollLeft = GetCookie("scrollLeft");//获取水平滚动条位置
   document.getElementById("leftdiv").scrollTop = GetCookie("scrollTop"); //获取垂直滚动条位置
}
function winUnload()
{
   //SetCookie("scrollLeft", document.getElementById("leftdiv").scrollLeft) //保存水平滚动条位置
   SetCookie("scrollTop", document.getElementById("leftdiv").scrollTop)    //保存垂直滚动条位置
}
window.onload = winLoad;                               //加载页面时自动执行获取cookie保存值的方法
window.onunload = winUnload;                           //关闭页面时自动执行保存cookie的方法

function lightMenu(obj) {
	var myNav = document.getElementById("leftdiv").getElementsByTagName("a");
	for ( var i = 0; i < myNav.length; i++) {
		var links = myNav[i].getAttribute("href");
		if (obj == myNav[i]) {
			myNav[i].className = "d_over";
		} else {
			myNav[i].className = "d_out";
		}
	}
	document.getElementById("rightdiv").scrollTop  = 0;
}

function lightMenuFirst() {
	var myNav = document.getElementById("leftdiv").getElementsByTagName("a");
	if (myNav.length != 0){
		myNav[0].className = "d_over";
	}
}

function topDiv(){
	
}


