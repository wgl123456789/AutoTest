package cn.consur.testng.multThread;

import org.testng.annotations.Test;

public class MultThreadOnXml {

    @Test
    public void tesst1(){
        System.out.printf("Thread Id :%s%n",Thread.currentThread().getId());
    }

    @Test
    public void tesst2(){
        System.out.printf("Thread Id :%s%n",Thread.currentThread().getId());
    }

    @Test
    public void tesst3(){
        System.out.printf("Thread Id :%s%n",Thread.currentThread().getId());
    }

}
