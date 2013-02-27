<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/struts-nested" prefix="nested"%>
<%@ taglib uri="/tags/jim" prefix="jim"%>
<%@ taglib uri="/tags/nested-jim" prefix="nested-jim"%>
<%@page import="utils.jsp.JspUtils"%>

<logic:notPresent name="org.apache.struts.action.MESSAGE"
	scope="application">
	<font color="red"> ERROR: Application resources not loaded --
	check servlet container logs for error messages. </font>
</logic:notPresent>

<html:form action="<%=JspUtils.getCurrentAction(request)%>">
	<html:hidden property="id" />


	<table>
		<tr>
			<td colspan=2><html:errors /></td>
		</tr>
	</table>



	<nested:nest property="research_group_Form">
		<nested:hidden property="research_groupcode" />
	</nested:nest>



	<table cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/pages/common/templates/groupHeader.jsp">
				<jsp:param name="HeaderKey" value="research_group.new" />
			</jsp:include></td>
		</tr>
		<tr align="center">
			<td class="GroupContent">
			<table class="FormTable" cellpadding=0 cellspacing=0>


				<tr>
					<td align="center"><nested:nest property="research_group_Form">

						<table cellpadding=0 cellspacing=0>

							<tr>

								<td class="FormFieldLeft"><jim:message key="supervisor" />

								</td>
								<td class="FormFieldRight"><nested-jim:TagSelectionPopUp
									property="supervisor" codeProperty="personalcode"
									url="<%=request.getContextPath()+"/_popUp/selectPersonalPopUp.do" %>"
									objectFiled="_popUp__selectPersonalPopUp" /></td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
							<tr>

								<td class="FormFieldLeft"><jim:message key="unit" /></td>
								<td class="FormFieldRight"><nested-jim:TagSelect
									property="unit.unitcode">
									<nested-jim:TagOptionsCollection name="_selec_unit"
										label="_descripcion" value="unitcode" />
								</nested-jim:TagSelect></td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
							<tr>

								<td class="FormFieldLeft"><jim:message key="description" />

								</td>
								<td class="FormFieldRight"><nested:textarea
									property="description" /></td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
							<tr>

								<td class="FormFieldLeft"><jim:message key="group" /></td>
								<td class="FormFieldRight"><nested:text property="group" />

								</td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
						</table>

					</nested:nest></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<br>




</html:form>