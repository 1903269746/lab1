package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class mapper_demo2 {
    public static void main(String[] args) throws Exception {
        //mapper代理开发
        //1.加载mybatis核心文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession
        SqlSession sqlSession= sqlSessionFactory.openSession();

        //3.执行sql
        //3.1获取UserMapper
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> users=userMapper.selectAll();
        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }
}
