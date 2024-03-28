package com.example.demo.interceptor;

import com.example.demo.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        if(jwtTokenProvider.validateToken(token)) {
            String username=jwtTokenProvider.getUsernameFromToken(token);
            request.setAttribute("username", username);
            return true;
        }
        else throw new RuntimeException("token error");
    }
}
