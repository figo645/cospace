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
	//	document.getElementById("rightdiv").innerHTML = "<p>未初始化</p>"
	//}
	//if (xmlHttp.readyState == 1) {
	//	document.getElementById("rightdiv").innerHTML = "<p>您的请求以发送，请稍等</p>"
	//}
	//if (xmlHttp.readyState == 2) {
	//	document.getElementById("rightdiv").innerHTML = "<p>正在等待请求响应.</p>"
	//}
	//if (xmlHttp.readyState == 3) {
	//	document.getElementById("rightdiv").innerHTML = "<p>请求正在处理中</p>"
	//}
	if (xmlHttp.readyState == 4) {
	document.getElementById("rightdiv").innerHTML = xmlHttp.responseText;
	}
}



