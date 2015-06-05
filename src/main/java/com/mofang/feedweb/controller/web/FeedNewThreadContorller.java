package com.mofang.feedweb.controller.web;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
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
import com.mofang.feedweb.global.Constant;

@Controller
public class FeedNewThreadContorller extends FeedCommonController {

	@RequestMapping(value = "/newThreadInit", method = RequestMethod.GET)
	public ModelAndView init(@RequestParam(value = "fid") long fid,HttpServletRequest request)
			throws Exception {
		
		String uid  = String.valueOf(request.getSession().getAttribute("uid"));
		//test
		if(StringUtils.isEmpty(uid)) {
			uid = "129707";
		}
		
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
			@RequestParam(value = "tid") long tid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String uid  = String.valueOf(request.getSession().getAttribute("uid"));
		//test
		if(StringUtils.isEmpty(uid)) {
			uid = "129707";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 帖子信息
		map.putAll(threadInfoJson("tid=" + tid, request));
		// 用户信息
		map.putAll(userJson("user_id=" + uid, request));
		// 标签列表
		map.putAll(tagJson("fid=" + fid, request));
		
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
		return new ModelAndView("new_thread", map);
	}

	@RequestMapping(value = { "/newThread" }, method = RequestMethod.POST)
	public void newThread(HttpServletRequest request, HttpServletResponse response, RedirectAttributes  redirectAtt)
			throws Exception {
		String strTid = request.getParameter("tid");
		String content = request.getParameter("content");
		String strTagId = request.getParameter("tagId");
		String subject = request.getParameter("subject");
		String strFid = request.getParameter("fid");
		
		long tid = 0;
		if(!StringUtils.isEmpty(strTid)) {
			tid = Long.valueOf(strTid);
		}
		int tagId = 0;
		if(!StringUtils.isEmpty(strTagId)){
			tagId = Integer.valueOf(strTagId);
		}
		
		if(!StringUtils.isEmpty(content)) {
			content =  new String(content.getBytes("ISO-8859-1"), "UTF-8");
		}
		if(!StringUtils.isEmpty(subject)) {
			subject =  new String(subject.getBytes("ISO-8859-1"), "UTF-8");
		}
		
		
		JSONObject obj = new JSONObject();
		
		//发新帖
		if(tid == 0) {
			JSONObject json = new JSONObject();
			json.put("fid", strFid);
			json.put("subject", subject);
			json.put("content", content);
			json.put("tag_id", tagId);
			JSONObject result = postHttpInfo(getFeedUrlInfo() + Constant.THREAD_CREATE_URL, json);
			int code;
			if(result != null && (code = result.optInt("code", -1)) == 0) {
				String message = result.optString("message", "");
				obj.put("code", code);
				obj.put("message", message);
			}else{
				obj.put("code", -1);
				obj.put("message", "保存失败");
			}
//			int code = result.optInt("code", -1);
//			//跳转到 板块内容页
//			if(code == 0){
//				result.put("code", 0);
//				redirectAtt.addAttribute("fid", strFid);
//				return new ModelAndView("redirect:/forum_content");
//			}
			
			
		//编辑
		}else if(tid > 0){
			long threadId = tid;
			JSONObject json = new JSONObject();
			json.put("tid", threadId);
			json.put("subject", subject);
			json.put("content", content);
			json.put("tag_id", tagId);
			JSONObject result = postHttpInfo(getFeedUrlInfo() + Constant.THREAD_EDIT_URL, json);
			int code;
			if(result != null && (code = result.optInt("code", -1)) == 0) {
				String message = result.optString("message", "");
				obj.put("code", code);
				obj.put("message", message);
			}else{
				obj.put("code", -1);
				obj.put("message", "保存失败");
			}
//			int code = result.optInt("code", -1);
//			//跳转到 帖子详情页
//			if(code == 0){
//				redirectAtt.addAttribute("thread_id", strTid);
//				return new ModelAndView("redirect:/thread_info");
//			}
//			
//			message = result.optString("message", "");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(obj.toString());
		//return null;
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
			e.printStackTrace();
		} finally {
			if(fileOut != null) {
				fileOut.close();
			}
		}		
	}
	
}