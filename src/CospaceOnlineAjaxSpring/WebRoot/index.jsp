<%@ page contentType="text/html;charset=GBK"%>
<%@ page errorPage="Error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html lang="true">
<head>
	<html:base />
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<title>Co-space合城首页</title>
	<jsp:include page="./indexheader.jsp"></jsp:include>
	<style type="text/css">
body {
	height: 100%;
	max-height: 100%;
	overflow-y: hidden;
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

.leftdiv {
	WIDTH: 98%;
	HEIGHT: 580;
	OVERFLOW-y: scroll;
	scrollbar-face-color: #01A2F2;
	scrollbar-shadow-color: #FFFFFF;
	scrollbar-highlight-color: #FFFFFF;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: FFFFFF;
	scrollbar-arrow-color: #FFFFFF;
}

.rightdiv {
	align: "right";
	WIDTH: 97%;
	HEIGHT: 580;
	OVERFLOW-y: scroll;
	scrollbar-face-color: #01A2F2;
	scrollbar-shadow-color: #FFFFFF;
	scrollbar-highlight-color: #FFFFFF;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: FFFFFF;
	scrollbar-arrow-color: #FFFFFF;
}

.framewidth {
	width: 1260;
	width: expression(documentElement.clientWidth-30);
}

.leftgray {
	background-color: #F3F3F3;
}

.titleleft {
	font-family: "Arial";
	font-size: 18px;
	font-weight: bold;
	color: #51C2EE;
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
	text-decoration: none;
	font-weight: bold;
	font-size: 12px;
	letter-spacing: 0;
	color: #3163A8;
	word-spacing: 0px
}

.d_out {
	font-family: "Arail";
	text-decoration: none;
	font-weight: bold;
	font-size: 12px;
	letter-spacing: 0;
	color: #999999;
	word-spacing: 0px
}

.styleTitle {
	font-family: "汉仪大宋简";
	font-size: 41px;
	color: #024999;
}

.styleTitleEN {
	font-family: "Arial";
	font-weight: normal;
	font-size: 40px;
	color: #01A0FC;
}
</style>
	<script type="text/javascript">
function resize() {
	var oClientHeight = document.documentElement.scrollHeight;
	var resizeheight = oClientHeight - 116 - 30 - 454;
	document.getElementById("indexHId").style.height = resizeheight + "px";
	//alert(resizeheight);
}
</script>

</head>
<body onload="resize();" onresize="resize();">

	<div class="bodycontent">
		<div class="maincontent">
			<table border="0" cellpadding="0" cellspacing="0">

				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="116">
									<img src="images/index_r1_c1.jpg" width="400" height="116">
								</td>
							</tr>
							<tr>
								<td>
									<div id="indexHId"></div>
								</td>
							</tr>
							<tr>
								<td>
									<!--1.设置FLASH为底层-->
									<object id="Shockwaveflash9"
										classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
										codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
										height="449" width="1260"
										style="z-index: 0;">
										<param name="movie" value="swf/flash-index.swf" />
										<param name="quality" value="high" />
										<param name="wmode" value="transparent" />
										<embed src="swf/flash-index.swf"  wmode="transparent"
												type="application/x-shockwave-flash " width="1260"
												height="449">
											</embed>
									</object>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		
			<jsp:include page="./indexfooter.jsp"></jsp:include>
		
	</div>

</body>
</html:html>
