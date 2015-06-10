package com.mofang.feedweb.controller;

import java.io.File;
import java.io.FileOutputStream;
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
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mofang.feedweb.entity.FeedTag;
import com.mofang.feedweb.entity.FeedThread;
import com.mofang.feedweb.entity.ThreadUserInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedNewThreadService;
import com.mofang.feedweb.util.StringUtil;

@Controller
public class FeedNewThreadContorller extends FeedCommonController {

	@Autowired
	private FeedNewThreadService feedNewThreadService;
	
	@RequestMapping(value = "/newThreadInit", method = RequestMethod.GET)
	public ModelAndView init(@RequestParam(value = "fid") long fid,HttpServletRequest request)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		FeedThread threadinfo = new FeedThread();
		map.put("threadInfo", threadinfo);
		map.put("fid", fid);
		try {
			UserInfo userInfo = getUserInfo(request);
			// 用户信息
			if(userInfo != null) {
				Map<String, Object> userMap = feedNewThreadService.userMap("user_id=" + userInfo.getUserId(), request);
				map.putAll(userMap);
			}else {
				map.put("user", new ThreadUserInfo());
			}
			// 标签列表
			Map<String, Object> tagMap = feedNewThreadService.tagMap("fid=" + fid, request);
			map.putAll(tagMap);
			return new ModelAndView("new_thread", map);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadController.init throw an error.", e);
			map.put("user", new ThreadUserInfo());
			map.put("tagList", new ArrayList<FeedTag>(1));
			return new ModelAndView("new_thread", map);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = { "/editThreadInit" })
	public ModelAndView editInit(@RequestParam(value = "fid") long fid,
			@RequestParam(value = "tid") long tid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserInfo userInfo = getUserInfo(request);

			// 帖子信息
			Map<String, Object> threadInfoMap = feedNewThreadService.threadInfoMap("tid=" + tid, request);
			map.putAll(threadInfoMap);
			
			// 默认综合 特殊处理
			FeedThread threadInfo = (FeedThread)map.get("threadInfo");
			if(threadInfo != null) {
				int tagId = threadInfo.getTagId();
				if(tagId > 0){
					List<FeedTag> list = (List)map.get("tagList");
					list.add(new FeedTag(0, "综合"));
				}
			}
			map.put("fid", fid);
			
			// 用户信息
			if(userInfo != null) {
				Map<String, Object> userMap = feedNewThreadService.userMap("user_id=" + userInfo.getUserId(), request);
				map.putAll(userMap);
			}else {
				map.put("user", new ThreadUserInfo());
			}
			// 标签列表
			Map<String, Object> tagMap = feedNewThreadService.tagMap("fid=" + fid, request);
			map.putAll(tagMap);
			return new ModelAndView("new_thread", map);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadContorller.editInit throw an error.", e);
			map.put("user", new ThreadUserInfo());
			map.put("tagList", new ArrayList<FeedTag>(1));
			map.put("threadInfo", new FeedThread());
			return new ModelAndView("new_thread", map);
		}

	}

	@RequestMapping(value = { "/newThread" }, method = RequestMethod.POST)
	public void newThread(HttpServletRequest request, HttpServletResponse response, RedirectAttributes  redirectAtt)
			throws Exception {
		String strTid = request.getParameter("tid");
		String content = request.getParameter("content");
		String strTagId = request.getParameter("tagId");
		String subject = request.getParameter("subject");
		String strFid = request.getParameter("fid");
		
		try {
			long tid = 0;
			if(!StringUtil.isNullOrEmpty(strTid)) {
				tid = Long.valueOf(strTid);
			}
			int tagId = 0;
			if(!StringUtil.isNullOrEmpty(strTagId)){
				tagId = Integer.valueOf(strTagId);
			}
			
			JSONObject obj = new JSONObject();
			//发新帖
			if(tid == 0) {
				JSONObject json = new JSONObject();
				json.put("fid", strFid);
				json.put("subject", subject);
				json.put("content", content);
				json.put("tag_id", tagId);
//				JSONObject result = postHttpInfo(getFeedUrlInfo() + Constant.THREAD_CREATE_URL, json, request);
//				int code;
//				if(result != null && (code = result.optInt("code", -1)) == 0) {
//					String message = result.optString("message", "");
//					obj.put("code", code);
//					obj.put("message", message);
//				}else{
//					obj.put("code", -1);
//					obj.put("message", "保存失败");
//				}
				obj = feedNewThreadService.newThread(json, request);
			//编辑
			}else if(tid > 0){
				long threadId = tid;
				JSONObject json = new JSONObject();
				json.put("tid", threadId);
				json.put("subject", subject);
				json.put("content", content);
				json.put("tag_id", tagId);
//				JSONObject result = postHttpInfo(getFeedUrlInfo() + Constant.THREAD_EDIT_URL, json, request);
//				int code;
//				if(result != null && (code = result.optInt("code", -1)) == 0) {
//					String message = result.optString("message", "");
//					obj.put("code", code);
//					obj.put("message", message);
//				}else{
//					obj.put("code", -1);
//					obj.put("message", "保存失败");
//				}
				obj = feedNewThreadService.editThread(json, request);
			}
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(obj.toString());
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadController.newThread throw an error.", e);
		}

	}
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public void upload(@RequestParam("upfile") CommonsMultipartFile file, 
			MultipartHttpServletRequest multiRequest, HttpServletResponse response) throws Exception {
		String fileName = file.getOriginalFilename();
		PostMethod filePost = new PostMethod(getUploadImgUrl());
		HttpClient client = new HttpClient();
		String filePath = multiRequest.getSession().getServletContext().getRealPath("/")
				+ "tmpfile/";
		FileOutputStream fileOut=null;
		try {
			String tempDir = filePath + fileName;
			File newFile = new File(filePath);
			if(!newFile.exists()){
				newFile.mkdir();
			}
			fileOut = new FileOutputStream(tempDir);
			FileCopyUtils.copy(file.getBytes(), fileOut);
			Part[] parts = {
								  new StringPart("type", "image"), 
								  new StringPart("from", "bbs"), 
								  new FilePart("file", new File(tempDir)) 
								 };
			filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
			client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		    int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				String body = filePost.getResponseBodyAsString();
				JSONObject obj = new JSONObject(body);
				String url = "";
				if(obj.optInt("code", -1) == 0) {
					JSONObject urlObj = obj.optJSONObject("data");
					url = urlObj.optString("url", "");
				}
				
				JSONObject convertJsonObj = new JSONObject();
				convertJsonObj.put("originalName", fileName);
				convertJsonObj.put("name", fileName);
				convertJsonObj.put("url", url);
				convertJsonObj.put("size", file.getBytes().length);
				String type = fileName.substring(fileName.lastIndexOf("."));
				convertJsonObj.put("type", type);
				convertJsonObj.put("state", "SUCCESS");
				
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(convertJsonObj);
			}
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedNewThreadController.upload throw an error.", e);
		} finally {
			if(fileOut != null) {
				fileOut.close();
			}
		}		
	}
	
}