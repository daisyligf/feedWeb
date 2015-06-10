package com.mofang.feedweb.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.Game;
import com.mofang.feedweb.entity.GameGift;
import com.mofang.feedweb.entity.HotThread;
import com.mofang.feedweb.entity.NewGame;
import com.mofang.feedweb.entity.RoleInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.ForumType;
import com.mofang.feedweb.util.SignUtil;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;

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
		FeedForum feedForum = getFeedForumInfo(request, fid);
		
		// 获取该版块的吧主列表
		List<RoleInfo> roleList= getFeedForumRoleInfoList(request, fid);
		feedForum.setRoleList(roleList);
		
		// 获取版块下的帖子列表
		List<FeedThread> threadList = getThreadList(request, fid, model);
//		model.put("threadList", threadList);
		
		// if 是官方版块，获取头条列表和新游推荐
		int type = feedForum.getType();
		if (type == ForumType.OFFICIAL) {
			//头条列表
			List<HotThread> hotThreadList = getHotThreads(request);
			model.put("hotThreadList", hotThreadList);
			
			// 新游推荐
			List<NewGame> newGameList = getNewGameList(request);
			model.put("newGameList", newGameList);
			
		} else { // else 获取该版块关联的游戏信息和礼包发号
			// 游戏信息
			int gameId = feedForum.getGameId();
			Game game = getGameInfo(request, gameId);
			
			model.put("game", game);
			
			// 礼包发号
			List<GameGift> giftList = getGiftList(request, gameId);
			model.put("giftList", giftList);
		}
		model.put("keyword", getSearchKey(request));
		model.put("feedForum", feedForum);
		
		// 关注状态
		UserInfo userInfo = getUserInfo(request);
		if(userInfo == null) {
			model.put("isFollow", false);
		}else {
			boolean isFollow = isFollow(userInfo.getUserId(), fid, request);
			model.put("isFollow", isFollow);
		}
		
		return new ModelAndView("forum_content", model);
	}
	

	private boolean isFollow(long userId, long forumId, HttpServletRequest request) {
		JSONObject json = getHttpInfo(getUserInfoUrl() + Constant.USER_IS_FOLLOW_URL, "?uid=" + userId + "&area_id=" + forumId, request);
		if(json == null) {
			return false;
		}
		int code = json.optInt("code", -1);
		if(code == 0) {
			JSONObject data = json.optJSONObject("data");
			int flag = data.optInt("is_follow", 0);
			if(flag == 1) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value = "/follow.json")
	public String follow(@RequestParam("fid") long forumId, @RequestParam("is_follow") int isFollow, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("area_id", forumId);
		postData.put("dofollow", isFollow);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData, request);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	private List<GameGift> getGiftList(HttpServletRequest request, int gameId) {
		List<GameGift> giftList = new ArrayList<GameGift>();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("game_id", String.valueOf(gameId));
		map.put("appid", Constant.APP_ID);
		
		String sign = SignUtil.buildSign(map, null, Constant.SECRET);
		
		StringBuilder param = new StringBuilder();
		param.append("game_id=").append(gameId);
		//param.append("&offset=0&limit=5");
		param.append("&appid=").append(Constant.APP_ID);
		param.append("&sign=").append(sign);
		
		JSONObject json = this.getHttpInfoWithoutAtom(getGameGiftListUrl(), param.toString());
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONArray data = json.optJSONArray("data");
			if (data != null && data.length() > 0) {
				for (int i = 0; i < data.length(); i++) {
					JSONObject obj = data.optJSONObject(i);
					
					GameGift gameGift = new GameGift();
					gameGift.setId(obj.optInt("id", 0));
					gameGift.setName(obj.optString("name", ""));
					gameGift.setIcon(obj.optString("icon", ""));
					gameGift.setUrl(obj.optString("url", ""));
					gameGift.setWapUrl(obj.optString("wap_url", ""));
					
					giftList.add(gameGift);
				}
			}
		}
		
		return giftList;
	}
	
	private Game getGameInfo(HttpServletRequest request, int gameId) {
		String param = "id=" + gameId;
		JSONObject json = getHttpInfo(getGameInfoUrl(), param, request);
		
		Game game = new Game(gameId);
		if (json != null && json.optInt("code", -1) == 0) {
			JSONObject obj = json.optJSONObject("data");
			game.setName(obj.optString("name", ""));
			game.setIcon(obj.optString("icon", ""));
			game.setUrl(obj.optString("url", ""));
			game.setComment(obj.optString("comment", ""));
		}
		
		return game;
	}

	private List<NewGame> getNewGameList(HttpServletRequest request)
			throws JSONException {
		JSONObject json = getHttpInfo(getRecommendGameRankUrl(), "", request);
		List<NewGame> newGameList = new ArrayList<NewGame>();
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONArray data = json.optJSONArray("data");
			
			if (data != null && data.length() > 0) {
				for (int i = 0; i < data.length(); i++) {
					JSONObject obj = data.getJSONObject(i);
					NewGame newGame = new NewGame();
					newGame.setForumId(obj.optLong("forum_id", 0));
					newGame.setForumName(obj.optString("forum_name", ""));
					newGame.setIcon(obj.optString("icon", ""));
					newGame.setDownloadUrl(obj.optString("download_url"));
					newGame.setGiftUrl(obj.optString("gift_url", ""));
					
					newGameList.add(newGame);
				}
			}
		}
		return newGameList;
	}

	private List<HotThread> getHotThreads(HttpServletRequest request)
			throws JSONException {
		JSONObject json = getHttpInfo(getTopThreadsUrl(), "", request);
		List<HotThread> hotThreadList = new ArrayList<HotThread>();
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONArray data = json.optJSONArray("data");
			
			if (data != null && data.length() > 0) {
				for (int i = 0; i < data.length(); i++) {
					JSONObject obj = data.getJSONObject(i);
					HotThread hotThread = new HotThread(obj.optLong("thread_id", 0), obj.optString("subject", ""));
					hotThreadList.add(hotThread);
				}
			}
		}
		return hotThreadList;
	}
	
	private List<RoleInfo> getFeedForumRoleInfoList(HttpServletRequest request, long fid) throws Exception {
		String param = "fid=" + fid;
		JSONObject json = getHttpInfo(getRoleInfoListGetUrl(), param, request);
		List<RoleInfo> roleList = new ArrayList<RoleInfo>();
		if (json != null && json.optInt("code", -1) == 0) {
			JSONArray data = json.optJSONArray("data");
			if (data != null && data.length() > 0) {
				for (int i = 0; i < data.length(); i++) {
					JSONObject obj = data.getJSONObject(i);
					RoleInfo roleInfo = new RoleInfo(obj.optLong("user_id", 0), obj.optString("nickname", ""), obj.optString("avatar", ""));
					roleList.add(roleInfo);
				}
			}
		}
		return roleList;
	}
	
	private List<FeedThread> getThreadList(HttpServletRequest request, long fid, Map<String, Object> model) throws Exception {
		List<FeedThread> threadList = new ArrayList<FeedThread>();
		int total = 0;
		int threadType = 0; // 0表示普通，1表示精华
		String typeString = request.getParameter("type");
		if (typeString != null && StringUtil.isInteger(typeString)) {
			threadType = Integer.parseInt(typeString);
		}
		
		int timeType = 0; // 0表示按回复时间排序、1表示按发帖时间排序
		
		String timeTypeString = request.getParameter("timeType");
		if (timeTypeString != null && StringUtil.isInteger(timeTypeString)) {
			timeType = Integer.parseInt(timeTypeString);
		}
		
		int p = 1;
		String pString = request.getParameter("currentPage");
		if (pString != null && StringUtil.isInteger(pString)) {
			p = Integer.parseInt(pString);
		}
		
		int pageSize = 20;
//		String pageSizeString = request.getParameter("pagesize");
//		if (pageSizeString != null && StringUtil.isInteger(pageSizeString)) {
//			pageSize = Integer.parseInt(pageSizeString);
//		}
		
		if (p == 1) {
			getThreadTopList(request, fid, model);
		}
		
		StringBuilder paramBuilder = new StringBuilder();
		paramBuilder.append("fid=").append(fid);
		paramBuilder.append("&type=").append(threadType);
		paramBuilder.append("&timetype=").append(timeType);
		paramBuilder.append("&page=").append(p);
		paramBuilder.append("&size=").append(pageSize);
		
		int tagId = 0;
		String tagIdString = request.getParameter("tag_id");
		if (tagIdString != null && StringUtil.isInteger(tagIdString)) {
			tagId = Integer.parseInt(tagIdString);
			paramBuilder.append("&tagid=").append(tagId);
		}
		
		JSONObject json = getHttpInfo(getThreadListUrl(), paramBuilder.toString(), request);
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONObject data = json.optJSONObject("data");
			total = data.optInt("total", 0);
			JSONArray threads = data.optJSONArray("threads");
			if (threads != null && threads.length() > 0) {
				for (int i = 0; i < threads.length(); i++) {
					JSONObject obj = threads.getJSONObject(i);
					FeedThread feedThread = this.fromJsonToFeedThread(obj);
					
					threadList.add(feedThread);
				}
			}
			
		}
		
		model.put("threadList", threadList);
		model.put("type", threadType);
		model.put("timeType", timeType);
		model.put("tag_id", tagId);
		model.put("currentPage", p);
		model.put("totalPages", Tools.editTotalPageNumber(total));
		model.put("pagelist", Tools.editPageNumber(total, p,Constant.PAGE_SIZE));
		
		return threadList;
	}
	
	private FeedThread fromJsonToFeedThread(JSONObject obj) {
		
		FeedThread feedThread = new FeedThread();
		feedThread.setThread_id(obj.optLong("tid", 0));
		feedThread.setSubject(obj.optString("subject", ""));
		feedThread.setContent(replaceEmoji(obj.optString("content", "")));
		feedThread.setPage_view(obj.optInt("pageview", 0));
		feedThread.setReplies(obj.optInt("replies", 0));
		feedThread.setCreate_time(new Date(obj.optLong("create_time", 0)));
		feedThread.setIsClosed(obj.optBoolean("is_closed", false));
		feedThread.setIsElite(obj.optBoolean("is_elite", false));
		feedThread.setIsTop(obj.optBoolean("is_top", false));
		feedThread.setRecommends(obj.optInt("recommends", 0));
		feedThread.setIsModerator(obj.optBoolean("is_moderator", false));
		
		JSONArray pics = obj.optJSONArray("pic");
		if (pics != null && pics.length() > 0) {
			feedThread.setHasPic(true);
		} else {
			feedThread.setHasPic(false);
		}
		JSONObject userObj = obj.optJSONObject("user");
		if (userObj != null) {
			feedThread.setUser_id(userObj.optLong("user_id", 0));
			feedThread.setUser_name(userObj.optString("nickname", ""));
			feedThread.setAvatar(userObj.optString("avatar", ""));
		}
		return feedThread;
	}
	
	private List<FeedThread> getThreadTopList(HttpServletRequest request, long forumId, Map<String, Object> model) throws Exception {
		String param = "fid=" + forumId;
		JSONObject json = getHttpInfo(getThreadTopListUrl(), param, request);
		List<FeedThread> topThreadList = new ArrayList<FeedThread>();
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONObject data = json.optJSONObject("data");
			JSONArray threads = data.optJSONArray("threads");
			if (threads != null && threads.length() > 0) {
				for (int i = 0; i < threads.length(); i++) {
					JSONObject obj = threads.getJSONObject(i);
					FeedThread feedThread = this.fromJsonToFeedThread(obj);
					topThreadList.add(feedThread);
				}
			}
		}
		
		model.put("topThreadList", topThreadList);
		return topThreadList;
		
	}
	
}
