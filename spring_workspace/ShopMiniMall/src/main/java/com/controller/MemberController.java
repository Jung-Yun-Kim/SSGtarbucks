package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;

	//�쉶�썝媛��엯�솕硫� 蹂닿린
	@GetMapping("/MemberUIServlet")
	public String memberUI() {
		return "memberForm";
	}
	
	//id 以묐났泥댄겕
	//�븳湲��씤肄붾뵫 泥섎━
	@GetMapping(value="/MemberIdCheckServlet", produces="text/plain;charset=utf-8")
	@ResponseBody // jackson-databind �쓽議댁꽦 異붽�
	public String idCheck(@RequestParam String userid) {
		System.out.println("------MemberIdCheckServlet (GET)------");
		String mesg="�븘�씠�뵒 以묐났";
		MemberDTO dto = mService.idCheck(userid);
		if(dto==null) {
			mesg="�븘�씠�뵒 �궗�슜 媛��뒫";
		}
		System.out.println("idCheck mesg 寃곌낵 : "+ mesg);
		return mesg;
	}
	
	//�쉶�썝�벑濡�
	@PostMapping("/MemberAddServlet")
	public String memberAdd(MemberDTO dto) {
		System.out.println("------MemberAddServlet (POST)------");
		System.out.println(dto);
		int n = mService.memberAdd(dto);
		return "redirect:main";
	}
	

	
	
}
