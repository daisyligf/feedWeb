package com.mofang.feedweb.global;

public class RedisKey {

	/**
	 * cookie_user缓存信息
	 * 结构: String
	 * 示例：set cookie_{cookie} userInfo
	 */
	public static final String COOKIE_USER_KEY_PREFIX = "cookie_";

	/**
	 * 验证码缓存信息
	 * 结果：String
	 * 示例：set rand_code_{userId} randCode
	 */
	public static final String RAND_CODE_KEY_PREFIX = "rand_code_";
}
