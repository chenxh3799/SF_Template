<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;

import com.sinolife.sf.framework.page.DataPage;
import com.sinolife.sf.framework.page.DataPageRequest;
import ${basepackage}.domain.${className};
import ${basepackage}.service.${className}Service;


@Controller
public class ${className}Controller {
	@Autowired
	private ${className}Service ${classNameLower}Service;
	
	/**
	 * 增加了@ModelAttribute的方法可以在本controller的方法调用前执行,可以存放一些共享变量,如枚举值
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		//model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 主页面
	 * @param filterMask
	 * @param pageCriteria
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${className}/main")
	String mainPage(${className} filterMask,DataPageRequest pageCriteria, Model model,HttpServletRequest request, HttpServletResponse response)
	{ 
		String isSelect = request.getParameter("_SF_SELECT_MODE");		
		DataPageRequest req=${classNameLower}Service.buildDataPageRequest(pageCriteria, filterMask);
		DataPage<${className}> dataPage=  ${classNameLower}Service.list(req);
		model.addAttribute("dataPage", dataPage);
		model.addAttribute("filterMask", filterMask);
		if(isSelect!=null && !"".equals(isSelect)){
		   model.addAttribute("_SF_SELECT_MODE", isSelect);	
		}
		return "${className}/main";
	}
	

	/**
	 * 进入新增页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/${className}/new")
	String createNew(Model model)
	{
		model.addAttribute("${classNameLower}", ${classNameLower}Service.create${className}());
		return "${className}/new";
	}
	
	
	
	/**
	 * 新增
	 * @param country
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/${className}/addNew",params="button=保存")
	@Transactional
	public String addNew(${className} entity,BindingResult result,HttpServletRequest request, HttpServletResponse response)
	{
		//这里只进行简单非空验证，更多的业务验证由开发者自己添加
		 if(!validateIsNotNull(entity,result)){
			 return "/${className}/new";
		 }			
		 ${classNameLower}Service.add${className}(entity);
		request.setAttribute("msgs", "新增成功！");
		request.setAttribute("forwardUrl", "/${className}/main");
		return "commons/msgAndforward";
	}
	
	
	/**
	 * 新增页面返回主页面
	 * @return
	 */
	@RequestMapping(value = "/${className}/addNew",params="button=返回")
	String cancelAddNew()
	{
		return "redirect:/${className}/main";
	}
	
	
	
	/**
	 * 进入编辑页面
	 * @param pk
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/${className}/edit")	
	String edit(<@getAllPK />,Model model)throws Exception
	{
		Map map = new HashMap();
		<@setAllPKToMap />	
		${className} ${classNameLower} = ${classNameLower}Service.get${className}ByPK(map);
		if(${classNameLower} == null){
			${classNameLower} = new ${className}();
		}		
		model.addAttribute("${classNameLower}",${classNameLower}Service.get${className}ByPK(map));		
		return "${className}/edit";
	}
	
	
	/**
	 * 修改
	 * @param country
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/${className}/update",params="button=保存")
	@Transactional
	public String saveEdit(${className} entity,BindingResult result,HttpServletRequest request, HttpServletResponse response)
	{
		//这里只进行简单非空验证，更多的业务验证由开发者自己添加
		 if(!validateIsNotNull(entity,result)){
			 return "/${className}/new";
		 }	
		
		${classNameLower}Service.update${className}(entity);
		request.setAttribute("msgs", "修改成功！");
		request.setAttribute("forwardUrl", "/${className}/main");
		return "commons/msgAndforward";
	}
	
	/**
	 * 修改页面返回主页面
	 * @return
	 */
	@RequestMapping(value = "/${className}/update",params="button=返回")
	String cancelSaveEdit()
	{
		return "redirect:/${className}/main";
	}
	
	/**
	 * 查看
	 * @param pk
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/${className}/view")
	String view(<@getAllPK />,Model model)throws Exception
	{
		Map map = new HashMap();
		<@setAllPKToMap />	
		${className} ${classNameLower} = ${classNameLower}Service.get${className}ByPK(map);
		if(${classNameLower} == null){
			${classNameLower} = new ${className}();
		}		
		model.addAttribute("${classNameLower}",${classNameLower}Service.get${className}ByPK(map));
		return "${className}/view";
	}
	
	/**
	 * 查看页面返回
	 * @return
	 */
	@RequestMapping(value = "/${className}/cancel")
	String cancelView(){
		return "redirect:/${className}/main";
	}
	
	/**
	 * 删除
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/${className}/delete")
	@Transactional
	public String delete(<@getAllPK />,HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		Map map = new HashMap();
		<@setAllPKToMap />	
		${classNameLower}Service.remove${className}(map);
		request.setAttribute("msgs", "删除成功！");
		request.setAttribute("forwardUrl", "/${className}/main");
		return "commons/msgAndforward";
	}
	
	
	/**
	 * 验证
	 * @param country
	 * @param result
	 * @return
	 */
	boolean validateIsNotNull(${className} entity,BindingResult result){
		<@generateValidate />
		return true;
	}
	
}

<#--构造验证语句-->
<#macro generateValidate>
	<#list table.columns as column>
	 <#if !column.nullable >  
		 <#if (column.javaType =="java.lang.String")>
		 		if(entity.get${column.columnName}()==null && "".equals(entity.get${column.columnName}()))
		 <#else>
		 		if(entity.get${column.columnName}()==null)		
		 </#if>
			    {
			     result.addError(new org.springframework.validation.FieldError("message", "${column.columnNameLower}", ${className}.ALIAS_${column.constantName}+"不能为空！"));			   		
			     return false;
			    }
	 </#if>
	
	   
		
	</#list>
</#macro>
