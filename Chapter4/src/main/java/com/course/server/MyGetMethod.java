package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class MyGetMethod {

    @RequestMapping(value="/getcookie",method = RequestMethod.GET)
    @ResponseBody
    public String getCookies(HttpServletResponse response){
        //httpservertRequest
        //httpservertResponse
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你活动cookies成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */

    @RequestMapping(value="/getWithCookie",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
           Cookie[] cookies = request.getCookies();
           if (Objects.nonNull(cookies)){
               for (Cookie cookie:cookies){
                   if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                       return "cookie携带成功";
                   }
               }
           }

          return "你必须携带cookis信息";
    }

}
