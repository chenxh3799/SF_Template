<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import ${basepackage}.domain.${className};
import ${basepackage}.service.${className}Service;

@Component
public class ${className}Validator {
	@Autowired
	private ${className}Service ${classNameLower}Service;
	
	public void validateAddNewPage(${className} entity,ValidationContext validateContext)
	{

		MessageContext messagesContext = validateContext.getMessageContext();
		//需要开发者根据实际情况填写验证规则
		/*if(${classNameLower}Service.get${className}ByPK(entity.getCountryCode())!=null)
		{			
			messagesContext.addMessage(new MessageBuilder().error().source(
			"countryCode").code("org.sinolife.cms.country.code.must.unique")
			.build());
		}*/
	}
	public void validateEditPage(${className} entity,ValidationContext validateContext)
	{

		MessageContext messagesContext = validateContext.getMessageContext();
		//需要开发者根据实际情况填写验证规则
		 /*if(entity.getCountryName()==null||entity.getCountryName().trim().length()==0)
		 {
			 messagesContext.addMessage(new MessageBuilder().error().source(
				"countryName").code("org.sinolife.cms.country.name.must.not.null")
				.build());
		 }*/
	}
	

}