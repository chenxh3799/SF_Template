<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className> 
<#assign classNameLower = className?uncap_first>
<%@page import="${basepackage}.domain.${className}" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>

<sf:override name="content">

	<div>
	<sfform:form modelAttribute="${classNameLower}" action="<@jspEl 'ctx'/>${className}/cancel">
	<div style="background:url(<@jspEl 'ctx'/>resources/images/banner.jpg)" align="left">
<img src="<@jspEl 'ctx'/>resources/styles/ui/images/common/arrow1.gif" width="12" height="15" style="margin-left:10px" class="arrow"/>查看
 <script type="text/javascript">
 $(".arrow").click(function(){
	 $(".content").toggle();
	 })
 </script>
 </div>
 <div class="content">

		<table border="0" cellspacing="0" cellpadding="0" class="table_data">
			<tr>
				<td align="center" valign="top" class="table_text_td">
				<table align="center" class="list">
					<#list table.columns as column>	
					<#if (column_index==0)>
					<tr>
						<@generateViewForm column/>									
					<#elseif ((column_index%4)!=0)&&(column_has_next)>
					   <@generateViewForm column/>
					<#elseif ((column_index%4)==0)&&(column_has_next)>
					</tr>
					<tr>
						<@generateViewForm column/>
					<#elseif ((column_index%4)==0)&&(!column_has_next)>
					</tr>
					<tr>
						<@generateViewForm column/>
						<td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					 </tr>
					<#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==1)>
						<@generateViewForm column/>
						<td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					 </tr> 
					 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==2)>
						<@generateViewForm column/>
						<td class="list_td per4_1"></td>
					 </tr> 
					 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==3)>
						<@generateViewForm column/>
					 </tr>
					 <#else>
					 
					</#if>
				</#list>				
                    
				</table>
				</td>
			</tr>
		</table>
		<div align="right">
        <button type="submit" name="button" id="cancel" value="cancel"  class="btn" >返回</button>		
	</sfform:form></div>
</sf:override>


<jsp:include page="/WEB-INF/views/layouts/NoLayout.jsp"></jsp:include>