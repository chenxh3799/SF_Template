<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;

import ${basepackage}.domain.${className};

@Repository("${classNameLower}")
public class ${className}Dao extends SqlMapClientDaoSupport {
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(${className} entity) {
		getSqlMapClientTemplate().delete(${className}Dao.class.getName()+".removeByPK", entity.<@getPKGetMethod/>);
	}
	
	/**
	 * 查询
	 */
	public List<${className}> findAllBy(String propertyName, Object value) {
		 
		HashMap pMap=new HashMap();
		pMap.put(propertyName, value);
		return getSqlMapClientTemplate().queryForList(${className}Dao.class.getName()+".findAllByProperty", pMap);
	}
	
	public ${className} findByProperty(String propertyName, Object value) {
		 List<${className}>  list= findAllBy(  propertyName,   value);
		 if(list!=null&&list.size()>0)
			 return list.get(0);
		 return null;
	}
	
	/**
	 * 通过主键查询实体
	 */
	public ${className} getByPK(<@getPKDataType/> pk)
	{
		return (${className}) getSqlMapClientTemplate().queryForObject(${className}Dao.class.getName()+".getByPK", pk);
	}
	
	/**
	 * 分页查询
	 */
	public List<${className}> list() {
		return  getSqlMapClientTemplate().queryForList(${className}Dao.class.getName()+".list");
	}
	
	/**
	 * 分页准备
	 */
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
	 * 根据主键删除
	 */
	public void removeByPK(<@getPKDataType/> pk)
	{
		getSqlMapClientTemplate().delete(${className}Dao.class.getName()+".removeByPK", pk);
	}
	
	/**
	 * 保存
	 */
	public void save(${className} entity)
	{
		getSqlMapClientTemplate().insert(${className}Dao.class.getName()+".add${className}", entity);
	}
	
	/**
	 * 修改
	 */
	public void update(${className} entity) 
	{
		getSqlMapClientTemplate().update(${className}Dao.class.getName()+".update${className}", entity);
	}

}
