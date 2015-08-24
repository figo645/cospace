<%@ page contentType="text/html;charset=GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<meta http-equiv="Content-Language" content="gbk" />
		<title>��̨����</title>
		<style type="text/css">
body {
	margin: 0;
	text-align: center;
	color: #000;
	font: normal 12px Arial, Verdana, Tahoma;
	text-align: center;
	background: #C8D0D5;
	line-height: 150%;
}

a:link,a:visited {
	color: #385065;
	text-decoration: none
}

a:hover {
	text-decoration: underline
}

#menu {
	width: 140px;
	margin: 0px 15px;
	padding: 0px;
	text-align: left;
	list-style: none
}

#menu .item {
	margin: 5px 0px;
	padding: 0px;
	list-style: none
}

a.title:link,a.title:visited,a.title:hover {
	display: block;
	background: url(<   a href = 
		 "http://www.tblog.com.cn/attachments/month_0609/m20069110491.gif"
		target =   "_blank" >   http :// www.tblog.com.cn/ attachments/
		month_0609/ m20069110491.gif </ a >) no-repeat;
	color: #385065;
	font-weight: bold;
	padding: 2px 0 0 22px;
	width: 140px;
	line-height: 23px;
	cursor: pointer;
	text-decoration: none
}

#menu .item ul {
	border: 1px solid #9FACB7;
	margin: 0;
	width: 140px;
	padding: 3px 0px 3px 30px;
	background: #fff;
	list-style: none;
	display: none
}

#menu .item ul li {
	display: block;
}

@font-face {Left.jsp
	font-family: '���Ǵ��μ�';
	src: url('font/HYDSJ.eot');
}

.styleTitle {
	font-family: "���Ǵ��μ�";
	font-size: 30px;
	color: #024999;
}
</style>
		<script language="javascript" type="text/javascript">
// --- ��ȡClassName
document.getElementsByClassName = function(cl) {
	var retnode = [];
	var myclass = new RegExp('\\b' + cl + '\\b');
	var elem = this.getElementsByTagName('*');
	for ( var j = 0; j < elem.length; j++) {
		var classes = elem[j].className;
		if (myclass.test(classes))
			retnode.push(elem[j]);
	}
	return retnode;
}

// --- ��������
function HideAll() {
	var items = document.getElementsByClassName("optiton");
	for ( var j = 0; j < items.length; j++) {
		items[j].style.display = "none";
	}
}

// --- ����cookie
function setCookie(sName, sValue, expireHours) {
	var cookieString = sName + "=" + escape(sValue);
	//;�ж��Ƿ����ù���ʱ��
	if (expireHours > 0) {
		var date = new Date();
		date.setTime(date.getTime + expireHours * 3600 * 1000);
		cookieString = cookieString + "; expire=" + date.toGMTString();
	}
	document.cookie = cookieString;
}

//--- ��ȡcookie
function getCookie(sName) {
	var aCookie = document.cookie.split("; ");
	for ( var j = 0; j < aCookie.length; j++) {
		var aCrumb = aCookie[j].split("=");
		if (escape(sName) == aCrumb[0])
			return unescape(aCrumb[1]);
	}
	return null;
}

window.onload = function() {
	var show_item = "opt_1";
	if (getCookie("show_item") != null) {
		show_item = "opt_" + getCookie("show_item");
	}
	document.getElementById(show_item).style.display = "block";
	var items = document.getElementsByClassName("title");
	for ( var j = 0; j < items.length; j++) {
		items[j].onclick = function() {
			var o = document.getElementById("opt_" + this.name);
			if (o.style.display != "block") {
				//HideAll();
				o.style.display = "block";
				setCookie("show_item", this.name);
			} else {
				o.style.display = "none";
			}
		}
	}
}
</script>
	</head>

	<body>
		<p>&nbsp;</p>
		<p align="center" valign="bottom" class="styleTitle">
			�ϳǹ���
		</p>
		<ul id="menu">
			<li class="item">
				<a href="javascript:void(0)" class="title" name="1">������Ϣ</a>
				<ul id="opt_1" class="optiton">
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c001"></html:param>
					���ںϳ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0021"></html:param>
					�ϳ�����-���Ŷ�̬
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0022"></html:param>
					�ϳ�����-�Ļ��
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c008"></html:param>
					����о�
					</html:link>
					</li>
				</ul>
			</li>
			<li class="item">
				<a href="javascript:void(0)" class="title" name="2">��Ʒ���</a>
				<ul id="opt_2" class="optiton">
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c003"></html:param>
					�滮���������
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c005"></html:param>
					��ס�������
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c006"></html:param>
					�������
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0111"></html:param>
					�������--�칫�ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0112"></html:param>
					�������--��ҵ�ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0113"></html:param>
					�������--�Ļ��ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0114"></html:param>
					�������--�������ֿռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0115"></html:param>
					�������--���Ʋ����ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0116"></html:param>
					�������--��ס�ռ�
					</html:link>
					</li>
				</ul>
			</li>
			
			<li class="item">
			<a href="javascript:void(0)" class="title" name="3">�����������</a>
			<ul id="opt_3" class="optiton">
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0041"></html:param>
					��ҵ����
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0042"></html:param>
					���彨��
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0043"></html:param>
					�칫����
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0044"></html:param>
					�Ƶ꽨��
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0045"></html:param>
					ҽԺ����
					</html:link>
					</li>
				</ul>
			</li>
			<li class="item">
			<a href="javascript:void(0)" class="title" name="4">�������</a>
			<ul id="opt_4" class="optiton">
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0111"></html:param>
					�칫�ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0112"></html:param>
					��ҵ�ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0113"></html:param>
					�Ļ��ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0114"></html:param>
					�������ֿռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0115"></html:param>
					���ݾƵ꼰�����ռ�
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c0116"></html:param>
					��ס�ռ�
					</html:link>
					</li>
				</ul>
			</li>
			<li class="item">
				<a href="javascript:void(0)" class="title" name="5">��������</a>
				<ul id="opt_5" class="optiton">
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c009"></html:param>
					��ӭ����
					</html:link>
					</li>
					<li>
					<html:link action="listByCategory" target="browserframe">
					<html:param name="menuId" value="c010"></html:param>
					��ҵ����
					</html:link>
					</li>
				</ul>
			</li>
			<li class="item">
				<a href="javascript:void(0)" class="title" name="6">ϵͳ����</a>
				<ul id="opt_6" class="optiton">
					<li>
					<html:link forward="subblog" target="browserframe">��������</html:link>
					</li>
					<li>
					<html:link forward="backup" target="browserframe">ϵͳ�����뻹ԭ</html:link>
					</li>
					<li>
						<html:link forward="cospace" target="parent">�˳�ϵͳ</html:link>
					</li>
				</ul>
			</li>
		</ul>
	</body>
</html>