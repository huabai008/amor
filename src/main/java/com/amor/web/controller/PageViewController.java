package com.amor.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amor.core.util.Constants;
import com.amor.orm.model.AProduct;
import com.amor.web.solr.SolrBaseService;

/**
 * 公共控制器
 * @author zhangyue
 *
 */

@Controller
@RequestMapping("/page")
public class PageViewController {
	@Resource
	private SolrBaseService solrService;
	/**
	 * 首页
	 */
	@RequestMapping("/index")
	@RequiresRoles(value={"0","1"}, logical=Logical.OR)
	public String index(HttpServletRequest request, Model model){
		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("userid", subject.getSession().getAttribute(Constants.USER_ID));
		solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		AProduct p = solrService.queryById(6, AProduct.class);
		System.out.println(p);
		
		return "index";
	}
	
	/**
	 * 婚纱 按系列
	 */
	@RequestMapping("/weddingdress")
	@RequiresRoles(value={"0","1"}, logical=Logical.OR)
	public String weddingdress(HttpServletRequest request, Model model){
		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("userid", subject.getSession().getAttribute(Constants.USER_ID));
		solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		AProduct p = solrService.queryById(6, AProduct.class);
		System.out.println(p);
		
		return "weddingdress";
	}
	
	/**
	 * 婚纱细览
	 */
	@RequestMapping("/weddingdress_detail")
	@RequiresRoles(value={"0","1"}, logical=Logical.OR)
	public String weddingdressdetail(HttpServletRequest request, Model model){
		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("userid", subject.getSession().getAttribute(Constants.USER_ID));
		solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		AProduct p = solrService.queryById(6, AProduct.class);
		System.out.println(p);
		
		return "weddingdress_detail";
	}
	
	/**
	 * 婚纱细览
	 */
	@RequestMapping("/store")
	@RequiresRoles(value={"0","1"}, logical=Logical.OR)
	public String store(HttpServletRequest request, Model model){
		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("userid", subject.getSession().getAttribute(Constants.USER_ID));
		solrService.setSolrCore(Constants.SOLRSERVICE_PRODUCT);
		AProduct p = solrService.queryById(6, AProduct.class);
		System.out.println(p);
		
		return "store";
	}
}
