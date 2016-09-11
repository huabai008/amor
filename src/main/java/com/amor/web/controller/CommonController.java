package com.amor.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共控制器
 * @author zhangyue
 *
 */

@Controller
public class CommonController {
	/**
	 * 首页
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request){
		return "index";
	}
}
