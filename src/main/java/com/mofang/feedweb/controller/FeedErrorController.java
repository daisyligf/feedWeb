package com.mofang.feedweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.form.FeedForumOfficalForm;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;

@Controller
public class FeedErrorController extends FeedCommonController{
	@RequestMapping(value = "/error")
	public ModelAndView  error(HttpServletRequest request) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			//搜索关键词
			model.put("keyword", getSearchKey(request));
			//官方版块
			model.put("officalForum", getHomeOfficalForum(request));
			return new ModelAndView("error", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("FeedErrorController.error throw an error.", e);
			return new ModelAndView("error", model);
		}
	}
	
	private FeedForumOfficalForm getHomeOfficalForum(
			HttpServletRequest request) throws JSONException {
		
		FeedForumOfficalForm form = new FeedForumOfficalForm();
		
		try {
			//官方版块
			JSONObject officalResult = getHttpInfo(
					getFeedUrlInfo().concat(
							Constant.PREFECTURE_INFO_GET_URL),"" , request);
			if (null != officalResult) {
				
				int code = officalResult.optInt("code", -1);
				if(0 != code) {
				} else {
					
					JSONArray data = officalResult.optJSONArray("data");
					JSONObject json = null;
					for(int i=0; i<data.length(); i++)
					{
						json = data.getJSONObject(i);
						if (i == 0) {
							form.setForumId1(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName1(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName1(json.optString("forum_name", ""));
							}
							form.setIcon1(json.optString("icon", ""));
							form.setTodayThreads1(json.optInt("today_threads", 0));
							form.setTotalThreads1(json.optInt("total_threads", 0));
						} else if (i == 1) {
							form.setForumId2(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName2(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName2(json.optString("forum_name", ""));
							}
							form.setIcon2(json.optString("icon", ""));
							form.setTodayThreads2(json.optInt("today_threads", 0));
							form.setTotalThreads2(json.optInt("total_threads", 0));
						} else if (i == 2) {
							form.setForumId3(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName3(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName3(json.optString("forum_name", ""));
							}
							form.setIcon3(json.optString("icon", ""));
							form.setTodayThreads3(json.optInt("today_threads", 0));
							form.setTotalThreads3(json.optInt("total_threads", 0));
						} else if (i == 3) {
							form.setForumId4(json.optLong("forum_id", 0));
							if (json.optString("forum_name", "").length() > 8) {
								form.setForumName4(json.optString("forum_name", "").substring(0, 8));
							} else {
								form.setForumName4(json.optString("forum_name", ""));
							}
							form.setIcon4(json.optString("icon", ""));
							form.setTodayThreads4(json.optInt("today_threads", 0));
							form.setTotalThreads4(json.optInt("total_threads", 0));
						}
						
					}
					
				}
				
			}
			return form;
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedErrorController.getHomeOfficalForum throw an error.", e);
			return form;
		}
		
	}
}
