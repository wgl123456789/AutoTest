package cn.consur.testng.multThread;

import org.testng.annotations.Test;

public class MultThreadTest {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id :%s%n",Thread.currentThread().getId());
    }
}
