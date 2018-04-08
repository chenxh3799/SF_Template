<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className> 
<#assign classNameLower =className?uncap_first>
<%@page import="${basepackage}.domain.${className}" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/commons/head.jsp"%>

<div>

<sf:block name="content">


	<spring:hasBindErrors name="${classNameLower}">
		<div class="error"><spring:bind path="${classNameLower}.*">
			<c:forEach items="<@jspEl 'status.errorMessages'/>" var="error">
				<c:out value="<@jspEl 'error'/>" />
				<br>
			</c:forEach>
		</spring:bind>
		</div>
	</spring:hasBindErrors>
	
</sf:block>	
	
<sfform:form modelAttribute="${classNameLower}" action="<@jspEl 'ctx'/>${className}/addNew">

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
				  <#-- 表单中非空字段加上notnull,外键加弹出框-->
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
												<@generateEditFormOpen column fkPojoClass/>									
											<#elseif ((column_index%4)!=0)&&(column_has_next)>
											   <@generateEditFormOpen column=column fkPojoClass=fkPojoClass/>	
											<#elseif ((column_index%4)==0)&&(column_has_next)>
											</tr>
											<tr>
												<@generateEditFormOpen column fkPojoClass/>	
											<#elseif ((column_index%4)==0)&&(!column_has_next)>
											</tr>
											<tr>
												<@generateEditFormOpen column fkPojoClass/>	
												<td class="list_td per4_1"></td>
											    <td class="list_td per4_1"></td>
											    <td class="list_td per4_1"></td>
											 </tr>
											<#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==1)>
												<@generateEditFormOpen column fkPojoClass/>
												<td class="list_td per4_1"></td>
											    <td class="list_td per4_1"></td>
											 </tr> 
											 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==2)>
												<@generateEditFormOpen column fkPojoClass/>
												<td class="list_td per4_1"></td>
											 </tr> 
											 <#elseif ((column_index%4)!=0)&&(!column_has_next)&&((column_index%4)==3)>
												<@generateEditFormOpen column fkPojoClass/>
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
								<@generateEditForm column=column/>
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
					</#if>
				</#list>				
				</table>
				</td>
			</tr>
		</table>
		<div align="right">		
		 <input type="submit" name="button" id="save" value="保存" class="btn" ></input>
		 <input type="submit" name="button" id="cancel" value="返回"  class="btn" ></input>		
		</div>
			</div>
	</sfform:form>


</div>