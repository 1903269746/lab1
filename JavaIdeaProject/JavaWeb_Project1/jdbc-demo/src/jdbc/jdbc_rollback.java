package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_rollback {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
       // Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/db1?useSLL=false";
        String username="root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt= conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);
            //3.定义sql
            String sql1="update stu set gender='男' where id = 1";
            String sql2="insert into stu(id,name,gender) values(3,'王五','男')";
            //4.获取执行sql的对象Statement
            stmt = conn.createStatement();

            //5.执行sql
            int count1 = stmt.executeUpdate(sql1);

            //制造错误
            //int i=3/0;
            int count2 = stmt.executeUpdate(sql2);
            //6.处理结果
            System.out.println(count1);
            System.out.println(count2);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        } finally {
        }

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
