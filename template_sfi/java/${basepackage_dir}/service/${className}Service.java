<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.domain.${className};
import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;

public interface ${className}Service{

	${className} create${className}();
	void add${className}(${className} entity);
	void update${className}(${className} entity);
	${className} get${className}ByPK(<@getPKDataType/> pk);
	void remove${className}(<@getPKDataType/> pk);
	
	DataPage<${className}>   list(DataPageRequest request);
	DataPageRequest  buildDataPageRequest(DataPageRequest request,${className} ${classNameLower});
}

