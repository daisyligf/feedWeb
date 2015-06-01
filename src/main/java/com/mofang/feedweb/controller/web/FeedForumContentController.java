package com.mofang.feedweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author daisyli
 * 版块内容页（即帖子列表页）
 *
 */
@Controller
public class FeedForumContentController {
	
	@RequestMapping(value = "/forum_content", method = RequestMethod.GET)
	public ModelAndView forumContent() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("forum_content", model);
	}
	
}

