package cn.consur.testng;

import org.testng.annotations.*;

public class testng1 {

    @BeforeMethod
    public void beforecase(){
        System.out.println("11");
    }

    @Test
    public void testngcase(){
        System.out.println("测试用例1");
    }

    @Test
    public void testcase2(){
        System.out.println("测试用例2");
    }

    @AfterMethod
    public void aftercase(){
        System.out.println(222);
    }

    @BeforeClass
    public void beferClass(){
        System.out.println("这是类运行之前");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是类运行之后");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }
}

