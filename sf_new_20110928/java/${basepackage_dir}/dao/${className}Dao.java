<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import ${basepackage}.domain.${className}Domain;

@Repository("${classNameLower}Dao")
public class ${className}Dao extends SqlMapClientDaoSupport {
	
	 /**
         * 总数
         * 
         * @param ${classNameLower}Domain
         * @return
         */
	 public int getMatched${className}Count(${className}Domain ${classNameLower}Domain){
			return (Integer) this.getSqlMapClientTemplate().queryForObject(${className}Dao.class.getName()+ ".getMatched${className}Count",${classNameLower}Domain);
	}
	 
	 /**
         * 列表
         * 
         * @param ${classNameLower}Domain
         * @return
         */
	 public List<${className}Domain> getMatched${className}List(${className}Domain ${classNameLower}Domain){

			return this.getSqlMapClientTemplate().queryForList(${className}Dao.class.getName()+ ".getMatched${className}List",${classNameLower}Domain);
		    }
	 
	 /**
         * 保存
         * 
         * @param ${classNameLower}Domain
         */
	    public void save(${className}Domain ${classNameLower}Domain){
	     this.getSqlMapClientTemplate().insert(${className}Dao.class.getName()+ ".save${className}",${classNameLower}Domain);
	    }
	    
	    /**
         * 更新
         * 
         * @param ${classNameLower}Domain
         */
	    public int update(${className}Domain ${classNameLower}Domain){
	    	return (Integer)this.getSqlMapClientTemplate().update(${className}Dao.class.getName()+ ".update${className}",${classNameLower}Domain);
	    }
	    
	    /**
         * 删除
         * 
         * @param ${classNameLower}Domain
         */
	    public int delete(${className}Domain ${classNameLower}Domain){
	    	return (Integer)this.getSqlMapClientTemplate().delete(${className}Dao.class.getName()+ ".delete${className}",${classNameLower}Domain);
	    } 
	 
	    /**
         * 根据主键获取对象
         * 
         * @param pk
         * @return
         */
	    @SuppressWarnings("unchecked")
	    public ${className}Domain getObjectById(String pkValue)
	    {
	        return (${className}Domain) this.getSqlMapClientTemplate().queryForObject(${className}Dao.class.getName()+".getObjectById", pkValue);
	    }
}
