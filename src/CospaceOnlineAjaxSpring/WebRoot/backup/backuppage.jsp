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
	<title>ESADϵͳ�����뻹ԭ</title>
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
		ϵͳ�����뻹ԭ
	</h1>

	<div id="alerts">
		<noscript>
		</noscript>
	</div>

	<p>
		<br />
		������ʾ��<br />
		���������ޱ�С��ʹ�ã�������Ϻ������Ʊ��ܺ����ı������ݣ��Ա�֮��Ļ�ԭ��<br />
		ϵͳ����˵����<br />
		1����ѡ�����м�ı������ݿⰴť<br />
		2����ϵͳ����ѡ��ʱ��ѡ�񡾱��桿���������ñ�����Ϊ��ȫ��Ŀ¼�У��Ա�����<br />
		3��������������<br />
		<html:form action="dobackupDB">
		<input type="submit" name="backup" value="�������ݿ�" size="10"/>
		</html:form>
		<br />
		<br />
		ϵͳ��ԭ˵����<br />
		1����ѡ��ϵͳ��ԭ��֮�󣬻������ʾ��ѡ���Լ����ݵ��ļ�<br />
		2��ѡ���ļ�֮�����ʾ���Ƿ���Ҫ��ԭ�����ܻ�Ӱ�쵽�������ݣ�<br />
		3��ѡ��ȷ��֮�����������ݵĻ�ԭ<br />
		 <script language="javascript" type="text/javascript">
		   function xd(oForm)
		   {     
		     var ext = "*.sql";
		     s = oForm.uploadFile.value;
		     s = s.substr(s.lastIndexOf("."));  
		     if(ext.indexOf("*"+s)==-1)     
		     {  
		       alert("������"+s);
		       return false;
		     }
			 else{
			 	if(confirm("�Ƿ���Ҫ��ԭ�����ܻ�Ӱ�쵽�������ݣ�?")){
					return true;
				}else{ return false;
				} 			 
			 }
		   }
		 </script> 
		<html:form action="dorestoreDB" enctype="multipart/form-data" onsubmit="return xd(this)">
		<html:file property="uploadFile"></html:file>
		<input type="submit" name="restore" value="   ϵͳ��ԭ    " size="10"/>
		</html:form>
		<br />
	</p>
	
	



	<p>


	</p>
	<p>
	</p>



</body>
</html:html>
