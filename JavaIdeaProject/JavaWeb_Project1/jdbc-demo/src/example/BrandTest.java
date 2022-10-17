package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.ha.selector.DataSourceSelectorFactory;

import org.junit.Test;
import pojo.brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
   @Test
    public void testSelectAll() throws Exception {
       /*
       获取连接
        */
       Properties prop=new Properties();
       //加载配置文件
       prop.load(new FileInputStream("./src/druid.properties"));
       DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
       Connection conn= dataSource.getConnection();
       //定义sql
       String sql = "select * from tb_brand";

       //获取PreparedStatement
       PreparedStatement pstmt= conn.prepareStatement(sql);

       //设置参数

       //执行sql

       ResultSet rs = pstmt.executeQuery();

       //处理结果List<Brand>
       List<brand> brandList = new ArrayList<>();
       while(rs.next()){
           int id = rs.getInt("id");
           String branName = rs.getString("brand_name");
           String companyName = rs.getString("company_name");
           int ordered = rs.getInt("ordered");
           String description = rs.getString("description");
           int status = rs.getInt("statu");
           //封装brand对象
           brand brand= new brand(id,branName,companyName,ordered,description,status);
           brandList.add(brand);
       }
       System.out.println(brandList);
       //释放资源
       rs.close();
       pstmt.close();
       conn.close();
   }


   /*
   添加*******************************************
    */
   @Test
    public void testAdd() throws Exception {
       //获取页面参数
       String brandName="香飘飘";
       String companyName="香飘飘";
       int ordered=10;
       String description="香麻了！！！";
       int status=1;

       //获取连接
       String sql ="insert into tb_brand(brand_name,company_name,ordered,description,statu) values(?,?,?,?,?)";
       Properties prop =new Properties();
       prop.load(new FileInputStream("./src/druid.properties"));
       DataSource dataSource=DruidDataSourceFactory.createDataSource(prop);
       Connection conn=dataSource.getConnection();
       PreparedStatement pstmt= conn.prepareStatement(sql);
       //设置sql值
       pstmt.setString(1,brandName);
       pstmt.setString(2,companyName);
       pstmt.setInt(3,ordered);
       pstmt.setString(4,description);
       pstmt.setInt(5,status);

       //执行sql
       int count=pstmt.executeUpdate();
       if(count!=0){
           System.out.println("添加成功！！！！");
       }
       //释放资源
       pstmt.close();
       conn.close();
   }
}
