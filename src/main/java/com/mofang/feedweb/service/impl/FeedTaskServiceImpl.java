package com.mofang.feedweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mofang.feedweb.component.HttpComponent;
import com.mofang.feedweb.config.ExternalUrlInfo;
import com.mofang.feedweb.entity.TaskInfo;
import com.mofang.feedweb.global.Constant;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.service.FeedTaskService;

@Service("feedTaskService")
public class FeedTaskServiceImpl implements FeedTaskService{

	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	@Autowired
	private HttpComponent httpComp;
	@Override
	public Map<String, Object> getTaskState(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(1);
		try {
			
			JSONObject result = httpComp.getHttpInfo(externalUrlInfo.getTask_info_url()
					+ Constant.TASK_LIST_URL, "", request);
			TaskInfo taskinfo = new TaskInfo();
			if (result != null && 0 == result.optInt("code")) {
				JSONArray data = result.optJSONArray("data");
				JSONObject jsonObj = null;
				
				for (int i = 0; i < data.length(); i++ ) {
					jsonObj = data.getJSONObject(i);
					if (1001 == jsonObj.optInt("task_id") && true == jsonObj.optBoolean("is_completed")) {
						taskinfo.setRegistFlg(true);
					} else if (1002 == jsonObj.optInt("task_id") && true == jsonObj.optBoolean("is_completed")) {
						taskinfo.setFirstNewThreadFlg(true);
					} else if (1003 == jsonObj.optInt("task_id") && true == jsonObj.optBoolean("is_completed")) {
						taskinfo.setFirstRecommendFlg(true);
					}  else if (1004 == jsonObj.optInt("task_id") && true == jsonObj.optBoolean("is_completed")) {
						taskinfo.setFirstReplyFlg(true);
					} else if (1015 == jsonObj.optInt("task_id") && true == jsonObj.optBoolean("is_completed")) {
						taskinfo.setAvatarUploadFlg(true);
					}
				}
				
			}
			map.put("taskInfo", taskinfo);
			return map;
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at FeedTaskServiceImpl.getTaskState throw an error.", e);
			return map;
		}
	}

}
