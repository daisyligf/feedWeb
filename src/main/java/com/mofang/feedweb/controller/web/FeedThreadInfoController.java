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

import com.mofang.feedweb.entity.FeedComment;
import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedPost;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.ThreadUserInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.util.StringUtil;

/**
 * 
 * @author daisyli
 * 帖子详情页
 *
 */
@Controller
public class FeedThreadInfoController extends FeedCommonController {

	@RequestMapping(value = "/thread_info", method = RequestMethod.GET)
	public ModelAndView getThreadInfo(HttpServletRequest request, @RequestParam("thread_id") long threadId) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		
		getThreadInfo(request, threadId, model);
		
		
		return new ModelAndView("thread_info", model);
	}
	
	private void getThreadInfo(HttpServletRequest request, long threadId, Map<String, Object> model) throws JSONException {
		
		StringBuilder param = new StringBuilder();
		param.append("tid=").append(threadId);
		
		String currPage = request.getParameter("currPage");
		int page = 1;
		if (currPage != null && StringUtil.isInteger(currPage)) {
			page = Integer.parseInt(currPage);
		}
		
		param.append("&page=").append(page);
		
		String pageSize = request.getParameter("pageSize");
		int size = 30;
		if (pageSize != null && StringUtil.isInteger(pageSize)) {
			size = Integer.parseInt(pageSize);
		}
		param.append("&size=").append(size);
		
		int type = 0;
		String typeString = request.getParameter("type");
		if (typeString != null && StringUtil.isInteger(typeString)) {
			type = Integer.parseInt(typeString);
		}
		param.append("&type=").append(type);
		
		JSONObject json = getHttpInfo(getPostListUrl(), param.toString(), request);
		
		int total = 0;
		boolean isModerator = false;
		boolean isAdmin = false;
		int[] privileges = {};
		FeedThread feedThread = new FeedThread();
		FeedForum feedForum = new FeedForum();
		ThreadUserInfo threadUserInfo = new ThreadUserInfo();
		List<FeedPost> postList = new ArrayList<FeedPost>();
		
		if (json != null && json.optInt("code", -1) == 0) {
			JSONObject data = json.optJSONObject("data");
			total = data.optInt("total", 0);
			JSONObject threadObj = data.optJSONObject("thread");
			if (threadObj != null) {
				feedThread.setThread_id(threadObj.optLong("tid", 0));
				feedThread.setSubject(threadObj.optString("subject", ""));
				feedThread.setContent(threadObj.optString("content", ""));
				feedThread.setPage_view(threadObj.optInt("pageview", 0));
				feedThread.setReplies(threadObj.optInt("replies", 0));
				feedThread.setCreate_time(new Date(threadObj.optLong("create_time", 0)));
				feedThread.setIsClosed(threadObj.optBoolean("is_closed", false));
				feedThread.setIsElite(threadObj.optBoolean("is_elite", false));
				feedThread.setIsTop(threadObj.optBoolean("is_top", false));
				feedThread.setRecommends(threadObj.optInt("recommends", 0));
				feedThread.setIsModerator(threadObj.optBoolean("is_moderator", false));
				
				JSONObject forumObj = threadObj.optJSONObject("forum");
				if (forumObj != null) {
					feedForum.setForum_id(forumObj.optLong("fid", 0));
					feedForum.setForum_name(forumObj.optString("name", ""));
				}
				
				JSONObject userObj = threadObj.optJSONObject("user");
				if (userObj != null) {
					threadUserInfo.setUserId(userObj.optLong("user_id", 0));
					threadUserInfo.setNickname(userObj.optString("nickname", ""));
					threadUserInfo.setAvatar(userObj.optString("avatar", ""));
					threadUserInfo.setCoin(userObj.optInt("coin", 0));
					threadUserInfo.setThreads(userObj.optInt("threads", 0));
					threadUserInfo.setReplies(userObj.optInt("replies", 0));
					threadUserInfo.setEliteThreads(userObj.optInt("eliteThreads", 0));
				}
			}
			
			JSONObject currentUserObj = data.optJSONObject("current_user");
			
			JSONArray posts = data.optJSONArray("posts");
			if (posts != null && posts.length() > 0) {
				for (int i = 0; i < posts.length(); i++) {
					JSONObject postObj = posts.getJSONObject(i);
					FeedPost feedPost = new FeedPost();
					feedPost.setPost_id(postObj.optLong("pid", 0));
					feedPost.setContent(postObj.optString("content", ""));
					feedPost.setHtmlContent(postObj.optString("html_content", ""));
					feedPost.setRecommends(postObj.optInt("recommends", 0));
					feedPost.setPosition(postObj.optInt("position", 0));
					feedPost.setCreate_time(new Date(postObj.optLong("reate_time", 0)));
					
					List<FeedComment> commentList = new ArrayList<FeedComment>();
					
					JSONArray comments = postObj.optJSONArray("comments");
					if (comments != null && comments.length() > 0) {
						for (int j = 0; j < comments.length(); j++) {
							FeedComment comment = new FeedComment();
							
							JSONObject commentObj = comments.getJSONObject(i);
							comment.setComment_id(commentObj.optLong("cid", 0));
							comment.setContent(commentObj.optString("content", ""));
							comment.setCreate_time(new Date(commentObj.optLong("create_time", 0)));
							
							JSONObject commentUserObj = commentObj.optJSONObject("user");
							long commentUserId = 0;
							String commentNickname = "";
							String commentAvatar = "";
							if (commentUserObj != null) {
								
								commentUserId = commentUserObj.optLong("user_id", 0);
								commentNickname = commentUserObj.optString("nickname", "");
								commentAvatar = commentUserObj.optString("avatar", "");
							}
							
							UserInfo userInfo = new UserInfo(commentUserId, commentNickname, commentAvatar);
							
							comment.setUserInfo(userInfo);
							commentList.add(comment);
						}
					}
					
					
					feedPost.setCommentList(commentList);
					postList.add(feedPost);
				}
			}
			
		}
		
		model.put("total", total);
		model.put("feedThread", feedThread);
		model.put("feedForum", feedForum);
		model.put("threadUserInfo", threadUserInfo);
		model.put("postList", postList);
		
		
	}
	
	@RequestMapping(value = "comment_list.json")
	public String commentList(@RequestParam("pid") long pid, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		StringBuilder param = new StringBuilder();
		param.append("pid=").append(pid);
		param.append("&page=1&size=10");
		
		JSONObject json = getHttpInfo(getCommentListUrl(), param.toString(), request);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "reply_post.json")
	public String replyPost(@RequestParam("pid") long pid, @RequestParam("content") String content, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("pid", pid);
		postData.put("content", content);
		
		JSONObject json = postHttpInfo(getReplyPostUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "del_floor.json")
	public String delFloor(@RequestParam("pid") long pid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("pid", pid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getDelFloorUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "recommend_floor.json")
	public String recommendFloor(@RequestParam("pid") long pid, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("pid", pid);
		
		JSONObject json = postHttpInfo(getRecommendFloorUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "close_thread.json")
	public String closeThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("tid", tid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getCloseThreadUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "open_thread.json")
	public String openThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("tid", tid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "top_thread.json")
	public String topThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("tid", tid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "cancel_top_thread.json")
	public String cancelTopThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("tid", tid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "elite_thread.json")
	public String eliteThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("tid", tid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
	@RequestMapping(value = "cancel_elite_thread.json")
	public String cancelEliteThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject postData = new JSONObject();
		postData.put("tid", tid);
		postData.put("reason", reason);
		
		
		JSONObject json = postHttpInfo(getForumFollowUrl(), postData);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
		return null;
	}
	
}
