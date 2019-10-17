package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookieGetPost {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookie信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        //读取配置文件
        bundle = ResourceBundle.getBundle("application");
        //通过key读取url
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        //拼接url
        String testurl = this.url + bundle.getString("getCookie.uri");
        //测试逻辑代码
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookeis信息
        this.store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:" + name + "," + "value:" + value);
        }


    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {

        //拼接地址
        String testurl = this.url+bundle.getString("getCookie.post");
        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client =new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testurl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","test");
        param.put("age","18");
        //设置请求头信息
         post.setHeader("content-type","application/json");
         //将参数列表set到列表中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行相应结果的存取
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);

        //执行
        HttpResponse response = client.execute(post);
        //获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，就是判断返回结果是否一致
        //1.将返回的值变成json对象
        JSONObject resultjson = new JSONObject(result);
        //2.获取结果值
        String success = (String) resultjson.get("status");
        Assert.assertEquals("success",success);


    }






}
