<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = procedure.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.po;

import java.io.Serializable;

@Entity
public class ${className}Po implements java.io.Serializable{
	
	private static final long serialVersionUID = 5454155825314635342L;
	
	//属性
	<@generateFields/>
	
	//无参构造函数
	public ${className}Po(){
		
	}
	
	//属性getter setter方法生成
	<@generatePropertiesGetAndSet />
	

}


<#macro generateFields>
	<#--自定义函数，根据存储过程入参出参生成java中的属性 -->
	//property START
	<#list procedure.parameters as parameter>
	
	/**
	 * java中展示属性的名称:${parameter.parameterJavaName!}       存储过程参数名称: ${parameter.parameterName} 
	 */ 
	private ${parameter.javaTypeName} ${parameter.parameterJavaName};	
	</#list>
	//property END
</#macro>


<#macro generatePropertiesGetAndSet>
	<#list procedure.parameters as parameter>
	<#assign parameterJavaNameFirstUp = parameter.parameterJavaName?cap_first> 	
	public ${parameter.javaTypeName} get${parameterJavaNameFirstUp}() {
		return this.${parameter.parameterJavaName};
	}
	
	public void set${parameterJavaNameFirstUp}(${parameter.javaTypeName} value) {
		this.${parameter.parameterJavaName} = value;
	}
	
	</#list>
</#macro>