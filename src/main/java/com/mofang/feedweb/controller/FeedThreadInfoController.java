package com.mofang.feedweb.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.config.PrivilegesConfig;
import com.mofang.feedweb.entity.CurrentUser;
import com.mofang.feedweb.entity.FeedComment;
import com.mofang.feedweb.entity.FeedForum;
import com.mofang.feedweb.entity.FeedPost;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.ThreadUserInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;

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
		
		try {
			getThreadInfo(request, threadId, model);
			
			UserInfo loginUser = getUserInfo(request);
			model.put("loginUser", loginUser);
			model.put("keyword", getSearchKey(request));
			return new ModelAndView("thread_info", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.getThreadInfo throw an error.", e);
			return new ModelAndView("thread_info", model);
		}
	}
	
	private void getThreadInfo(HttpServletRequest request, long threadId, Map<String, Object> model) throws Exception {
		
		try {
			StringBuilder param = new StringBuilder();
			param.append("tid=").append(threadId);
			long forumId = 0;
			String currPage = request.getParameter("currentPage");
			int page = 1;
			if (currPage != null && StringUtil.isInteger(currPage)) {
				page = Integer.parseInt(currPage);
			}
			
			param.append("&page=").append(page);
			
			String pageSize = request.getParameter("pageSize");
			//int size = 30;
			int size = 20;
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
	
			FeedThread feedThread = new FeedThread();
			FeedForum feedForum = new FeedForum();
			ThreadUserInfo threadUserInfo = new ThreadUserInfo();
			CurrentUser currentUser = new CurrentUser();
			List<FeedPost> postList = new ArrayList<FeedPost>();
			
			if (json != null && json.optInt("code", -1) == 0) {
				JSONObject data = json.optJSONObject("data");
				total = data.optInt("total", 0);
				JSONObject threadObj = data.optJSONObject("thread");
				if (threadObj != null) {
					feedThread.setThread_id(threadObj.optLong("tid", 0));
					feedThread.setSubject(threadObj.optString("subject", ""));
					
					String content = threadObj.optString("content", "");
					feedThread.setContent(replaceEmoji(content));
					feedThread.setPage_view(threadObj.optInt("pageview", 0));
					feedThread.setReplies(threadObj.optInt("replies", 0));
					feedThread.setCreate_time(new Date(threadObj.optLong("create_time", 0)));
					feedThread.setIsClosed(threadObj.optBoolean("is_closed", false));
					feedThread.setIsElite(threadObj.optBoolean("is_elite", false));
					feedThread.setIsTop(threadObj.optBoolean("is_top", false));
					feedThread.setRecommends(threadObj.optInt("recommends", 0));
					feedThread.setIsModerator(threadObj.optBoolean("is_moderator", false));
					feedThread.setIsRecommend(threadObj.optBoolean("is_recommend", false));
					
					JSONObject forumObj = threadObj.optJSONObject("forum");
					if (forumObj != null) {
						forumId = forumObj.optLong("fid", 0);
						feedForum.setForum_id(forumId);
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
	//			System.out.println("currentUserObj:" + currentUserObj);
				
				if (currentUserObj != null) {
					currentUser.setIsModerator(currentUserObj.optBoolean("is_moderator", false));
					boolean isAdmin = currentUserObj.optBoolean("is_admin", false);
					currentUser.setIsAdmin(isAdmin);
					
					Set<Integer> privileges = new HashSet<Integer>();
					
					if (isAdmin) {
						privileges = getAllPrivileges();
					} else {
						JSONArray privilegesArray = currentUserObj.optJSONArray("privileges");
						if (privilegesArray != null && privilegesArray.length() > 0) {
							for (int i = 0; i < privilegesArray.length(); i++) {
								
								int privilege = privilegesArray.optInt(i, 0);
								if (privilege > 0) {
									privileges.add(privilege);
									
								}
							}
						}
					}
					
					currentUser.setPrivileges(privileges);
				}
				
				JSONArray posts = data.optJSONArray("posts");
				if (posts != null && posts.length() > 0) {
					for (int i = 0; i < posts.length(); i++) {
						JSONObject postObj = posts.getJSONObject(i);
						if (postObj == null)
							continue;
						FeedPost feedPost = new FeedPost();
						feedPost.setPost_id(postObj.optLong("pid", 0));
						feedPost.setContent(replaceEmoji(postObj.optString("content", "")));
						feedPost.setHtmlContent(replaceEmoji(postObj.optString("html_content", "")));
						feedPost.setRecommends(postObj.optInt("recommends", 0));
						feedPost.setPosition(postObj.optInt("position", 0));
						feedPost.setCreate_time(new Date(postObj.optLong("create_time", 0)));
						feedPost.setComments(postObj.optInt("comments", 0)); 
						feedPost.setIsRecommend(postObj.optBoolean("is_recommend", false));
						
						List<String> pic = new ArrayList<String>();
						JSONArray picArray = postObj.optJSONArray("pic");
						if (picArray != null && picArray.length() > 0) {
							for (int j = 0; j < picArray.length(); j++) {
								String picString = picArray.getString(j);
								if (!StringUtil.isNullOrEmpty(picString)) {
									pic.add(picString);
								}
							}
						}
						feedPost.setPic(pic);
						
						JSONObject postUserJson = postObj.optJSONObject("user");
						UserInfo postUserInfo = new UserInfo();
						if (postUserJson != null && postUserJson.length() > 0) {
							postUserInfo.setUserId(postUserJson.optLong("user_id", 0));
							postUserInfo.setNickname(postUserJson.optString("nickname", ""));
							postUserInfo.setAvatar(postUserJson.optString("avatar", ""));
						}
						
						feedPost.setPostUserInfo(postUserInfo);
						
						List<FeedComment> commentList = new ArrayList<FeedComment>();
						
						JSONArray comments = postObj.optJSONArray("comments");
						if (comments != null && comments.length() > 0) {
							for (int j = 0; j < comments.length(); j++) {
								FeedComment comment = new FeedComment();
								
								JSONObject commentObj = comments.getJSONObject(j);
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
			
			List<FeedThread> highestList = replyHighest(request, forumId);
			
			model.put("total", total);
			model.put("type", type);
			model.put("feedThread", feedThread);
			model.put("feedForum", feedForum);
			model.put("threadUserInfo", threadUserInfo);
			model.put("currentUser", currentUser);
			model.put("postList", postList);
			model.put("highestList", highestList);
			
			model.put("currentPage", page);
			model.put("totalPages", Tools.editTotalPageNumber(total));
			model.put("pagelist", Tools.editPageNumber(total, page,Constant.PAGE_SIZE));
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.(void)getThreadInfo throw an error.", e);
		}
		
	}
	
	private Set<Integer> getAllPrivileges() throws Exception {
//		Set<Integer> privileges = new HashSet<Integer>();
//		Class<?> clz = Class.forName("com.mofang.feedweb.global.SysPrivilege");
//		
//        // 获取实体类的所有属性，返回Field数组  
//        Field[] fields = clz.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//        	Field field = fields[i];
//        	String name = field.getName();
//        	privileges.add(field.getInt(name));
//        }
//		return privileges;
		try {
			return PrivilegesConfig.getAllPrivileges();
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.getAllPrivileges throw an error.", e);
			return null;
		}
	}

	private List<FeedThread> replyHighest(HttpServletRequest request, long forumId) throws Exception {
		String param = "fid=" + forumId;
		List<FeedThread> threadList = new ArrayList<FeedThread>();
		
		try {
			JSONObject json = getHttpInfo(getFeedUrlInfo() + Constant.REPLY_HIGHEST_URL, param, request);
			if (json != null && json.optInt("code", -1) == 0) {
				JSONArray data = json.optJSONArray("data");
				if (data != null && data.length() > 0) {
					for (int i = 0; i < data.length(); i++) {
						JSONObject obj = data.getJSONObject(i);
						FeedThread feedThread = new FeedThread();
						feedThread.setThread_id(obj.optLong("tid", 0));
						feedThread.setSubject(obj.optString("subject", ""));
						threadList.add(feedThread);
					}
				}
			}
			
			return threadList;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.replyHighest throw an error.", e);
			return threadList;
		}
	}
	
	@RequestMapping(value = "comment_list.json")
	public String commentList(@RequestParam("pid") long pid, @RequestParam("p") int p, @RequestParam("pagesize") int pageSize,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			StringBuilder param = new StringBuilder();
			param.append("pid=").append(pid);
			param.append("&page=").append(p);
			param.append("&size=").append(pageSize);
			
			JSONObject json = getHttpInfo(getCommentListUrl(), param.toString(), request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.commentList throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "reply_post.json")
	public String replyPost(@RequestParam("pid") long pid, @RequestParam("content") String content, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("pid", pid);
			postData.put("content", content);
			
			JSONObject json = postHttpInfo(getReplyPostUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.replyPost throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "del_floor.json")
	public String delFloor(@RequestParam("pid") long pid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("pid", pid);
			postData.put("reason", reason);
			
			JSONObject json = postHttpInfo(getDelFloorUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.delFloor throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "recommend_thread.json", method = RequestMethod.POST)
	public String recommendThread(@RequestParam("tid") long tid, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			
			JSONObject json = postHttpInfo(getRecommendThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.recommendThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "recommend_floor.json", method = RequestMethod.POST)
	public String recommendFloor(@RequestParam("pid") long pid, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("pid", pid);
			
			JSONObject json = postHttpInfo(getRecommendFloorUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.recommendFloor throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "close_thread.json", method = RequestMethod.POST)
	public String closeThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			
			JSONObject json = postHttpInfo(getCloseThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.closeThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "open_thread.json")
	public String openThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			
			JSONObject json = postHttpInfo(getOpenThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.openThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "top_thread.json")
	public String topThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			
			JSONObject json = postHttpInfo(getSetTopThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.topThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "cancel_top_thread.json")
	public String cancelTopThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			
			JSONObject json = postHttpInfo(getCancelTopThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.cancelTopThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "elite_thread.json")
	public String eliteThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			
			JSONObject json = postHttpInfo(getEliteThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.eliteThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "cancel_elite_thread.json")
	public String cancelEliteThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			
			JSONObject json = postHttpInfo(getCancelEliteThreadUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.cancelEliteThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "award.json")
	public String award(@RequestParam("uid") long uid, @RequestParam("coin") int coin, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			JSONObject postData = new JSONObject();
			postData.put("uid", uid);
			
			JSONObject awardJson = new JSONObject();
			awardJson.put("coin", coin);
			postData.put("reward", awardJson);
			
			JSONObject json = postHttpInfo(getViperAwardUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.award throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "del_thread.json")
	public String deleteThread(@RequestParam("tid") long tid, @RequestParam("reason") String reason, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", tid);
			postData.put("reason", reason);
			
			JSONObject json = postHttpInfo(getThreadDeleteUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.deleteThread throw an error.", e);
			return null;
		}
	}
	
	@RequestMapping(value = "send_reply.json")
	public ModelAndView sendReply(@RequestParam("tid") long threadId, @RequestParam("content") String content, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		try {
			JSONObject postData = new JSONObject();
			postData.put("tid", threadId);
			postData.put("content", content);
			
			JSONObject json = postHttpInfo(getSendReplyUrl(), postData, request);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedThreadInfoController.sendReply throw an error.", e);
			return null;
		}
	}
	
	
	
}
