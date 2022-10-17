package jdbc;


import java.sql.*;
import java.util.Scanner;

public class jdbcDemo4_PreparedStatement {
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
        String sql="select * from users where id=? and passwd=?";

        //4.获取执行sql的对象Statement
        PreparedStatement pstmt= conn.prepareStatement(sql);
        pstmt.setString(1,id);
        pstmt.setString(2,passwd);
        //5.执行sql
        ResultSet rs=pstmt.executeQuery();
        //6.处理结果
        if(rs.next()){
            System.out.println("登陆成功！！！");
        }
        else {
            System.out.println("登录失败！！！");
        }
        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}
