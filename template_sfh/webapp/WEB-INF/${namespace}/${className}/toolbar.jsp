<#include "/macro.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<%@page import="${basepackage}.domain.${className}" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>


<sfform:form modelAttribute="searchCriteria" enctype="application/x-www-form-urlencoded; charset=UTF-8" action="<@jspEl 'flowExecutionUrl'/>">
<div style="background:url(<@jspEl 'ctx'/>resources/images/banner.jpg)" align="left">
<img src="<@jspEl 'ctx'/>resources/styles/ui/images/common/arrow1.gif" width="12" height="15" style="margin-left:10px" class="arrow"/>搜索条件
 </div>
 <script type="text/javascript">
 $(".arrow").click(function(){
	 $(".content").toggle();
	 })
 </script>
 <div class="content">


	<#-- 最多自动生成16个查询条件，太多页面难看，用户可以根据实际情况手动添加-->
	<table border="0" cellspacing="0" cellpadding="0" class="table_data">
		<tr>
			<td align="center" valign="top" class="table_text_td">
			<table align="center" class="list">
				<#list table.columns as column>	
					<#if (column_index==0)>
					<tr>
						<@generateForm column/>
					<#elseif (column_index==16)&&(column_has_next)>
					</tr><#break>					
					<#elseif ((column_index%4)!=0)&&(column_has_next)>
					   <@generateForm column/>
					<#elseif ((column_index%4)==0)&&(column_has_next)>
					</tr>
					<tr>
						<@generateForm column/>
					<#elseif ((column_index%4)==0)&&(!column_has_next)>
					</tr>
					<tr>
						<@generateForm column/>
						<td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					 </tr>
					<#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==1)>
						<@generateForm column/>
						<td class="list_td per4_1"></td>
					    <td class="list_td per4_1"></td>
					 </tr> 
					 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==2)>
						<@generateForm column/>
						<td class="list_td per4_1"></td>
					 </tr> 
					 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==3)>
						<@generateForm column/>
					 </tr>
					 <#else>
					 
					</#if>
				</#list>				
			</table>
			</td>
		</tr>
	</table>
	
	   <div align="right">
			<button type="submit" id="search" name="_eventId_search" class="btn">搜索</button>
			<script type="text/javascript">
							Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'search',event:'onclick',formId:'searchCriteria',params:{fragments:'list'}	}));
			</script>
	        <button type="button" id="addnew"  class="btn">创建</button>
	    <script type="text/javascript">
		$("#addnew").click(function(){
			window.location.href="<@jspEl 'flowExecutionUrl'/>&_eventId=new"});
			
	     </script>
	    </div>
   
 </div>
		
</sfform:form>




