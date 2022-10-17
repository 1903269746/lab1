package day3.ClassTest.dao;

import day3.ClassTest.UserInfo.UserInfo;
import day3.ClassTest.UserInfo.UserOperation;

public interface UserDao {

        /**
         * 定义了一个方法插入用户
         * @param user
         */
        void insert(UserInfo user) ;
        void insertOp(UserOperation userOperation);

}
