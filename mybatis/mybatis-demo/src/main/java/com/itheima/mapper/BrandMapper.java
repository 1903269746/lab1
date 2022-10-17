package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//===========================================================================================
public interface BrandMapper {
    /*
    **查询所有
     */
    List<Brand> selectAll();

//=============================================================================================
    /*
      根据id查看详情
     */
    Brand selectById(int id);

    //==========================================================================================
    /*
    条件查询
        *参数传递
            1.散装参数：方法中有多个参数，需要用@Param
            2.对象参数
            3.map参数
     */
    //List<Brand> selectByCondition(@Param("status") int status ,@Param("companyName") String CompanyName ,@Param("brandName") String brandName);

        //List<Brand> selectByCondition(Brand brand);

        List<Brand> selectByCondition(Map map);

        //单条件动态查询
        List<Brand> selectByConditionSingle(Brand brand);

        //添加
        void add(Brand brand);

        //更新
        int update(Brand brand);

        //删除
        int deleteById(int id);

        //批量删除
        void deleteByIds( @Param("ids") int[] ids);

}
