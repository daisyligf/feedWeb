package com.mofang.feedweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.config.ExternalUrlInfo;
import com.mofang.feedweb.entity.FeedTag;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.ThreadUserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedNewThreadService;
import com.mofang.feedweb.util.StringUtil;

@Service("feedNewThreadService")
public class FeedNewThreadServiceImpl implements FeedNewThreadService {

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	@Autowired
	private HttpComponent httpComp;
	
	@Override
	public Map<String, Object> userMap(String requestParam,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(1);
		try {
			JSONObject userResult = httpComp.getHttpInfo(externalUrlInfo.getFeed_info_url()
					+ Constant.USER_INFO_URL, requestParam, request);
			ThreadUserInfo info = new ThreadUserInfo();
			if (userResult != null) {
				int code = userResult.optInt("code", -1);
				if (code == 0) {
					JSONObject data = userResult.optJSONObject("data");
					info.setUserId(data.optLong("user_id", 0));
					info.setNickname(data.optString("nickname", ""));
					info.setAvatar(data.optString("avatar", ""));
					info.setReplies(data.optInt("replies", 0));
					info.setLevel(data.optInt("level", 0));
					info.setThreads(data.optInt("threads", 0));
					info.setEliteThreads(data.optInt("elite_threads", 0));
					info.setCoin(data.optInt("coin", 0));
				}
			}
			map.put("user", info);
			return map;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadServiceImpl.userMap throw an error.", e);
			map.put("user", new ThreadUserInfo());
			return map;
		}
	}

	@Override
	public Map<String, Object> tagMap(String requestParam,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(1);
		try {
			JSONObject tagResult = httpComp.getHttpInfo(externalUrlInfo.getFeed_info_url()
					+ Constant.FORUM_TAG_LIST_URL, requestParam, request);
			List<FeedTag> tagList = new ArrayList<FeedTag>();
			if (tagResult != null) {
				int code = tagResult.optInt("code", -1);
				if (code == 0) {
					JSONArray data = tagResult.optJSONArray("data");
					for (int idx = 0; idx < data.length(); idx++) {
						JSONObject jsonFeedTag = data.getJSONObject(idx);

						FeedTag tag = new FeedTag();
						tag.setTag_id(jsonFeedTag.optInt("tag_id", 0));
						tag.setTag_name(jsonFeedTag.optString("tag_name", ""));
						if(!StringUtil.isNullOrEmpty(tag.getTag_name())) {
							tagList.add(tag);
						}
					}
				}
			}
			if(tagList.size() == 0) {
				tagList.add(new FeedTag(0, "综合"));
			}
			map.put("tagList", tagList);
			return map;			
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadServiceImpl.tagMap throw an error.", e);
			map.put("tagList", new ArrayList<FeedTag>(1));
			return map;
		}
	}

	@Override
	public Map<String, Object> threadInfoMap(String requestParam,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(1);
		try {
			FeedThread threadinfo = new FeedThread();
			JSONObject threadResult = httpComp.getHttpInfo(externalUrlInfo.getFeed_info_url()
					+ Constant.THREAD_INFO_URL, requestParam, request);
			if (threadResult != null) {
				int code = threadResult.optInt("code", -1);
				if (code == 0) {
					JSONObject data = threadResult.optJSONObject("data");

					threadinfo.setThread_id(data.optLong("tid", 0));
					threadinfo.setSubject(data.optString("subject", ""));
					threadinfo.setHtmlContent(data.optString("html_content", ""));
					threadinfo.setPic(data.optString("pic", ""));
					threadinfo.setTagId(data.optInt("tag_id", 0));

				}
			}
			map.put("threadInfo", threadinfo);
			return map;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadServiceImpl.threadInfoMap throw an error.", e);
			map.put("threadInfo", new FeedThread());
			return map;
		}
	}

	@Override
	public JSONObject newThread(JSONObject json, HttpServletRequest request)
			throws Exception {
		JSONObject obj = new JSONObject();
		try {
			JSONObject result = httpComp.postHttpInfo(externalUrlInfo.getFeed_info_url() + Constant.THREAD_CREATE_URL, json, request);
			int code;
			if(result != null && (code = result.optInt("code", -1)) == 0) {
				String message = result.optString("message", "");
				obj.put("code", code);
				obj.put("message", message);
			}else{
				obj.put("code", -1);
				obj.put("message", "保存失败");
			}
			return obj;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadServiceImpl.newThread throw an error.", e);
			obj.put("code", -1);
			obj.put("message", "保存失败");
			return obj;
		}
	}

	@Override
	public JSONObject editThread(JSONObject json, HttpServletRequest request)
			throws Exception {
		JSONObject obj = new JSONObject();
		try {
			JSONObject result = httpComp.postHttpInfo(externalUrlInfo.getFeed_info_url() + Constant.THREAD_EDIT_URL, json, request);
			int code;
			if(result != null && (code = result.optInt("code", -1)) == 0) {
				String message = result.optString("message", "");
				obj.put("code", code);
				obj.put("message", message);
			}else{
				obj.put("code", -1);
				obj.put("message", "保存失败");
			}
			return obj;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadServiceImpl.editThread throw an error.", e);
			obj.put("code", -1);
			obj.put("message", "保存失败");
			return obj;
		}
	}

}
