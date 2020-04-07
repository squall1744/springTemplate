package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect
@Configuration
public class CacheAspect {
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }



    @Pointcut("execution(* com.example.demo.controller..*(Integer))")
    public void matchPack() {}

    @After("matchPack()")
    public void before() {
        System.out.println("beforebfoefoe");
    }

    @Around("@annotation(com.example.demo.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        String methodName = signature.getName();

        Object cachedValue = redisTemplate.opsForValue().get(methodName);

        if (cachedValue != null) {
            System.out.println("Get value from cache!");
            return cachedValue;
        } else {
            System.out.println("Get  value from database");
            Object realValue = joinPoint.proceed();
            redisTemplate.opsForValue().set(methodName, realValue);
            return realValue;
        }
    }
}
