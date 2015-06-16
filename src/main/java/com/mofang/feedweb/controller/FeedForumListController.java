package com.mofang.feedweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mofang.feedweb.entity.ForumListInfo;
import com.mofang.feedweb.form.FeedForumListForm;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.util.StringUtil;
import com.mofang.feedweb.util.Tools;
@Controller
public class FeedForumListController extends FeedCommonController {
	
	
	//版块列表
	@RequestMapping(value = "/forumList")
	public ModelAndView forumList(HttpServletRequest request) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			int letterGroup = 1;
			if (!StringUtil.isNullOrEmpty(request.getParameter("letterGroup"))) {
				letterGroup = Integer.valueOf(request.getParameter("letterGroup"));
			}
			
			int currentPage = 1;
			if (!StringUtil.isNullOrEmpty(request.getParameter("currentPage"))) {
				currentPage = Integer.valueOf(
						Tools.replaceBlank(request.getParameter("currentPage")));
			}
			int forumType = 1;//热门游戏  ：1  新游推荐 ：2
			if (!StringUtil.isNullOrEmpty(request.getParameter("forumType"))) {
				forumType = Integer.valueOf(
						Tools.replaceBlank(request.getParameter("forumType")));
			}
			
			//获取版块list
			String getLetterGroup = "";
			if (letterGroup == 1) {
				getLetterGroup = Constant.STR_ABCDE;
			} else if (letterGroup == 2) {
				getLetterGroup = Constant.STR_FGHIJ;
			} else if (letterGroup == 3) {
				getLetterGroup = Constant.STR_KLMNO;
			} else if (letterGroup == 4) {
				getLetterGroup = Constant.STR_PQRST;
			} else if (letterGroup == 5) {
				getLetterGroup = Constant.STR_WXYZ;
			} else if (letterGroup == 6) {
				getLetterGroup = Constant.STR_OTHER;
			}
			
			FeedForumListForm form = getForumList(request, currentPage, forumType, getLetterGroup);
			int total = form.getTotal();
			
			
			model.put("listInfo", form.getInfoList());
			model.put("letterGroup", letterGroup);
			model.put("searchkey", "");
			model.put("currentPage", currentPage);
			model.put("totalPages", Tools.editTotalPageNumber(total));
			model.put("pagelist", Tools.editPageNumber(total, currentPage,Constant.PAGE_SIZE));
			model.put("forumType", forumType);
			model.put("keyword", getSearchKey(request));
			
			return new ModelAndView("forumList", model);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumListController.forumList throw an error.", e);
			return new ModelAndView("forumList", model);
		}

	}
	
	private FeedForumListForm getForumList(HttpServletRequest request, int p, int type, String letterGroup)
			throws JSONException {
		
		FeedForumListForm form = new FeedForumListForm();
		try {
			StringBuffer name = new StringBuffer();
			StringBuffer content = new StringBuffer();
			name.append("page");
			name.append(Constant.STR_COMMA);
			name.append("type");
			name.append(Constant.STR_COMMA);
			name.append("pagesize");
			name.append(Constant.STR_COMMA);
			name.append("letterGroup");
			content.append(p);
			content.append(Constant.STR_COMMA);
			content.append(type);
			content.append(Constant.STR_COMMA);
			content.append(Constant.PAGE_SIZE);
			content.append(Constant.STR_COMMA);
			content.append(letterGroup);
			
			String parameterURL = Tools.editURLParameter(name.toString(),content.toString());
			JSONObject result = getHttpInfo(getFeedUrlInfo().concat(Constant.LIST_FORUM_GET_URL),
					parameterURL, request);
			List<ForumListInfo> listInfo = new ArrayList<ForumListInfo>();
			int total = 0;
			if (null != result) {
				int code = result.optInt("code", -1);
				if (0 != code) {
				} else {
					
					JSONObject data = result.optJSONObject("data");
					total = data.optInt("total", 0);
					JSONArray list = data.optJSONArray("list");
					JSONObject json = null;
					ForumListInfo info = null;
					for(int i=0; i<list.length(); i++)
					{
						info = new ForumListInfo();
						json = list.getJSONObject(i);
						info.setForumId(json.optLong("fid", 0));
						info.setGameId(json.optLong("game_id", 0));
						if (json.optString("name", "").length() > 10) {
							info.setForumName(json.optString("name", "").substring(0, 10));
						} else {
							info.setForumName(json.optString("name", ""));
						}
						
						info.setIcon(json.optString("icon", ""));
						info.setTodayThreads(json.optInt("today_threads", 0));
						info.setTotalThreads(json.optInt("total_threads", 0));
						if ("null".equals(json.optString("prefecture_url", ""))) {
							info.setPrefectureUrl("");
						} else {
							info.setPrefectureUrl(json.optString("prefecture_url", ""));
						}
						
						info.setGiftUrl(json.optString("gift_url", ""));
						info.setDownLoadUrl(json.optString("download_url", ""));
						listInfo.add(info);
					}
				}	
				
			}
			form.setInfoList(listInfo);
			form.setTotal(total);
			
			return form;
		} catch (JSONException e) {
			GlobalObject.ERROR_LOG.error(
					"at FeedForumListController.getForumList throw an error.", e);
			return form;
		}
	}
}
