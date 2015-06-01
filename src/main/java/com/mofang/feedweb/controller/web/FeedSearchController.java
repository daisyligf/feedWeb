package com.mofang.feedweb.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedThreadStarterInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.util.Tools;

//@Controller
//public class FeedSearchController {
//
//	private FeedSearchPageServiceImpl searchService = new FeedSearchPageServiceImpl();
//	private StringBuffer message = null;
//	
//	//搜索页
//	@RequestMapping(value = "/search",method = RequestMethod.GET)
//	@ResponseBody
//	public String initsearchPage(@RequestBody String keyword,HttpServletRequest request) throws Exception {
//		message = new StringBuffer();
//		
//		int p = 1;
//		//获取版块list
//		JSONObject forumListResult = searchService.forumSearch(keyword, p, 8);
//		if (null != forumListResult) {
//			int code = forumListResult.optInt("code", -1);
//			if (0 != code) {
//				message.append(forumListResult.optString("message", ""));
//			} else {
//				JSONObject data = forumListResult.optJSONObject("data");
//				
//				//通过总数算出页码
//				int total = data.optInt("total",0);
//				request.setAttribute("pageList", Tools.editPageNumber(total, p));
//				request.setAttribute("page", p);
//				request.setAttribute("totalPages", total);
//				
//				JSONArray list = data.optJSONArray("list");
//				List<FeedForum> listForum = new ArrayList<FeedForum>();
//				FeedForum objFeedForum = null;
//				JSONObject jsonFeedForum = null;
//				for(int i=0; i<list.length(); i++)
//				{
//					jsonFeedForum = list.getJSONObject(i);
//					objFeedForum = new FeedForum();
//					objFeedForum.setForum_id(jsonFeedForum.optLong("fid", 0));
//					objFeedForum.setForum_name(jsonFeedForum.optString("name", ""));
//					objFeedForum.setTotal_threads(jsonFeedForum.optInt("threads", 0));
//					objFeedForum.setToday_threads(jsonFeedForum.optInt("today_threads", 0));
//					objFeedForum.setForum_url("");
//					objFeedForum.setGift_url(jsonFeedForum.optString("gift_url", ""));
//					objFeedForum.setPrefecture_url(jsonFeedForum.optString("prefecture_url", ""));
//					listForum.add(objFeedForum);
//				}
//				
//				request.setAttribute("forumList", listForum);
//				
//			}	
//		} else {
//			request.setAttribute("forumList", new ArrayList<FeedForum>());
//		}
//		
//		//获取帖子list
//		
//		return "search";
//
//	}
//
//	 //版块点击更多
//	 @RequestMapping(value = { "/forumMore" })
//	 @ResponseBody
//	 public void forumMore(@RequestBody long fid, String keyword, int p ,HttpServletRequest request,
//	 HttpServletResponse response) throws IOException {
////
////		String author = "";
////		int status = 1;
////		//热门游戏版块list
////		JSONObject threadInfoResult = searchService.forumSearch(keyword, p, 8);
////		List<Map<String, Object>> threadlist = new ArrayList<Map<String,Object>>();
////		Map<String, Object> map1 = null;
////		if (null != threadInfoResult) {
////			JSONObject data = threadInfoResult.optJSONObject("data");
////
////			//通过总数算出页码
////			int total = data.optInt("total",0);
////			request.setAttribute("pageList", Tools.editPageNumber(total, p));
////			request.setAttribute("page", p);
////			request.setAttribute("totalPages", total);
////			
////			JSONArray list = data.optJSONArray("list");
////			JSONObject jsonthread = null;
////			for(int i=0; i<list.length(); i++)
////			{
////				jsonthread = list.getJSONObject(i);
////				map1 = new HashMap<String, Object>(10);
////				map1.put("fid", jsonthread.optLong("fid", 0));
////				map1.put("tid", jsonthread.optLong("tid", 0));
////				map1.put("icon", jsonthread.optString("icon", ""));
////				map1.put("thread_name", jsonthread.optString("subject", ""));
////				map1.put("user_id", jsonthread.optLong("uid", 0));
////				map1.put("user_name", jsonthread.optString("nickname", ""));
////				map1.put("pageview", jsonthread.optInt("pageview", 0));
////				map1.put("replies", jsonthread.optInt("replies", 0));
////				threadlist.add(map1);
////				
////			}
////			
////		}
////		Tools.renderData(response, threadlist.toString());
//	
//	 }
//	
//	 //主题分页点击
//	 @RequestMapping(value = { "/threadPageClick" }, method = RequestMethod.POST)
//	 @ResponseBody
//	 public void threadPageClick(@RequestBody long fid, String keyword, int p ,HttpServletRequest request,
//	 HttpServletResponse response) throws Exception {
//		 
//		
//		String author = "";
//		int status = 1;
//		//热门游戏版块list
//		JSONObject threadInfoResult = searchService.threadSearch(fid, author, status, keyword, p, Constant.PAGE_SIZE);
//		List<Map<String, Object>> threadlist = new ArrayList<Map<String,Object>>();
//		Map<String, Object> map1 = null;
//		if (null != threadInfoResult) {
//			JSONObject data = threadInfoResult.optJSONObject("data");
//
//			//通过总数算出页码
//			int total = data.optInt("total",0);
//			request.setAttribute("pageList", Tools.editPageNumber(total, p));
//			request.setAttribute("page", p);
//			request.setAttribute("totalPages", total);
//			
//			JSONArray list = data.optJSONArray("list");
//			JSONObject jsonthread = null;
//			for(int i=0; i<list.length(); i++)
//			{
//				jsonthread = list.getJSONObject(i);
//				map1 = new HashMap<String, Object>(10);
//				map1.put("fid", jsonthread.optLong("fid", 0));
//				map1.put("tid", jsonthread.optLong("tid", 0));
//				map1.put("icon", jsonthread.optString("icon", ""));
//				map1.put("thread_name", jsonthread.optString("subject", ""));
//				map1.put("user_id", jsonthread.optLong("uid", 0));
//				map1.put("user_name", jsonthread.optString("nickname", ""));
//				map1.put("pageview", jsonthread.optInt("pageview", 0));
//				map1.put("replies", jsonthread.optInt("replies", 0));
//				threadlist.add(map1);
//				
//			}
//			
//		}
//		Tools.renderData(response, threadlist.toString());
//	
//	 }
//	
//	
//
//}
