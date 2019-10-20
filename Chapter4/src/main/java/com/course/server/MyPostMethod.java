package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "post请求")
public class MyPostMethod {

    //这个变量是用来装cookies信息
    private static Cookie cookie;

    //用户登录成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口", httpMethod = "post")
    public String login(HttpServletResponse httpServletResponse,
                        @RequestParam(value = "username", required = true) String username,
                        @RequestParam String password) {
        if (username.equals("test") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            httpServletResponse.addCookie(cookie);
            return "登录成功";
        }

        return "登录失败";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "登录成功获取用户列表", httpMethod = "post")
    private User getUserList(HttpServletRequest request,
                               @RequestBody User user) {
        User user1 = new User();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length!= 0){
        for (Cookie c : cookies) {
            if (c.getName().equals("login") & c.getValue().equals("true")) {
                user1.setName("汪共量");
                user.setAge("18");
                return user1;
            }
        }
        }
        user1.setName("登录失败啦");
        return user1;
    }

}
