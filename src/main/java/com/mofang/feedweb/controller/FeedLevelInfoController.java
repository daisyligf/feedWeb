package com.mofang.feedweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.global.GlobalObject;

@Controller
public class FeedLevelInfoController {
	
	@RequestMapping(value = "/level_info")
	public ModelAndView  levelInfo(HttpServletRequest request) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			return new ModelAndView("level_info", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("FeedLevelInfoController.levelInfo throw an error.", e);
			return new ModelAndView("level_info", model);
		}
	}
}
