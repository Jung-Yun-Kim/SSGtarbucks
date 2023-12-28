package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class MainController {
	
	@Autowired
	GoodsService gService;
	
	@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue="top") String gCategory
						,Model m){
		//RequestParam �뾾�쑝硫� 400�뿉�윭 諛쒖깮
		//RequestParam(required=true)媛� 湲곕낯媛믪씠誘�濡� false瑜� 二쇨굅�굹 珥덇린媛믪＜嫄곕굹 �븯硫� �맖
		
		//Goods �뀒�씠釉� �뜲�씠�꽣 移댄뀒怨좊━蹂꾨줈 寃��깋
		List<GoodsDTO> list = gService.goodsList(gCategory);
		m.addAttribute("goodsList",list); //湲곕낯媛� requestScope -> main.jsp�� goodslist.jsp �몮 �떎 �씠�슜媛��뒫
		
		return "main"; //WEB-INF/views/main.jsp
	}
	

}
