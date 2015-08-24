<%@ page language="java" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>上传您的图片</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery.js"></script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.tdcolor {
	background-color: #F3F3F3
}
	</style>
	
		<script type="text/javascript">
function onclickUpload() {
	//var fileUrl = document.getElementById("uploadFile");
	//window.returnValue = fileUrl.value;
}
</script>
	</head>

	<body class="tdcolor">
		<iframe name="smz" width="0" height="0" frameborder="0"
			style="display: none"></iframe>

		<form action="./uploadClose.do" method="POST"
			enctype="multipart/form-data" target="smz">
  <p style="font-size: 14px;">图片上传完毕后会自动关闭本窗口，请耐心等待...</p>  
    		<input type="file" name="uploadFile" id="file">
			<input type="hidden" name="type" id="type" value=".jpg">
			<html:submit value="上传图片" />
		</form>
		<input type="hidden" name="pagePath" id="_page_path"
			value="<%String p = (String) session.getAttribute("pagePath");
			if (p != null)
				out.print(p);
			session.removeAttribute("pagePath");%>" />
		<script type="text/javascript">
var _page_path = $('#_page_path').attr("value");
if (null != _page_path && "" != _page_path) {
	window.returnValue = _page_path;
	window.close();
}
function Submit() {
	$('#type').attr("value") = $('#uploadFile').attr("value");
}
</script>

	</body>
</html>
