package com.mofang.feedweb.redis;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author zhaodx
 *
 */
public interface RedisWorker<T>
{
	public T execute(Jedis jedis) throws Exception;
}