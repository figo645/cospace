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
        
        //���½��в���
        //if(Sys.ie) alert("");
        //if(Sys.firefox)alert("���Ǽ�����ʹ�õ�FIREFOX�����\n�����ǽ�����ʹ��IE�����������Ч��");
        //if(Sys.chrome)alert("���Ǽ�����ʹ�õ�GOOGLE�����\n�����ǽ�����ʹ��IE�����������Ч��");
        if(Sys.opera)alert("���Ǽ�����ʹ�õ�OPERA�����\n�����ǽ�����ʹ��IE�����������Ч��");
        if(Sys.safari)alert("���Ǽ�����ʹ�õ�SAFARI�����\n�����ǽ�����ʹ��IE�����������Ч��");
}


function click(){ 
if(event.button==2){ 
alert( '����վ��ӭ�� !!'); 
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
   date.setDate(s+1);    //����cookie����Ч��
   document.cookie = sName + "=" + escape(sValue) + "; expires=" + date.toGMTString();//����cookie
}
function GetCookie(sName)
{
   var aCookie = document.cookie.split("; "); //��cookie�е������и�����飬�������
   for (var i=0; i < aCookie.length; i++)      //����cookie�е�����
   {
   var aCrumb = aCookie[i].split("=");         //������ֵ�ֿ�
   if (sName == aCrumb[0]) {                   //�ж��Ƿ���ָ���ļ�
    return unescape(aCrumb[1]);}            //���ؼ���Ӧ��ֵ
   }
   return null;
}
function winLoad()
{
   //document.getElementById("leftdiv").scrollLeft = GetCookie("scrollLeft");//��ȡˮƽ������λ��
   document.getElementById("leftdiv").scrollTop = GetCookie("scrollTop"); //��ȡ��ֱ������λ��
}
function winUnload()
{
   //SetCookie("scrollLeft", document.getElementById("leftdiv").scrollLeft) //����ˮƽ������λ��
   SetCookie("scrollTop", document.getElementById("leftdiv").scrollTop)    //���洹ֱ������λ��
}
window.onload = winLoad;                               //����ҳ��ʱ�Զ�ִ�л�ȡcookie����ֵ�ķ���
window.onunload = winUnload;                           //�ر�ҳ��ʱ�Զ�ִ�б���cookie�ķ���

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


