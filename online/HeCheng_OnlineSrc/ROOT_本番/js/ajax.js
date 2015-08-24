var xmlHttp;

function GetXmlHttpObject() {
	var xmlHttp = null;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}

function ajaxFunction(blogId) {
	//alert(blogId);
	xmlHttp = GetXmlHttpObject();
	xmlHttp.onreadystatechange = stateChanged;
	xmlHttp.open("POST", "./showBlogAjax.do?blogId=" + blogId, true);
	xmlHttp.send(null);
}

function stateChanged() {

	//if (xmlHttp.readyState == 0) {
	//	document.getElementById("rightdiv").innerHTML = "<p>δ��ʼ��</p>"
	//}
	//if (xmlHttp.readyState == 1) {
	//	document.getElementById("rightdiv").innerHTML = "<p>���������Է��ͣ����Ե�</p>"
	//}
	//if (xmlHttp.readyState == 2) {
	//	document.getElementById("rightdiv").innerHTML = "<p>���ڵȴ�������Ӧ.</p>"
	//}
	//if (xmlHttp.readyState == 3) {
	//	document.getElementById("rightdiv").innerHTML = "<p>�������ڴ�����</p>"
	//}
	if (xmlHttp.readyState == 4) {
	document.getElementById("rightdiv").innerHTML = xmlHttp.responseText;
	}
}



