package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	MemberService mService;

	//濡쒓렇�씤 �솕硫대낫湲�
	@GetMapping("/LoginUIServlet")
	public String loginUI() {
		return "loginForm";
	}
	
	//濡쒓렇�씤
	@GetMapping("/LoginServlet")
	public String login(@RequestParam HashMap<String, String> map, HttpSession session) {
		
		MemberDTO dto = mService.login(map);
		String nextPage = null;
		if(dto !=null) {
			//�꽭�뀡���옣
			session.setAttribute("login", dto);
			nextPage = "redirect:main";
		}else {
			// id�� pw ��由� 寃쎌슦濡쒖꽌 �떎�떆 濡쒓렇�씤�븯�룄濡� 泥섎━
			nextPage ="member/loginFail";
		}
		return nextPage;
	}
	
	//濡쒓렇�븘�썐
	@GetMapping("/LogoutServlet")
	public String logout(HttpSession session) {
		//濡쒓렇�씤 �뿬遺� �솗�씤 => HandlerInterceptor �궗�슜
		session.invalidate();
		return "redirect:main";
	}

}
