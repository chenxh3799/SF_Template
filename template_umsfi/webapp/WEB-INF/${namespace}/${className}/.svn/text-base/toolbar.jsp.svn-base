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

	<table border="0" cellspacing="0" cellpadding="0" class="table_data">
		<tr>
			<td align="center" valign="top" class="table_text_td">
			<table align="center" class="list">
				 <#-- 表单外键加弹出框-->
					<#list table.columns as column>	
						<#assign flag = "true">
						<#list table.importedKeys.associatedTables?values as foreignKey>
						 
						  <#if ((foreignKey?size)>0)>
						      <#-- 存在外键的情况-->
						  	  <#assign fkSqlTable = foreignKey.sqlTable>
							  <#assign fkPojoClass = fkSqlTable.className>
							 	
							  <#list foreignKey.parentColumns?values as fkColumn>
							  	  <#if ("${column.sqlName}"=="${fkColumn}")>
							  	        <#assign flag = "false">
							  	    	<#if (column_index==0)>
											<tr>
												<@generateFormOpen column fkPojoClass/>									
											<#elseif ((column_index%4)!=0)&&(column_has_next)>
											   <@generateFormOpen column=column fkPojoClass=fkPojoClass/>	
											<#elseif ((column_index%4)==0)&&(column_has_next)>
											</tr>
											<tr>
												<@generateFormOpen column fkPojoClass/>	
											<#elseif ((column_index%4)==0)&&(!column_has_next)>
											</tr>
											<tr>
												<@generateFormOpen column fkPojoClass/>	
												<td class="list_td per4_1"></td>
											    <td class="list_td per4_1"></td>
											    <td class="list_td per4_1"></td>
											 </tr>
											<#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==1)>
												<@generateFormOpen column fkPojoClass/>
												<td class="list_td per4_1"></td>
											    <td class="list_td per4_1"></td>
											 </tr> 
											 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==2)>
												<@generateFormOpen column fkPojoClass/>
												<td class="list_td per4_1"></td>
											 </tr> 
											 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==3)>
												<@generateFormOpen column fkPojoClass/>
											 </tr>
										<#else>															 
										</#if>										
							  	    </#if>		 							  	 
							    </#list>						        										
						   </#if>						  												
					</#list>
					
					<#if ("${flag}"=="true")>
						<#-- 不存在外键的情况-->
				  		<#if (column_index==0)>
							<tr>
								<@generateForm column/>									
							<#elseif ((column_index%4)!=0)&&(column_has_next)>
							   <@generateForm column/>
							<#elseif ((column_index%4)==0)&&(column_has_next)>
							</tr>
							<tr>
								<@generateForm column/>
							<#elseif ((column_index%4)==0)&&(!column_has_next)>
							</tr>
							<tr>
								<@generateForm column=column/>
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
		
		<c:if test="<@jspEl 'empty _SF_SELECT_MODE'/>">
		        <button type="button" id="addnew"  class="btn">创建</button>
		    <script type="text/javascript">
			$("#addnew").click(function(){
				window.location.href="<@jspEl 'flowExecutionUrl'/>&_eventId=new"});
				
		     </script>
	     </c:if>
	    </div>
   
 </div>
		
</sfform:form>




