package com.amor.web.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amor.orm.model.AProduct;
import com.amor.service.ProductInfoService;

/**
 * 产品信息控制器
 * @author sicong.yang
 */
@Controller
@RequestMapping(value="/product")
public class ProductInfoController {
	
	@Resource
	private ProductInfoService productInfoSerivce;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_type");
		model.addAttribute("typeMap", map);
		return "product_main";
	}
	
	@RequestMapping(value="/record")
	public String record(Model model) {
		try {
			String[] dicts = {"trends", "silhouette", "neckline", "waistline", "sleeve", 
							  "color", "size", "type", "collar_stays", "cuff_words_type", 
							  "version", "placket"};
			for (String dict : dicts) {
				Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_"+dict);
				model.addAttribute(dict + "Map", map);
			}
			return "record";
		} catch (Error e) {
			model.addAttribute("error", e);
			return "record";
		}
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String submit(@Valid AProduct product, HttpServletRequest request, Model model) {
		Map<Integer, String> map = productInfoSerivce.getBusinessDict("product_type");
		model.addAttribute("typeMap", map);
		try {
			// common attributes
			product.setItemCode(request.getParameter("item_no"));
			Integer type = Integer.parseInt(request.getParameter("type"));
			product.setItemType(type);
			product.setPriceCost(Double.parseDouble(request.getParameter("price_cost")));
			product.setPriceAgent(Double.parseDouble(request.getParameter("price_agent")));
			product.setPriceRent(Double.parseDouble(request.getParameter("price_rent")));
			product.setPriceSell(Double.parseDouble(request.getParameter("price_sell")));
			product.setPriceAlliance(Double.parseDouble(request.getParameter("price_alliance")));
			product.setCreateTime(new Date());
			product.setUpdateTime(new Date());
			product.setCreateUid(Integer.parseInt(request.getParameter("user_no")));
			product.setUpdateUid(Integer.parseInt(request.getParameter("user_no")));
			
			// wedding
			if (type == 0 || type == 1) {
				String[] trends = request.getParameterValues("trends");
				product.setTrends(String.join(",", trends));
				product.setSilhouette(request.getParameter("silhouette"));
				product.setNeckline(request.getParameter("waistline"));
				product.setWaistline(request.getParameter("waistline"));
				product.setSleeve(request.getParameter("sleeve"));
				product.setColor(request.getParameter("color"));
				product.setSize(request.getParameter("size"));
			}
			
			// shirt
			if (type == 2) {
				product.setCollarStays(Integer.parseInt(request.getParameter("collar")));
				product.setPlacket(Integer.parseInt(request.getParameter("placket")));
				product.setVersion(Integer.parseInt(request.getParameter("version")));
				product.setWhiteCollarSleeve(Integer.parseInt(request.getParameter("white_collar")));
				product.setPocket(request.getParameter("pocket"));
				product.setMaterial(request.getParameter("material"));
			}
			// suit
			if (type == 3) {
				
			}
			
			productInfoSerivce.insertProductInfo(product);
			model.addAttribute("success", 1);
			
			return "product_main";
		} catch (Exception err) {
			model.addAttribute("success", 0);
			model.addAttribute("error", err.getMessage());
			return "product_main";
		}
	}

}
