package com.mofang.feedweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.component.UserComponent;
import com.mofang.feedweb.config.ExternalUrlInfo;
import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedTag;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;

public class FeedCommonController {

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	@Autowired
	private UserComponent userComp;
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

	protected String getAddPostUrl() {
		return externalUrlInfo.getFeed_info_url() + Constant.POST_CREATE_URL;
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

	protected String getThreadTopListUrl() {
		return externalUrlInfo.getFeed_info_url()
				+ Constant.THREAD_TOP_LIST_URL;
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
			UserInfo userInfo = this.getUserInfo(request);
			StringBuffer strb = new StringBuffer();
			if (userInfo != null) {
				String atom = Tools.encodetoAtom(String.valueOf(userInfo
						.getUserId()));
				strb.append(getUrl).append("?").append(atom);
				if (!StringUtil.isNullOrEmpty(param)) {
					strb.append("&").append(param);
				}
			} else {
				strb.append(getUrl);
				if (!StringUtil.isNullOrEmpty(param)) {
					strb.append("?").append(param);
				}
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

	protected JSONObject getHttpInfoWithoutAtom(String getUrl, String param,
			HttpServletRequest request) {
		try {
			StringBuffer strb = new StringBuffer();
			strb.append(getUrl);
			strb.append("?").append(param);
			String result = httpComp.get(strb.toString());
			if (StringUtil.isNullOrEmpty(result))
				return null;
			return new JSONObject(result);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"FeedCommonController.getHttpInfoWithoutAtom", e);
			return null;
		}
	}

	protected JSONObject postHttpInfo(String postUrl, JSONObject postData,
			HttpServletRequest request) {
		try {
			UserInfo userInfo = this.getUserInfo(request);
			if (userInfo == null) {
				return null;
			}
			String userId = String.valueOf(userInfo.getUserId());
			String atom = Tools.encodetoAtom(userId);
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

	protected String replaceEmoji(String content) {
		Map<String, String> emojiMap = getEmojiMap();

		for (String key : emojiMap.keySet()) {
			String value = emojiMap.get(key);
			content = content.replace("[" + key + "]", "<img src=" + value
					+ " alt=" + value + " class='emoji'>");
		}

		return content;
	}

	private Map<String, String> getEmojiMap() {
		Map<String, String> emojiMap = new HashMap<String, String>();

		emojiMap.put("嘻哈",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiaha_9481465.png");
		emojiMap.put("龇牙",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_ziya_2c94900.png");
		emojiMap.put("受伤",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shoushang_56c02f5.png");
		emojiMap.put("大笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_daxiao_85572c2.png");
		emojiMap.put("开心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kaixin_e68274a.png");
		emojiMap.put("笑汗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiaohan_50f11c1.png");
		emojiMap.put("讥笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jixiao_90dac1b.png");
		emojiMap.put("天使",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tianshi_dba4be0.png");
		emojiMap.put("恶魔",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_emo_b5f33d7.png");
		emojiMap.put("挑逗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tiaodou_eb53a90.png");
		emojiMap.put("可爱",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_keai_cfb4134.png");
		emojiMap.put("微笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_weixiao_66df40a.png");
		emojiMap.put("满意",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_manyi_f7b49a1.png");
		emojiMap.put("色心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_sexin_3138a3a.png");
		emojiMap.put("得意",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_deyi_ea1cd7e.png");
		emojiMap.put("阴险",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_yinxian_dfc8dad.png");
		emojiMap.put("平静",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_pingjing_42af35a.png");
		emojiMap.put("淡定",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_danding_f0af606.png");
		emojiMap.put("斜视",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xishi_2819ad6.png");
		emojiMap.put("尴尬",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_ganga_4156747.png");
		emojiMap.put("失望",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shiwang_f2f843c.png");
		emojiMap.put("傲慢",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_aoman_a9dc4e2.png");
		emojiMap.put("撇嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_pizui_5924bde.png");
		emojiMap.put("喜欢",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xihuan_8be7916.png");
		emojiMap.put("飞吻",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_feiwen_5e1d111.png");
		emojiMap.put("喜爱",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiai_7e90fa9.png");
		emojiMap.put("亲嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_qinzui_670ec07.png");
		emojiMap.put("快乐",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kuaile_346ffba.png");
		emojiMap.put("调皮",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tiaopi_ba4c7ba.png");
		emojiMap.put("吐舌",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tushe_d64a42a.png");
		emojiMap.put("失落",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shiluo_c051da6.png");
		emojiMap.put("伤心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shangxin_5280e71.png");
		emojiMap.put("发怒",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_fanu_edff1ca.png");
		emojiMap.put("生气",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shengqi_1e5cee8.png");
		emojiMap.put("纠结",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jiujie_ce8fe76.png");
		emojiMap.put("喷气",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_penqi_03b4ddc.png");
		emojiMap.put("汗呐",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_hanna_eaade91.png");
		emojiMap.put("张嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_zhangzui_e0b1c6c.png");
		emojiMap.put("意外",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_yiwai_aa26189.png");
		emojiMap.put("恐怖",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kongbu_c8b5f71.png");
		emojiMap.put("大哭",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_daku_c4cf035.png");
		emojiMap.put("生病",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shengbin_2f18be2.png");
		emojiMap.put("难过",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_naguo_6ac90c6.png");
		emojiMap.put("挤笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jixiao_45_9cbbeb0.png");
		emojiMap.put("流泪",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_liulei_e82b024.png");
		emojiMap.put("惊讶",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jingya_f4d3f19.png");
		emojiMap.put("期待",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_qidai_230ebe0.png");
		emojiMap.put("冷汗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lenghan_e14a9f1.png");
		emojiMap.put("惊悚",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jingsun_5c05f23.png");
		emojiMap.put("拒绝",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jujue_e3c96db.png");
		emojiMap.put("脸红",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lianhong_595f92f.png");
		emojiMap.put("睡觉",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shuijiao_b83bb83.png");
		emojiMap.put("冷静",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lengjing_4a97155.png");
		emojiMap.put("口罩",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kouzhao_02c0354.png");

		return emojiMap;
	}

	public static void main(String[] args) {
		FeedCommonController common = new FeedCommonController();
		String content = "[尴尬]好看的。。。。。。[汗呐][亲嘴]";
		System.out.print(common.replaceEmoji(content));
	}

}
