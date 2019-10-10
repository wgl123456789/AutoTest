package cn.consur.testng;

import org.testng.annotations.Test;

/*
例如登录测试存在依赖
 */
public class RelyTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
