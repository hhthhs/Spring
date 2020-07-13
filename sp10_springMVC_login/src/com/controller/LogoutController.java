package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout.bo")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("logout 실행");
		return "loginForm";
	}

}
