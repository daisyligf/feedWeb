package com.mofang.feedweb.util;

import redis.clients.jedis.Jedis;

import com.mofang.feedweb.component.RedisComponent;
import com.mofang.feedweb.global.RedisKey;
import com.mofang.feedweb.redis.RedisWorker;

public class RedisUtil {

	public static void set(final RedisComponent redisComp, final String keyPrefix, final String param) throws Exception {
		RedisWorker<Boolean> worker = new RedisWorker<Boolean>() {
			@Override
			public Boolean execute(Jedis jedis) throws Exception {
				String key = RedisKey.RAND_CODE_KEY_PREFIX.concat(keyPrefix);
				jedis.set(key, param);
				return true;
			}
		};
		redisComp.executeInMaster(worker);
	}
	
	public static String get(final RedisComponent redisComp, final String keyPrefix) throws Exception {
		RedisWorker<String> worker = new RedisWorker<String>() {
			@Override
			public String execute(Jedis jedis) throws Exception {
				String key = RedisKey.RAND_CODE_KEY_PREFIX.concat(keyPrefix);
				return jedis.get(key);
			}
		};
		return redisComp.executeInSlave(worker);
	}
	
}
