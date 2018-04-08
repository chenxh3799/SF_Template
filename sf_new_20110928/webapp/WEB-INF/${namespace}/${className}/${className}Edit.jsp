<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className> 
<#assign classNameLower =className?uncap_first>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="${basepackage}.domain.${className}Domain" %>
<html>
<head>
  <%@ include file="/WEB-INF/views/commons/head.jsp"%>
</head>
<script type="text/javascript">
  $(function(){
		 $("#back").bind("click",function(){
		     var url = "<@jspEl 'ctx'/>${classNameLower}/initQuery.do";
		     $("#back").attr("href",url);
		 });
		 
		 $("#reset").bind("click",function(){
		     $("#editForm input").attr("value","");
		 });
  });
  
  function saveAction(){
	  $.messager.confirm('提示', '是否确认修改?', function(r){
			if (r){
				 	JSCoverController.showDiv("正在处理中...");
				 	$("#editForm").attr("action","<@jspEl 'ctx'/>${classNameLower}/edit.do");
				 	$("#editForm").submit();
  	             }
			});
  }
</script>
<body>
<sfform:form  modelAttribute="filterMask" id="editForm">
	<div class="layout_div">
      <div class="navigation_div"> 
         <span class="font_heading1">${table.tableAlias}&gt;&gt;</span><a href="#">${table.tableAlias}</a>
      </div>
      <fieldset class="fieldsetdefault"><legend>修改</legend>
	        <table class="layouttable" id="input_info">
			       <#list table.columns as column>
			      	    <#if (column_index==0)>
							<tr>
								<@generateForm column/>									
						<#elseif ((column_index%3)!=0)&&(column_has_next)>
							   <@generateForm column/>
						<#elseif ((column_index%3)==0)&&(column_has_next)>
							</tr>
							<tr>
								<@generateForm column/>
						<#elseif ((column_index%3)==0)&&(!column_has_next)>
							</tr>
							<tr>
								<@generateForm column=column/>
								<td class="layouttable_td_widget"></td>
							    <td class="layouttable_td_widget"></td>
							    <td class="layouttable_td_widget"></td>
							    <td class="layouttable_td_widget"></td>
							 </tr>
						<#elseif ((column_index%3)!=0)&&(!column_has_next)&&((column_index%3)==1)>
								<@generateForm column/>
								<td class="layouttable_td_widget"></td>
							    <td class="layouttable_td_widget"></td>
							 </tr> 
						<#elseif ((column_index%3)!=0)&&(!column_has_next)&&((column_index%3)==2)>
								<@generateForm column/>
							 </tr> 
						<#else>					 
						</#if>								
			      </#list>  
			       
		     </table>
		      </fieldset>
       <table width="100%">
	        <tr>
	           <td align="right">
	                <a class="easyui-linkbutton" onclick="javascript:saveAction()"  iconCls="icon-save" id="save">保存</a>
	                <a class="easyui-linkbutton" onclick="javascript:void(0)"  iconCls="icon-back" id="back">返回</a>
		            <a class="easyui-linkbutton" onclick="javascript:$('#paginateForm')[0].reset();"  iconCls="icon-cancel" id="reset">重置</a>
	           </td>
	        </tr>
	  </table>
</sfform:form>
</body>
</html>