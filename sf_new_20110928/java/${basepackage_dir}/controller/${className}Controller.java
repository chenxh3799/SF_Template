<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinacri.pcmp.commons.DateJsonValueProcessor;

import ${basepackage}.domain.${className}Domain;
import ${basepackage}.service.${className}Service;


@Controller
public class ${className}Controller {
	@Autowired
	private ${className}Service ${classNameLower}Service;
	
	
	/**
     * 进入主页面
     * 
     * @param filterMask
     * @param model
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value = "/${classNameLower}/initQuery", method = RequestMethod.GET)
	String initQuery(${className}Domain filterMask,Model model,HttpServletRequest request, HttpServletResponse response)
	{ 
		model.addAttribute("filterMask", filterMask);
		return "${className}/${className}Main";
	}
	
	/**
     * 查询列表
     * 
     * @param request
     * @param response
     * @param ${className}Domain
     * @throws Exception
     */
	@RequestMapping(value = "/${classNameLower}/query")
    public void query(HttpServletRequest request,
	    HttpServletResponse response,${className}Domain filterMask) throws Exception {
	// 业务------------------------------------------------------------------------
    Map<String, Object> resultMap = ${classNameLower}Service.query(filterMask);
    List<${className}Domain> list = (List<${className}Domain>) resultMap.get("${classNameLower}DomainList");
    Integer total = (Integer) resultMap.get("total");
	PrintWriter write = response.getWriter();
	JsonConfig config = new JsonConfig();
	/**
     * DateJsonValueProcessor 这个是公用类,可从SF_DEOM中获取
     */
	config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
	Map map=new HashMap();
	map.put("total", total);
	map.put("rows",  list);
	JSONObject o =JSONObject.fromObject(map, config);

	write.write(o.toString());
	write.flush();
	write.close();
	o.clear();
    }

	/**
     * 进入新增页面
     * 
     * @param filterMask
     * @param model
     * @return
     */
	@RequestMapping(value = "/${classNameLower}/initSave", method = RequestMethod.POST)
	String initSave(${className}Domain filterMask,Model model)
	{
		model.addAttribute("filterMask", filterMask);
		return "${className}/${className}Add";
	}
	
	/**
     * 新增
     * 
     * @param country
     * @param result
     * @return
     */
	@RequestMapping(value = "/${classNameLower}/save")
	@Transactional
	public String save(HttpServletRequest request,Model model,
			    HttpServletResponse response,${className}Domain filterMask) throws Exception {
			// 保存
		    ${classNameLower}Service.save(filterMask);
		    model.addAttribute("filterMask", new ${className}Domain());
			return "${className}/${className}Main";
	}
	
	/**
     * 进入修改页面
     * 
     * @param filterMask
     * @param model
     * @return
     */
	@RequestMapping(value = "/${classNameLower}/initEdit", method = RequestMethod.POST)	
    public String  initEdit(${className}Domain filterMask,Model model) throws Exception{
	model.addAttribute("filterMask", filterMask);
	return "${className}/${className}Edit";
    }
	
	
	/**
     * 修改
     * 
     * @param country
     * @param result
     * @return
     */
	 @RequestMapping(value = "/${classNameLower}/edit")
	    @Transactional
	    public String edit(HttpServletRequest request,Model model,
		    HttpServletResponse response,${className}Domain filterMask) throws Exception {
		
		 ${classNameLower}Service.edit(filterMask);
		 model.addAttribute("filterMask", new ${className}Domain());
		 return "${className}/${className}Main";
	    }
}
	