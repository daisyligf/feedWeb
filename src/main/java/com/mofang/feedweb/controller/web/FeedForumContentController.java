package com.mofang.feedweb.controller.web;

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
import com.mofang.feedweb.entity.FeedTag;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.Game;
import com.mofang.feedweb.entity.GameGift;
import com.mofang.feedweb.entity.HotThread;
import com.mofang.feedweb.entity.NewGame;
import com.mofang.feedweb.entity.RoleInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.ForumType;
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
		
		model.put("feedForum", feedForum);
		
		return new ModelAndView("forum_content", model);
	}
	
	@RequestMapping(value = "/follow.json")
	public String follow(@RequestParam("fid") long forumId, @RequestParam("is_follow") int isFollow, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("area_id", forumId);
		postData.put("dofollow", isFollow);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData);
		
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
		
		StringBuilder param = new StringBuilder();
		param.append("game_id=").append(gameId);
		param.append("&offset=0&limit=5");
		
		JSONObject json = getHttpInfo(getGameGiftListUrl(), param.toString(), request);
		
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
	
	private FeedForum getFeedForumInfo(HttpServletRequest request, long fid)
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
		}
		
		return feedForum;
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
					RoleInfo roleInfo = new RoleInfo(obj.optInt("role_id", 0), obj.optString("role_name", ""), obj.optString("icon", ""));
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
		
		String timeTypeString = request.getParameter("timetype");
		if (timeTypeString != null && StringUtil.isInteger(timeTypeString)) {
			timeType = Integer.parseInt(timeTypeString);
		}
		
		int p = 1;
		String pString = request.getParameter("p");
		if (pString != null && StringUtil.isInteger(pString)) {
			p = Integer.parseInt(pString);
		}
		
		int pageSize = 30;
		String pageSizeString = request.getParameter("pagesize");
		if (pageSizeString != null && StringUtil.isInteger(pageSizeString)) {
			pageSize = Integer.parseInt(pageSizeString);
		}
		
		StringBuilder paramBuilder = new StringBuilder();
		paramBuilder.append("fid=").append(fid);
		paramBuilder.append("&type=").append(threadType);
		paramBuilder.append("&timeType=").append(timeType);
		paramBuilder.append("&p=").append(p);
		paramBuilder.append("pagesize=").append(pageSize);
		
		String tagIdString = request.getParameter("tag_id");
		if (tagIdString != null && StringUtil.isInteger(tagIdString)) {
			int tagId = Integer.parseInt(tagIdString);
			paramBuilder.append("&tagId=").append(tagId);
		}
		
		JSONObject json = getHttpInfo(getThreadListUrl(), paramBuilder.toString(), request);
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONObject data = json.optJSONObject("data");
			total = data.optInt("total", 0);
			JSONArray threads = data.optJSONArray("threads");
			if (threads != null && threads.length() > 0) {
				for (int i = 0; i < threads.length(); i++) {
					
					JSONObject obj = threads.getJSONObject(i);
					FeedThread feedThread = new FeedThread();
					feedThread.setThread_id(obj.optLong("tid", 0));
					feedThread.setSubject(obj.optString("subject", ""));
					feedThread.setContent(obj.optString("content", ""));
					feedThread.setPage_view(obj.optInt("pageview", 0));
					feedThread.setReplies(obj.optInt("replies", 0));
					feedThread.setCreate_time(new Date(obj.optLong("create_time", 0)));
					feedThread.setIsClosed(obj.optBoolean("is_closed", false));
					feedThread.setIsElite(obj.optBoolean("is_elite", false));
					feedThread.setIsTop(obj.optBoolean("is_top", false));
					feedThread.setRecommends(obj.optInt("recommends", 0));
					feedThread.setIsModerator(obj.optBoolean("is_moderator", false));
					
					JSONArray pics = obj.getJSONArray("pic");
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
					
					threadList.add(feedThread);
				}
			}
			
		}
		
		model.put("threadList", threadList);
		model.put("currentPage", p);
		model.put("totalPages", Tools.editTotalPageNumber(total));
		model.put("pagelist", Tools.editPageNumber(total, p,Constant.PAGE_SIZE));
		
		return threadList;
	}
	
}
