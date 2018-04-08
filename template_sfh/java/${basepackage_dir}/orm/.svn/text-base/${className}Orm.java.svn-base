<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.orm;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;
import com.sinolife.sf.framework.util.HibernateDaoUtil;

import ${basepackage}.domain.${className};


@Repository("${classNameLower}")
public class ${className}Orm extends HibernateDaoSupport{
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(${className} entity) {
		 
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 查询
	 */
	public List<${className}> findAllBy(String propertyName, Object value) {
		 
		return HibernateDaoUtil.findAllBy(${className}.class, propertyName, value, getHibernateTemplate());
	}

	 
	public ${className} findByProperty(String propertyName, Object value) {
		 
		return (${className}) HibernateDaoUtil.findByProperty(${className}.class, propertyName, value,  getHibernateTemplate());
	}

	/**
	 * 通过主键查询实体
	 */
	public ${className} getByPK(<@getPKDataType/> pk) {
		 
		return (${className}) getHibernateTemplate().get(${className}.class, (Serializable) pk);
	}

	 
	 

	 
	public List<${className}> list() {
	 
		return HibernateDaoUtil.find(${className}.class, getHibernateTemplate());
	}

	 
	public DataPage<${className}> list(DataPageRequest request) {
		 
		return HibernateDaoUtil.find(${className}.class, request, getHibernateTemplate());
	}

	 
	public void removeByPK(<@getPKDataType/> pk) {
		 
		Object entity = getByPK(pk);
		if(entity == null) {
			throw new ObjectRetrievalFailureException(${className}.class,pk);
		}
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 保存
	 */
	public void save(${className} entity) {
		getHibernateTemplate().save(entity);
		
	}

	/**
	 * 修改
	 */
	public void update(${className} entity) {
		getHibernateTemplate().update(entity);
		
	}
	
	 
	
}
