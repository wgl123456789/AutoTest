package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这个是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value="/getcookie",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通过这个方法获得cookies",httpMethod = "GET")
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
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
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

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 1.第url：key=value&key=value
     * 获取模拟商品列表
     */
    @RequestMapping(value ="/getWithParam",method = RequestMethod.GET)
    @ApiOperation(value = "开发一个需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("衣服",200);

        return  myList;
    }


    /**
     * 开发一个需要携带参数才能访问的get请求
     * 2.第url：url:ip:port/get/with/param/10/20
     * 获取模拟商品列表
     */

    @RequestMapping(value = "/getWithParam2/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("衣服",200);
        return  myList;
    }




}
