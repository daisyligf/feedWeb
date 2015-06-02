package com.mofang.feedweb.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.util.Tools;

@Controller
public class FeedSearchController extends FeedCommonController{

	/***
	 * 组装 板块，帖子 数据
	 * @param keyword
	 * @param p
	 * @param pagesize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	@ResponseBody
	public String search(@RequestParam(value = "keyword") String keyword, HttpServletRequest request) throws Exception {
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		StringBuffer requestParam = new StringBuffer();
		requestParam.append("p=1&");
		requestParam.append("pagesize=8&");
		requestParam.append("keyword=").append(keyword);
		
		//获取版块list
		JSONObject forumListResult = getHttpInfo(getFeedUrlInfo() + Constant.LIST_FORUM_SEARCH_URL, requestParam.toString(), request);
		if (forumListResult != null) {
			int code = forumListResult.optInt("code", -1);
			if (0 != code) {
				//错误信息
				String message = forumListResult.optString("message", "");
			} else {
				JSONObject data = forumListResult.optJSONObject("data");
				//通过总数算出页码
				int total = data.optInt("total",0);
				
				request.setAttribute("pageList", Tools.editPageNumber(total, 1, 8));
				request.setAttribute("page", 1);
				request.setAttribute("totalPages", total);
				
				JSONArray jsonArr = data.optJSONArray("list");
				int length = jsonArr.length();
				List<FeedForum> listForum = new ArrayList<FeedForum>(length);
				FeedForum objFeedForum = null;
				for(int idx = 0; idx < length; idx ++) {
					JSONObject jsonFeedForum = jsonArr.getJSONObject(idx);
					objFeedForum = new FeedForum();
					
					long forumId = jsonFeedForum.optLong("fid", 0);
					objFeedForum.setForum_id(forumId);
					objFeedForum.setForum_name(jsonFeedForum.optString("name", ""));
					objFeedForum.setTotal_threads(jsonFeedForum.optInt("threads", 0));
					objFeedForum.setToday_threads(jsonFeedForum.optInt("today_threads", 0));
					objFeedForum.setIcon(jsonFeedForum.optString("icon", ""));
					objFeedForum.setForum_url("http://bbs.mofang.com/f/" + forumId);
					objFeedForum.setGift_url(jsonFeedForum.optString("gift_url", ""));
					objFeedForum.setPrefecture_url(jsonFeedForum.optString("prefecture_url", ""));
					
					listForum.add(objFeedForum);
				}
				request.setAttribute("forumList", listForum);
			}	
		} else {
			request.setAttribute("forumList", new ArrayList<FeedForum>(0));
		}
		
		
		
		//获取帖子list
		
		return "search";
	}
	
	
	@RequestMapping(value = "/thread/search",method = RequestMethod.GET)
	@ResponseBody
	public String searchThread(@RequestBody int fid, int status, String keyword, int p, int pagesize, HttpServletRequest request) throws Exception {
		StringBuffer requestParam = new StringBuffer();
		requestParam.append("fid=").append(fid).append("&");
		requestParam.append("status=").append(status).append("&");
		requestParam.append("p=").append(p).append("&");
		requestParam.append("pagesize=").append(pagesize).append("&");
		requestParam.append("keyword=").append(keyword).append("&");
		requestParam.append("keyword=").append(keyword).append("&");
		
		//获取版块list
		JSONObject forumListResult = getHttpInfo(Constant.LIST_THREAD_SEARCH_URL, requestParam.toString(), request);
		if (forumListResult != null) {
			int code = forumListResult.optInt("code", -1);
			if (0 != code) {
				//错误信息
				String message = forumListResult.optString("message", "");
			} else {
				JSONObject data = forumListResult.optJSONObject("data");
				//通过总数算出页码
				int total = data.optInt("total",0);
				
				
				request.setAttribute("pageList", Tools.editPageNumber(total, p));
				request.setAttribute("page", p);
				request.setAttribute("totalPages", total);
				
				JSONArray list = data.optJSONArray("list");
				List<FeedThread> threadList = new ArrayList<FeedThread>();
				FeedThread feedThread = null;
				JSONObject jsonThread = null;
				for(int i=0; i<list.length(); i++) {
					jsonThread = list.getJSONObject(i);
					feedThread = new FeedThread();
					feedThread.setForum_id(jsonThread.optLong("fid", 0));
					feedThread.setThread_id(jsonThread.optLong("tid", 0));
					feedThread.setUser_name(jsonThread.optString("nickname",""));
					feedThread.setIcon(jsonThread.optString("icon", ""));
					feedThread.setReplies(jsonThread.optInt("replies", 0));
					feedThread.setPage_view(jsonThread.optInt("pageview", 0));
					threadList.add(feedThread);
				}
				request.setAttribute("forumList", list);
			}	
		} else {
			request.setAttribute("forumList", new ArrayList<FeedForum>());
		}
		//获取帖子list
		return "search";
	}
	
	
	

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
	
	

}
