<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My jQuery</title>
<script type="text/javascript" src="./jquery/jquery.js"></script>
<style type="text/css">
@font-face {
    font-family: '汉仪大宋简';
    src: url('font/HYDSJ.eot');
    }

body {
	height: 100%;
	max-height: 100%;
	overflow: hidden;
	padding: 0;
	margin: 0;
	border: 0;
}

.content {
	width: 100%;
}

.leftcontent {
	width: 308;
}

.framewidth {
	width: 1260;
}

.leftgray {
	background-color: #F3F3F3;
}

.titleleft {
	font-family: "Arial";
	font-size: 19px;
	font-weight: bold;
	color: #3163A8;
}

.navifont {
	text-decoration: none;
	font-family: "Arial";
	font-size: 14px;
	color: #1D1D1D;
}

.navid_over {
	text-decoration: none;
	background-image: url(images/button02.jpg);
	font-weight: bold;
	color: #000000;
}

.navid_out {
	text-decoration: none;
	background-image: url(images/button01.jpg);
	font-weight: bold;
	color: #999999;
}

.naviback {
	color: #FFFFFF;
	text-decoration: none;
	background-color: #01A2F2;
}

.navibackfontsize {
	font-size: 13px;
}

.navibackd_over {
	font-family: "Arail";
	text-decoration: none;
	font-weight: bold;
	color: #004454;
}

.navibackdA_out {
	font-family: "Arail";
	text-decoration: none;
	font-weight: bold;
	color: #FFFFFF;
}

.navibackdB_out {
	font-family: "Arail";
	text-decoration: none;
	font-weight: bold;
	color: #747474;
}

.d_over {
	font-family: "Arail";
	font-weight: bold;
	font-size: 13px;
	color: #51C2EE;
}

.d_out {
	font-family: "Arail";
	font-weight: normal;
	font-size: 13px;
	color: #999999;
}

.styleTitle {
	font-family: "汉仪大宋简";
	font-size: 45px;
	color: #024999;
}

.styleTitleEN {
	font-family: "Arial";
	font-weight: normal;
	font-size: 43px;
	color: #01A0FC;
}
</style>
</head>
 
<body>

<div id="LoadingStatus" style="background:red;color:#fff;float:right;width:100px;display:none;border:1px solid #000;z-index:1000;">LOADING......</div>

<div id="msg" style="border:1px solid #ccc"></div>

<div><input type="button" value="Get" id="getBtn"></div>
<script language="JavaScript">
<!--
function myajax(ajaxurl,para){
$('#LoadingStatus').show();//显示进度条
$.ajax({
 url: ajaxurl,
 type: 'POST',
 dataType: 'html',
 timeout: 20000,//超时时间设定
 data:para,//参数设置
 error: function(){alert('error');$('#LoadingStatus').hide(2000);},//错误处理，隐藏进度条
 success: function(html){
  //加载成功处理
  $('#LoadingStatus').hide(2000);
  $('#msg').html(html);
 }
});
}
var ajaxurl='http://web337788.host89.chinajsp.net/news.jsp';
var para='&showEditorContent.do?menuId=c002';
$("#getBtn").click(function(){myajax(ajaxurl,para);});//绑定
</script>



</body>
</html>

