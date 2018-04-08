<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.domain.${className};

import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;
import java.util.Map;

public interface ${className}Service{
	/**
	 * 实例对象
	 * @return
	 */
	${className} create${className}();
	/**
	 * 保存
	 * @param entity
	 */
	void add${className}(${className} entity);
	
	/**
	 * 修改
	 * @param entity
	 */
	void update${className}(${className} entity);
	
	/**
	 * 根据主键获取对象
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	${className} get${className}ByPK(Map map);
	
	/**
	 * 根据主键删除
	 * @param map
	 */
	void remove${className}(Map map);
	
	/**
	 * 构建分页过滤条件
	 * @param request
	 * @param country
	 * @return
	 */
	DataPageRequest  buildDataPageRequest(DataPageRequest request,${className} entity);
	
	/**
	 * 分页查询
	 * @param request
	 * @return
	 */
	DataPage<${className}> list(DataPageRequest request);

}

