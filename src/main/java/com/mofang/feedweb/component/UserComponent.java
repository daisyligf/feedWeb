package com.mofang.feedweb.component;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

import com.mofang.feedweb.config.ExternalUrlInfo;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.global.RedisKey;
import com.mofang.feedweb.redis.RedisWorker;
import com.mofang.feedweb.util.StringUtil;

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
	@Autowired
	private RedisComponent redisComp;

	public UserInfo getUserInfo(HttpServletRequest request) throws Exception {
		String mcs = this.getCookie(request);
		if (StringUtil.isNullOrEmpty(mcs)) {
			return null;
		}
		UserInfo userInfo = this.get(mcs);
		if (userInfo == null) {
			String strResult = httpComp.get(externalUrlInfo
					.getUser_loginstatus_url() + "?user=" + mcs);
			JSONObject json = new JSONObject(strResult);
			int code = json.optInt("code", -1);
			if (code != 0) {
				return null;
			}
			JSONObject data = json.optJSONObject("data");
			String userName = data.optString("nickname", "");
			long userId = data.optLong("uid", 0l);
			String avatar = data.optString("avatar", "");
			int status = data.optInt("status", -1);

			GlobalObject.INFO_LOG.info("at UserComponent.getUserInfo. mcs: " + mcs + ", userId: " + userId);
			if (status != 0) {
				return null;
			}

			userInfo = new UserInfo();
			userInfo.setUserId(userId);
			userInfo.setAvatar(avatar);
			userInfo.setNickname(userName);

			JSONObject userJson = new JSONObject();
			userJson.put("uid", userId);
			userJson.put("avatar", avatar);
			userJson.put("nickname", userName);

			// redis缓存
			save(mcs, userJson.toString());
			
			
		} 
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

	private boolean save(final String cookie, final String userInfo)
			throws Exception {
		RedisWorker<Boolean> worker = new RedisWorker<Boolean>() {
			@Override
			public Boolean execute(Jedis jedis) throws Exception {
				String key = RedisKey.COOKIE_USER_KEY_PREFIX.concat(cookie);
				jedis.setex(key, 30 * 60, userInfo);
				return true;
			}
		};
		return redisComp.executeInMaster(worker);
	}

	public UserInfo get(final String cookie) throws Exception {
		RedisWorker<UserInfo> worker = new RedisWorker<UserInfo>() {
			@Override
			public UserInfo execute(Jedis jedis) throws Exception {
				String key = RedisKey.COOKIE_USER_KEY_PREFIX.concat(cookie);
				String result = jedis.get(key);
				if (StringUtil.isNullOrEmpty(result)) {
					return null;
				}
				JSONObject json = new JSONObject(result);
				UserInfo userInfo = new UserInfo();
				userInfo.setAvatar(json.optString("avatar", ""));
				userInfo.setNickname(json.optString("nickname", ""));
				userInfo.setUserId(json.optLong("uid", 0l));
				return userInfo;
			}
		};
		return redisComp.executeInSlave(worker);
	}

	/***
	 * 验证用户登录状态
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public boolean validate(HttpServletRequest request) throws Exception {
		UserInfo userInfo = getUserInfo(request);
		if (userInfo == null) {
			return false;
		}
		return true;
	}

}
