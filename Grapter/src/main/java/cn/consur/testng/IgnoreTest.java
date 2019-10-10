package cn.consur.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("执行11");
    }

    //默认true，执行
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("执行22");
    }

}
