package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcDemo3_userLogin {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/db1?useSLL=false";
        String username="root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,username,password);

        //3.定义sql
        Scanner in = new Scanner(System.in);
        System.out.print("输入账号：");
        String id=in.next();
        System.out.print("输入密码：");
        String passwd=in.next();
        String sql="select * from users where id='"+id+"' and passwd ='"+passwd+"'";

        //4.获取执行sql的对象Statement
        Statement stmt= conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //6.处理结果
        if(rs.next()){
            System.out.println("登陆成功！！！");
        }
        else {
            System.out.println("登录失败！！！");
        }
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
