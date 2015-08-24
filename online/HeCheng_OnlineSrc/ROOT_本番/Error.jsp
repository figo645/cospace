<%@ page language="java" pageEncoding="GBK"%>
<%@ page isErrorPage="true" import="java.io.*"%>
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
	<title>出错啦</title>
	<meta content="text/html; charset=utf-8" http-equiv="content-type" />
	<style type="text/css">
.tdcolor {
	background-color: #F3F3F3
}
</style>
</head>
<body class="tdcolor">
	<h1>
		您的程序或者服务器有错误，请及时与管理员取得联系
	</h1>

	<div id="alerts">
		<noscript>
		</noscript>
	</div>

	<table border="1" cellpadding="0" cellspacing="0">
		<tr bgcolor="#C8D0D5">
			<td width="800">
				发生日时
			</td>
		</tr>
		<tr>
			<td><%=new Date()%></td>
		</tr>
		<tr bgcolor="#C8D0D5">
			<td width="800">
				错误原因
			</td>
		</tr>
		<tr>
			<td>
				<div style="height: 500px; width: 800px; overflow: scroll;">
				<logic:notEmpty name="errorMessage">
					<bean:write name="errorMessage"/>
					</logic:notEmpty>
				</div>
			</td>
		</tr>
		<tr bgcolor="#C8D0D5">
			<td width="800">
				解决方法
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>

</body>
</html:html>
