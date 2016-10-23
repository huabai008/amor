package com.amor.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amor.core.util.Constants;

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
	@RequestMapping("/index")
	@RequiresRoles("2")
	public String index(HttpServletRequest request, Model model){
		Subject subject = SecurityUtils.getSubject();
		model.addAttribute("userid", subject.getSession().getAttribute(Constants.USER_ID));
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
