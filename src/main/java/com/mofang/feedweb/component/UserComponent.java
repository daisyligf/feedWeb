package com.mofang.feedweb.component;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.properties.annotation.ExternalUrlInfo;

/***
 * 蛋碎的登录
 * 
 * @author linjx
 */
@Component
public class UserComponent {
	@Autowired
	private HttpComponent httpComp;
	@Autowired
	private ExternalUrlInfo externalUrlInfo;
	// 缓存cookie信息
	private final ThreadLocal<String> cookieCache = new ThreadLocal<String>();
	// 缓存用户信息
	private final ThreadLocal<UserInfo> userCache = new ThreadLocal<UserInfo>();

	public UserInfo getUserInfo(HttpServletRequest request) throws Exception {
		boolean loginStatus = this.validate(request);
		//如果是未登录状态 或者 缓存为空重新获取用户信息
		if(!loginStatus || userCache.get() == null) {
			String mcs = this.getCookie(request);
			String strResult = httpComp.get(externalUrlInfo
					.getUser_loginstatus_url() + "?user=" + mcs);
			JSONObject json = new JSONObject(strResult);
			int code = json.optInt("code", -1);
			if (code != 0) {
				return null;
			}
			JSONObject data = json.optJSONObject("data");
			String userName = data.optString("username", "");
			long userId = data.optLong("uid", 0l);
			String avatar = data.optString("avatar", "");
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(userId);
			userInfo.setAvatar(avatar);
			userInfo.setNickname(userName);
			userCache.set(userInfo);
		}
		UserInfo userInfo = userCache.get();
		return userInfo;
	}

	@SuppressWarnings("deprecation")
	private String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();// 从request中获得cookie对象的集合
		String user = "";
		if (cookies != null) {
			for (int idx = 0; idx < cookies.length; idx++) {
				if (cookies[idx].getName().equals("mf_scis")) {
					user = URLDecoder.decode(cookies[idx].getValue());
				}
			}
		}
		return user;
	}

	/***
	 * 验证用户登录状态
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public boolean validate(HttpServletRequest request) throws Exception {
		String mcs = cookieCache.get();
		String newMcs = this.getCookie(request);
		// 如果不为空，当前cookie值与缓存的cookie值是否一致，如一致，用户处于登录状态
		if (!StringUtils.isEmpty(mcs) && mcs.equals(newMcs)) {
			return true;
		}
		// 不一致，重新获取登录状态
		String strResult = httpComp.getUser(externalUrlInfo
				.getUser_loginstatus_url() + "?user=" + newMcs);
		JSONObject json = new JSONObject(strResult);
		int code = json.optInt("code", -1);
		if (code != 0) {
			return false;
		}
		cookieCache.set(newMcs);
		return true;
	}

}
