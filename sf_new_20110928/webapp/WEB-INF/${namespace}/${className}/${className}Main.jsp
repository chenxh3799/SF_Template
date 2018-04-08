<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>

<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="${basepackage}.domain.${className}Domain" %>
<html>
<head>
<%@ include file="/WEB-INF/views/commons/head.jsp"%>
</head>
<script type="text/javascript">
   <%--新增--%>
    function addrow(){
    	$("#paginateForm").attr("action","<@jspEl 'ctx'/>${classNameLower}/initSave.do");
    	$("#paginateForm").submit();
    } 
    
    <%--修改--%>
    function editrow(obj){
    	var index=$(obj).parent().parent().parent().attr("datagrid-row-index");
		var row = $('#${className}Table').datagrid('getRows')[index];
		for(var pro in row){
			$("#editForm").append("<input type='hidden' name='"+pro+"' id='"+pro+"' value='"+row[pro]+"'/>");
		}			
		url = "<@jspEl 'ctx'/>${classNameLower}/edit.do";
		$("#editForm").attr("action",url);
		$("#editForm").submit();
    }
    
    <%--查询--%>
	function queryAction(){			
		var wd = $("#paginateForm").width();
		var data = $("#paginateForm").serialize();
		var send_url = "<@jspEl 'ctx'/>${classNameLower}/query.do?"+data;
		var col_size = ${table.columns?size};
		$('#${className}Table').datagrid({
		        title:'查询信息',
		        width:wd,
		        url:send_url,		   
		        columns:[[
                    <#list table.columns as column>
                      {field:'${column.columnNameLower}',title:'<%=${className}Domain.ALIAS_${column.constantName}%>',align:'center',width:wd*(1/(col_size+1))},
                    </#list>		            
		              {field:'operate',title:'操作',align:'center',width:wd*(1/(col_size+1)-0.01),
		            	 formatter:function(value,row,index){
		            		 return '<a name="edit_data" href="#" onclick="javascript:editrow(this)">修改</a>';
		            	 }	
		            }
		        ]],
		        pagination:true,
		        toolbar:[
				         {
				            text:'新增',
				            align:'right',
				            iconCls:'icon-add',
				            handler:function(){
				                addrow();
				            }
				         }
		            ]
		    }); 
	}
	
	<%--页面加载触发--%>
	$(document).ready(function(){
	     queryAction();		          
    });
	
</script>
<body> 
<sfform:form  modelAttribute="filterMask" id="paginateForm">
   <div class="layout_div">
      <div class="navigation_div"> 
         <span class="font_heading1">${table.tableAlias}&gt;&gt;${table.tableAlias}</span>
      </div>
      <fieldset class="fieldsetdefault"><legend>查询</legend>
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
		     <table width="100%">
		        <tr>
		           <td align="right">
		                <a class="easyui-linkbutton" onclick="javascript:queryAction()"  iconCls="icon-search" id="search">查询</a>
			            <a class="easyui-linkbutton" onclick="javascript:$('#paginateForm')[0].reset();"  iconCls="icon-cancel" id="reset">重置</a>
		           </td>
		        </tr>
		     </table>
       </fieldset>
       <div class="layout_div_top_spance">
         <table id="${className}Table"></table>
       </div>
   </div>
</sfform:form>
<form id="editForm" method="post"></form>
</body>
</html>