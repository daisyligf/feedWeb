//package com.mofang.feedweb.controller.web;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.jasper.tagplugins.jstl.core.Redirect;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.mofang.feedweb.entity.FeedTag;
//import com.mofang.feedweb.entity.FeedThread;
//import com.mofang.feedweb.entity.FeedThreadStarterInfo;
//import com.mofang.feedweb.global.Constant;
//import com.mofang.feedweb.service.impl.FeedCreateThreadServiceImpl;
//
//public class FeedCreateThreadContorller {
//
//	private FeedCreateThreadServiceImpl createService ;
//	private StringBuffer message = null;
//	
//	// home主页初期信息显示
//	@RequestMapping(value = "/initCreateThread",method = RequestMethod.GET)
//	@ResponseBody
//	public String init(@RequestBody long fid, long tid,HttpServletRequest request) throws Exception {
//		createService = new FeedCreateThreadServiceImpl();
//		message = new StringBuffer();
//		
//		//获取楼主信息
//		JSONObject threadStarterResult = createService.getThreadStarterInfo(tid);
//		if (null != threadStarterResult) {
//			int code = threadStarterResult.optInt("code", -1);
//			if (0 != code) {
//				message.append(threadStarterResult.optString("message", ""));
//			} else {
//				JSONObject data = threadStarterResult.optJSONObject("data");
//				FeedThreadStarterInfo info = new FeedThreadStarterInfo();
//				info.setUser_id(data.optLong("uid", 0));
//				info.setUser_name(data.optString("nickname", ""));
//				info.setMagics(data.optInt("magics", 0));
//				info.setReplies(data.optInt("replies", 0));
//				info.setCreate_threads(data.optInt("threads", 0));
//				info.setElites(data.optInt("elites", 0));
//				
//				request.setAttribute("tStarterInfo", info);
//				
//			}	
//		} else {
//			request.setAttribute("tStarterInfo", new FeedThreadStarterInfo());
//		}
//		
//		
//		//获取版块标签
//		JSONObject tagResult = createService.getForumTagInfo(fid);
//		if (null != tagResult) {
//			
//			int code = tagResult.optInt("code", -1);
//			if (0 != code) {
//				message.append(tagResult.optString("message", ""));
//			} else {
//				JSONArray data = tagResult.optJSONArray("data");
//				List<FeedTag> listFeedTag = new ArrayList<FeedTag>();
//				FeedTag objFeedTag = null;
//				JSONObject jsonFeedTag = null;
//				for(int i=0; i<data.length(); i++)
//				{
//					jsonFeedTag = data.getJSONObject(i);
//					objFeedTag = new FeedTag();
//					objFeedTag.setTag_id(jsonFeedTag.optInt("tag_id", 0));
//					objFeedTag.setTag_name(jsonFeedTag.optString("tag_name", ""));
//					listFeedTag.add(objFeedTag);
//				}
//				
//				request.setAttribute("tagList", listFeedTag);
//			}	
//			
//		} else {
//			request.setAttribute("tickers", new ArrayList<FeedTag>());
//		}
//		
//		//获取帖子信息
//		if (tid > 0) {
//			JSONObject threadResult = createService.getEditThreadInfo(tid);
//			if (null != threadResult) {
//				
//				int code = threadResult.optInt("code", -1);
//				if (0 != code) {
//					message.append(threadResult.optString("message", ""));
//				} else {
//					JSONObject data = threadResult.optJSONObject("data");
//					FeedThread threadinfo = new FeedThread();
//					threadinfo.setForum_name(data.optString("forum_name", ""));
//					threadinfo.setThread_id(data.optLong("tid", 0));
//					threadinfo.setThread_name(data.optString("subject", ""));
//					threadinfo.setHtmlContent(data.optString("html_content", ""));
//					threadinfo.setPic(data.optString("pic", ""));
//					
//					request.setAttribute("threadInfo", threadinfo);
//				}	
//				
//			} else {
//				request.setAttribute("threadInfo", new FeedThread());
//			}
//		}
//		return "createThread";
//	}
//
//	
//	 //编辑帖子更新（修改）
//	 @RequestMapping(value = { "/editThread" })
//	 @ResponseBody
//	 public String editThread(@RequestBody long user_id,HttpServletRequest request,
//			 HttpServletResponse response) throws Exception {
//		 
//		 	createService = new FeedCreateThreadServiceImpl();
//			message = new StringBuffer();
//			
//			//验证码check
//			
//			JSONObject editThreadInfo = new JSONObject();
//			editThreadInfo.put("tid", request.getAttribute("tid"));
//			editThreadInfo.put("uid", user_id);
//			editThreadInfo.put("subject", request.getAttribute("subject"));
//			editThreadInfo.put("content", request.getAttribute("content"));
//			editThreadInfo.put("pic", "");
//			editThreadInfo.put("video_id", request.getAttribute("video_id"));
//			editThreadInfo.put("game_id", request.getAttribute("game_id"));
//			editThreadInfo.put("tag_id", request.getAttribute("tag_id"));
//			
//			JSONObject editResult = createService.editThread(editThreadInfo);
//			if (null != editResult) {
//				int code = editResult.optInt("code", -1);
//				if(0 != code) {
//					request.setAttribute("message", editResult.optString("message", ""));
//					return "redirect:error";
//				} else {
//					return "redirect:home_rank";
//				}
//				
//			} else {
//				request.setAttribute("message", "500");
//				return "redirect:error";
//			}
//	 }
//		
//	 //编辑帖子更新（创建）
//	 @RequestMapping(value = { "/createThread" })
//	 @ResponseBody
//	 public String createThread(@RequestBody long user_id,HttpServletRequest request,
//			 HttpServletResponse response) throws Exception {
//		 
//		 	createService = new FeedCreateThreadServiceImpl();
//			message = new StringBuffer();
//			
//			
//			//验证码check
//			
//			JSONObject editThreadInfo = new JSONObject();
//			editThreadInfo.put("tid", request.getAttribute("tid"));
//			editThreadInfo.put("uid", user_id);
//			editThreadInfo.put("fid", request.getAttribute("fid"));
//			editThreadInfo.put("title", request.getAttribute("subject"));
//			editThreadInfo.put("content", request.getAttribute("content"));
//			editThreadInfo.put("pic", "");
//			//帖子类型
//			editThreadInfo.put("type", "");
//			editThreadInfo.put("tags", request.getAttribute("tagid"));
//			editThreadInfo.put("video_id", request.getAttribute("video_id"));
//			editThreadInfo.put("game_id", request.getAttribute("game_id"));
//			editThreadInfo.put("tag_id", request.getAttribute("tag_id"));
//			
//			JSONObject editResult = createService.threadCreate(editThreadInfo);
//			if (null != editResult) {
//				int code = editResult.optInt("code", -1);
//				if(0 != code) {
//					request.setAttribute("message", editResult.optString("message", ""));
//					return "redirect:error";
//				} else {
//					return "redirect:home_rank";
//				}
//				
//			} else {
//				request.setAttribute("message", "500");
//				return "redirect:error";
//			}
//	 }
//			
//	 
//	
//}