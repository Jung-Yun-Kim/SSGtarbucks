package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MypageController {
	
	@Autowired
	MemberService mService;
	
	
	@GetMapping("/MypageServlet")
	public String mypage(HttpSession session, Model model) {
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		model.addAttribute("loginDTO", dto);
		return "mypage";
	}

	@PostMapping("/MemberModifyServlet")
	public String memberModify(MemberDTO dto, HttpSession session) {
		int value = mService.updateMember(dto);
		session.setAttribute("login", dto);		//세션에 저장된 로그인 정보 업데이트
		return "redirect:main";
	}
	
	
	
}
