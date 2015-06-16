package com.mofang.feedweb.controller;

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
import com.mofang.feedweb.global.GlobalObject;

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
		try {
			ModeratorApplyCondition condition = moderatorCheck(request, forumId);
			
			FeedForum feedForum = getFeedForumInfo(request, forumId);
			model.put("moderatorApplyCondition", condition);
			model.put("feedForum", feedForum);
			
			return new ModelAndView("apply_moderator", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedApplyModeratorController.applyCheck throw an error.", e);
			return new ModelAndView("apply_moderator", model);
		}
	}
	
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(HttpServletRequest request, HttpServletResponse response, @RequestParam("forum_id") long forumId, 
			@RequestParam("qq") String qq, @RequestParam("phone") String mobile, 
			@RequestParam("game_exp") String gameExp) throws Exception {
		try {
			JSONObject json = moderatorApply(request, forumId, qq, mobile);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedApplyModeratorController.apply throw an error.", e);
			return null;
		}
		
		
	}
	
	private ModeratorApplyCondition moderatorCheck(HttpServletRequest request, long forumId) {
		String param = "fid=" + forumId;
		
		getHttpInfo(getModeratorCheckUrl(), param, request);
		
		ModeratorApplyCondition condition = new ModeratorApplyCondition();
		
		condition.setIsPass(true);
		condition.setIsFollowOk(true);
		condition.setIsThreadsOk(true);
		condition.setIsIntervalOk(true);
		condition.setIsElitecountOk(true);
		return condition;
	}
	
	private JSONObject moderatorApply(HttpServletRequest request, long forumId, String qq, String mobile) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("fid", forumId);
			postData.put("qq", qq);
			postData.put("mobile", mobile);
			
			JSONObject json = postHttpInfo(getModeratorApplyUrl(), postData, request);
			if (json != null && json.optInt("code", -1) == 0) {
				return json.optJSONObject("data");
			}
			return new JSONObject();
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedApplyModeratorController.moderatorApply throw an error.", e);
			return new JSONObject();
		}
	}
}
