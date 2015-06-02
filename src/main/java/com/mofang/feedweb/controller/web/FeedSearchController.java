package com.mofang.feedweb.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.util.TimeUtil;
import com.mofang.feedweb.util.Tools;

@Controller
public class FeedSearchController extends FeedCommonController{

	@RequestMapping(value = "/search",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView search(@RequestParam(value = "keyword") String keyword, 
			@RequestParam(value = "fid", required=false) String fid,@RequestParam(value = "author", required=false) String author,
			@RequestParam(value = "status",required=false) String status,
			HttpServletRequest request) throws Exception {
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		StringBuilder requestParam = new StringBuilder();
		requestParam.append("p=1&");
		requestParam.append("pagesize=8&");
		requestParam.append("keyword=").append(keyword);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.putAll(forumMap(requestParam.toString(), 1, request));
		
		requestParam = new StringBuilder();
		if(!StringUtils.isEmpty(author)){
			author = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		//测试数据
		if(StringUtils.isEmpty(fid)){
			fid = "10";
		}
		if(StringUtils.isEmpty(status)){
			status = "1";
		}
		if(StringUtils.isEmpty(author)){
			author = "";
		}
		
		requestParam.append("fid=").append(fid).append("&");
		requestParam.append("author=").append(author).append("&");
		requestParam.append("status=").append(status).append("&");
		requestParam.append("keyword=").append(keyword).append("&");
		requestParam.append("p=1&pagesize=20");
		
		map.putAll(threadMap(requestParam.toString(), 1, request));
		map.put("keyword", keyword);
		
		return new ModelAndView("search", map);
	}
	
	/***
	 * 
	 * @param requestParam
	 * @param p 页码
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> forumMap(String requestParam, int p, HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(4);
		JSONObject forumListResult = getHttpInfo(getFeedUrlInfo() + Constant.LIST_FORUM_SEARCH_URL, requestParam, request);
		if (forumListResult != null) {
			int code = forumListResult.optInt("code", -1);
			if (0 != code) {
				//错误信息
				String message = forumListResult.optString("message", "");
			} else {
				JSONObject data = forumListResult.optJSONObject("data");
				//通过总数算出页码
				int total = data.optInt("total",0);
				
				
				map.put("forumPageList", Tools.editPageNumber(total, p, 8));
				map.put("forumPage", 1);
				map.put("forumTotalPages", total);
				
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
					objFeedForum.setForum_url("http://bbs.mofang.com/f/" + forumId + ".html");
					objFeedForum.setGift_url(jsonFeedForum.optString("gift_url", ""));
					objFeedForum.setPrefecture_url(jsonFeedForum.optString("prefecture_url", ""));
					
					listForum.add(objFeedForum);
				}
				map.put("forumList", listForum);
			}	
		} else {
			map.put("forumList", new ArrayList<FeedForum>(0));
		}		
		return map;
	}
	
	/***
	 * 
	 * @param requestParam
	 * @param p 页码
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> threadMap(String requestParam, int p, HttpServletRequest request) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>(4);
		JSONObject threadListResult = getHttpInfo(getFeedUrlInfo() + Constant.LIST_THREAD_SEARCH_URL, requestParam, request);
		if (threadListResult != null) {
			int code = threadListResult.optInt("code", -1);
			if (0 != code) {
				//错误信息
				String message = threadListResult.optString("message", "");
			} else {
				JSONObject data = threadListResult.optJSONObject("data");
				//通过总数算出页码
				int total = data.optInt("total",0);
				
				map.put("threadPageList", Tools.editPageNumber(total, p, 20));
				map.put("threadPage", 1);
				map.put("threadTotalPages", total);
				
				JSONArray jsonArr = data.optJSONArray("list");
				int length = jsonArr.length();
				List<FeedThread> threadList = new ArrayList<FeedThread>(length);
				FeedThread thread = null;
				for(int idx = 0; idx < length; idx ++) {
					JSONObject jsonThread = jsonArr.getJSONObject(idx);
					thread = new FeedThread();
					
					long forumId = jsonThread.optLong("fid", 0);
					thread.setForum_id(forumId);
					thread.setForum_name(jsonThread.optString("name", ""));
					thread.setThread_id(jsonThread.optLong("tid", 0));
					thread.setUser_id(jsonThread.optLong("user_id", 0));
					thread.setSubject(jsonThread.optString("subject", ""));
					thread.setReplies(jsonThread.optInt("replies", 0));
					thread.setPage_view(jsonThread.optInt("pageview", 0));
					thread.setIcon(jsonThread.optString("icon", ""));
					
					long createTime = jsonThread.optLong("utime", 0l);
					thread.setCreate_time(TimeUtil.format(createTime));
					thread.setUser_name(jsonThread.optString("nickname" , ""));
					
					String content = jsonThread.optString("content", "");
					if(StringUtils.isEmpty(content)){
						content = "test test test test test test test test test test test test test test ";
					}
					thread.setContent(content);
					
					threadList.add(thread);
				}
				map.put("threadList", threadList);
			}	
		} else {
			map.put("threadList", new ArrayList<FeedThread>(0));
		}	
		
		return map;
	}
	
	
	@RequestMapping(value = "/thread/search",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView searchThread(@RequestParam(value = "keyword") String keyword, 
			@RequestParam(value = "fid") String fid,@RequestParam(value = "author") String author,
			@RequestParam(value = "status") String status, 
			@RequestParam(value = "p") int p,HttpServletRequest request) throws Exception {
		
		//测试数据
		if(StringUtils.isEmpty(fid)){
			fid = "10";
		}
		if(StringUtils.isEmpty(status)){
			status = "1";
		}
		if(StringUtils.isEmpty(author)){
			author = "";
		}
		if(!StringUtils.isEmpty(keyword)){
			keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		}
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		StringBuilder requestParam = new StringBuilder();
		requestParam.append("p=1&");
		requestParam.append("pagesize=8&");
		requestParam.append("keyword=").append(keyword);
		map.putAll(forumMap(requestParam.toString(), p, request));
		
		requestParam = new StringBuilder();
		requestParam.append("fid=").append(fid).append("&");
		requestParam.append("author=").append(author).append("&");
		requestParam.append("status=").append(status).append("&");
		requestParam.append("keyword=").append(keyword).append("&");
		requestParam.append("p=").append(p).append("&pagesize=20");
		map.putAll(threadMap(requestParam.toString(), p, request));
		
		map.put("keyword", keyword);

		return new ModelAndView("search", map);
	}
	

}
