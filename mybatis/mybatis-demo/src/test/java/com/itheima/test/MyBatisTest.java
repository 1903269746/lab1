package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws Exception {
        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception {
        int id =1;
        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByCondition() throws Exception {
        //接受参数
        int status =1;
        String companyName= "华为";
        String brandName = "华为";

        //处理参数
        companyName= '%'+companyName+'%';
        brandName = '%'+brandName+'%';

        /*
        //封装对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

         */

        Map map=new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void selectByConditionSingle() throws Exception {
        //接受参数
        int status =1;
        String companyName= "华为";
        String brandName = "华为";


        //处理参数
        companyName= '%'+companyName+'%';
        brandName = '%'+brandName+'%';


        //封装对象
        Brand brand=new Brand();
        brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);

       /*
        Map map=new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        */
        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

       //4.执行
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }


    /*
    添加
     */
    @Test
    public void testAdd() throws Exception {
        //接受参数
        int status =1;
        String companyName= "7波导";
        String brandName = "波导手机";
        String description="777";
        int ordered=100;


        //封装对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行
        brandMapper.add(brand);

        //提交事务
        //sqlSession.commit();
       List<Brand> brands=brandMapper.selectAll();

        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }


    /*
    更新
     */
    @Test
    public void  testUpdate() throws Exception {
        //接受参数
        int id = 4;
        int status =1;
       // String companyName= "波导";
        String brandName = "波导手机";
        String description="垃圾手机，手机中的战斗机";
        int ordered=200;


        //封装对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行
       int count = brandMapper.update(brand);

        //提交事务
        //sqlSession.commit();
        if(count > 0){
            System.out.println("更新成功！！！！");
        }

        //5.释放资源
        sqlSession.close();
    }

    //删除
    @Test
    public void  testDelete() throws Exception {
        //接受参数
        int id = 6;

        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行
        int count = brandMapper.deleteById(id);

        //提交事务
        //sqlSession.commit();
        if(count > 0){
            System.out.println("更新成功！！！！");
        }

        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void  testDeleteByids() throws Exception {
        //接受参数
        int ids[]={5,7,8};

        //1.获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行
          brandMapper.deleteByIds(ids);


        //5.释放资源
        sqlSession.close();
    }
}
