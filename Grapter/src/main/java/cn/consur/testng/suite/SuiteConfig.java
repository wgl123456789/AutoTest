package cn.consur.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suite运行");

    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("after suite 运行");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("before test运行");
    }


    @AfterSuite
    public void aftertest(){
        System.out.println("after test运行");
    }

}
