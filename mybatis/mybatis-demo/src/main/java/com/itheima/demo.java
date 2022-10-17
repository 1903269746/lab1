package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class demo {
    public static void main(String[] args) throws Exception {

        //1.加载mybatis核心文件，官网上找
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象，执行sql
        SqlSession sqlSession= sqlSessionFactory.openSession();

        //3.执行sql
        List<User> users= sqlSession.selectList("test.selectAll");
        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }
}
