package cn.wolfcode.test;

import cn.wolfcode.dao.UserDao;
import cn.wolfcode.entity.T_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    UserDao userMapper ;

    @Test
    public void TestSelectAll(){
        List<T_User> t_userList = userMapper.selectAll();
        for (T_User t_user:t_userList
             ) {
            System.out.println(t_user.toString());
        }
    }

    @Test
    public void test_delete(){
        userMapper.deleteByUcode("G100");
        List<T_User> t_userList = userMapper.selectAll();
        for (T_User t_user:t_userList
        ) {
            System.out.println(t_user.toString());
        }
    }
    @Test
    public void test_selectUserByCondition(){
        List<T_User> t_userList = userMapper.selectBySingle("刚");
        for (T_User t_user:t_userList
        ) {
            System.out.println(t_user.toString());
        }
    }


}
