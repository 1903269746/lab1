package com.niuma.mapper;

import com.niuma.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;
//DAO代码
public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //添加
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //查询
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    //修改
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id =#{id}")
    void update(Brand brand);

    //删除
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);
}
