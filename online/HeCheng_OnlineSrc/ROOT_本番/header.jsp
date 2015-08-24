<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<noscript>
	<iframe src="*.jsp"></iframe>
</noscript>



<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/cospace.js">
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ajax.js">
</script>
<link href="<%=request.getContextPath()%>/css/cospace.css" rel="stylesheet"
	type="text/css" />
<link href="<%=request.getContextPath()%>/css/font.css" rel="stylesheet"
	type="text/css" />

<div id="fontdiv">
</div>




<script type="text/javascript">
checkBrowser();
</script>
<!--ÆÁ±ÎÍøÒ³ÓÒæI£¬ÊÊÓÃÓÚIE6,IE7,IE8,FireFox,¹È¸èChromeä¯ÀÀÆ÷ ¿ªÊ¼-->
<script type="text/javascript">
function clickIE4(){
        if (event.button==2){
                return false;
        }//end if
}//end func
 
function clickNS4(e){
        if (document.layers||document.getElementById&&!document.all){
                if (e.which==2||e.which==3){
                        return false;
                }//end if
        }//end if
}//end func
 
function OnDeny(){
        if(event.ctrlKey || event.keyCode==78 && event.ctrlKey || event.altKey || event.altKey && event.keyCode==115){
        alert("»¶Ó­ÄúÀ´ºÏ³Ç");
        return false;
        }//end if
}
 
if (document.layers){
        document.captureEvents(Event.MOUSEDOWN);
        document.onmousedown=clickNS4;
        document.onkeydown=OnDeny();
}else if (document.all&&!document.getElementById){
        document.onmousedown=clickIE4;
        document.onkeydown=OnDeny();
}//end if
 
document.oncontextmenu=new Function("return false");
</script>
<!--ÆÁ±ÎÍøÒ³ÓÒæI£¬ÊÊÓÃÓÚIE6,IE7,IE8,FireFox,¹È¸èChromeä¯ÀÀÆ÷ ½áÊø-->
