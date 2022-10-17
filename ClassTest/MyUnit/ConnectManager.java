package day3.ClassTest.MyUnit;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

/*事务管理器*/
@Repository
public class ConnectManager {
    @Autowired
    private BasicDataSource basicDataSource;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

        /*获取连接，保证获取到的是同一个连接*/
        public Connection connection(){
            Connection conn = threadLocal.get();
            if (conn!=null){
                return conn;
            }
            try {
                conn=basicDataSource.getConnection();
                threadLocal.set(conn);
                return conn;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        /*开启事务 AutoCommit*/

        /*提交 commit*/

        /*回滚 rollback*/

        /*在dao层将连接替换为管理器获取到的连接，在service层增加开启事务、提交和回滚操作*/
}
