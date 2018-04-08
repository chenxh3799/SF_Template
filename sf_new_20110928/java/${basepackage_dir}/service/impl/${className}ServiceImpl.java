<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basepackage}.domain.${className}Domain;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;


@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
	
	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	
	 /**
         * 总数
         * 
         * @param ${classNameLower}Domain
         * @return
         */
    public int getMatched${className}Count(${className}Domain ${classNameLower}Domain){
    	return ${classNameLower}Dao.getMatched${className}Count(${classNameLower}Domain);
    }

    /**
     * 列表
     * 
     * @param ${classNameLower}Domain
     * @return
     */
    public List<${className}Domain> getMatched${className}List(${className}Domain ${classNameLower}Domain){
    	return ${classNameLower}Dao.getMatched${className}List(${classNameLower}Domain);
    }
	
    /**
     * 查询
     * 
     * @param ${className}Domain
     * @return Map<String, Object>
     */
    public Map<String, Object> query(${className}Domain ${classNameLower}Domain){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<${className}Domain> ${classNameLower}DomainList = ${classNameLower}Dao.getMatched${className}List(${classNameLower}Domain);
        resultMap.put("${classNameLower}DomainList", ${classNameLower}DomainList);
        Integer total = ${classNameLower}Dao.getMatched${className}Count(${classNameLower}Domain);
        resultMap.put("total", total);
        return resultMap;
    }
    
    /**
     * 保存
     * 
     * @param ${classNameLower}Domain
     */
    public int save(${className}Domain ${classNameLower}Domain){
    	${classNameLower}Dao.save(${classNameLower}Domain);
    	return 1;
    }
    
    /**
     * 更新
     * 
     * @param ${classNameLower}Domain
     */
    public int edit(${className}Domain ${classNameLower}Domain){
    	return ${classNameLower}Dao.update(${classNameLower}Domain);
    }
}

