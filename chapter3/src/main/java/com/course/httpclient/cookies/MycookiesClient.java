package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class MycookiesClient {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookie信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        //读取配置文件
       bundle= ResourceBundle.getBundle("application");
       //通过key读取url
       url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        //拼接url
        String testurl = this.url+bundle.getString("getCookie.uri");
        //测试逻辑代码
        HttpGet get  = new HttpGet(testurl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result= EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookeis信息
        this.store =client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie:cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:"+name +","+"value:"+value);
        }






    }

}
