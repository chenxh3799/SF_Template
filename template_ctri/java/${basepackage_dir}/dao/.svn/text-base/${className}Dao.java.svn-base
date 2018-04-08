<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;

import ${basepackage}.domain.${className};

@Repository("${classNameLower}")
public class ${className}Dao extends SqlMapClientDaoSupport {
	
	/**
	 * 根据主建获取对象
	 * @param pk
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ${className} getByPK(Map map)
	{
		return (${className}) getSqlMapClientTemplate().queryForObject(${className}Dao.class.getName()+".get${className}ByPK", map);
	}
	
	
	/**
	 * 分页查询
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DataPage<${className}> list(DataPageRequest request)
	{
		request.calcOffset();
		
		HashMap filterMap=(HashMap) request.getOptions().get("filterMap");
		if(filterMap==null)
			filterMap=new HashMap();
		int totalCount=(Integer) getSqlMapClientTemplate().queryForObject(${className}Dao.class.getName()+".getMatched${className}Count", filterMap);
		
		filterMap.put("req", request);
		List<${className}> list=getSqlMapClientTemplate().queryForList(${className}Dao.class.getName()+".getMatched${className}Page", filterMap);
		
		return new DataPage<${className}>(request,list,totalCount) ;
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	public void removeByPK(Map map)
	{
		getSqlMapClientTemplate().delete(${className}Dao.class.getName()+".remove${className}ByPK", map);
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(${className} entity)
	{
		getSqlMapClientTemplate().insert(${className}Dao.class.getName()+".add${className}", entity);
	}
	
	/**
	 * 修改
	 * @param entity
	 */
	public void update(${className} entity) 
	{
		getSqlMapClientTemplate().update(${className}Dao.class.getName()+".update${className}", entity);
	}

}
