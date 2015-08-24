<%@ page language="java" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html:html lang="true">
<head>
	<html:base />
	<title>ESAD������Ĳ���</title>
	<meta content="text/html; charset=utf-8" http-equiv="content-type" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor.js"></script>
	<script src="<%=request.getContextPath()%>/sample.js" type="text/javascript"></script>
	<link href="<%=request.getContextPath()%>/sample.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easy_validator.pack.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.bgiframe.min.js" ></script>
<script type="text/javascript">
$(function(){
	$("[name='cb']").each(function(){
		$(this).addClass("input_validation-failed");
	});
	
});
</script>

<link  href="<%=request.getContextPath()%>/css/validate.css" rel="stylesheet" type="text/css" />
	
	<style type="text/css">
.tdcolor {
	background-color: #F3F3F3
}
</style>

</head>
<body class="tdcolor">

	<h1>
		��д�����²���
	</h1>

	<div id="alerts">
		<noscript>
		</noscript>
	</div>
	<html:form action="submitBlogEditorBack" method="post">
		<p>
			<label for="editor1">
				���±���:
			</label>
			<br />
			CN:
			<input name="blogtitle" type="text" value="" size="100" id="blogtitle" />
			<br />
			EN:
			<input name="blogtitleen" type="text" value="" size="100" id="blogtitleen" />
		</p>
		<p>
		<span>
			<label for="editor1">
				��������:
			</label>
			<br />

			<input type="hidden" name="id" value="" />
			
			<select name="categories">
				<option value="c001">
					���ںϳ�
				</option>
				<option value="c0021">
					�ϳ�����--���Ŷ�̬
				</option>
				<option value="c0022">
					�ϳ�����--�Ļ��
				</option>
				<option value="c003">
					�滮���������
				</option>
				<option value="c0041">
					�����������--��ҵ����
				</option>
				<option value="c0042">
					�����������--���彨��
				</option>
				<option value="c0043">
					�����������--�칫����
				</option>
				<option value="c0044">
					�����������--�Ƶ꽨��
				</option>
				<option value="c0045">
					�����������--ҽԺ����
				</option>
				<option value="c0111" >�������--�칫�ռ�</option>
				<option value="c0112" >�������--��ҵ�ռ�</option>
				<option value="c0113" >�������--�Ļ��ռ�</option>
				<option value="c0114" >�������--�������ֿռ�</option>
				<option value="c0115" >�������--���ݾƵ꼰�����ռ�</option>
				<option value="c0116" >�������--��ס�ռ�</option>
				<option value="c005">
					��ס�������
				</option>
				<option value="c006">
					�������
				</option>
				<option value="c007">
					�������
				</option>
				<option value="c008">
					����о�
				</option>
				<option value="c009">
					��ӭ����
				</option>
				<option value="c010">
					��ҵ����
				</option>
			</select>
			</span>
			<span>
			<select name="delflg" >
					<option value="0">��ʾ�ҵĲ���</option>
					<option value="1">�ݲ���ʾ�ҵĲ���</option>     
	   		</select>
	   		
	   		
		</span>
		</p>
<p>
			<label for="editor1">
				�����������ڵڼ�λ��ʾ:
			</label>
			<br />
			<select name="topvalue">
				<option value="0">
					����������
				</option>
				<option value="1">
					��һλ
				</option>
				<option value="2">
					�ڶ�λ
				</option>
				<option value="3">
					����λ
				</option>
				<option value="4">
					����λ
				</option>
				<option value="5">
					����λ
				</option>
				<option value="6">
					����λ
				</option>
				<option value="7">
					����λ
				</option>
				<option value="8">
					�ڰ�λ
				</option>
				<option value="9">
					�ھ�λ
				</option>
				<option value="10">
					��ʮλ
				</option>
			</select>

		</p>
		<p>

			<label for="editor1">
				��������:
			</label>
			<br />
			
			
			<textarea name="blogcontent" id="blogcontent"></textarea>
			
			<script type="text/javascript">
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
	//�������Լ��Ĵ����ļ�/ͼƬ�ϴ���ҳ��URL
	var uploadUrl = "<%=request.getContextPath()%>/uploadsFiles.jsp"; 

	var imgUrl = window.showModalDialog(uploadUrl,null,"dialogWidth:360px;dialogHeight:120px;help:no;status��no");

	var urlObj = document.getElementById(theURLElementId);

	urlObj.value = imgUrl;
	//����url�ı����onchange�¼����Ա�Ԥ��ͼƬ
	urlObj.fireEvent("onchange"); 

}
</script>
		</p>
		<p>
			<html:submit value="ȷ�Ϸ���" />
		</p>
		<input type="hidden" name="ctrlback" value="sub" />
	</html:form>

	<div id="footer">
		<hr />
		<p>

		</p>
	</div>
</body>
</html:html>
