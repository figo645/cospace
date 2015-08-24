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
	<title>ESAD修改您的博客</title>	
	
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
		修改您的新博客
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
				文章标题:</label><br />
			CN:
			<input name="blogtitle" type="text" value="${subBlogForm.blogtitle}" size="100" id="blogtitle" />
			<br />
			EN:
			<input name="blogtitleen" type="text" value="${subBlogForm.blogtitleen}" size="100" id="blogtitleen" />	
		</p>
		<p>
		<span>
		<label for="editor1">
				文章种类:</label><br />
		<bean:define id="categoryId" name="subBlogForm" property="categories"></bean:define>
		<html:select name="subBlogForm" property="categories" value="${categoryId}" >                
        	<html:option value="c001" >关于合城</html:option>
			<html:option value="c0021">合城新闻--新闻动态</html:option>
			<html:option value="c0022">合城新闻--文化活动</html:option>
			<html:option value="c003" >规划及城市设计</html:option>
			<html:option value="c0041" >公共建筑设计--商业建筑</html:option>
			<html:option value="c0042" >公共建筑设计--文体建筑</html:option>
			<html:option value="c0043" >公共建筑设计--办公建筑</html:option>
			<html:option value="c0044" >公共建筑设计--酒店建筑</html:option>
			<html:option value="c0045" >公共建筑设计--医院建筑</html:option>
			<html:option value="c0111" >室内设计--办公空间</html:option>
			<html:option value="c0112" >室内设计--商业空间</html:option>
			<html:option value="c0113" >室内设计--文化空间</html:option>
			<html:option value="c0114" >室内设计--休闲娱乐空间</html:option>
			<html:option value="c0115" >室内设计--宾馆酒店及餐饮空间</html:option>
			<html:option value="c0116" >室内设计--居住空间</html:option>
			<html:option value="c005" >居住建筑设计</html:option>
			<html:option value="c006" >景观设计</html:option>
			<html:option value="c007" >室内设计</html:option>
			<html:option value="c008" >设计研究</html:option>
			<html:option value="c009" >欢迎加盟</html:option>
			<html:option value="c010" >企业联盟</html:option>
   		</html:select>
		</span>
		<span>
		<bean:define id="delflgId" name="subBlogForm" property="delflg"></bean:define>
		<html:select name="subBlogForm" property="delflg" value="${delflgId}" >           
			<html:option value="0" >显示我的博客</html:option>
			<html:option value="1" >暂不显示我的博客</html:option>
   		</html:select>
   		
		</span>
		</p>
		<p>
		<bean:define id="topvalueId" name="subBlogForm" property="topvalue"></bean:define>
			<label for="editor1">
				博客期望排在第几位显示:
			</label>
			<br />
			<html:select name="subBlogForm" property="topvalue" value="${topvalueId}">
				<html:option value="0">
					按正常排序
				</html:option>
				<html:option value="1">
					第一位
				</html:option>
				<html:option value="2">
					第二位
				</html:option>
				<html:option value="3">
					第三位
				</html:option>
				<html:option value="4">
					第四位
				</html:option>
				<html:option value="5">
					第五位
				</html:option>
				<html:option value="6">
					第六位
				</html:option>
				<html:option value="7">
					第七位
				</html:option>
				<html:option value="8">
					第八位
				</html:option>
				<html:option value="9">
					第九位
				</html:option>
				<html:option value="10">
					第十位
				</html:option>
			</html:select>

		</p>
		<p>
		
			<label for="editor1">
				文章内容:</label><br />
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

				label : '上传文件',

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

	var uploadUrl = "<%=request.getContextPath()%>/uploadsFiles.jsp"; //这是我自己的处理文件/图片上传的页面URL

	var imgUrl = window.showModalDialog(uploadUrl,null,"dialogWidth:360px;dialogHeight:120px;help:no;status：no");

		//open(uploadUrl,
		//'图片上载',
		//'height=100,width=400,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');  
	
	//window.open(uploadUrl,"图片上载");
	

	//在upload结束后通过js代码window.returnValue=...可以将图片url返回给imgUrl变量。
	
	//更多window.showModalDialog的使用方法参考

	var urlObj = document.getElementById(theURLElementId);

	urlObj.value = imgUrl;

	urlObj.fireEvent("onchange"); //触发url文本框的onchange事件，以便预览图片

}
			//]]>
			</script>
		</p>
		<p>
			<html:submit value="确认修改" />
		</p>
	</html:form>
	
	<div id="footer">
		<hr />
		<p>
			
		</p>
	</div>
</body>
</html:html>
