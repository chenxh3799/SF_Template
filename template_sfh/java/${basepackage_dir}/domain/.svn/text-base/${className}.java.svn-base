<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.domain;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 表名和字段名前加双引号，是因为当这些标识是oralce中的关键字时，会报错，加上双引号是防止出错
 */ 
@Entity
@Table(name = "\"${table.sqlName}\"")
public class ${className} implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//别名，页面中使用
	public static final String TABLE_ALIAS = "${table.tableAlias}";
	<#list table.columns as column>
	public static final String ALIAS_${column.constantName} = "${column.columnAlias}";
	</#list>	
	
	//属性
	<@generateFields/>
	//构造函数
	<@generateCompositeIdConstructorIfis/>
	//默认主键自动生成，具体开发中需要开发人员根据实际情况进行适当修改
	<@generatePkProperties/>
	//非主键getter setter方法生成
	<@generateNotPkProperties/>
	<@generateJavaOneToMany/>
	<@generateJavaManyToOne/>
	
}


<#macro generateFields>
	     <#--自定义函数，根据数据库中表字段生成java中的属性 -->
		//columns START
	<#list table.columns as column>
	    /**
	     * ${column.columnAlias!}       db_column: ${column.sqlName} 
	     */ 
		<#if column.isDateTimeColumn>
		@DateTimeFormat(pattern="dd-MM-yyyy")
		private ${column.javaType} ${column.columnNameLower};
		<#else>
		private ${column.javaType} ${column.columnNameLower};
		</#if>		
	</#list>
		//columns END
</#macro>

<#macro generateCompositeIdConstructorIfis>
	
	<@generateConstructor className/>
	
</#macro>

<#macro generatePkProperties>
		<#list table.columns as column>
			<#if column.pk>
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "\"${column.sqlName}\"", unique = ${column.unique?string}, nullable = ${column.nullable?string})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
			</#if>
		</#list>
		
	
</#macro>

<#macro generateNotPkProperties>
	<#list table.columns as column>
		<#if !column.pk>
		
	@Column(name = "\"${column.sqlName}\"", unique = ${column.unique?string}, nullable = ${column.nullable?string})
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
		</#if>
	</#list>
</#macro>

<#macro generateJavaOneToMany>
/*
 *代码自动生成一对多的关系，处于注释掉状态，实际开发中可以去掉注释或者删掉该部分内容
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "${classNameLower}")
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	
	</#list>
*/
</#macro>

<#macro generateJavaManyToOne>
   /*
    *代码自动生成多对一的关系，处于注释掉状态，实际开发中可以去掉注释或者删掉该部分内容
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
	<#list foreignKey.parentColumns?values as fkColumn>
		@JoinColumn(name = "${fkColumn}",nullable = false, insertable = false, updatable = false) <#if fkColumn_has_next>,</#if>
    </#list>
	})
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	
	</#list>
	*/
</#macro>

