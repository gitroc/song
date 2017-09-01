package com.example.song.config;

import com.example.song.aop.SongAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    private Logger logger = LoggerFactory.getLogger(SongAspect.class);
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    /**
     * 自定义生成key的规则
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        /**
         * java 8 lambda 表达式， roc 试用，不足之处请见谅
         */
        return (Object o, Method method, Object... objects) -> {
            //格式化缓存key字符串
            StringBuilder sb = new StringBuilder();
            //追加类名
            sb.append(o.getClass().getName());
            //追加方法名
            sb.append(method.getName());
            //遍历参数并且追加
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            logger.info("调用Redis缓存Key : " + sb.toString());
            return sb.toString();
        };
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        // Defaults
        redisConnectionFactory.setHostName(host);
        redisConnectionFactory.setPort(port);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)
        return cacheManager;
    }
}
