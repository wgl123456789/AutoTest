package cn.consur.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupClass3 {

    public void teacher1(){
        System.out.println("teach1运行1");
    }


    public void teacher2(){
        System.out.println("teach2运行1");
    }
}
