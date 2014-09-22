package com.gofaner.game.lswht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gofaner.game.lswht.dto.ExchangeCodeView;
import com.gofaner.game.lswht.dto.ViewDTO;
import com.gofaner.game.lswht.service.IExchangeCodeService;
import com.gofaner.game.lswht.service.IUserService;

@Controller
public class GameController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IExchangeCodeService exchangeCodeService;
	
	@RequestMapping("/lswht")
	public ModelAndView gameIndex(){
		ModelAndView mav = new ModelAndView("redirect:/game/index.jsp"); 
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/getPlayTime")
	public ViewDTO<Integer> getPlayTime(
			String loginToken){
		ViewDTO<Integer> view = userService.getPlayTime(loginToken);
		return view;
	}
	
	@RequestMapping("/input-mobile")
	public ModelAndView inputMobile(){
		ModelAndView mav = new ModelAndView("game/input-mobile"); 
		
		return mav;
	}
	
	@RequestMapping("/exchange-code")
	public ModelAndView exchangeCode(){
		ModelAndView mav = new ModelAndView("game/exchange-code"); 
		
		return mav;
	}
	
	@RequestMapping("/getmycodes")
	@ResponseBody
	public ViewDTO<List<ExchangeCodeView>> exchangeCode(String userid){
		ViewDTO<List<ExchangeCodeView>> view = exchangeCodeService.listMyCodes(userid);
		
		return view;
	}
	
	@RequestMapping("/getonecodes")
	@ResponseBody
	public ViewDTO<ExchangeCodeView> getOneCodes(String userid,Integer codeType,HttpServletRequest request){
		String remoteIP = request.getRemoteHost();
		ViewDTO<ExchangeCodeView> view = exchangeCodeService.deliverCode(userid,codeType,remoteIP);
		
		return view;
	}
	
}
