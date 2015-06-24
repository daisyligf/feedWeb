package com.mofang.feedweb.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.form.FeedForumOfficalForm;
import com.mofang.feedweb.form.FeedHomeHotForumRankForm;
import com.mofang.feedweb.form.FeedHomeListHotForumForm;
import com.mofang.feedweb.form.FeedHomeListRecommendGameForm;
import com.mofang.feedweb.form.FeedHomeRecommendGameRankForm;
import com.mofang.feedweb.form.FeedHomeSubjectForm;
import com.mofang.feedweb.form.FeedHomeTickerForm;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;

@Controller
public class FeedUserNoticeMessageController extends FeedCommonController {
	
	
	//页面头部用户信息
	@RequestMapping(value = "/getUserNotice",method = RequestMethod.GET)
	public String getUserNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject json = getUserNotice(request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedUserNoticeMessageController.getUserNotice throw an error.", e);
			return null;
		}
	}
}