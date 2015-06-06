package com.mofang.feedweb.controller.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.ModeratorApplyCondition;

/**
 * 
 * @author daisyli
 * 版主申请页
 *
 */
@Controller
public class FeedApplyModeratorController extends FeedCommonController {

	@RequestMapping(value = "/apply_check", method = RequestMethod.GET)
	public ModelAndView applyCheck(HttpServletRequest request, @RequestParam("forum_id") long forumId) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		ModeratorApplyCondition condition = moderatorCheck(request, forumId);
		
		FeedForum feedForum = getFeedForumInfo(request, forumId);
		model.put("moderatorApplyCondition", condition);
		model.put("feedForum", feedForum);
		
		return new ModelAndView("apply_moderator", model);
	}
	
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(HttpServletRequest request, HttpServletResponse response, @RequestParam("forum_id") long forumId, 
			@RequestParam("qq") String qq, @RequestParam("phone") String mobile, 
			@RequestParam("game_exp") String gameExp) throws Exception {
		JSONObject json = moderatorApply(request, forumId, qq, mobile);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
		
	}
	
	private ModeratorApplyCondition moderatorCheck(HttpServletRequest request, long forumId) {
		String param = "fid=" + forumId;
		
		JSONObject json = getHttpInfo(getModeratorCheckUrl(), param, request);
		
		ModeratorApplyCondition condition = new ModeratorApplyCondition();
//		if (json != null && json.optInt("code", -1) == 0) {
//			JSONObject data = json.optJSONObject("data");
//			if (data == null || data.length() == 0) {
//				return condition;
//			}
//			
//			condition.setIsPass(data.optBoolean("is_pass", false));
//			condition.setIsFollowOk(data.optBoolean("is_follow_ok", false));
//			condition.setIsThreadsOk(data.optBoolean("is_threads_ok", false));
//			condition.setIsIntervalOk(data.optBoolean("is_interval_ok", false));
//			condition.setIsElitecountOk(data.optBoolean("is_elitecount_ok", false));
//			
//			return condition;
//		}
		
		condition.setIsPass(true);
		condition.setIsFollowOk(true);
		condition.setIsThreadsOk(true);
		condition.setIsIntervalOk(true);
		condition.setIsElitecountOk(true);
		return condition;
	}
	
	private JSONObject moderatorApply(HttpServletRequest request, long forumId, String qq, String mobile) throws Exception {
		JSONObject postData = new JSONObject();
		postData.put("fid", forumId);
		postData.put("qq", qq);
		postData.put("mobile", mobile);
		
		JSONObject json = postHttpInfo(getModeratorApplyUrl(), postData, request);
		if (json != null && json.optInt("code", -1) == 0) {
			return json.optJSONObject("data");
		}
		return new JSONObject();
	}
}
