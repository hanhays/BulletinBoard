package com.naver.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.dto.LoginTo;
import com.naver.dto.MemberDTO;
import com.naver.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Inject
	private UserService uservice;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() {
		
	}
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	public void login(LoginTo to, Model model) {
		LoginTo lto = uservice.login(to);
		model.addAttribute("login", lto);
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "enroll", method = RequestMethod.GET)
	public void enrollui() {
		
	}
	
	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public String enroll(MemberDTO dto) {
		uservice.enroll(dto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "myinfo/{id}", method = RequestMethod.GET)
	public String myinfo(@PathVariable("id") String id, Model model) {
		MemberDTO dto = uservice.myinfo(id);
		model.addAttribute("dto", dto);
		return "user/myinfo";
	}
	
	@RequestMapping(value = "revise/{id}", method = RequestMethod.GET)
	public String reviseui(@PathVariable("id") String id, Model model) {
		MemberDTO dto = uservice.myinfo(id);
		model.addAttribute("dto", dto);
		return "/user/revise";
	}
	
	@RequestMapping(value = "revise", method = RequestMethod.POST)
	public String revise(MemberDTO dto) {
		uservice.revise(dto);
		return "redirect:/user/myinfo/"+dto.getId();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String id, HttpSession session) {
		uservice.delete(id);
		session.invalidate();
		return "redirect:/";
	}
}
