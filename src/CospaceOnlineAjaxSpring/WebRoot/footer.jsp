<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<script type="text/javascript">
<!--
lightMenuFirst();
//-->
</script>
<div class="righttop" id="righttop">
<a href='http://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&entyId=20120214221828597'><img src='images/icon.gif' border=0></a>
</div>
<div style="position:absolute;bottom: 0px;margin-bottom: 0px;float: left;">

	<table class="framewidth" style="border-collapse:collapse" height="35" border="0" cellpadding="0"
					cellspacing="0">
					<tr class="navibackfontsize">
						<td align="center" class="naviback">
							<html:link action="/listAboutMenu" styleClass="navibackdA_out"
								onmouseover="this.className='navibackd_over'"
								onmouseout="this.className='navibackdA_out'">
								<html:param name="menuId" value="c001"></html:param>
  关于合城
   </html:link>
						</td>
						<td align="center" class="naviback">

							<html:link action="/listMenu" styleClass="navibackdA_out"
								onmouseover="this.className='navibackd_over'"
								onmouseout="this.className='navibackdA_out'">
								<html:param name="menuId" value="c002"></html:param>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新闻中心
   </html:link>

						</td>
						<td align="center" class="naviback">

							<html:link action="/listMenuDesign" styleClass="navibackdA_out"
								onmouseover="this.className='navibackd_over'"
								onmouseout="this.className='navibackdA_out'">
								<html:param name="menuId" value="c003"></html:param>  
   &nbsp;&nbsp;&nbsp;作品简介
   </html:link>
						</td>
						<td align="center" class="naviback">
							<html:link action="/listResearchMenu" styleClass="navibackdA_out"
								onmouseover="this.className='navibackd_over'"
								onmouseout="this.className='navibackdA_out'">
								<html:param name="menuId" value="c008"></html:param>  
 &nbsp;&nbsp;&nbsp;设计研究
   </html:link>
						</td>
						<td align="center" class="allotherfont" bgcolor="#FFFFFF">
						<html:link action="/listWelcomeMenu" styleClass="navibackdB_out"
								onmouseover="this.className='navibackd_over'"
								onmouseout="this.className='navibackdB_out'">
								<html:param name="menuId" value="c009"></html:param>  
								欢迎加盟
						</html:link>
						</td>
						<td align="center" class="allotherfont" bgcolor="#FFFFFF">
						<html:link action="/listLeagueMenu" styleClass="navibackdB_out"
								onmouseover="this.className='navibackd_over'"
								onmouseout="this.className='navibackdB_out'">
								<html:param name="menuId" value="c010"></html:param>  
							企业联盟
						</html:link>
						</td>
						<td align="center" class="allotherfont" bgcolor="#FFFFFF">
						&nbsp;
						</td>
						<td align="left" width="280" bgcolor="#FFFFFF" class="footerstyle">
						    Copyright@2010 Co-space Design 沪ICP备10219119号
						</td>
					</tr>
				</table>

</div>