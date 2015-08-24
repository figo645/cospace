<%@ page language="java" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="java.util.*"%>
<%@ page import="grass.tree.action.*"%>
<%@ page import="grass.tree.form.*"%>
<%@ page import="grass.tree.hibernate.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html:html lang="true">
<head>
	<html:base />
	<title>ESAD添加您的博客</title>
	<meta content="text/html; charset=utf-8" http-equiv="content-type" />
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ckeditor.js">
	</script>
	<script src="<%=request.getContextPath()%>/sample.js"
		type="text/javascript">
	</script>
	<link href="<%=request.getContextPath()%>/sample.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js">
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/easy_validator.pack.js">
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery.bgiframe.min.js">
	</script>
	<script type="text/javascript">
$(function() {
	$("[name='cb']").each(function() {
		$(this).addClass("input_validation-failed");
	});

});

function mycheckbox() {
var falg = 0;
$("input[name='delflg']:checkbox").each(function () {
if ($(this).attr("checked")) {
falg +=1;
}
})
if (falg > 0){
return true;
}
else{
alert("请选中您要删除的项目");
return false;
}
}


function selectAll() {
var falg = 0;
$("input[name='delflg']:checkbox").each(function () {
if ($(this).attr("checked")) {
$(this).removeAttr("checked");
}
else{
$(this).attr("checked",'true');
}
})

}
</script>
	<link href="<%=request.getContextPath()%>/css/validate.css"
		rel="stylesheet" type="text/css" />
	<style type="text/css">
.tdcolor {
	background-color: #F3F3F3
}
</style>
</head>
<logic:notEmpty name="blogListFormTmp">
<bean:define id="blogListForm" name="blogListFormTmp"></bean:define>
</logic:notEmpty>
<body class="tdcolor">
	<h1>
		文章种类
	</h1>

	<div id="alerts">
		<noscript>
		</noscript>
	</div>

	<p>
		<br />
	</p>
	<html:form action="blogDel">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr bgcolor="#C8D0D5">
				<td>
					<input type="checkbox" name="ctrlflg" id="ctrlflg" onclick="selectAll();"/>
				</td>
				<td width="250">
					发布日期
				</td>
				<td width="100">
					优先顺序
				</td>
				<td width="800">
					主题（中文）
				</td>
				<td width="100">
					修改
				</td>
				<td width="100">
					暂不显示
				</td>
			</tr>
			<logic:notEmpty name="blogListForm">
				<logic:iterate id="blogObject" name="blogListForm"
					property="subBlogFormList" >
					<bean:define id="blogId" name="blogObject" property="id"></bean:define>
					<bean:define id="blogFlg" name="blogObject" property="delflg"></bean:define>
					<tr>
						<td>
							<input type="checkbox" name="delflg" id="delflg" value="${blogObject.id}"/>
						</td>
						<td>
							<bean:write name="blogObject" property="createdate" />
						</td>
						<td>
							<bean:write name="blogObject" property="topvalue" />
						</td>
						<td>
							<bean:write name="blogObject" property="blogtitle" />
						</td>
						<td>
							<html:link action="blogEdit" paramId="blogId" paramName="blogId">
				修改
				</html:link>
						</td>
						<td>
						<logic:equal value="0" name="blogFlg">
							<html:link action="blogDel" paramId="blogId" paramName="blogId">
							暂不显示
							</html:link>
						</logic:equal>
						<logic:equal value="1" name="blogFlg">
							<html:link action="blogUndo" paramId="blogId" paramName="blogId">
							我要显示
							</html:link>
						</logic:equal>
						</td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
		</table>

		<p>
			<input type="submit" name="del" value="暂不显示" onclick="return mycheckbox();"/>
			<input type="submit" name="del" value="彻底删除" onclick="return mycheckbox();"/>
		</p>
	</html:form>
	<br />




	<p>


	</p>
	<p>
	</p>



</body>
</html:html>
