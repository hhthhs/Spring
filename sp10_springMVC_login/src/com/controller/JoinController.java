package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDao;

@Controller
public class JoinController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value="/join.bo", method = RequestMethod.GET)
	public String form() {	//get
		System.out.println("form 실행");
		return "joinForm"; //view > /WEB-INF/views/ + joinForm + .jsp
	}
	
	@RequestMapping(value="/join.bo", method = RequestMethod.POST)
	public String submit(
				@RequestParam(value = "id", required = true) String id,
				@RequestParam(value = "name", required = true) String name,
				@RequestParam(value = "pwd", required = true) String pwd,
				@RequestParam(value = "email", required = true) String email,
				@RequestParam(value = "age", required = true) int age
			) throws Exception 
	{	//post
	String view = null;
	boolean joinMember = memberDao.memberInsert(id, name, pwd, email, age);
	System.out.println(joinMember);
	
	if(joinMember) {
		view = "joinSuccess";
	}else {
		view = "joinForm";
	}
	
	return view;
		
	}
}
