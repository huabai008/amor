package com.amor.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amor.orm.model.AProduct;
import com.amor.orm.model.AProductImage;
import com.amor.orm.model.PageForSolr;
import com.amor.service.ProductInfoService;
import com.amor.service.ProductSearchService;
import com.amor.web.solr.SolrDataInit;

@Controller
@RequestMapping(value = "/product")
public class ProductSearchController {
	@Resource
	private ProductSearchService productSearchService;
	
	@Resource
	private ProductInfoService productService;

	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request, HttpServletResponse response, Model model) {
		String search_text = request.getParameter("searchtext");
		model.addAttribute("searchtext", search_text);
		String facet_text = request.getParameter("facettext");
		model.addAttribute("facettext", facet_text);
		String filter_text = request.getParameter("filtertext");
		model.addAttribute("filtertext", filter_text);		
		
		SolrQuery query = new SolrQuery();
		try {
			if(search_text == null || search_text.equals(""))
				query.setQuery("all:*");
			else
				query.setQuery("all:"+search_text);
			
			if(filter_text != null && !filter_text.equals("")){
				//增加过滤条件
				
			}
			
			int pageNum, pageSize;
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (Exception e) {
				pageNum = 1;
			}
			try {
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			} catch (Exception e) {
				pageSize = 12;
			}

			PageForSolr<AProduct> page = new PageForSolr<>();
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setQuery(query);
			
			page.addFacetField("itemType");
			page.addFacetField("trends");
			page.addFacetField("color");

			productSearchService.serarchAllByPage(page);
			model.addAttribute("page", page);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "product_search";
	}
	
	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer id;
		if(request.getParameter("id") == null || request.getParameter("id").equals(""))
			return "401";
		else
			id = Integer.parseInt(request.getParameter("id"));
		
		AProduct product = productSearchService.serarchDeatil(id);
		model.addAttribute("product", product);
		
		List<AProductImage> images = productService.selectProductImageByID(id);
		model.addAttribute("images", images);
		
		return "product_detail";
	}
	
	@Resource
	private SolrDataInit solrInit;
	
	@RequestMapping(value = "/initIndex")
	public void initIndex(){
		solrInit.initAll();
	}
}
