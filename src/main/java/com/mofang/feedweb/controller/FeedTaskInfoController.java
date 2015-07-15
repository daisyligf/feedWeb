package com.mofang.feedweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedTaskService;

@Controller
public class FeedTaskInfoController extends FeedCommonController{
	@Autowired
	private FeedTaskService feedTaskService;
	
	@RequestMapping(value = "/task_info")
	public ModelAndView  taskInfo(HttpServletRequest request) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			//搜索关键词
			model.put("keyword", getSearchKey(request));
			Map <String, Object> taskmap = feedTaskService.getTaskState(request);
			model.putAll(taskmap);
			return new ModelAndView("task_info", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("FeedLevelInfoController.error throw an error.", e);
			return new ModelAndView("task_info", model);
		}
	}
}
