package com.mofang.feedweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedSearchService;
import com.mofang.feedweb.util.StringUtil;

@Controller
public class FeedSearchController extends FeedCommonController {

	@Autowired
	private FeedSearchService feedSearchService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "keyword") String keyword,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(1);
		try {
			if (null != keyword && !"".equals(keyword)) {
				map.put("keyword", keyword);
			} else {
				map.put("keyword", getSearchKey(request));
			}
			return new ModelAndView("search", map);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedSearchController.search throw an error.", e);
			return new ModelAndView("search", map);
		}
	}

	@RequestMapping(value = "/searchThread", method = RequestMethod.GET)
	public void searchThread(@RequestParam(value = "keyword") String keyword,
			@RequestParam(value = "fid", required = false) String strFid,
			@RequestParam(value = "p", required = false) int p,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (StringUtil.isNullOrEmpty(keyword)) {
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
		try {
			String status = "1";
			String author = "";
			long fid = 0;
			if (!StringUtil.isNullOrEmpty(strFid)) {
				fid = Long.valueOf(strFid);
			}
			StringBuilder requestParam = new StringBuilder();
			requestParam.append("fid=").append(fid).append("&");
			requestParam.append("author=").append(author).append("&");
			requestParam.append("status=").append(status).append("&");
			requestParam.append("keyword=").append(keyword).append("&");
			requestParam.append("page=").append(p).append("&size=20");
			JSONObject result = feedSearchService.searchThread(
					requestParam.toString(), request);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);

		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedSearchController.searchThread throw an error.", e);
		}
	}

	@RequestMapping(value = "/searchForum", method = RequestMethod.GET)
	public void searchForum(@RequestParam(value = "keyword") String keyword,
			@RequestParam(value = "p", required = false) int p,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (StringUtil.isNullOrEmpty(keyword)) {
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
		try {
			StringBuilder requestParam = new StringBuilder();
			requestParam.append("page=").append(p).append("&");
			requestParam.append("size=8&");
			requestParam.append("keyword=").append(keyword);
			JSONObject json = feedSearchService.searchForum(
					requestParam.toString(), request);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedSearchController.searchForum throw an error.", e);
		}
	}

}
