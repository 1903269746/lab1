package com.niuma.service;

import com.niuma.mapper.BrandMapper;
import com.niuma.pojo.Brand;
import com.niuma.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()

        SqlSession sqlSession =sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    //添加

    public void add(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        sqlSession.commit();

        sqlSession.close();
    }
    //根据id查询
    public Brand selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    //修改
    public void update(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        sqlSession.commit();

        sqlSession.close();
    }

    //删除
    public void deleteById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
