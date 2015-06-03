package com.mofang.feedweb.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author daisyli
 * 版主申请页
 *
 */
@Controller
public class FeedApplyModeratorController extends FeedCommonController {

	@RequestMapping(value = "/apply_moderator", method = RequestMethod.GET)
	public ModelAndView checkApply(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("apply_moderator", model);
	}
}
