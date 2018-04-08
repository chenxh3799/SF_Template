<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	 * 实例对象
	 * @return
	 */ 
	public ${className} create${className}() {
		 
		return new ${className}();
	}
	
	/**
	 * 保存
	 */
	public void add${className}(${className} entity)
	{		
		${classNameLower}Dao.save(entity);		 
	}
	 
	  
	/**
	 * 构建分页过滤条件
	 */
	@SuppressWarnings("unchecked")
	public DataPageRequest buildDataPageRequest(DataPageRequest request,
			${className} entity) {
	    
		DataPageRequest req=request.clone();
		HashMap filterMap=new HashMap();
		req.getOptions().put("filterMap", filterMap);
		
        //注意，这里只进行了简单的非空判断，开发时可以根据实际情况加强非空检查力度		
		<@generateFilters />
		return req;
		 		
	}
	
	/**
	 * 分页查询
	 */
	public DataPage<${className}> list(DataPageRequest request) {
		return ${classNameLower}Dao.list(request);
	}



	/**
	 * 修改
	 * @param entity
	 */
	public void update${className}(${className} entity) {		
		${classNameLower}Dao.update(entity);
		
	}
	
	
	/**
	 * 根据主建获取对象
	 * @param pk
	 */
	@SuppressWarnings("unchecked")
	public ${className} get${className}ByPK(Map map)
	{
		return ${classNameLower}Dao.getByPK(map);
	}


	 
	/**
	 * 删除
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	public void remove${className}(Map map) {
		${classNameLower}Dao.removeByPK(map);
		
	}
	

}


<#--构造ibatis查询过滤使用-->
<#macro generateFilters>
<#list table.columns as column>
   <#if (column.javaType =="java.lang.String")>
   	   if(entity.get${column.columnName}()!=null && !"".equals(entity.get${column.columnName}()))
   <#else>
	   if(entity.get${column.columnName}()!=null)		
   </#if>
	   {
		   filterMap.put("${column.columnNameLower}", entity.get${column.columnName}());
			
		}
	
</#list>
</#macro>


