package com.mofang.feedweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.global.GlobalObject;

@Controller
public class FeedErrorController {
	@RequestMapping(value = "/error")
	public ModelAndView  error(HttpServletRequest request) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String message = "";
			if (null != request.getAttribute("message")) {
				message	= String.valueOf(request.getAttribute("message"));
			}
			
			model.put("message", message);
			return new ModelAndView("error", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("FeedErrorController.error throw an error.", e);
			return new ModelAndView("error", model);
		}
	}
}
