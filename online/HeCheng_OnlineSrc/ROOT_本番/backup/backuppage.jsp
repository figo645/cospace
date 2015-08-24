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
	<title>ESAD系统备份与还原</title>
	<meta content="text/html; charset=utf-8" http-equiv="content-type" />
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
		系统备份与还原
	</h1>

	<div id="alerts">
		<noscript>
		</noscript>
	</div>

	<p>
		<br />
		友情提示：<br />
		本功能请无比小心使用，备份完毕后，请妥善保管好您的备份数据，以便之后的还原。<br />
		系统备份说明：<br />
		1）点选画面中间的备份数据库按钮<br />
		2）当系统弹出选项时，选择【保存】，将至放置本地最为安全的目录中，以备管理<br />
		3）备份数据完了<br />
		<html:form action="dobackupDB">
		<input type="submit" name="backup" value="备份数据库" size="10"/>
		</html:form>
		<br />
		<br />
		系统还原说明：<br />
		1）点选【系统还原】之后，画面会提示你选中自己备份的文件<br />
		2）选中文件之后会提示您是否需要还原（可能会影响到现有数据）<br />
		3）选择确认之后便完成了数据的还原<br />
		 <script language="javascript" type="text/javascript">
		   function xd(oForm)
		   {     
		     var ext = "*.sql";
		     s = oForm.uploadFile.value;
		     s = s.substr(s.lastIndexOf("."));  
		     if(ext.indexOf("*"+s)==-1)     
		     {  
		       alert("不允许"+s);
		       return false;
		     }
			 else{
			 	if(confirm("是否需要还原（可能会影响到现有数据）?")){
					return true;
				}else{ return false;
				} 			 
			 }
		   }
		 </script> 
		<html:form action="dorestoreDB" enctype="multipart/form-data" onsubmit="return xd(this)">
		<html:file property="uploadFile"></html:file>
		<input type="submit" name="restore" value="   系统还原    " size="10"/>
		</html:form>
		<br />
	</p>
	
	



	<p>


	</p>
	<p>
	</p>



</body>
</html:html>
