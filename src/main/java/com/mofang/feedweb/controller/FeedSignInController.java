package com.mofang.feedweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedSignInService;

@Controller
public class FeedSignInController extends FeedCommonController{
	@Autowired
	FeedSignInService feedSignInService;
	
	@RequestMapping(value = "/getSignInState")
	public void getSignInState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
			JSONObject json = feedSignInService.getSignInstate(request);
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json.toString());
			
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedSignInController.getSignInState throw an error.", e);
		}
	}
	
	@RequestMapping(value = "/addSignIn")
	public void addSignIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			JSONObject json = feedSignInService.addSignIn(request);
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json.toString());
			
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedSignInController.addSignIn throw an error.", e);
		}
	}
	
}
