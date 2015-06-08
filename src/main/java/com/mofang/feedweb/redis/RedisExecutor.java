package com.mofang.feedweb.redis;


import redis.clients.jedis.JedisPool;


public class RedisExecutor {

	private JedisPool pool;
	
	public void setJedisPool(JedisPool pool)
	{
		this.pool = pool;
	}
	
	public <T> T execute(RedisWorker<T> worker) throws Exception
	{
		return RedisHelper.execute(pool, worker);
	}

	
}
