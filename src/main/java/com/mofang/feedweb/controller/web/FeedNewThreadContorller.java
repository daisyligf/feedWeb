package com.mofang.feedweb.controller.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.FeedTag;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.ThreadUserInfo;
import com.mofang.feedweb.global.Constant;

@Controller
public class FeedNewThreadContorller extends FeedCommonController {

	@RequestMapping(value = "/newThreadInit", method = RequestMethod.GET)
	public ModelAndView init(@RequestParam(value = "fid") long fid,
			@RequestParam(value = "uid") long uid, HttpServletRequest request)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 用户信息
		map.putAll(userJson("user_id=" + uid, request));
		// 标签列表
		map.putAll(tagJson("fid=" + fid, request));
		
		map.put("fid", fid);
		FeedThread threadinfo = new FeedThread();
		map.put("threadInfo", threadinfo);
		return new ModelAndView("new_thread", map);
	}

	private Map<String, Object> userJson(String param,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		JSONObject userResult = getHttpInfo(getFeedUrlInfo()
				+ Constant.USER_INFO_URL, param, request);
		ThreadUserInfo info = new ThreadUserInfo();
		if (userResult != null) {
			int code = userResult.optInt("code", -1);
			if (code == 0) {
				JSONObject data = userResult.optJSONObject("data");
				info.setUserId(data.optLong("user_id", 0));
				info.setNickname(data.optString("nickname", ""));
				info.setAvatar(data.optString("avatar", ""));
				info.setReplies(data.optInt("replies", 0));
				info.setThreads(data.optInt("threads", 0));
				info.setEliteThreads(data.optInt("elite_threads", 0));
				info.setCoin(data.optInt("coin", 0));
			}
		}
		map.put("user", info);
		return map;
	}

	private Map<String, Object> tagJson(String param, HttpServletRequest request)
			throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>(1);
		JSONObject tagResult = getHttpInfo(getFeedUrlInfo()
				+ Constant.FORUM_TAG_LIST_URL, param, request);
		List<FeedTag> tagList = new ArrayList<FeedTag>();
		if (tagResult != null) {
			int code = tagResult.optInt("code", -1);
			if (code == 0) {
				JSONArray data = tagResult.optJSONArray("data");
				for (int idx = 0; idx < data.length(); idx++) {
					JSONObject jsonFeedTag = data.getJSONObject(idx);

					FeedTag tag = new FeedTag();
					tag.setTag_id(jsonFeedTag.optInt("tag_id", 0));
					tag.setTag_name(jsonFeedTag.optString("tag_name", ""));

					tagList.add(tag);
				}
			}
		}
		map.put("tagList", tagList);
		return map;
	}

	private Map<String, Object> threadInfoJson(String param,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		FeedThread threadinfo = new FeedThread();
		JSONObject threadResult = getHttpInfo(getFeedUrlInfo()
				+ Constant.THREAD_INFO_URL, param, request);
		if (threadResult != null) {
			int code = threadResult.optInt("code", -1);
			if (code == 0) {
				JSONObject data = threadResult.optJSONObject("data");

				threadinfo.setThread_id(data.optLong("tid", 0));
				threadinfo.setSubject(data.optString("subject", ""));
				threadinfo.setHtmlContent(data.optString("html_content", ""));
				threadinfo.setPic(data.optString("pic", ""));
				threadinfo.setTagId(data.optInt("tag_id", 0));

			}
		}
		map.put("threadInfo", threadinfo);
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = { "/editThreadInit" })
	public ModelAndView editInit(@RequestParam(value = "fid") long fid,
			@RequestParam(value = "uid") long uid,
			@RequestParam(value = "tid") long tid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 帖子信息
		map.putAll(threadInfoJson("tid=" + tid, request));
		// 用户信息
		map.putAll(userJson("user_id=" + uid, request));
		// 标签列表
		map.putAll(tagJson("fid=" + fid, request));
		
		FeedThread threadInfo = (FeedThread)map.get("threadInfo");
		if(threadInfo != null) {
			int tagId = threadInfo.getTagId();
			if(tagId > 0){
				List<FeedTag> list = (List)map.get("tagList");
				list.add(new FeedTag(0, "综合"));
			}
		}
		map.put("fid", fid);
		return new ModelAndView("new_thread", map);
	}

	@RequestMapping(value = { "/newThread" }, method = RequestMethod.POST)
	public void newThread(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long tid = Integer.valueOf(request.getParameter("tid"));
		String content = request.getParameter("content");
		String strTagId = request.getParameter("tagId");
		int tagId = 0;
		if(!StringUtils.isEmpty(strTagId)){
			tagId = Integer.valueOf(strTagId);
		}
		String subject = request.getParameter("subject");
		int fid = Integer.valueOf(request.getParameter("fid"));
		
		String message = "保存失败";
		
		//发新帖
		if(tid == 0) {
			long forumId = fid;
			JSONObject json = new JSONObject();
			json.put("fid", forumId);
			json.put("subject", subject);
			json.put("content", content);
			json.put("tag_id", tagId);
			JSONObject result = postHttpInfo(getFeedUrlInfo() + Constant.THREAD_CREATE_URL, json);
			int code = result.optInt("code", -1);
			//跳转到 板块内容页
			if(code == 0){
				
			}
			
			message = result.optString("message", "");
			
		//编辑
		}else if(tid > 0){
			long threadId = tid;
			JSONObject json = new JSONObject();
			json.put("tid", threadId);
			json.put("subject", subject);
			json.put("content", content);
			json.put("tag_id", tagId);
			JSONObject result = postHttpInfo(getFeedUrlInfo() + Constant.THREAD_EDIT_URL, json);
			int code = result.optInt("code", -1);
			//跳转到 帖子详情页
			if(code == 0){
				
			}
			
			message = result.optString("message", "");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(message);
	}
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public void upload(@RequestParam("upfile") String file, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		MultipartFile mpf = request.getFile(file);
		PostMethod filePost = new PostMethod(getUploadImgUrl());
		HttpClient client = new HttpClient();
		String filePath = request.getSession().getServletContext().getRealPath("/")
				+ "files/";

		try {
			FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(filePath
					+ mpf.getOriginalFilename()));
			String tempDir = filePath + mpf.getOriginalFilename();
			Part[] parts = { new StringPart("type", "image"), new StringPart("from", "bbs"), new FilePart("file", new File(tempDir)) };
			filePost.setRequestEntity(new MultipartRequestEntity(parts,
					filePost.getParams()));
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(5000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				String body = filePost.getResponseBodyAsString();
				JSONObject obj = new JSONObject(body);

				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(obj);
			} else {
				//log.info("上传失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}		
	}
	
}