<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinacri.pcmp.commons.PaginatedHelper;


@Entity
public class ${className}Domain extends PaginatedHelper implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//别名，页面中使用
	public static final String TABLE_ALIAS = "${table.tableAlias}";
	<#list table.columns as column>
	public static final String ALIAS_${column.constantName} = "${column.columnAlias}";
	</#list>	
	
	//属性
	<@generateFields/>
	
	//构造函数
	<@generateConstructor className/>
	
	//getter setter方法
	<@genGetSetProperties/>
		
}