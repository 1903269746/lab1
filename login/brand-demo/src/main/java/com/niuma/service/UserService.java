package com.niuma.service;

import com.niuma.mapper.UserMapper;
import com.niuma.pojo.User;
import com.niuma.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /*
    登录
     */
    public User login(String username , String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);
        sqlSession.close();
        return  user;
    }



    /*
    注册
     */
    public boolean register(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.selectByUsername(user.getUsername());
        if(u == null){
            userMapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }

    /**
     * 判断用户名是否已被注册ajax
     */
    public boolean selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.selectByUsername(username);
        return u == null;
    }
}
