package com.example.demo.aop;

import com.example.demo.Pojo.User;
import com.example.demo.annotation.Authority;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {
    @Around("@annotation(authority)")
    public Object checkAuth(ProceedingJoinPoint joinPoint, Authority authority) throws Throwable {
        Object[] args = joinPoint.getArgs();
        User user= (User) args[0];
        int auth=user.getAuth();
        if(auth!=0) return joinPoint.proceed();
        else throw new RuntimeException("have no authority");
    }
}
