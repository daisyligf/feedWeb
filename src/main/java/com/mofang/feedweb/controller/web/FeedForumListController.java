//package com.mofang.feedweb.controller.web;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.mofang.feedweb.entity.FeedForum;
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.service.impl.FeedForumListServiceImpl;
//import com.mofang.feedweb.util.Tools;
//
//public class FeedForumListController {
//
//
//	private FeedForumListServiceImpl forumlistService = new FeedForumListServiceImpl();
//	private StringBuffer message = null;
//	
//	//版块列表
//	//type:热门游戏  ：1  新游推荐 ：2
//	@RequestMapping(value = "/ForumList",method = RequestMethod.GET)
//	@ResponseBody
//	public String initsearchPage(@RequestBody String letterGroup, int p, int type,HttpServletRequest request) throws Exception {
//		message = new StringBuffer();
//		
//		//获取版块list
//		JSONObject forumListResult = forumlistService.getForumListByLetterGroup(p, Constant.PAGE_SIZE, type, letterGroup);
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
//		
//		return "forumList";
//
//	}
//}
