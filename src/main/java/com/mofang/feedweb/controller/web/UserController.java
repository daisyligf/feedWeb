package com.mofang.feedweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends FeedCommonController {

	@RequestMapping("/loginStatus")
	public void loginStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		json.put("code", 0);
		response.getWriter().print(json.toString());
	}
}
