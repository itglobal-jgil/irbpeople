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



	<nested:nest property="personal_Form">
		<nested:hidden property="personalcode" />
	</nested:nest>



	<table cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/pages/common/templates/groupHeader.jsp">
				<jsp:param name="HeaderKey" value="personal" />
			</jsp:include></td>
		</tr>
		<tr align="center">
			<td class="GroupContent">
			<table class="FormTable" cellpadding=0 cellspacing=0>


				<tr>
					<td align="center"><nested:nest property="personal_Form">

						<table cellpadding=0 cellspacing=0>

							<tr>

								<td class="FormFieldLeft"><jim:message key="usercode" /></td>
								<td class="FormFieldRight"><nested:write
									property="usercode" /></td>
								<td class="FormFieldLeft"><jim:message key="name" /></td>
								<td class="FormFieldRight"><nested:write property="name" />

								</td>
								<td class="FormFieldLeft"><jim:message key="surname1" /></td>
								<td class="FormFieldRight"><nested:write
									property="surname1" /></td>
								<td class="FormFieldLeft"><jim:message key="surname2" /></td>
								<td class="FormFieldRight"><nested:write
									property="surname2" /></td>
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



	<table cellpadding=0 cellspacing=0>
		<tr>
			<td><jsp:include page="/pages/common/templates/groupHeader.jsp">
				<jsp:param name="HeaderKey" value="end/spof/spcontract" />
			</jsp:include></td>
		</tr>
		<tr align="center">
			<td class="GroupContent">
			<table class="FormTable" cellpadding=0 cellspacing=0>


				<tr>
					<td align="center"><nested:nest property="personal_Form">

						<table cellpadding=0 cellspacing=0>

							<tr>

								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spreason" /></td>
								<td class="FormFieldRight"><nested:text
									property="end_of_contract_reason" maxlength="100" /></td>
								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spaddress" /></td>
								<td class="FormFieldRight"><nested:text
									property="end_of_contract_address" maxlength="100" /></td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
							<tr>

								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spcity" /></td>
								<td class="FormFieldRight"><nested:text
									property="end_of_contract_city" maxlength="100" /></td>
								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spzip/spcode" /></td>
								<td class="FormFieldRight"><nested:text
									property="end_of_contract_zip_code" maxlength="100" /></td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
							<tr>

								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spcountry" /></td>
								<td class="FormFieldRight"><nested-jim:TagSelect
									property="end_of_contract_country.countrycode">
									<nested-jim:TagOptionsCollection name="_selec_country"
										label="_descripcion" value="countrycode" />
								</nested-jim:TagSelect></td>
								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spphone" /></td>
								<td class="FormFieldRight"><nested:text
									property="end_of_contract_phone" maxlength="100" /></td>
							</tr>
							<tr>
								<td class="FormSeparator"></td>
								<td class="BlankSeparator"></td>
							</tr>
							<tr>

								<td class="FormFieldLeft"><jim:message
									key="end/spof/spcontract/spemail" /></td>
								<td class="FormFieldRight"><nested:text
									property="end_of_contract_email" maxlength="100" /></td>
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