<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@page import="${basepackage}.domain.${className}" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>

<div>

<div style="background:url(<@jspEl 'ctx'/>resources/images/banner.jpg)" align="left">
<img src="<@jspEl 'ctx'/>resources/styles/ui/images/common/arrow1.gif" width="12" height="15" style="margin-left:10px" class="arrow"/>搜索结果
 </div>
  <script type="text/javascript">
 $(".arrow").click(function(){
	 $(".listContent").toggle();
	 })
 </script>
 <div class="listContent">
<c:if test="<@jspEl 'not empty dataPage.pageData'/>">
	<table cellpadding="2" cellspacing="1" class="table_head">
		<thead>
		 <tr class="table_head_tr">
		    <td class="table_head_th">序号</td>
		  	<#list table.columns as column>
		  		<td class="table_head_th"><%=${className}.ALIAS_${column.constantName}%></td>
		  	</#list>
		  	<td class="table_head_th">操作</td>
		 </tr>
		</thead>
		
		<tbody>
			<c:forEach var="item" items="<@jspEl 'dataPage.pageData'/>" varStatus="status">
				  <tr class="<@jspEl "status.count % 2 == 0 ? 'odd' : 'even'"/>">
				    <td><@jspEl 'status.index+1+dataPage.dataPageRequest.pageIndex*dataPage.dataPageRequest.pageSize'/></td>
				     <#list table.columns as column>
				    	<#if column.isDateTimeColumn>
				    	<td id="${column.columnNameLower}_<@jspEl 'status.index'/>"><fmt:formatDate value="<@jspEl 'item.'+column.columnNameLower/>" type="date" dateStyle="default"/></td>
				    	<#else>
				   		 <td id="${column.columnNameLower}_<@jspEl 'status.index'/>"><@jspEl 'item.'+column.columnNameLower/></td>
				    	</#if>
				    </#list>
				   										
					<td>
					<c:if test="<@jspEl 'empty _SF_SELECT_MODE'/>">
					    <a id="pk-<@jspEl 'item.'+table.pkColumn.columnNameLower/>-edit" href="<@jspEl 'flowExecutionUrl'/>">编辑</a>
				         <script type="text/javascript">
					        Spring.addDecoration(new Spring.AjaxEventDecoration({
					    	elementId: "pk-<@jspEl 'item.'+table.pkColumn.columnNameLower/>-edit",
						    event: "onclick",
						    params: {_eventId: "edit",<@generateIdQueryString />}	
					      }));
				          </script>
				          
				         <a id="pk-<@jspEl 'item.'+table.pkColumn.columnNameLower/>-view" href="<@jspEl 'flowExecutionUrl'/>">查看</a>
				         <script type="text/javascript">
					        Spring.addDecoration(new Spring.AjaxEventDecoration({
					    	elementId: "pk-<@jspEl 'item.'+table.pkColumn.columnNameLower/>-view",
						    event: "onclick",
						    params: {_eventId: "view",<@generateIdQueryString />}	
					      }));
				          </script>
				          
				          <a id="pk-<@jspEl 'item.'+table.pkColumn.columnNameLower/>-remove" href="<@jspEl 'flowExecutionUrl'/>">删除</a>
				         <script type="text/javascript">
					        Spring.addDecoration(new Spring.AjaxEventDecoration({
					    	elementId: "pk-<@jspEl 'item.'+table.pkColumn.columnNameLower/>-remove",
						    event: "onclick",
						    params: {_eventId: "remove",<@generateIdQueryString />}	
					      }));
				          </script>
				        </c:if>
				        
				         <c:if test="<@jspEl 'not empty _SF_SELECT_MODE'/>">
						     <a href="#" class="select" onclick="selectValue('<@jspEl 'status.index'/>')" style=" text-decoration: underline;">选择</a>
	                            <script type="text/javascript">
	                            function selectValue(number){
			                         var value = "<@jspEl '_SF_SELECT_MODE'/>_"+number;                      
		                        	 window.opener.document.getElementById("<@jspEl '_SF_SELECT_MODE'/>").value=$("#"+value).text();
									 window.close();	
				                   }
								 </script>
						 </c:if>   
				        					   
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>总记录：<@jspEl 'dataPage.totalRecord'/>  总页数：<@jspEl 'dataPage.pageCount'/> 当前页：<@jspEl 'dataPage.dataPageRequest.pageIndex+1'/></p>	
	<div class="buttonGroup">
	
	    
		<div class="span-3">
			<c:if test="<@jspEl 'dataPage.dataPageRequest.pageIndex > 0'/>">
				<a id="prevResultsLink" href="<@jspEl 'flowExecutionUrl'/>">上一页</a>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.AjaxEventDecoration({
						elementId: "prevResultsLink",
						event: "onclick",
						params: {_eventId: "pre",fragments:'list'}	
					}));
				</script>
			</c:if>
		</div>
		<div> 
		</div>
		<div class="span-3  append-12  last">
			<c:if test="<@jspEl 'dataPage.dataPageRequest.pageIndex<(dataPage.pageCount-1)'/>">
				<a id="moreResultsLink" href="<@jspEl 'flowExecutionUrl'/>">下一页</a>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.AjaxEventDecoration({
						elementId: "moreResultsLink",
						event: "onclick",
						params: {_eventId: "next",fragments:'list'}	
					}));
				</script>
			</c:if>	
			
		</div>
	</div>
	
</c:if>
<c:if test="<@jspEl 'empty dataPage.pageData'/>">
				<tr>
					<td colspan="5">没有数据</td>
				</tr>
</c:if>
</div>
</div>	

