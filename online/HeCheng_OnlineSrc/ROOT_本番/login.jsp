<%@ page contentType="text/html;charset=GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>ESAD客户自服务系统</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 14px;
	font-weight: bold;
}
-->
</style>

<script type="text/javascript" src="images/common.js"></script>
<link href="images/default.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery.js"></script>
 
</head><body>
<div id="result" style="color: red; "></div>

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
<link  href="<%=request.getContextPath()%>/css/validate.css" rel="stylesheet" type="text/css" />

<table align="center" border="0" cellpadding="0" cellspacing="0" width="370">
  <tbody><tr>
    <td height="8"></td>
  </tr>
</tbody></table>

  <table align="center" border="0" cellpadding="0" cellspacing="0" width="370">
  <tbody><tr>
    <td colspan="3" height="1"></td>
  </tr>
  <tr>
    <td width="1"></td>
    <td align="center" width="370" height="244">
    <html:form action="/logIn" method="post">
      <table border="0" cellpadding="0" cellspacing="0" width="370">
        <tbody><tr>
          <td colspan="4" height="12"><font color="#ff0000"></font></td>
        </tr>
        
        <tr>
          <td width="23" height="13">&nbsp;</td>
          <td width="80" height="13">&nbsp;</td>
          <td colspan="2" height="30">&nbsp;</td>
        </tr>
       
        <tr>
          <td width="22" height="13">&nbsp;</td>
          <td width="77" height="13"><font color="#723b00">帐号：</font></td>
          <td colspan="2" height="30">
            <input size="20" id="userinputname" name="username"  reg="^\w+$" tip="用户名不能为空">
          </td>
        </tr>
        <tr>
          <td width="22" height="25">&nbsp;</td>
          <td width="77" height="25"><font color="#723b00">密码：</font></td>
          <td colspan="2" height="30">
            <input size="20" name="passwords" type="password"  reg="^\w+$" tip="密码不能为空">
          </td>
        </tr>
	
	<tr>
          <td width="22" height="25">&nbsp;</td>
          <td width="77" height="25">&nbsp;</td>
          <td colspan="2" height="25">
            &nbsp;
          </td>
        </tr>
        <tr>
          <td width="22" height="49">&nbsp;</td>
          <td width="77" height="49">&nbsp;</td>
          <td colspan="2" height="49">
            <input value=" 登 录 " id="send_ajax" name="ajax" type="submit"/>
            <input value=" 重 置 " type="reset"/>
          </td>
        </tr>

      </tbody></table>
	  </html:form>


</td>
<td bgcolor="#baa05f" width="1"></td>
</tr>
<tr>
  <td colspan="3" bgcolor="#baa05f" height="1"></td>
</tr>
</tbody></table><table align="center" border="0" cellpadding="0" cellspacing="0" width="370">
  <tbody><tr>
    <td align="center" height="55"><br>
      <br>
      <br>
    </td>
  </tr>
</tbody></table>
</body></html>