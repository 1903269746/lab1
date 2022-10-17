package day3.ClassTest;

import day3.ClassTest.UserInfo.UserInfo;
import day3.ClassTest.UserInfo.UserOperation;
import day3.ClassTest.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class Test {

   /* @org.junit.jupiter.api.Test
    public void test(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = ac.getBean("UserService", UserService.class);
        UserInfo userInfo = new UserInfo();
        UserOperation userOperation = new UserOperation();
        userInfo.setName("user2");
        userInfo.setPassword("123456");
        userInfo.setAge(23);

        us.addUser(userInfo,userOperation);

    }*/


}
