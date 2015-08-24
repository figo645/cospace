



	
	
	function checkkey()//filter un-number input
	{	//var c=event.keyCode
		//if((c>=0x30) && (c<=0x39) || (c==8) || (c==46) || (c==37) || (c==39)  || (c==189)  || (c==190)  ) 
			event.returnValue=true;
		//else 
		//	event.returnValue=false;
	
	};

	function gonext(obj)//check enter and focus next object
	{
		if(event.keyCode==13) document.all(obj).focus();
	};

	function disable(obj,flag)//hide or show an object
	{
		if(flag)
		{
			obj.style.visibility=''; 
		}
		else 
		{
			obj.style.visibility='hidden'; 
		}
	
	};

	function readonly(obj,flag)//set Readonly or un-Readonly to an object
	{	if(flag)
		{
			obj.readOnly=false;
		}
		else 
		{
			obj.readOnly=true; 
		}
	
	};
	function disabled(obj,flag)//Disabled or Enabled An Object
	{	if(flag)
		{
			obj.disabled=false;
		}
		else 
		{
			obj.disabled=true; 
		}
	
	};
	
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; 

if(!x && d.getElementById) 
	x=d.getElementById(n); 

if(!x && d.getElementByName) 
	x=d.getElementByName(n); 


if((p=n.indexOf("?"))>0&&parent.frames.length) {

    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);

}

if(!x && !(x=d[n])&&d.all) 
	x=d.all[n]; 

for (i=0;!x&&i<d.forms.length;i++) 
	x=d.forms[i][n];

for(i=0;!x&&d.layers&&i>d.layers.length;i++) 
	x=MM_findObj(n,d.layers[i].document);



return x;
}

function getattr(val,attrname) { 

try{ 
		return 		val.attributes[attrname].nodeValue					
				

}catch(e){ 
	
	return '';
} 

}

function MM_validateForm() { //v4.0,Form Checked,modify from Dreamweaver4.0
  var i,p,q,nm,test,num,min,max,objfocus='',errors='',args=MM_validateForm.arguments;
  for (i=0; i<(args.length-2); i+=3) 
  { test=args[i+2]; val=MM_findObj(args[i]);
  	
    if (val) {nm="[ "+getattr(val,'title')+" ]"; if ((val=val.value)!="") {
      if (test.indexOf('isEmail')!=-1) { p=val.indexOf('@');
        if (p<1 || p==(val.length-1)) errors+=nm+' 必须是有效的邮箱地址.\n';
      } else if (test!='R') {
        if (isNaN(val)) {errors+=nm+' 必须是一个数字.\n';}
        if (test.indexOf('inRange') != -1) { p=test.indexOf(':');
          min=parseInt(test.substring(8,p)); max=parseInt(test.substring(p+1));
            if (min>parseInt(val) || max<parseInt(val)) errors+=nm+' 必须是介于 '+min+' 到 '+max+' 的数字.\n';

    } } } else if (test.charAt(0) == 'R') errors +=nm+' 必须填写内容.\n'; }
   /////////////////////////Updated on Aug. 7th, 2002 with focusing functions
  
   if(objfocus=='' && errors)
	{	objfocus=args[i];
		if(document.getElementById(objfocus).type=='hidden')objfocus='Composition';
	}
  	//////////////////
  }
  
  if (errors) {
  alert( '在您的表单中发现如下错误:\n----------------------------------------------------------------------\n'+errors);
	//alert(objfocus);
   document.getElementById(objfocus).focus();
   if( objfocus=="Composition") Composition.focus();
 }
  document.MM_returnValue = (errors == '');
  return (errors == '');
}	

/////////////Filter HTML Code
function rphtml() {
  var args=rphtml.arguments;
  for (i=0; i<(args.length); i++) 
  { val=MM_findObj(args[i]);
  	var re=//g
  	val.value=val.value.toString().replace(re,'&gt;');
  }

}

/////////Opreate Event onMouseOver
	function ov(a)
	{
		a.bgColor=hotcolor;
	}

/////////Opreate Event onMouseOut
	function mo(a)
	{
		a.bgColor=vcolcolor;
	}
	
	
	
/////////Print the document
	function doprint(){
	//WebBrowser1.ExecWB(6,1);
	window.print();
	}




function setvalue(ifrom,ito)
{
document.all(ito).value=document.all(ifrom).value

}

function IEVer()
{
var str=navigator.appVersion
var loca=str.indexOf('MSIE') +5
return parseInt(str.substr(loca))

}

//校验 多个日期输入元素，元素ID用-分割
//用法：isDateTimeString("TextBox1-TextBox2-TextBox3") ;

function CheckDate(str)
{			

			if(str=="")
				return true;
		
			var t,fResult;
			fResult=true;
			//alert(str);
			//alert(str);
			t=str.split("-");
			
			for( i=0;i< t.length;i++)
			{
				var obj=document.getElementById(t[i]);
			
				if(obj)
				{
					if(!isDateTimeString(obj.value))
					{
						alert( getattr(obj,'title') + ' 日期时间格式无效，请按照 2008-1-1 的格式输入!'); 
						return false;
					
					}
					
				}
				


			}
			
			
			return fResult;
		
	}


//校验 完全使用时间正则表达式
//用法：isDateTimeString(document.getElementById('TextBox1').value) ;
function isDateTimeString(str)
{
	
	if(str.length == 0 ) return true ;
	
	var a = str.match(/^((\d{2}(([02468][048])|([13579][26]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|([1-2][0-9])))))|(\d{2}(([02468][1235679])|([13579][01345789]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\s((([0-9]|[0-1][0-9]|[2][0-3]))\:([0-9]|[0-5][0-9])(()|(\:([0-9]|[0-5][0-9])))))?$/);
	if (a == null) { return false;}
	if (a[1]>24 || a[3]>60 || a[4]>60)
	{
	  //alert("时间格式不对");
	  return false
	}
	return true;
}

//写cookies函数 作者：翟振凯
function setCookie(name,value)//两个参数，一个是cookie的名子，一个是值
{
    var Days = 30; //此 cookie 将被保存 30 天
    var exp  = new Date();    //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name)//取cookies函数        
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
     if(arr != null) return unescape(arr[2]); return null;

}
function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}