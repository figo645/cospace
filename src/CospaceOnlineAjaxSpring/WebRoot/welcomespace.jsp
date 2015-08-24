<%@ page contentType="text/html;charset=GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html lang="true">
<head>
	<html:base />
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<title>Co-space欢迎加盟</title>
	<jsp:include page="./header.jsp"></jsp:include>
	


</head>
<body onload="resize();" onresize="resize();">
<div class="bodycontent">
<div class="maincontent">
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="116">
				<table border="0" class="framewidth" height="116" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="308" rowspan="2" class="leftgray">
							<img name="news_r1_c1" src="images/welcome_r2_c1.jpg" width="308"
								height="116" border="0" id="news_r1_c1" alt="" />
						</td>
						<td rowspan="2">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						 <tr>
						 <td width="65"></td>
						 <td>
							<p align="left">
								<!-- 顶部的灰色二级MENU -->
								<jsp:include page="./tablenoframehandler.jsp"></jsp:include>
							</p>
							</td>
							</tr>
							</table>
						</td>
						<tr>
				</table>
			</td>
		</tr>

		<tr>
			<td>
				<table border="0" class="content" cellpadding="0" cellspacing="0">
					<tr>
						<td rowspan="2" width="308" class="leftgray">
							<table border="0" width="100%" cellpadding="0" cellspacing="0">
								<tr>
									<td colspan="3" height="5">
										&nbsp;
									</td>
								</tr>
								<!-- == BLUE TITLE ABOVE THE MENU== -->
								<tr>
								<td width="41" ></td>
									<td colspan="2">
										<span class="titleleft">
											&nbsp;</span>
									</td>
								</tr>
								<tr>
									<td width="41" rowspan="3">
										&nbsp;
									</td>
									<td colspan="2">
										<div id="leftdiv" class="leftdiv">
											<table border="0" height="inherit" cellpadding="0"
												cellspacing="0">
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
<!-- ===MENU==== -->
												<logic:notEmpty name="menuLst">
													<logic:iterate id="blogMasterObj" name="menuLst"
														indexId="blogIdx">
														<tr>
															<td>
															<bean:define id="blogFormId"  name="subBlogForm" property="id" />
															<script type="text/javascript">
															ajaxFunction(${subBlogForm.id});
															</script>
																<html:link action="/showWelcome"
																	paramId="blogId" paramName="blogMasterObj"
																	paramProperty="blogid" style="text-decoration:none;"
																	styleClass="d_out"
																	onclick="lightMenu(this);ajaxFunction(${blogMasterObj.blogid});return false;">
		<%=blogIdx+1%>&nbsp;<bean:write name="blogMasterObj"
																		property="title" />
																</html:link>
															
														</tr>
														<tr>
															<td height="10"></td>
														</tr>
													</logic:iterate>
												</logic:notEmpty>

											</table>
										</div>
									</td>
								</tr>
								
							</table></td>
						<!-- ==BLOG CONTENT== -->
						<td width="64">&nbsp;</td>
						<td>
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr><td height="46"></td></tr>
						<tr><td>
						<div id="rightdiv" class="rightdiv">
								<table border="0" width="102%" cellpadding="0"
									cellspacing="0">
									<logic:notEmpty name="subBlogForm">

										<tr>
											<td align="right" valign="bottom" class="styleTitle">
												<bean:write name="subBlogForm" property="blogtitle" />&nbsp;</td>
											<td width="50">&nbsp;</td>
										</tr>
										<tr>
											<td align="right" valign="top" class="styleTitleEN">
												<bean:write name="subBlogForm" property="blogtitleen" />&nbsp;&nbsp;&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</logic:notEmpty>
									<tr>
										<td align="center" valign="top">
											<logic:notEmpty name="subBlogForm">
												<bean:write name="subBlogForm" property="blogcontent"
													filter="false" />
											</logic:notEmpty>
										</td>
										<td>&nbsp;</td>
									</tr>
								</table>
							</div></td></tr>
						</table>
						
							</td>
							<tr>
				</table>
			</td>
		</tr>
	</table>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
	</div>
</body>
</html:html>

