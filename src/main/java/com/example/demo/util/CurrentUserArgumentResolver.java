package com.example.demo.util;

import com.example.demo.Pojo.User;
import com.example.demo.annotation.CurrentUser;
import com.example.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    private static UsersMapper usersMapper;

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper){
        CurrentUserArgumentResolver.usersMapper=usersMapper;
    }
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token=webRequest.getHeader("token");
        String username=JwtTokenProvider.getUsernameFromToken(token);
        User user=usersMapper.getByUsername(username);
        return user;
    }
}
