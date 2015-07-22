package com.mofang.feedweb.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.component.UserComponent;
import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.Game;
import com.mofang.feedweb.entity.GameGift;
import com.mofang.feedweb.entity.HotForumRank;
import com.mofang.feedweb.entity.HotThread;
import com.mofang.feedweb.entity.RoleInfo;
import com.mofang.feedweb.entity.SignInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.ForumType;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedSignInService;
import com.mofang.feedweb.util.SignUtil;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.TimeUtil;
import com.mofang.feedweb.util.Tools;

/**
 * 
 * @author daisyli
 * 版块内容页（即帖子列表页）
 *
 */
@Controller
public class FeedForumContentController extends FeedCommonController {
	
	@Autowired
	private UserComponent userComp;
	@Autowired
	private FeedSignInService feedSignInService;
	
	@RequestMapping(value = "/forum_content/{fid}/{type}/{timeType}/{currentPage}/{tag_id}.htm", method = RequestMethod.GET)
	public ModelAndView forumContent(HttpServletRequest request, 
					@PathVariable(value = "fid") long fid,
					@PathVariable(value = "type") String type,
					@PathVariable(value = "timeType") String timeType,
					@PathVariable(value = "currentPage") String currentPage,
					@PathVariable(value = "tag_id") String tagId) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			//获取当前用户的签到状态
			JSONObject json = feedSignInService.getSignInstate(request);
			SignInfo signInfo = new SignInfo();
			if (null != json && 0 == json.optInt("code")) {
				JSONObject data = json.optJSONObject("data");
				signInfo.setIs_sign_in(data.optBoolean("is_sign_in", false));
				signInfo.setDays(data.optInt("days", 0));
				signInfo.setRank(data.optInt("rank", 0));
				signInfo.setTotalMember(data.optInt("totalMember", 0));
			}
			model.put("signInfo", signInfo);
			
			// 获取版块信息
			FeedForum feedForum = getFeedForumInfo(request, fid);
			
			if (feedForum.getCode() == Constant.FORUM_NOT_EXISTS) {
				return new ModelAndView("redirect:error");
			}
			
			// 获取该版块的吧主列表
			List<RoleInfo> roleList= getFeedForumRoleInfoList(request, fid, model);
			feedForum.setRoleList(roleList);
			
			// 获取版块下的帖子列表
			getThreadList(request, fid, type, timeType, currentPage, tagId,  model);
			
			// if 是官方版块，获取头条列表和新游推荐
			int forumType = feedForum.getType();
			if (forumType == ForumType.OFFICIAL) {
				//头条列表
				List<HotThread> hotThreadList = getHotThreads(request);
				model.put("hotThreadList", hotThreadList);
				
				// 新游推荐
				List<HotForumRank> newGameList = getNewGameList(request);
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
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.forumContent throw an error.", e);
			return new ModelAndView("forum_content", model);
		} 
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
		
		try {
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
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.follow throw an error.", e);
			return null;
		}
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

	private List<HotForumRank> getNewGameList(HttpServletRequest request)
			throws JSONException {
		
		List<HotForumRank> newGameList = new ArrayList<HotForumRank>();
		
		try {
			
			JSONObject json = getHttpInfo(getFeedUrlInfo().concat(Constant.HOT_FOURM_RANK_GET_URL), "", request);
			
			if (json != null && json.optInt("code", -1) == 0) {
				JSONArray data = json.optJSONArray("data");
				HotForumRank newGame = null;
				if (data != null && data.length() > 0) {
					for (int i = 0; i < data.length(); i++) {
						JSONObject obj = data.getJSONObject(i);
						newGame = new HotForumRank();
						newGame.setForum_id(obj.optLong("forum_id", 0));
						newGame.setForum_name(obj.optString("forum_name", ""));
						newGame.setIcon(obj.optString("icon", ""));
						newGame.setUp_down(obj.optInt("up_down"));
						
						newGameList.add(newGame);
					}
				}
			}
			return newGameList;
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.getNewGameList throw an error.", e);
			return newGameList;
		}
	}

	private List<HotThread> getHotThreads(HttpServletRequest request)
			throws JSONException {
		List<HotThread> hotThreadList = new ArrayList<HotThread>();
		
		try {
			JSONObject json = getHttpInfo(getTopThreadsUrl(), "", request);
			
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
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.getHotThreads throw an error.", e);
			return hotThreadList;
		}
	}
	
	private List<RoleInfo> getFeedForumRoleInfoList(HttpServletRequest request,
			long fid, Map<String, Object> model) throws Exception {
		
		List<RoleInfo> roleList = new ArrayList<RoleInfo>();
		try {
			String param = "fid=" + fid;
			boolean isFull = false;
			JSONObject json = getHttpInfo(getRoleInfoListGetUrl(), param, request);
			UserInfo userinfo = userComp.getUserInfo(request);
			long userId = 0;
			boolean moderatorflg = false;
			if (null != userinfo && 0 != userinfo.getUserId()) {
				userId =  userinfo.getUserId();
			}
			if (json != null && json.optInt("code", -1) == 0) {
				
				JSONObject data = json.optJSONObject("data");
				if (data != null) {
					isFull = data.optBoolean("is_full", false);
					JSONArray moderators = data.optJSONArray("moderators");
					for (int i = 0; i < moderators.length(); i++) {
						JSONObject obj = moderators.getJSONObject(i);
						RoleInfo roleInfo = new RoleInfo(obj.optLong("user_id", 0), obj.optString("nickname", ""), obj.optString("avatar", ""));
						if (0 != userId && userId == obj.optLong("user_id", 0)) {
							moderatorflg = true;
						}
						roleList.add(roleInfo);
					}
				}
			}
			model.put("is_full", isFull);
			model.put("moderatorflg", moderatorflg);
			return roleList;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.getFeedForumRoleInfoList throw an error.", e);
			return roleList;
		}
	}
	
	private List<FeedThread> getThreadList(HttpServletRequest request, long fid, String typeString, String timeTypeString, 
			String pString, String tagIdString, Map<String, Object> model) throws Exception {
		
		List<FeedThread> threadList = new ArrayList<FeedThread>();
		
		try {
			int total = 0;
			int threadType = 0; // 0表示普通，1表示精华
			//String typeString = request.getParameter("type");
			if (typeString != null && StringUtil.isInteger(typeString)) {
				threadType = Integer.parseInt(typeString);
			}
			
			int timeType = 0; // 0表示按回复时间排序、1表示按发帖时间排序
			
			//String timeTypeString = request.getParameter("timeType");
			if (timeTypeString != null && StringUtil.isInteger(timeTypeString)) {
				timeType = Integer.parseInt(timeTypeString);
			}
			
			int p = 1;
			//String pString = request.getParameter("currentPage");
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
			//String tagIdString = request.getParameter("tag_id");
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
			model.put("pagelist", Tools.editPageNumber(total, p,Constant.PAGE_SIZE, 2));
			return threadList;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.getThreadList throw an error.", e);
			return threadList;
		}
	}
	
	private FeedThread fromJsonToFeedThread(JSONObject obj) {
		
		FeedThread feedThread = new FeedThread();
		feedThread.setThread_id(obj.optLong("tid", 0));
		feedThread.setSubject(obj.optString("subject", ""));
		String content = obj.optString("content", "");
		if (content.length() > 40) {
			content = content.substring(0, 40) + "...";
		}
		String htmlContent = obj.optString("html_content", "");
		feedThread.setContent(replaceEmoji(content));
		feedThread.setPage_view(obj.optInt("pageview", 0));
		feedThread.setReplies(obj.optInt("replies", 0));
		
		Date createTime = new Date(obj.optLong("create_time", 0));
		feedThread.setCreate_time(createTime);
		
		feedThread.setFormat(TimeUtil.getFormat(createTime));
		
		feedThread.setIsClosed(obj.optBoolean("is_closed", false));
		feedThread.setIsElite(obj.optBoolean("is_elite", false));
		feedThread.setIsTop(obj.optBoolean("is_top", false));
		feedThread.setRecommends(obj.optInt("recommends", 0));
		feedThread.setIsModerator(obj.optBoolean("is_moderator", false));
		
		JSONArray pics = obj.optJSONArray("pic");
		feedThread.setHasPic(hasPic(pics, htmlContent));
		
		JSONObject userObj = obj.optJSONObject("user");
		if (userObj != null) {
			feedThread.setUser_id(userObj.optLong("user_id", 0));
			feedThread.setUser_name(userObj.optString("nickname", ""));
			feedThread.setAvatar(userObj.optString("avatar", ""));
		}
		return feedThread;
	}
	
	private boolean hasPic(JSONArray pics, String htmlContent) {
		if (pics != null && pics.length() > 0) {
			return true;
		} else {
			Pattern pattern = Pattern.compile("<img.*src=(.*?)[^>]*?>");
			Matcher matcher = pattern.matcher(htmlContent);
			return matcher.find();
		}
	}
	
	public static void main(String[] args) {
		JSONArray pics = null;
		String htmlContent = "<font>Bye Beijing! I had a lot of fun!</font><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/emimage/ee9098.png\" width=\"20px\" height=\"20px\" style=\"vertical-align: text-bottom; font-family: Arial, 'Microsoft YaHei'; font-size: 14px; line-height: 23px; white-space: normal; background-color: rgb(255, 255, 255);\"><img render=\"ext\" src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/d9/ye_org.gif\" title=\"[耶]\" alt=\"[耶]\" type=\"face\" style=\"vertical-align: text-bottom; font-family: Arial, 'Microsoft YaHei'; font-size: 14px; line-height: 23px; white-space: normal; background-color: rgb(255, 255, 255);\"><br /><img src=\"http://ww1.sinaimg.cn/bmiddle/d374ba31jw1erk3wrh30fj20ku0rsjw0.jpg\" _src=\"http://ww1.sinaimg.cn/bmiddle/d374ba31jw1erk3wrh30fj20ku0rsjw0.jpg\"><br>";
		FeedForumContentController demo = new FeedForumContentController();
		System.out.println(demo.hasPic(pics, htmlContent));
	
	}
	
	private List<FeedThread> getThreadTopList(HttpServletRequest request, long forumId, Map<String, Object> model) throws Exception {
		
		List<FeedThread> topThreadList = new ArrayList<FeedThread>();
		
		try {
			String param = "fid=" + forumId;
			JSONObject json = getHttpInfo(getThreadTopListUrl(), param, request);
			
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
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumContentController.getThreadTopList throw an error.", e);
			return topThreadList;
		}
		
	}
	
}
