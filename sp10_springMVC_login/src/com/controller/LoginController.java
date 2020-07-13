package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDao;

@Controller
//@RequestMapping(value="/login.bo")
//@RequestMapping(method = RequestMethod.GET)
public class LoginController {
	
	@Autowired
	private MemberDao dao;
	
	@RequestMapping(value="/login.bo", method = RequestMethod.GET)
	public String form() {
		
		return "loginForm";
	}
	
	@RequestMapping(value="/login.bo", method = RequestMethod.POST)
	public String submit
	(
			@RequestParam(value="id", required = true) String id,
			@RequestParam(value="pwd", required = true) String pwd,
			HttpSession session //session 객체를 얻기
			) throws Exception
	
	{
		
		String view = null;
		boolean isMember = dao.memberCheck(id, pwd);
		System.out.println("isMember : " + isMember);
		
		if (isMember) {
			session.setAttribute("USERID", id);
			view = "loginSuccess";
		}else {
			view = "loginForm";
		}
		return view;
	}

}
