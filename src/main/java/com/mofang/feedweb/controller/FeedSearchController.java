package com.mofang.feedweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.util.StringUtil;

@Controller
public class FeedSearchController extends FeedCommonController{

	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "keyword") String keyword,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(1);
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		map.put("keyword", keyword);
		return new ModelAndView("search", map);
	}
	
	private JSONObject forumJson(String requestParam, int p, HttpServletRequest request) throws Exception{
		JSONObject result = getHttpInfo(getFeedUrlInfo() + Constant.LIST_FORUM_SEARCH_URL, requestParam, request);
		if(result==null){
			return new JSONObject();
		}
		int code = result.optInt("code", -1);
		if(code == 0) {
			JSONObject objData = result.optJSONObject("data");
			JSONArray jsonArr = objData.optJSONArray("list");
			for(int idx = 0; idx < jsonArr.length(); idx ++) {
				JSONObject objForum = jsonArr.getJSONObject(idx);
				long fid = objForum.optLong("fid", 0l);
				objForum.put("link_url", "forum_content?fid=" +  fid);
			}
		}
		return result;
	}
	
	private JSONObject threadJson(String requestParam, int p, HttpServletRequest request) throws Exception{
		JSONObject result = getHttpInfo(getFeedUrlInfo() + Constant.LIST_THREAD_SEARCH_URL, requestParam, request);
		if(result==null){
			return new JSONObject();
		}
		
		int code = result.optInt("code", -1);
		if(code == 0){
			JSONObject objData = result.optJSONObject("data");
			JSONArray jsonArr = objData.optJSONArray("threads");
			for(int idx = 0; idx < jsonArr.length(); idx ++) {
				JSONObject objThread = jsonArr.getJSONObject(idx);
				String content = objThread.optString("content", "");
				if(!StringUtil.isNullOrEmpty(content)) {
					// content字段截取40个字符显示
					if(content.length() > 40){
						content = content.substring(0, 39);
						objThread.put("content", content);
					}
				}
				
				long threadId = objThread.optLong("tid", 0l);
				objThread.put("link_url", "thread_info?thread_id=" + threadId);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/searchThread",method = RequestMethod.GET)
	public void searchThread(@RequestParam(value = "keyword") String keyword, 
			@RequestParam(value = "fid", required=false) String strFid,
			@RequestParam(value = "p", required=false) int p,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(StringUtil.isNullOrEmpty(keyword)) {
			JSONObject json = new JSONObject();
			json.put("code", 0);
			json.put("message", "ok");
			JSONObject data = new JSONObject();
			data.put("total", 0);
			data.put("threads", "[]");
			json.put("data", data);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json.toString());
			return;
		}
		
		String status = "1";
		String author = "";
		if(!StringUtil.isNullOrEmpty(keyword)){
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		long fid = 0;
		if(!StringUtil.isNullOrEmpty(strFid)) {
			fid = Long.valueOf(strFid);
		}
		StringBuilder requestParam = new StringBuilder();
		requestParam.append("fid=").append(fid).append("&");
		requestParam.append("author=").append(author).append("&");
		requestParam.append("status=").append(status).append("&");
		requestParam.append("keyword=").append(keyword).append("&");
		requestParam.append("page=").append(p).append("&size=20");
		JSONObject json = threadJson(requestParam.toString(), p, request);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json.toString());
	}
	
	@RequestMapping(value = "/searchForum",method = RequestMethod.GET)
	public void searchForum(@RequestParam(value = "keyword") String keyword,
			@RequestParam(value = "p", required=false) int p,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(StringUtil.isNullOrEmpty(keyword)) {
			JSONObject json = new JSONObject();
			json.put("code", 0);
			json.put("message", "ok");
			JSONObject data = new JSONObject();
			data.put("total", 0);
			data.put("list", "[]");
			json.put("data", data);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json.toString());
			return;
		}
		
		if(!StringUtil.isNullOrEmpty(keyword)){
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}

		StringBuilder requestParam = new StringBuilder();
		requestParam.append("page=").append(p).append("&");
		requestParam.append("size=8&");
		requestParam.append("keyword=").append(keyword);
		
		JSONObject json = forumJson(requestParam.toString(), p ,request);
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print(json.toString());
	}
	
//	private Map<String, Object> forumMap(String requestParam, int p, HttpServletRequest request) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>(4);
//		JSONObject forumListResult = getHttpInfo(getFeedUrlInfo() + Constant.LIST_FORUM_SEARCH_URL, requestParam, request);
//		if (forumListResult != null) {
//			int code = forumListResult.optInt("code", -1);
//			if (0 != code) {
//				//错误信息
//				String message = forumListResult.optString("message", "");
//			} else {
//				JSONObject data = forumListResult.optJSONObject("data");
//				//通过总数算出页码
//				int total = data.optInt("total",0);
//				
//				
//				map.put("forumPageList", Tools.editPageNumber(total, p, 8));
//				map.put("forumPage", 1);
//				map.put("forumTotalPages", total);
//				
//				JSONArray jsonArr = data.optJSONArray("list");
//				int length = jsonArr.length();
//				List<FeedForum> listForum = new ArrayList<FeedForum>(length);
//				FeedForum objFeedForum = null;
//				for(int idx = 0; idx < length; idx ++) {
//					JSONObject jsonFeedForum = jsonArr.getJSONObject(idx);
//					objFeedForum = new FeedForum();
//					
//					long forumId = jsonFeedForum.optLong("fid", 0);
//					objFeedForum.setForum_id(forumId);
//					objFeedForum.setForum_name(jsonFeedForum.optString("name", ""));
//					objFeedForum.setTotal_threads(jsonFeedForum.optInt("threads", 0));
//					objFeedForum.setToday_threads(jsonFeedForum.optInt("today_threads", 0));
//					objFeedForum.setIcon(jsonFeedForum.optString("icon", ""));
//					objFeedForum.setForum_url("http://bbs.mofang.com/f/" + forumId + ".html");
//					objFeedForum.setGift_url(jsonFeedForum.optString("gift_url", ""));
//					objFeedForum.setPrefecture_url(jsonFeedForum.optString("prefecture_url", ""));
//					
//					listForum.add(objFeedForum);
//				}
//				map.put("forumList", listForum);
//			}	
//		} else {
//			map.put("forumList", new ArrayList<FeedForum>(0));
//		}		
//		return map;
//	}
//	
//	private Map<String, Object> threadMap(String requestParam, int p, HttpServletRequest request) throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>(4);
//		JSONObject threadListResult = getHttpInfo(getFeedUrlInfo() + Constant.LIST_THREAD_SEARCH_URL, requestParam, request);
//		if (threadListResult != null) {
//			int code = threadListResult.optInt("code", -1);
//			if (0 != code) {
//				//错误信息
//				String message = threadListResult.optString("message", "");
//			} else {
//				JSONObject data = threadListResult.optJSONObject("data");
//				//通过总数算出页码
//				int total = data.optInt("total",0);
//				
//				map.put("threadPageList", Tools.editPageNumber(total, p, 20));
//				map.put("threadPage", 1);
//				map.put("threadTotalPages", total);
//				
//				JSONArray jsonArr = data.optJSONArray("list");
//				int length = jsonArr.length();
//				List<FeedThread> threadList = new ArrayList<FeedThread>(length);
//				FeedThread thread = null;
//				for(int idx = 0; idx < length; idx ++) {
//					JSONObject jsonThread = jsonArr.getJSONObject(idx);
//					thread = new FeedThread();
//					
//					long forumId = jsonThread.optLong("fid", 0);
//					thread.setForum_id(forumId);
//					thread.setForum_name(jsonThread.optString("name", ""));
//					thread.setThread_id(jsonThread.optLong("tid", 0));
//					thread.setUser_id(jsonThread.optLong("user_id", 0));
//					thread.setSubject(jsonThread.optString("subject", ""));
//					thread.setReplies(jsonThread.optInt("replies", 0));
//					thread.setPage_view(jsonThread.optInt("pageview", 0));
//					thread.setIcon(jsonThread.optString("icon", ""));
//					
//					long createTime = jsonThread.optLong("utime", 0l);
//					thread.setCreate_time(TimeUtil.format(createTime));
//					thread.setUser_name(jsonThread.optString("nickname" , ""));
//					
//					String content = jsonThread.optString("content", "");
//					if(StringUtils.isEmpty(content)){
//						content = "test test test test test test test test test test test test test test ";
//					}
//					thread.setContent(content);
//					
//					threadList.add(thread);
//				}
//				map.put("threadList", threadList);
//			}	
//		} else {
//			map.put("threadList", new ArrayList<FeedThread>(0));
//		}	
//		return map;
//	}

}
