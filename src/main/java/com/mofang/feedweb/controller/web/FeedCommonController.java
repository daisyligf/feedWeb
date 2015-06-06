package com.mofang.feedweb.controller.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.component.UserComponent;
import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedTag;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.properties.annotation.ExternalUrlInfo;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;

public class FeedCommonController {

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	@Autowired
	private UserComponent userComp;
//	 @Autowired
//	 private HttpClientInfo connInfo;

	@Autowired
	private HttpComponent httpComp;

	protected String getFeedUrlInfo() {
		return externalUrlInfo.getFeed_info_url();
	}

	protected String getGame_info_url() {
		return externalUrlInfo.getGame_info_url();
	}

	protected String getGift_info_url() {
		return externalUrlInfo.getGift_info_url();
	}

	protected String getImage_info_url() {
		return externalUrlInfo.getImage_info_url();
	}

	protected String getUser_LogOut_info_url() {
		return externalUrlInfo.getUser_info_url() + Constant.USER_LOGOUT_URL;
	}

	protected String getUser_LogIn_info_url() {
		return externalUrlInfo.getUser_info_url() + Constant.USER_LOGIN_URL;
	}

	protected String getUser_Update_State_url() {
		return externalUrlInfo.getUser_info_url()
				+ Constant.USER_STATE_UPDATE_URL;
	}

	protected String getForumInfoGetUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.FORUM_INFO_GET_URL;
	}

	protected String getRoleInfoListGetUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.LIST_MODERATOR_GET_URL;
	}

	protected String getThreadListUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.LIST_THREAD_GET_URL;
	}

	protected String getTopThreadsUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.SUBJECT_INFO_GET_URL;
	}

	protected String getRecommendGameRankUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.RECOMMEND_GAME_RANK_GET_URL;
	}

	protected String getGameInfoUrl() {
		return externalUrlInfo.getGame_info_url() + Constant.GAME_INFO_URL;
	}

	protected String getGameGiftListUrl() {
		return externalUrlInfo.getGift_info_url() + Constant.GIFT_LIST_URL;
	}

	protected String getForumFollowUrl() {
		return externalUrlInfo.getUser_info_url() + Constant.FORUM_FOLLOW_URL;
	}

	protected String getModeratorCheckUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.MODERATOR_CHECK_URL;
	}

	protected String getModeratorApplyUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.MODERATOR_APPLY_URL;
	}

	protected String getThreadInfoUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.THREAD_INFO_URL;
	}

	protected String getPostListUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_POSTLIST_GET_URL;
	}

	protected String getCommentListUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_COMMENTLIST_GET_URL;
	}

	protected String getReplyPostUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.POST_REPLY_URL;
	}

	protected String getDelFloorUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.POST_DELETE_URL;
	}

	protected String getRecommendThreadUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_RECOMMEND_URL;
	}

	protected String getRecommendFloorUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.POST_COMMEND_URL;
	}

	protected String getCloseThreadUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.THREAD_CLOSE_URL;
	}

	protected String getOpenThreadUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.THREAD_OPEN_URL;
	}

	protected String getSetTopThreadUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.THREAD_SETTOP_URL;
	}

	protected String getCancelTopThreadUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_CANCELTOP_URL;
	}

	protected String getEliteThreadUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_SETELITE_URL;
	}

	protected String getCancelEliteThreadUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_CANCELELITE_URL;
	}

	protected String getUploadImgUrl() {
		return externalUrlInfo.getUpload_img_url();
	}

	protected String getSendReplyUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.POST_CREATE_URL;
	}
	
	protected String getThreadDeleteUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.THREAD_DELETE_URL;
	}
	
	protected String getViperAwardUrl() {
		return externalUrlInfo.getViper_info_url() + Constant.VIPER_AWARD_URL;
	}
	
	protected UserInfo getUserInfo(HttpServletRequest request) throws Exception {
		return userComp.getUserInfo(request);
	}
	
	protected boolean validate(HttpServletRequest request) throws Exception {
		return userComp.validate(request);
	}

	protected JSONObject getHttpInfo(String getUrl, String param,
			HttpServletRequest request) {
		try {
			String uid = "";
			if (null != request.getSession().getAttribute(
					Constant.SESSION_USERID)) {
				uid = String.valueOf(request.getSession().getAttribute(
						Constant.SESSION_USERID));
			}
			StringBuffer strb = new StringBuffer();
			strb.append(getUrl);
			strb.append(Constant.STR_QUESTION_MARK);
			strb.append(Tools.encodetoAtom(uid));

			if (!"".equals(param)) {
				strb.append(Constant.STR_AND);
				strb.append(param);
			}
			String result = httpComp.get(strb.toString());
			if (StringUtil.isNullOrEmpty(result))
				return null;

			return new JSONObject(result);

		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("FeedCommonController.getHttpInfo", e);
			return null;
		}
	}

	protected JSONObject postHttpInfo(String postUrl, JSONObject postData) {
		try {
			String atom = Tools.encodetoAtom("129707");
			String result = httpComp.post(postUrl + "?" + atom,
					postData.toString());
			if (StringUtil.isNullOrEmpty(result))
				return null;
			return new JSONObject(result);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG
					.error("FeedCommonController.postHttpInfo", e);
			return null;
		}
	}

	protected FeedForum getFeedForumInfo(HttpServletRequest request, long fid)
			throws JSONException {
		String param = "fid=" + fid;
		JSONObject json = getHttpInfo(getForumInfoGetUrl(), param, request);

		FeedForum feedForum = new FeedForum();
		if (json != null && json.optInt("code", -1) == 0) {
			JSONObject forum = json.optJSONObject("data");

			feedForum.setForum_id(forum.optLong("fid", 0));
			feedForum.setForum_name(forum.optString("name", ""));
			feedForum.setName_spell(forum.optString("name_spell", ""));
			feedForum.setIcon(forum.optString("icon", ""));
			feedForum.setType(forum.optInt("type", -1));
			feedForum.setGameId(forum.optInt("game_id", 0));
			feedForum.setTotal_threads(forum.optInt("threads", 0));
			feedForum
					.setYesterday_threads(forum.optInt("yesterday_threads", 0));
			feedForum.setTotal_follows(forum.optInt("follows", 0));
			feedForum.setYestoday_follows(forum.optInt("yesterday_follows", 0));
			feedForum.setCreate_time(new Date(forum.optLong("create_time", 0)));

			JSONArray tags = forum.optJSONArray("tags");
			List<FeedTag> tagList = new ArrayList<FeedTag>();
			if (tags != null && tags.length() > 0) {
				FeedTag feedTag = null;

				for (int i = 0; i < tags.length(); i++) {

					JSONObject tagJson = tags.getJSONObject(i);
					feedTag = new FeedTag(tagJson.optInt("tag_id", 0),
							tagJson.optString("tag_name", ""));
					tagList.add(feedTag);
				}
			}
			feedForum.setTags(tagList);
		}

		return feedForum;
	}

}
