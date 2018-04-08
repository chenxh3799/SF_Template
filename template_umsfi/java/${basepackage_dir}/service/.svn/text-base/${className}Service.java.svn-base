<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.domain.${className};
import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;

public interface ${className}Service{
	
	/**
	 * 实例对象
	 */
	${className} create${className}();
	/**
	 * 新增
	 */
	void add${className}(${className} entity);
	/**
	 * 修改
	 */
	void update${className}(${className} entity);
	/**
	 * 根据主键获取对象
	 */
	${className} get${className}ByPK(<@getAllPK />);
	/**
	 * 删除
	 */
	void remove${className}(<@getAllPK />);
	
	/**
	 * 分页查询
	 */
	DataPage<${className}>   list(DataPageRequest request);
	/**
	 * 分页查询过滤条件设置
	 */
	DataPageRequest  buildDataPageRequest(DataPageRequest request,${className} ${classNameLower});
}

