package com.mofang.feedweb.component;

import javax.annotation.PostConstruct;

import mofang.feedweb.redis.pool.RedisPoolConfig;
import mofang.feedweb.redis.pool.RedisPoolProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.mofang.feedweb.config.RedisMasterConfig;
import com.mofang.feedweb.config.RedisSlaveConfig;
import com.mofang.feedweb.redis.RedisExecutor;
import com.mofang.feedweb.redis.RedisWorker;

@Component
public class RedisComponent {

	private final RedisExecutor REDIS_MASTER_EXECUTOR = new RedisExecutor();
	private final RedisExecutor REDIS_SLAVE_EXECUTOR = new RedisExecutor();
	@Autowired
	private RedisMasterConfig redisMasterConfig;
	@Autowired
	private RedisSlaveConfig redisSlaveConfig;
	
	@PostConstruct
	public void init() throws Exception{
		initRedisMaster(redisMasterConfig);
		initRedisSlave(redisSlaveConfig);
	}

	public void initRedisMaster(RedisMasterConfig redisMasterConfig) throws Exception {
		RedisPoolConfig config = getRedisConfig(redisMasterConfig);
		JedisPool pool = RedisPoolProvider.getRedisPool(config);
		REDIS_MASTER_EXECUTOR.setJedisPool(pool);
	}

	public void initRedisSlave(RedisSlaveConfig redisSlaveConfig) throws Exception {
		RedisPoolConfig config = getRedisConfig(redisSlaveConfig);
		JedisPool pool = RedisPoolProvider.getRedisPool(config);
		REDIS_SLAVE_EXECUTOR.setJedisPool(pool);
	}

	private RedisPoolConfig getRedisConfig(RedisMasterConfig config)
			throws Exception {
		try {
			String host = config.getHost();
			int port = Integer.valueOf(config.getPort());
			int timeout = Integer.valueOf(config.getTimeout());
			int maxActive = Integer.valueOf(config.getMaxActive());
			int maxIdle = Integer.valueOf(config.getMaxIdle());
			boolean testOnBorrow = Boolean.valueOf(config.getTestOnBorrow());

			RedisPoolConfig redisPoolConfig = new RedisPoolConfig();
			JedisPoolConfig poolConf = new JedisPoolConfig();
			poolConf.setMaxActive(maxActive);
			poolConf.setMaxIdle(maxIdle);
			poolConf.setTestOnBorrow(testOnBorrow);
			redisPoolConfig.setConfig(poolConf);
			redisPoolConfig.setHost(host);
			redisPoolConfig.setPort(port);
			redisPoolConfig.setTimeout(timeout);
			return redisPoolConfig;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private RedisPoolConfig getRedisConfig(RedisSlaveConfig config)
			throws Exception {
		try {
			String host = config.getHost();
			int port = Integer.valueOf(config.getPort());
			int timeout = Integer.valueOf(config.getTimeout());
			int maxActive = Integer.valueOf(config.getMaxActive());
			int maxIdle = Integer.valueOf(config.getMaxIdle());
			boolean testOnBorrow = Boolean.valueOf(config.getTestOnBorrow());

			RedisPoolConfig redisPoolConfig = new RedisPoolConfig();
			JedisPoolConfig poolConf = new JedisPoolConfig();
			poolConf.setMaxActive(maxActive);
			poolConf.setMaxIdle(maxIdle);
			poolConf.setTestOnBorrow(testOnBorrow);
			redisPoolConfig.setConfig(poolConf);
			redisPoolConfig.setHost(host);
			redisPoolConfig.setPort(port);
			redisPoolConfig.setTimeout(timeout);
			return redisPoolConfig;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public <T> T executeInMaster(RedisWorker<T> worker) throws Exception {
		return REDIS_MASTER_EXECUTOR.execute(worker);
	}
	
	public <T> T executeInSlave(RedisWorker<T> worker) throws Exception {
		return REDIS_SLAVE_EXECUTOR.execute(worker);
	}
	
	
}
