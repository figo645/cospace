<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page errorPage="Error.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<table border="1px" class="navifont" width="807px" height="30px"
	cellpadding="0px" cellspacing="0px">
	<tr align="center" class="style7">
		<td width="180" class="navid_out"
			onMouseOver="this.className='navid_over'"
			onMouseOut="this.className='navid_out'">
			<html:link action="/listMenuDesign" styleClass="navid_out"
				onmouseover="this.className='navid_over'"
				onmouseout="this.className='navid_out'">
				<html:param name="menuId" value="c003"></html:param>  
      规划及城市设计
   </html:link>
		</td>
		<td width="180" class="navid_out"
			onMouseOver="this.className='navid_over'"
			onMouseOut="this.className='navid_out'">
			<html:link action="/listMenuArchDesign" styleClass="navid_out"
				onmouseover="this.className='navid_over'"
				onmouseout="this.className='navid_out'">
				<html:param name="menuId" value="c004"></html:param>  
   公共建筑设计</html:link>
		</td>
		<td width="180" class="navid_out"
			onMouseOver="this.className='navid_over'"
			onMouseOut="this.className='navid_out'">
			<html:link action="/listMenuDesign" styleClass="navid_out"
				onmouseover="this.className='navid_over'"
				onmouseout="this.className='navid_out'">
				<html:param name="menuId" value="c005"></html:param> 
   居住建筑设计
   </html:link>
		</td>
		<td width="180" class="navid_out"
			onMouseOver="this.className='navid_over'"
			onMouseOut="this.className='navid_out'">
			<html:link action="/listMenuDesign" styleClass="navid_out"
				onmouseover="this.className='navid_over'"
				onmouseout="this.className='navid_out'">
				<html:param name="menuId" value="c006"></html:param>   
   
   景观设计
   </html:link>
		</td>
		<td width="180" class="navid_out"
			onMouseOver="this.className='navid_over'"
			onMouseOut="this.className='navid_out'">
			<html:link action="/listMenuInteriorDesign" styleClass="navid_out"
				onmouseover="this.className='navid_over'"
				onmouseout="this.className='navid_out'">
				<html:param name="menuId" value="c011"></html:param>
   室内设计
   </html:link>
		</td>
	</tr>
</table>

