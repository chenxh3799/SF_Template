<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className> 
<#assign classNameLower =className?uncap_first>
<%@page import="${basepackage}.domain.${className}" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>

<sf:override name="content">

	<div>
	<spring:hasBindErrors name="${classNameLower}">
		<div class="error"><spring:bind path="${classNameLower}.*">
			<c:forEach items="<@jspEl 'status.errorMessages'/>" var="error">
				<c:out value="<@jspEl 'error'/>" />
				<br>
			</c:forEach>
		</spring:bind>
		</div>
	</spring:hasBindErrors>
	
	<sfform:form modelAttribute="${classNameLower}" action="<@jspEl 'flowExecutionUrl'/>">
	<div style="background:url(<@jspEl 'ctx'/>resources/images/banner.jpg)" align="left">
	<img src="<@jspEl 'ctx'/>resources/styles/ui/images/common/arrow1.gif" width="12" height="15" style="margin-left:10px" class="arrow"/>创建
	 </div>
	 <script type="text/javascript">
	 $(".arrow").click(function(){
		 $(".content").toggle();
		 })
	 </script>

 <div class="content">
		<table border="0" cellspacing="0" cellpadding="0" class="table_data">
			<tr>
				<td align="center" valign="top" class="table_text_td">
				<table align="center" class="list">
					<#list table.columns as column>	
					<#if (column_index==0)>
					<tr>
						<@generateEditForm column/>									
					<#elseif ((column_index%4)!=0)&&(column_has_next)>
					   <@generateEditForm column/>
					<#elseif ((column_index%4)==0)&&(column_has_next)>
					</tr>
					<tr>
						<@generateEditForm column/>
					<#elseif ((column_index%4)==0)&&(!column_has_next)>
					</tr>
					<tr>
						<@generateEditForm column/>
						<td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					 </tr>
					<#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==1)>
						<@generateEditForm column/>
						<td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					 </tr> 
					 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==2)>
						<@generateEditForm column/>
						<td class="list_td per4_1"></td>
					 </tr> 
					 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==3)>
						<@generateEditForm column/>
					 </tr>
					 <#else>
					 
					</#if>
				</#list>				
				</table>
				</td>
			</tr>
		</table>
		<div align="right">
		<button type="submit" id="save" name="_eventId_save" class="btn">保存</button>
		<button type="submit" id="cancel" name="_eventId_cancel" class="btn">取消</button>
		<script type="text/javascript">
						Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));
						Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'save',event:'onclick',formId:'${classNameLower}',params:{fragments:'content'}	}));
					</script></div>
			</div>
	</sfform:form>

		</div>
</sf:override>


<jsp:include page="/WEB-INF/views/layouts/NoLayout.jsp"></jsp:include>