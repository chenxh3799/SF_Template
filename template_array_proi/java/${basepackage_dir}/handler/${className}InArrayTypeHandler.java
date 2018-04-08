<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = procedure.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import ${basepackage}.po.${className}Po;

@Repository("${classNameLower}Dao")
public class ${className}Dao extends SqlMapClientDaoSupport {	
	/**
	 * 调用存储过程
	 * @param map
	 * @return map
	 */
	@SuppressWarnings("all")
	public ${className}Po get${className}(${className}Po entity)
	{
		/**
		 * 调用存储过程，返回值会放入map中
		 */
		getSqlMapClientTemplate().queryForList(${className}Dao.class.getName()+".get${className}", entity);
		return entity;
	}

}
