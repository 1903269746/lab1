package com.xxx.test;

import com.xxx.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    UserDao userMapper;

    @Test
    public void test_select(){
        int cnt = userMapper.select();
        System.out.println(cnt);
    }

    @Test

}
