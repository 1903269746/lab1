package day3.ClassTest.service.impl;

import day3.ClassTest.UserInfo.UserInfo;
import day3.ClassTest.UserInfo.UserOperation;
import day3.ClassTest.dao.UserDao;
import day3.ClassTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(UserInfo user,UserOperation userOperation) {
        userDao.insert(user);
        userDao.insertOp(userOperation);
    }


}
