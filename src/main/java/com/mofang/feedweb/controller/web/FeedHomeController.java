package com.mofang.feedweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.global.Constant;

@Controller
public class FeedHomeController extends FeedCommonController {
	
	
	// home主页初期信息显示
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) throws Exception {
		
		//bbs首页进来时，获取用户id
		String uid = "";
		if (null !=  request.getSession().getAttribute("uid")) {
			uid = String.valueOf(request.getSession().getAttribute("uid"));
		}
		request.getSession().setAttribute(Constant.SESSION_OPERATORID, uid);
		
//		Cookie[] cookies=request.getCookies();//从request中获得cookie对象的集合  
//		String userID="";//登录用户   
//		if(cookies!=null){  
//		    for(int i=0;i<cookies.length;i++){  
//		        if(cookies[i].getName().equals("uid")){  
//		            userID = URLDecoder.decode(cookies[i].getValue());//获取用户名                                                                
//		        }  
//		    }  
//		                                                                     
//		}
		
		
		//搜索关键字
		JSONObject keywordResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.HOME_SEARCH_KEYWORD_GET_URL),"" , request);
		Map<String, Object> model = new HashMap<String, Object>();
		if (null != keywordResult) {
			int code = keywordResult.optInt("code", -1);
			if (0 != code) {
			} else {
				JSONObject data = keywordResult.optJSONObject("data");
				model.put("recommendSearchKey", data.optString("key_word", ""));
			}	
		}
		//大小标题
		model.put("subjects", getHomeSubjects(request));
		//热游推荐榜单
		model.put("hotRank", getHomeHotForumRank(request));
		//新游推荐榜单
		model.put("recommendRank", getHomeRecommendRank(request));
		//热游版块
		model.put("hotForum", getHomeListHotForum(request));
		//新游版块
		model.put("recommendForum", getHomeListRecommendForum(request));
		//官方版块
		model.put("officalForum", getHomeOfficalForum(request));
		
		
		return new ModelAndView("index", model);

	}
}
