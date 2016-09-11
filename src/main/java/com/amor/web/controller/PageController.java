package com.amor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理jsp
 * @author huaba
 *
 */

@Controller
@RequestMapping(value="/page")
public class PageController {
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
