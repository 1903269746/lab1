package day3.ClassTest.dao.Impl;

import day3.ClassTest.MyUnit.ConnectManager;
import day3.ClassTest.UserInfo.UserInfo;
import day3.ClassTest.UserInfo.UserOperation;
import day3.ClassTest.dao.UserDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    /*@Autowired
    private BasicDataSource basicDataSource;
    public void setBasicDataSource(BasicDataSource basicDataSource){this.basicDataSource=basicDataSource;}*/

    @Autowired
    private ConnectManager connectManager;

    @Override
    public void insert(UserInfo user) {
        try {
            Connection connection = connectManager.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user values (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3,user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertOp(UserOperation userOperation) {
        try {
            Connection connection = connectManager.connection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into operation values (?,?)");
            preparedStatement.setString(1, userOperation.getName());
            preparedStatement.setString(2, userOperation.getOperation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
