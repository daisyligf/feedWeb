package com.mofang.feedweb.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.config.ExternalUrlInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedSearchService;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;

/**
 * 
 * @author linjx
 */
@Service("feedSearchService")
public class FeedSearchServiceImpl implements FeedSearchService {

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	@Autowired
	private HttpComponent httpComp;

	@Override
	public JSONObject searchForum(String requestParam,
			HttpServletRequest request) throws Exception {
		try {
			JSONObject result = httpComp.getHttpInfo(externalUrlInfo.getFeed_info_url()
					+ Constant.LIST_FORUM_SEARCH_URL, requestParam, request);
			if (result == null) {
				return new JSONObject();
			}
			int code = result.optInt("code", -1);
			if (code == 0) {
				JSONObject objData = result.optJSONObject("data");
				JSONArray jsonArr = objData.optJSONArray("list");
				for (int idx = 0; idx < jsonArr.length(); idx++) {
					JSONObject objForum = jsonArr.getJSONObject(idx);
					long fid = objForum.optLong("fid", 0l);
					objForum.put("link_url", "forum/" + fid + ".html");
					
					String prefectureUrl = objForum.optString("prefecture_url", "");
					if(StringUtil.isNullOrEmpty(prefectureUrl) || prefectureUrl.equals("null")) {
						objForum.put("prefecture_url", "null");
					}
					String giftUrl = objForum.optString("gift_url", "");
					if(StringUtil.isNullOrEmpty(giftUrl) || giftUrl.equals("null")) {
						objForum.put("gift_url", "null");
					}
				}
			}
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedSearcheServiceImpl.searchForum throw an error.", e);
			return new JSONObject();
		}
	}

	@Override
	public JSONObject searchThread(String requestParam,
			HttpServletRequest request) throws Exception {
		try {
			JSONObject result = httpComp.getHttpInfo(
					externalUrlInfo.getFeed_info_url()
							+ Constant.LIST_THREAD_SEARCH_URL, requestParam,
					request);
			if (result == null) {
				return new JSONObject();
			}
			int code = result.optInt("code", -1);
			if (code == 0) {
				JSONObject objData = result.optJSONObject("data");
				JSONArray jsonArr = objData.optJSONArray("threads");
				for (int idx = 0; idx < jsonArr.length(); idx++) {
					JSONObject objThread = jsonArr.getJSONObject(idx);
					String content = objThread.optString("content", "");
					if (!StringUtil.isNullOrEmpty(content)) {
						// content字段截取40个字符显示
						if (content.length() > 40) {
							content = content.substring(0, 39);
							content = content.concat("...");
							objThread.put("content", content);
						}
					}
					long threadId = objThread.optLong("tid", 0l);
					objThread.put("link_url", "thread_info?thread_id="
							+ threadId);
					
					JSONArray pics = objThread.optJSONArray("pic");
					String htmlContent = objThread.optString("html_content", "");
					objThread.put("is_pic", Tools.hasPic(pics, htmlContent));
				}
			}
			return result;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedSearcheServiceImpl.searchForum throw an error.", e);
			return new JSONObject();
		}
	}

}
