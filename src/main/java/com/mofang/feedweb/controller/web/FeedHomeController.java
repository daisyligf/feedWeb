package com.mofang.feedweb.controller.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.FeedHomeHotForumRank;
import com.mofang.feedweb.entity.FeedHomeHotGame;
import com.mofang.feedweb.entity.FeedHomeRecommendGame;
import com.mofang.feedweb.entity.FeedHomeRecommendGameRank;
import com.mofang.feedweb.entity.FeedHomeThreadsTitle;
import com.mofang.feedweb.entity.FeedHomeTicker;
import com.mofang.feedweb.entity.FeedOffical;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.util.StringUtil;

@Controller
public class FeedHomeController extends FeedCommonController {
	
	private StringBuffer message = null;
	
	// home主页初期信息显示
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) throws Exception {
		
		//bbs首页进来时，获取用户id
		String uid = "";
		if (null !=  request.getSession().getAttribute("uid")) {
			uid = String.valueOf(request.getSession().getAttribute("uid"));
		}
		request.getSession().setAttribute(Constant.SESSION_OPERATORID, uid);
		
//		Cookie[] cookies=request.getCookies();//从request中获得cookie对象的集合  
//		String userID="";//登录用户   
//		if(cookies!=null){  
//		    for(int i=0;i<cookies.length;i++){  
//		        if(cookies[i].getName().equals("uid")){  
//		            userID = URLDecoder.decode(cookies[i].getValue());//获取用户名                                                                
//		        }  
//		    }  
//		                                                                     
//		}
		
		
		//搜索关键字
		JSONObject keywordResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.HOME_SEARCH_KEYWORD_GET_URL),"" , request);
		Map<String, Object> model = new HashMap<String, Object>();
		if (null != keywordResult) {
			int code = keywordResult.optInt("code", -1);
			if (0 != code) {
			} else {
				JSONObject data = keywordResult.optJSONObject("data");
				model.put("recommendSearchKey", data.optString("key_word", ""));
			}	
		}
		
		
		//海报
		JSONObject tickersResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.TICKER_INFO_GET_URL),"" , request);
		if (null != tickersResult) {
			
			int code = tickersResult.optInt("code", -1);
			if (0 != code) {
			} else {
				JSONArray data = tickersResult.optJSONArray("data");
				List<FeedHomeTicker> listNewsPaper = new ArrayList<FeedHomeTicker>();
				FeedHomeTicker objNewsPaper = null;
				JSONObject jsonNewsPaper = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonNewsPaper = data.getJSONObject(i);
					objNewsPaper = new FeedHomeTicker();
					objNewsPaper.setIcon(jsonNewsPaper.optString("icon", ""));
					objNewsPaper.setLink_url(jsonNewsPaper.optString("link_url", ""));
					objNewsPaper.setDisplay_order(jsonNewsPaper.optInt("display_order", 1));
					listNewsPaper.add(objNewsPaper);
				}
				model.put("tickers", listNewsPaper);
			}	
			
		}
		
		
		//大小标题
		JSONObject subjectResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.SUBJECT_INFO_GET_URL),"" , request);
		if (null != subjectResult) {
			
			int code = subjectResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = subjectResult.optJSONArray("data");
				
				List<FeedHomeThreadsTitle> listThreadsTitle = new ArrayList<FeedHomeThreadsTitle>();
				FeedHomeThreadsTitle objThreadsTitle = null;
				JSONObject jsonThreadsTitle = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonThreadsTitle = data.getJSONObject(i);
					objThreadsTitle = new FeedHomeThreadsTitle();
					objThreadsTitle.setThread_id(jsonThreadsTitle.optInt("thread_id",0));
					objThreadsTitle.setThread_name(jsonThreadsTitle.optString("thread_name", ""));
					objThreadsTitle.setDisplay_order(jsonThreadsTitle.optInt("display_order", 1));
					objThreadsTitle.setForum_name(jsonThreadsTitle.optString("forum_name", ""));
					objThreadsTitle.setLink_url(jsonThreadsTitle.optString("link_url", ""));
					objThreadsTitle.setThread_content(jsonThreadsTitle.optString("thread_content", ""));
					listThreadsTitle.add(objThreadsTitle);
				}
				model.put("subjects", listThreadsTitle);
			}
			
		}
		
		//热门版块榜单
		JSONObject hotForumRankResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.LIST_HOT_FOURM_GET_URL),"" , request);
		if (null != hotForumRankResult) {
			
			int code = hotForumRankResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = hotForumRankResult.optJSONArray("data");
				
				List<FeedHomeHotForumRank> listHotForumRank = new ArrayList<FeedHomeHotForumRank>();
				FeedHomeHotForumRank objHotForumrank = null;
				JSONObject jsonHotForumrank = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonHotForumrank = data.getJSONObject(i);
					objHotForumrank = new FeedHomeHotForumRank();
					objHotForumrank.setForum_id(jsonHotForumrank.optLong("forum_id", 0));
					objHotForumrank.setForum_name(jsonHotForumrank.optString("forum_name", ""));
					objHotForumrank.setLink_url("");
					objHotForumrank.setUp_down(jsonHotForumrank.optInt("up_down", 0));
					listHotForumRank.add(objHotForumrank);
				}
				model.put("ForumRankList", listHotForumRank);
			}
			
		}
		
		//新游推荐榜单
		JSONObject recommendGameResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.LIST_RECOMMENDGAME_GET_URL),"" , request);
		if (null != recommendGameResult) {
			
			int code = recommendGameResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = recommendGameResult.optJSONArray("data");
				
				List<FeedHomeRecommendGameRank> listGameRecommendRank = new ArrayList<FeedHomeRecommendGameRank>();
				FeedHomeRecommendGameRank objGameRecommendRank = null;
				JSONObject jsonGameRecommendRank = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonGameRecommendRank = data.getJSONObject(i);
					objGameRecommendRank = new FeedHomeRecommendGameRank();
					objGameRecommendRank.setForum_id(jsonGameRecommendRank.optLong("forum_id", 0));
					objGameRecommendRank.setForum_name(jsonGameRecommendRank.optString("forum_name", ""));
					objGameRecommendRank.setLink_url("");
					objGameRecommendRank.setDownLoad_url(jsonGameRecommendRank.optString("downLoad_url", ""));
					objGameRecommendRank.setGift_url(jsonGameRecommendRank.optString("gift_url", ""));
					listGameRecommendRank.add(objGameRecommendRank);
				}
				model.put("recommendRank", listGameRecommendRank);
			}
		}
		
		//热门游戏版块list
		JSONObject listHotGameResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.LIST_HOT_FOURM_GET_URL),"" , request);
		if (null != listHotGameResult) {
			
			int code = listHotGameResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = listHotGameResult.optJSONArray("data");
				List<FeedHomeHotGame> listHotGame = new ArrayList<FeedHomeHotGame>();
				FeedHomeHotGame objHotGame = null;
				JSONObject jsonHotGame = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonHotGame = data.getJSONObject(i);
					objHotGame = new FeedHomeHotGame();
					objHotGame.setForum_id(jsonHotGame.optLong("forum_id", 0));
					objHotGame.setForum_name(jsonHotGame.optString("forum_name", ""));
					objHotGame.setForum_url("");
					objHotGame.setGift_url(jsonHotGame.optString("gift_url", ""));
					objHotGame.setIcon(jsonHotGame.optString("icon", ""));
					objHotGame.setPrefecture_url(jsonHotGame.optString("prefecture_url", ""));
					objHotGame.setToday_threads(jsonHotGame.optInt("today_threads", 0));
					objHotGame.setTotal_threads(jsonHotGame.optInt("total_threads", 0));
					listHotGame.add(objHotGame);
				}
				model.put("listHotGame", listHotGame);
				
			}
		}
		
		//新游推荐list
		JSONObject listRecommendGameResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.LIST_RECOMMENDGAME_GET_URL),"" , request);
		if (null != listRecommendGameResult) {
			
			int code = listRecommendGameResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = listRecommendGameResult.optJSONArray("data");
				List<FeedHomeRecommendGame> listRecommendGame = new ArrayList<FeedHomeRecommendGame>();
				FeedHomeRecommendGame objRecommendGame = null;
				JSONObject jsonRecommendGame = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonRecommendGame = data.getJSONObject(i);
					objRecommendGame = new FeedHomeRecommendGame();
					objRecommendGame.setForum_id(jsonRecommendGame.optLong("forum_id", 0));
					objRecommendGame.setForum_name(jsonRecommendGame.optString("forum_name", ""));
					objRecommendGame.setForum_url("");
					objRecommendGame.setGift_url(jsonRecommendGame.optString("gift_url", ""));
					objRecommendGame.setIcon(jsonRecommendGame.optString("icon", ""));
					objRecommendGame.setDownload_url(jsonRecommendGame.optString("download_url", ""));
					objRecommendGame.setToday_threads(jsonRecommendGame.optInt("today_threads", 0));
					objRecommendGame.setTotal_threads(jsonRecommendGame.optInt("total_threads", 0));
					listRecommendGame.add(objRecommendGame);
				}
				model.put("listRecommendGame", listRecommendGame);
				
			}
			
		} 
		
		//官方版块
		JSONObject officalResult = getHttpInfo(
				getFeedUrlInfo().concat(
						Constant.PREFECTURE_INFO_GET_URL),"" , request);
		if (null != officalResult) {
			
			int code = officalResult.optInt("code", -1);
			if(0 != code) {
			} else {
				
				JSONArray data = officalResult.optJSONArray("data");
				List<FeedOffical> listOffical = new ArrayList<FeedOffical>();
				FeedOffical objFeedOffical = null;
				JSONObject jsonFeedOffical = null;
				for(int i=0; i<data.length(); i++)
				{
					jsonFeedOffical = data.getJSONObject(i);
					objFeedOffical = new FeedOffical();
					objFeedOffical.setForum_id(jsonFeedOffical.optLong("forum_id", 0));
					objFeedOffical.setForum_name(jsonFeedOffical.optString("forum_name", ""));
					objFeedOffical.setForum_url("");
					objFeedOffical.setIcon(jsonFeedOffical.optString("icon", ""));
					objFeedOffical.setToday_threads(jsonFeedOffical.optInt("today_threads", 0));
					objFeedOffical.setTotal_threads(jsonFeedOffical.optInt("total_threads", 0));
					listOffical.add(objFeedOffical);
				}
				model.put("listOffical", listOffical);
				
			}
			
		}
		
//		//有出错消息跳转到出错页面
//		if (!StringUtil.isNullOrEmpty(message.toString())) {
//			request.setAttribute("message", message.toString());
//			return "error";
//		}
		
		return new ModelAndView("index", model);

	}

	 // 主题页面跳转
	 @RequestMapping(value = { "/thread" })
	 public String viewThread(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
		 
	 return "forumList";
	
	 }
	
	 // 版块信息页面跳转
	 @RequestMapping(value = { "/forum" }, method = RequestMethod.POST)
	 public String viewForum(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }
	
	 // 检索页面跳转
	 @RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	 public String viewSearch(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }
	
	 // 礼包页面跳转
	 @RequestMapping(value = { "/gift" }, method = RequestMethod.POST)
	 public String viewGift(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }
	
	 // 下载页面跳转
	 @RequestMapping(value = { "/download" }, method = RequestMethod.POST)
	 public String viewDownload(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }
	
	 // 专区页面跳转
	 @RequestMapping(value = { "/prefecture" }, method = RequestMethod.POST)
	 public String viewPrefecture(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }
	
	 // 热门游戏更多跳转
	 @RequestMapping(value = { "/hotGameMore" }, method = RequestMethod.POST)
	 public String viewHotGameMore(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }
	
	 // 新游推荐更多跳转
	 @RequestMapping(value = { "/newRecommendMore" }, method =
	 RequestMethod.POST)
	 public String viewNewRecommendMore(HttpServletRequest request,
	 HttpServletResponse response) throws IOException {
	 return null;
	
	 }

}
