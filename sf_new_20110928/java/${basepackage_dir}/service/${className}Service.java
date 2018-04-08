<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.domain.${className}Domain;
import java.util.List;
import java.util.Map;

import com.chinacri.pcmp.regist.domain.CrRegistmainDomain;

public interface ${className}Service{
	 /**
         * 总数
         * 
         * @param ${classNameLower}Domain
         * @return
         */
    public int getMatched${className}Count(${className}Domain ${classNameLower}Domain);

    /**
     * 列表
     * 
     * @param ${classNameLower}Domain
     * @return
     */
    public List<${className}Domain> getMatched${className}List(${className}Domain ${classNameLower}Domain);
    
    /**
     * 查询
     * 
     * @param ${className}Domain
     * @return Map<String, Object>
     */
    public Map<String, Object> query(${className}Domain ${classNameLower}Domain);
    
    /**
     * 保存
     * 
     * @param ${classNameLower}Domain
     */
    public int save(${className}Domain ${classNameLower}Domain);
    
    /**
     * 更新
     * 
     * @param ${classNameLower}Domain
     */
    public int edit(${className}Domain ${classNameLower}Domain);
}

