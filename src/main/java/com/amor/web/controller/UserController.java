package com.amor.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.SpringLayout.Constraints;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amor.core.util.Constants;
import com.amor.orm.model.AUser;
import com.amor.service.UserService;
import com.amor.web.security.UsernamePasswordWithCaptchaToken;

/**
 * 授权与验证控制器
 * @author huaba
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid AUser user, BindingResult result, HttpServletRequest request, Model model){
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				return "redirect:/";
			}
			if(result.hasErrors()){
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			boolean rememberMe = Boolean.valueOf(request.getParameter("remember"));
			subject.login(new UsernamePasswordWithCaptchaToken(user.getUsername(), user.getPassword(), rememberMe, null, request.getParameter("captchaCode")));
		}catch(AuthenticationException e){
			model.addAttribute("error", e.getMessage());
			return "login";
		}
		return "redirect:/";
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().removeAttribute("userInfo");
		subject.logout();
		return "login";
	}
}
