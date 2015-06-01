package com.mofang.feedweb.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mofang.feedweb.entity.FeedPost;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.FeedThreadStarterInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.util.Tools;

//public class FeedThreadDetailController {
//
//
//
//	private FeedThreadInfoServiceImpl threadInfoService = null;
//	private StringBuffer message = null;
//	
//	//版块列表
//	//type:热门游戏  ：1  新游推荐 ：2
//	@RequestMapping(value = "/threadDetail",method = RequestMethod.GET)
//	@ResponseBody
//	public String initsearchPage(@RequestBody int user_id,int p, int type,int tid,  HttpServletRequest request) throws Exception {
//		
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		//获取版块list
//		JSONObject postListResult = threadInfoService.getPostList(user_id, tid, p, Constant.PAGE_SIZE, type);
//		if (null != postListResult) {
//			int code = postListResult.optInt("code", -1);
//			if (0 != code) {
//				message.append(postListResult.optString("message", ""));
//			} else {
//				JSONObject data = postListResult.optJSONObject("data");
//				
//				//通过总数算出页码
//				int total = data.optInt("total",0);
//				request.setAttribute("pageList", Tools.editPageNumber(total, p));
//				request.setAttribute("page", p);
//				request.setAttribute("totalPages", total);
//				
//				//楼主信息
//				JSONObject jsonStarterInfo = data.optJSONObject("user");
//				FeedThreadStarterInfo info = new FeedThreadStarterInfo();
//				info.setUser_id(jsonStarterInfo.optLong("uid", 0));
//				info.setUser_name(jsonStarterInfo.optString("nickname", ""));
//				info.setMagics(jsonStarterInfo.optInt("magics", 0));
//				info.setReplies(jsonStarterInfo.optInt("replies", 0));
//				info.setCreate_threads(jsonStarterInfo.optInt("threads", 0));
//				info.setElites(jsonStarterInfo.optInt("elites", 0));
//				//是否是版主
//				info.setIs_moderator(jsonStarterInfo.optInt("is_moderator", 0));
//				
//				request.setAttribute("tStarterInfo", info);
//				
//				//楼层list信息
//				JSONArray list = data.optJSONArray("postlist");
//				List<FeedPost> listPost = new ArrayList<FeedPost>();
//				FeedPost objFeedPost = null;
//				JSONObject jsonFeedPost = null;
//				for(int i=0; i<list.length(); i++)
//				{
//					jsonFeedPost = list.getJSONObject(i);
//					objFeedPost = new FeedPost();
//					objFeedPost.setUser_id(jsonFeedPost.optLong("uid", 0));
//					objFeedPost.setUser_name(jsonFeedPost.optString("nickname", ""));
//					objFeedPost.setCreate_time(jsonFeedPost.optString("ctime", ""));
//					objFeedPost.setContent(jsonFeedPost.optString("html_content", ""));
//					//点赞数
//					objFeedPost.setRecommends(jsonFeedPost.optInt("support_cnt", 0));
//					//回复数
//					objFeedPost.setReplies(jsonFeedPost.optInt("replycnt", 0));
//					objFeedPost.setPost_id(jsonFeedPost.optInt("pid", 0));
//					listPost.add(objFeedPost);
//				}
//				
//				request.setAttribute("postList", listPost);
//				
//				//最热推荐的7条帖子信息
//				
//				
//				//帖子信息
//				JSONObject jsonTInfo = data.optJSONObject("thread");
//				FeedThread threadinfo = new FeedThread();
//				threadinfo.setThread_id(jsonTInfo.optLong("tid", 0));
//				threadinfo.setThread_name(jsonTInfo.optString("title", ""));
//				threadinfo.setForum_id(jsonTInfo.optLong("fid", 0));
//				
//				request.setAttribute("threadInfo", threadinfo);
//				
//			}	
//		}
//		
//		return "threadDetail";
//
//	}
//
//	//删除
//	@RequestMapping(value = "/threadDelete",method = RequestMethod.POST)
//	@ResponseBody
//	public void deleteThread(@RequestBody long thread_id, long user_id, String reason, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject deleteInfo = new JSONObject();
//		deleteInfo.put("tid", thread_id);
//		deleteInfo.put("uid", user_id);
//		deleteInfo.put("reason", reason);
//		
//		JSONObject deleteResult = threadInfoService.threadDelete(deleteInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != deleteResult) {
//			
//			int code = deleteResult.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//加精，取消加精
//	@RequestMapping(value = "/eliteOperator",method = RequestMethod.POST)
//	@ResponseBody
//	public void EliteOperator(@RequestBody long thread_id, long user_id, String reason, int elite_flg,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject eliteInfo = new JSONObject();
//		eliteInfo.put("tid", thread_id);
//		eliteInfo.put("uid", user_id);
//		eliteInfo.put("tag_id", 1);
//		eliteInfo.put("reason", reason);
//		
//		JSONObject Result = null;
//		//elite_flg=1 加精  elite_flg=2 取消加精
//		if (elite_flg == 1) {
//			Result = threadInfoService.threadSetElite(eliteInfo);
//		} else {
//			Result = threadInfoService.threadCancelElite(eliteInfo);
//		}
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//置顶取消置顶
//	@RequestMapping(value = "/topOperator",method = RequestMethod.POST)
//	@ResponseBody
//	public void topOperator(@RequestBody long thread_id, long user_id, String reason, int top_flg,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject topInfo = new JSONObject();
//		topInfo.put("tid", thread_id);
//		topInfo.put("uid", user_id);
//		topInfo.put("reason", reason);
//		
//		JSONObject Result = null;
//		if (top_flg == 1) {
//			Result = threadInfoService.threadSetTop(topInfo);
//		} else {
//			Result = threadInfoService.threadCancelTop(topInfo);
//		}
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//锁帖
//	@RequestMapping(value = "/close",method = RequestMethod.POST)
//	@ResponseBody
//	public void close(@RequestBody long thread_id, long user_id, String reason,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject closeInfo = new JSONObject();
//		closeInfo.put("tids", thread_id);
//		closeInfo.put("uid", user_id);
//		closeInfo.put("reason", reason);
//		
//		JSONObject Result = null;
//		Result = threadInfoService.threadClose(closeInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//开帖
//	@RequestMapping(value = "/open",method = RequestMethod.POST)
//	@ResponseBody
//	public void open(@RequestBody long thread_id, long user_id, String reason,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject openInfo = new JSONObject();
//		openInfo.put("tids", thread_id);
//		openInfo.put("uid", user_id);
//		openInfo.put("reason", reason);
//		
//		JSONObject Result = null;
//		Result = threadInfoService.threadOpen(openInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//楼层删除
//	@RequestMapping(value = "/postDelete",method = RequestMethod.POST)
//	@ResponseBody
//	public void postDelete(@RequestBody long post_id, long user_id, String reason,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject postDeleteInfo = new JSONObject();
//		postDeleteInfo.put("pid", post_id);
//		postDeleteInfo.put("uid", user_id);
//		postDeleteInfo.put("reason", reason);
//		
//		JSONObject Result = null;
//		Result = threadInfoService.postDelete(postDeleteInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//楼层点赞
//	@RequestMapping(value = "/postRecommend",method = RequestMethod.POST)
//	@ResponseBody
//	public void postRecommend(@RequestBody long post_id, long user_id,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject recommendInfo = new JSONObject();
//		recommendInfo.put("pid", post_id);
//		recommendInfo.put("uid", user_id);
//		
//		JSONObject Result = null;
//		Result = threadInfoService.postRecommend(recommendInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//回复指定楼层
//	@RequestMapping(value = "/postReply",method = RequestMethod.POST)
//	@ResponseBody
//	public void postReply(@RequestBody long thread_id, long user_id,int post_id, String content,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject commentInfo = new JSONObject();
//		commentInfo.put("tid", thread_id);
//		commentInfo.put("postid", user_id);
//		commentInfo.put("uid", post_id);
//		commentInfo.put("content", user_id);
//		
//		JSONObject Result = null;
//		Result = threadInfoService.replyPost(commentInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			if (0 == code) {
//				//回复楼层
//				JSONObject getInfo = Result.optJSONObject("data");
//				map1.put("user_id", getInfo.optLong("uid", 0));
//				map1.put("user_name", getInfo.optString("nickname", ""));
//				map1.put("create_time", getInfo.optString("ctime", ""));
//				map1.put("content", getInfo.optString("content", ""));
//				map1.put("comment_id", getInfo.optInt("rid", 0));
//				map1.put("thread_id", getInfo.optInt("tid", 0));
//			}
//			
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//回复帖子
//	@RequestMapping(value = "/threadReply",method = RequestMethod.POST)
//	@ResponseBody
//	public void threadReply(@RequestBody long forum_id, long user_id,int thread_id,String content,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		JSONObject postInfo = new JSONObject();
//		postInfo.put("fid", forum_id);
//		postInfo.put("tid", thread_id);
//		postInfo.put("uid", user_id);
//		postInfo.put("content", content);
//		
//		JSONObject Result = null;
//		Result = threadInfoService.createPost(postInfo);
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			
//			if (0 == code) {
//				//回复帖子信息
//				JSONObject getInfo = Result.optJSONObject("data");
//				map1.put("user_id", getInfo.optLong("uid", 0));
//				map1.put("user_name", getInfo.optString("nickname", ""));
//				map1.put("create_time", getInfo.optString("ctime", ""));
//				map1.put("content", getInfo.optString("html_content", ""));
//				map1.put("recommends", 0);
//				map1.put("replies", getInfo.optInt("replycnt", 0));
//				map1.put("post_id", getInfo.optInt("pid", 0));
//				
//				
//			}
//			map1.put("code", code);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//	
//	//评论列表
//	@RequestMapping(value = "/getCommentList",method = RequestMethod.GET)
//	@ResponseBody
//	public void getCommentList(@RequestBody long post_id, int page,HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		threadInfoService = new FeedThreadInfoServiceImpl();
//		message = new StringBuffer();
//		
//		
//		JSONObject Result = null;
//		Result = threadInfoService.getCommentList(post_id, page, 10);
//		List<Map<String, Object>> maplist = new ArrayList<Map<String,Object>>();
//		Map<String, Object> map1 = new HashMap<String, Object>(10);
//		if (null != Result) {
//			
//			int code = Result.optInt("code", -1);
//			
//			if (0 == code) {
//				//楼层list信息
//				JSONArray list = Result.optJSONArray("commentlist");
//				JSONObject jsonFeedComment = null;
//				for(int i=0; i<list.length(); i++)
//				{
//					jsonFeedComment = list.getJSONObject(i);
//					map1.put("user_id", jsonFeedComment.optLong("uid", 0));
//					map1.put("user_name", jsonFeedComment.optString("nickname", ""));
//					map1.put("create_time", jsonFeedComment.optString("ctime", ""));
//					map1.put("content", jsonFeedComment.optString("content", ""));
//					map1.put("comment_id", jsonFeedComment.optInt("rid", 0));
//					map1.put("thread_id", jsonFeedComment.optInt("tid", 0));
//					
//					maplist.add(map1);
//					
//				}
//			}
//			map1 = new HashMap<String, Object>(10);
//			map1.put("code", code);
//			map1.put("list", maplist);
//			maplist.add(map1);
//		}
//		Tools.renderData(response, map1.toString());
//		
//	}
//		
//
//}