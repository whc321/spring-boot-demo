package com.demo.common.config;

import com.demo.common.base.dao.BaseRedisDao;
import com.demo.common.utils.RedisExtendsUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.Method;

/**
 * Created by wang_haichun on 2016/11/15.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public KeyGenerator wiselyKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };

    }

    @Bean
    public CacheManager cacheManager(
            @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }
    /**
     *  初始化redisTemplate
     *  @param factory factory
     *  @return StringRedisTemplate
     */
    @Bean
    public StringRedisTemplate redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
    /**
     *  初始化BaseRedisDao
     *  @param redisTemplate redisTemplate
     *  @return BaseRedisDao
     */
    @Bean
    public BaseRedisDao baseRedisDao(RedisTemplate<String, String> redisTemplate){
        BaseRedisDao redisDao = new BaseRedisDao();
        redisDao.setRedisTemplate(redisTemplate);
        return redisDao;
    }
    /**
     *  初始化RedisExtendsUtils
     *  @param redisTemplate redisTemplate
     *  @return BaseRedisDao
     */
    @Bean
    public RedisExtendsUtils redisExtendsUtils(RedisTemplate<String, String> redisTemplate){
        RedisExtendsUtils redisExtendsUtils = new RedisExtendsUtils();
        redisExtendsUtils.setRedisTemplate(redisTemplate);
        return redisExtendsUtils;
    }
}
