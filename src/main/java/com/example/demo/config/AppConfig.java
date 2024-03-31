package com.example.demo.config;

import com.example.demo.interceptor.JwtTokenInterceptor;
import com.example.demo.util.CurrentUserArgumentResolver;
import com.example.demo.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    JwtTokenInterceptor jwtTokenInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(jwtTokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(new CurrentUserArgumentResolver());
    }
}
