package cn.consur.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut=3000)//单位为毫秒值
    public void testSuccess() throws InterruptedException {
        Thread.sleep(4000);
    }
}
