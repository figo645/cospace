<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<HTML>
	<HEAD>
		<TITLE>Co-space合城后台管理</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<link href="css/index.css" rel="stylesheet" type="text/css">
		<SCRIPT>
function findObj(theObj, theDoc)
{
  var p, i, foundObj;
 
  if(!theDoc) theDoc = document;
  if( (p = theObj.indexOf("?")) > 0 && parent.frames.length)
  {
    theDoc = parent.frames[theObj.substring(p+1)].document;
    theObj = theObj.substring(0,p);
  }
  if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj];
  for (i=0; !foundObj && i < theDoc.forms.length; i++)
    foundObj = theDoc.forms[i][theObj];
  for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++)
    foundObj = findObj(theObj,theDoc.layers[i].document);
  if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);
 
  return foundObj;
}
</SCRIPT>
		<style type="text/css">
<!--
body {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	MARGIN: 0px;
	BORDER-LEFT: 0px;
	BORDER-BOTTOM: 0px;
	font-size: 9pt;
	text-decoration: none;
	margin-top: 0px;
}

.ctrlbar {
	background-color: #D4D0C8;
}

.explorer {
	BORDER-RIGHT: 1px inset;
	BORDER-TOP: 1px inset;
	BORDER-LEFT: 1px inset;
	BORDER-BOTTOM: 1px inset;
	BACKGROUND-COLOR: #ffffff
}

.ctbutton {
	BORDER-TOP-WIDTH: 1px;
	BORDER-LEFT-WIDTH: 1px;
	FONT-SIZE: 8px;
	BORDER-BOTTOM-WIDTH: 1px;
	MARGIN-BOTTOM: 100px;
	WIDTH: 8px;
	FONT-FAMILY: "Arial Narrow";
	HEIGHT: 100px;
	BACKGROUND-COLOR: #eeeeee;
	BORDER-RIGHT-WIDTH: 1px
}
-->
</style>
	</HEAD>
	<BODY>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=200 id=menubar class=explorer>
						<IFRAME id=menuframe name=menuframe src="Left.jsp" frameBorder=0
							width="100%" height="100%"></IFRAME>
					</TD>
					<TD class=ctrlbar width=1>
						<BUTTON
							onmouseup="with(findObj('menubar').style){display=display=='none'?'':'none';this.innerText=display=='none'?'>':'<'}"
							class=ctbutton onMouseOver="this.style.backgroundColor='#ffffff'"
							onfocus=blur(); onmouseout="this.style.backgroundColor='#eeeeee'">
							&lt;
						</BUTTON>
					</TD>

					<TD class=explorer>
						<IFRAME id=browserframe name=browserframe src="listblog.jsp"
							frameBorder=0 width="100%" height="100%"></IFRAME>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</BODY>
</HTML>
