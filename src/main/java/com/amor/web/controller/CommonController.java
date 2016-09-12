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
	
	/**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
}
