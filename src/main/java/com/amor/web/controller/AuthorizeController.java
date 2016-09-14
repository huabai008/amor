package com.amor.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amor.orm.model.AAuthority;
import com.amor.service.AuthorityService;

/**
 * 授权与验证控制器
 * @author huaba
 *
 */
@Controller
@RequestMapping(value="/auth")
public class AuthorizeController {
	
	@Resource
	private AuthorityService authorityService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid AAuthority auth, BindingResult result, HttpServletRequest request, Model model){
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				return "redirect:/";
			}
			if(result.hasErrors()){
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			subject.login(new UsernamePasswordToken(auth.getUsername(), auth.getPassword()));
			final AAuthority authInfo = authorityService.selectByName(auth.getUsername());
			request.getSession().setAttribute("userInfo", authInfo);
		}catch(AuthenticationException e){
			model.addAttribute("error", e.getMessage());
			return "login";
		}
		return "redirect:/";
	}

}
