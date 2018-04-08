<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;

import ${basepackage}.domain.${className};
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;


@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
 
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
	/**
	 * 这里如果需要效验，自己注入Spring的效验上下文
	 */
	public void add${className}(${className} entity)
	{
		//需要开发者在这里填写业务逻辑
		
		${classNameLower}Dao.save(entity);
		 
	}
	 
	 
	public ${className} create${className}() {
		 
		return new ${className}();
	}


	/**
	 * 分页查询，需要先使用buildDataPageRequest方法构造出查询语句
	 */
	public DataPage<${className}> list(DataPageRequest request) {
		 
		return ${classNameLower}Dao.list(request);
	}
	
	
	 /**
	  * 构造hibernate 查询过滤语句
	  */
	public DataPageRequest buildDataPageRequest(DataPageRequest request,
			${className} ${classNameLower}) {			
		DataPageRequest req=request.clone();
		HashMap filterMap=new HashMap();
		req.getOptions().put("filterMap", filterMap);
		//注意，这里只进行了简单的非空判断，开发时可以根据实际情况加强非空检查力度
		
		<@generateFilters />
		return req;
		
	}

	 
	public void update${className}(${className} entity) {
		
		 //需要开发者在这里填写业务逻辑
		
		${classNameLower}Dao.update(entity);
		
	}
	
	/**
	  * 根据主键查询
	  */ 
	public ${className} get${className}ByPK(<@getPKDataType/> pk)
	{
		return ${classNameLower}Dao.getByPK(pk);
	}


	/**
	  * 根据主键进行删除
	  */ 
	public void remove${className}(<@getPKDataType/> pk) {
		${classNameLower}Dao.removeByPK(pk);
		
	}

}


<#--构造ibatis查询过滤使用-->
<#macro generateFilters>
<#list table.columns as column>
   <#if (column.javaType =="java.lang.String")>
   	   if(${classNameLower}.get${column.columnName}()!=null && !"".equals(${classNameLower}.get${column.columnName}()))
   <#else>
	   if(${classNameLower}.get${column.columnName}()!=null)		
   </#if>
	   {
		   filterMap.put("${column.columnNameLower}", ${classNameLower}.get${column.columnName}());
			
		}
	
</#list>
</#macro>


