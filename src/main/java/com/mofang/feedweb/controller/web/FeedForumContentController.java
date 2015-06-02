package com.mofang.feedweb.controller.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedTag;

/**
 * 
 * @author daisyli
 * 版块内容页（即帖子列表页）
 *
 */
@Controller
public class FeedForumContentController extends FeedCommonController {
	
	@RequestMapping(value = "/forum_content", method = RequestMethod.GET)
	public ModelAndView forumContent(HttpServletRequest request, @RequestParam("fid") long fid) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		// 获取版块信息
		String param = "fid=" + fid;
		JSONObject json = getHttpInfo(getForumInfoGetUrl(), param, request);
		
		FeedForum feedForum = new FeedForum();
		if (json.optInt("code", -1) == 0) {
			feedForum = makeFeedForum(json);
		}
		model.put("feedForum", feedForum);
		
		// 获取版块下的帖子列表
//		json = getHttpInfo(getForumInfoGetUrl(), param, request);
		
		
		// 获取该版块的吧主列表
		
		
		// if 是官方版块，获取头条列表和新游推荐
		
		
		// else 获取该版块关联的游戏信息和礼包发号
		
		return new ModelAndView("forum_content", model);
	}
	
	private FeedForum makeFeedForum(JSONObject json)
			throws JSONException {
		JSONObject forum = json.optJSONObject("data");
		FeedForum feedForum = new FeedForum();
		
		feedForum.setForum_id(forum.optLong("fid", 0));
		feedForum.setForum_name(forum.optString("name", ""));
		feedForum.setName_spell(forum.optString("name_spell", ""));
		feedForum.setIcon(forum.optString("icon", ""));
		feedForum.setType(forum.optInt("type", -1));
		feedForum.setTotal_threads(forum.optInt("threads", 0));
		feedForum.setYesterday_threads(forum.optInt("yesterday_threads", 0));
		feedForum.setTotal_follows(forum.optInt("follows", 0));
		feedForum.setYestoday_follows(forum.optInt("yesterday_follows", 0));
		feedForum.setCreate_time(new Date(forum.optLong("create_time", 0)));
		
		JSONArray tags = forum.optJSONArray("tags");
		List<FeedTag> tagList = new ArrayList<FeedTag>();
		if (tags != null && tags.length() > 0) {
			FeedTag feedTag = null;
			
			for (int i = 0; i < tags.length(); i++) {
				
				JSONObject tagJson = tags.getJSONObject(i);
				feedTag = new FeedTag(tagJson.optInt("tag_id", 0), tagJson.optString("tag_name", ""));
				tagList.add(feedTag);
			}
		}
		feedForum.setTags(tagList);
		return feedForum;
	}
	
}

