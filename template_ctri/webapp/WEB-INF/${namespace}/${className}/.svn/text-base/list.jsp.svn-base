<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@page import="${basepackage}.domain.${className}" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/commons/taglibs.jsp" %>


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
						    <a id="pk-<@jspEl 'status.index'/>-edit" href="<@jspEl 'ctx'/>${className}/edit.do?<@generateIdQueryString/>">编辑</a>
					        <a id="pk-<@jspEl 'status.index'/>-view" href="<@jspEl 'ctx'/>${className}/view.do?<@generateIdQueryString/>">查看</a>
					        <a id="pk-<@jspEl 'status.index'/>-delete" href="<@jspEl 'ctx'/>${className}/delete.do?<@generateIdQueryString/>">删除</a>	
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
	
	<table width="100%" border="0">
	   <tr> 
	    <td width="27%">&nbsp;</td>         
	    <td  align="right" width="30%">
	       <p>总记录：<@jspEl 'dataPage.totalRecord'/>  总页数：<@jspEl 'dataPage.pageCount'/> 当前页：<@jspEl 'dataPage.dataPageRequest.pageIndex+1'/></p>	
	    </td>
	     <td width="5%">&nbsp;</td>
	      <td width="30%"  align="right">
	        
	         <div class="buttonGroup">
	
	    
		<div class="span-3">
			<c:if test="<@jspEl 'dataPage.dataPageRequest.pageIndex > 0'/>">
				<a id="prevResultsLink" href="javascript:go('<@jspEl 'ctx'/>${className}/main.do?pageIndex=<@jspEl 'dataPage.dataPageRequest.pageIndex-1'/>&_SF_SELECT_MODE=<@jspEl '_SF_SELECT_MODE'/>')">上一页</a>
				
			</c:if>
		</div>
		
		</div>        
	 </td>
	 <td width="8%" align="right">
	  <div class="buttonGroup">
	   <div class="span-3  append-12  last">
			<c:if test="<@jspEl 'dataPage.dataPageRequest.pageIndex<(dataPage.pageCount-1)'/>">
				<a id="moreResultsLink" href="javascript:go('<@jspEl 'ctx'/>${className}/main.do?&pageIndex=<@jspEl 'dataPage.dataPageRequest.pageIndex+1'/>&_SF_SELECT_MODE=<@jspEl '_SF_SELECT_MODE'/>')">下一页</a>
				
			</c:if>	
			
		</div>
	   </div>
	 </td>
	    
	    <td width="2%">&nbsp;</td> 
	        
	   </tr>
	</table>
	
</c:if>
<c:if test="<@jspEl 'empty dataPage.pageData'/>">
				<tr>
					<td colspan="5">没有数据</td>
				</tr>
</c:if>
</div>
<script type="text/javascript">
	function go(action)
	{
		$("#filterMask").attr("action",action);
		$("#filterMask").submit();
	}
	
</script>
	

