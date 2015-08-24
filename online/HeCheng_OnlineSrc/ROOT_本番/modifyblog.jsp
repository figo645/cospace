<%@ page language="java" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="java.util.*" %> 
<%@ page import="grass.tree.action.*" %> 
<%@ page import="grass.tree.form.*" %> 
<%@ page import="grass.tree.hibernate.*" %> 

<%
String path = request.getContextPath();
String pathURL = request.getPathInfo();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!--
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html:html lang="true">
  <head>
    <html:base />
	<title>ESAD�޸����Ĳ���</title>	
	
	<meta content="text/html; charset=utf-8" http-equiv="content-type" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor.js"></script>
	<script src="<%=request.getContextPath()%>/sample.js" type="text/javascript"></script>
	<link href="<%=request.getContextPath()%>/sample.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easy_validator.pack.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript">
$(function(){
	$("[name='cb']").each(function(){
		$(this).addClass("input_validation-failed");
	});
	
});
</script>
	
	<style type="text/css">
	.tdcolor {background-color:#F3F3F3}
	</style>
</head>
<body class="tdcolor">
	<h1>
		�޸������²���
	</h1>
	
	<div id="alerts">
		<noscript>
		</noscript>
	</div>
	<bean:define id="subBlogForm" name="subBlogForm"></bean:define>
	<bean:define id="blogId" name="blogId"></bean:define>
	<html:form action="blogEditClose" method="post">
	<input type="hidden" name="blogId" value="${blogId}" />
 		<p>
		<label for="editor1">
				���±���:</label><br />
			CN:
			<input name="blogtitle" type="text" value="${subBlogForm.blogtitle}" size="100" id="blogtitle" />
			<br />
			EN:
			<input name="blogtitleen" type="text" value="${subBlogForm.blogtitleen}" size="100" id="blogtitleen" />	
		</p>
		<p>
		<span>
		<label for="editor1">
				��������:</label><br />
		<bean:define id="categoryId" name="subBlogForm" property="categories"></bean:define>
		<html:select name="subBlogForm" property="categories" value="${categoryId}" >                
        	<html:option value="c001" >���ںϳ�</html:option>
			<html:option value="c0021">�ϳ�����--���Ŷ�̬</html:option>
			<html:option value="c0022">�ϳ�����--�Ļ��</html:option>
			<html:option value="c003" >�滮���������</html:option>
			<html:option value="c0041" >�����������--��ҵ����</html:option>
			<html:option value="c0042" >�����������--���彨��</html:option>
			<html:option value="c0043" >�����������--�칫����</html:option>
			<html:option value="c0044" >�����������--�Ƶ꽨��</html:option>
			<html:option value="c0045" >�����������--ҽԺ����</html:option>
			<html:option value="c0111" >�������--�칫�ռ�</html:option>
			<html:option value="c0112" >�������--��ҵ�ռ�</html:option>
			<html:option value="c0113" >�������--�Ļ��ռ�</html:option>
			<html:option value="c0114" >�������--�������ֿռ�</html:option>
			<html:option value="c0115" >�������--���ݾƵ꼰�����ռ�</html:option>
			<html:option value="c0116" >�������--��ס�ռ�</html:option>
			<html:option value="c005" >��ס�������</html:option>
			<html:option value="c006" >�������</html:option>
			<html:option value="c007" >�������</html:option>
			<html:option value="c008" >����о�</html:option>
			<html:option value="c009" >��ӭ����</html:option>
			<html:option value="c010" >��ҵ����</html:option>
   		</html:select>
		</span>
		<span>
		<bean:define id="delflgId" name="subBlogForm" property="delflg"></bean:define>
		<html:select name="subBlogForm" property="delflg" value="${delflgId}" >           
			<html:option value="0" >��ʾ�ҵĲ���</html:option>
			<html:option value="1" >�ݲ���ʾ�ҵĲ���</html:option>
   		</html:select>
   		
		</span>
		</p>
		<p>
		<bean:define id="topvalueId" name="subBlogForm" property="topvalue"></bean:define>
			<label for="editor1">
				�����������ڵڼ�λ��ʾ:
			</label>
			<br />
			<html:select name="subBlogForm" property="topvalue" value="${topvalueId}">
				<html:option value="0">
					����������
				</html:option>
				<html:option value="1">
					��һλ
				</html:option>
				<html:option value="2">
					�ڶ�λ
				</html:option>
				<html:option value="3">
					����λ
				</html:option>
				<html:option value="4">
					����λ
				</html:option>
				<html:option value="5">
					����λ
				</html:option>
				<html:option value="6">
					����λ
				</html:option>
				<html:option value="7">
					����λ
				</html:option>
				<html:option value="8">
					�ڰ�λ
				</html:option>
				<html:option value="9">
					�ھ�λ
				</html:option>
				<html:option value="10">
					��ʮλ
				</html:option>
			</html:select>

		</p>
		<p>
		
			<label for="editor1">
				��������:</label><br />
			<html:textarea property="blogcontent" name="subBlogForm" styleClass="ckeditor">
			</html:textarea>
			<script type="text/javascript">
			//<![CDATA[

				CKEDITOR.replace('blogcontent', addUploadButton(this));

function addUploadButton(editor) {

	CKEDITOR.on('dialogDefinition', function(ev) {

		var dialogName = ev.data.name;

		var dialogDefinition = ev.data.definition;

		if (dialogName == 'image') {

			var infoTab = dialogDefinition.getContents('info');

			infoTab.add( {

				type : 'button',

				id : 'upload_image',

				align : 'center',

				label : '�ϴ��ļ�',

				onClick : function(evt) {

					var thisDialog = this.getDialog();

					var txtUrlObj = thisDialog.getContentElement('info',
							'txtUrl');

					var txtUrlId = txtUrlObj.getInputElement().$.id;

					addUploadImage(txtUrlId);

				}

			}, 'browse'); //place front of the browser button

		}

	});

}

function addUploadImage(theURLElementId) {

	var uploadUrl = "<%=request.getContextPath()%>/uploadsFiles.jsp"; //�������Լ��Ĵ����ļ�/ͼƬ�ϴ���ҳ��URL

	var imgUrl = window.showModalDialog(uploadUrl,null,"dialogWidth:360px;dialogHeight:120px;help:no;status��no");

		//open(uploadUrl,
		//'ͼƬ����',
		//'height=100,width=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');  
	
	//window.open(uploadUrl,"ͼƬ����");
	

	//��upload������ͨ��js����window.returnValue=...���Խ�ͼƬurl���ظ�imgUrl������
	
	//����window.showModalDialog��ʹ�÷����ο�

	var urlObj = document.getElementById(theURLElementId);

	urlObj.value = imgUrl;

	urlObj.fireEvent("onchange"); //����url�ı����onchange�¼����Ա�Ԥ��ͼƬ

}
			//]]>
			</script>
		</p>
		<p>
			<html:submit value="ȷ���޸�" />
		</p>
	</html:form>
	
	<div id="footer">
		<hr />
		<p>
			
		</p>
	</div>
</body>
</html:html>
