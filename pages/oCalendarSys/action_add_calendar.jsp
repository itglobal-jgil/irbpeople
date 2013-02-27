<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-nested" prefix="nested"%>
<%@ taglib uri="/tags/jim" prefix="jim"%>
<%@ taglib uri="/tags/nested-jim" prefix="nested-jim"%>
<%@page import="utils.jsp.JspUtils"%>

<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
	<font color="red">
		ERROR: Application resources not loaded -- check servlet container logs for error messages. 
	</font>
</logic:notPresent>

<html:form action="<%=JspUtils.getCurrentAction(request)%>">
	<html:hidden property="id"/>


	<table>
		<tr>
			<td colspan=2><html:errors/></td>
		</tr>
	</table>

<nested:nest property="irbholiday_Form">
	<nested:hidden property="irbholidaycode" />
	<nested:hidden property="personalcode" />
</nested:nest>

<table cellpadding=0 cellspacing=0>
	<tr>
		<td><jsp:include page="/pages/common/templates/groupHeader.jsp"> <jsp:param name="HeaderKey" value="personal/spdata"/> </jsp:include></td>
	</tr>
	<tr align="center">
		<td class="GroupContent">
			<table class="FormTable" cellpadding=0 cellspacing=0>
			

<tr>
	<td align="center">
	<nested:nest property="irbholiday_Form">

		<table cellpadding=0 cellspacing=0>		
			
<tr>
	
<td class="FormFieldLeft">
	
<jim:message key="name" />
	
</td>
<td class="FormFieldRight">
	<nested:write property="personal.name"/>
	
</td>
<td class="FormFieldLeft">
	
<jim:message key="surname1" />
	
</td>
<td class="FormFieldRight">
	<nested:write property="personal.surname1"/>
	
</td>
<td class="FormFieldLeft">
	
<jim:message key="surname2" />
	
</td>
<td class="FormFieldRight">
	<nested:write property="personal.surname2"/>
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
		</table>

	</nested:nest>
	</td>
</tr>
			</table>
		</td>
	</tr>
</table>
<br>
<table cellpadding=0 cellspacing=0>
	<tr>
		<td><jsp:include page="/pages/common/templates/groupHeader.jsp"> <jsp:param name="HeaderKey" value="holidaysinfo"/> </jsp:include></td>
	</tr>
	<tr align="center">
		<td class="GroupContent">
			<table class="FormTable" cellpadding=0 cellspacing=0>
			

<tr>
	<td align="center">
	<nested:nest property="irbholidayinfo_Form">

		<table cellpadding=0 cellspacing=0>		
<tr>
<td class="FormFieldLeft">
	
<jim:message key="previous/holidays" />
	
</td>
<td class="FormFieldRight">
	<nested:write property="previousyearholidays"/> (<nested:write property="pendingpreviousyearholidays"/>)
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
<td class="FormFieldLeft">
	
<jim:message key="holidays" /> (<jim:message key="pending" />)
	
</td>
<td class="FormFieldRight">
	<nested:write property="holidays"/> (<nested:write property="pendingholidays"/>)
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
<td class="FormFieldLeft">
	
<jim:message key="aps" /> (<jim:message key="pending" />)
	
</td>
<td class="FormFieldRight">
	<nested:write property="aps"/> (<nested:write property="pendingaps"/>)
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>

		</table>

	</nested:nest>
	</td>
</tr>
			</table>
		</td>
	</tr>
</table>
<br>


<table cellpadding=0 cellspacing=0>
	<tr>
		<td><jsp:include page="/pages/common/templates/groupHeader.jsp"> <jsp:param name="HeaderKey" value="irbholiday.new"/> </jsp:include></td>
	</tr>
	<tr align="center">
		<td class="GroupContent">
			<table class="FormTable" cellpadding=0 cellspacing=0>
			

<tr>
	<td align="center">

		<table cellpadding=0 cellspacing=0>
		<nested:nest property="irbholiday_Form">			
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
	
<td class="FormFieldLeft">
	
<jim:message key="calendar.initialdate" />
	
</td>
<td class="FormFieldRight">
	
<nested-jim:TagDate property="initialdate" />
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
	
<td class="FormFieldLeft">
	
<jim:message key="calendar.enddate" />
	
</td>
<td class="FormFieldRight">
	
<nested-jim:TagDate property="enddate" />
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
	
<td class="FormFieldLeft">
	
<jim:message key="calendar.description" />
	
</td>
<td class="FormFieldRight">
	
<nested:text property="description" />
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
	
<td class="FormFieldLeft">
	
<jim:message key="calendar.type" />
	
</td>
<td class="FormFieldRight">

<nested-jim:TagSelect property="type">
	<nested-jim:TagOptionsCollection name="_selec_type" label="description" value="typeirbholidaycode"/>
</nested-jim:TagSelect>
	
</td>
</tr>
	</nested:nest>
	<nested:nest property="supervisor" >
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
<tr>
	
<td class="FormFieldLeft">
	
<jim:message key="supervisor" />
	
</td>
<td class="FormFieldRight">
	
<nested:write property="name" /> <nested:write property="surname1" /> <nested:write property="surname2" />
	
</td>
</tr>
<tr>
	<td class="FormSeparator"></td>
	<td class="BlankSeparator"></td>
</tr>
</nested:nest>
		</table>
	</td>
</tr>
			</table>
		</td>
	</tr>
</table>
<br>


</html:form>