package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.MemberDao;
import com.model.MemberVO;

@Controller
@RequestMapping(value="/check.bo")
public class MemberCheckController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "membercheckForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(@RequestParam(value = "id", required = true) String id ) throws Exception {
		
		MemberVO vo = memberDao.selectMemberById(id);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("memberok", vo);
		if(vo != null) {
			mav.setViewName("mambercheckSuccess");
		}else {
			mav.setViewName("membercheckForm");
		}
		return mav;
	}
	

}
