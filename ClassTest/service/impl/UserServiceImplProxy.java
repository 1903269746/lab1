package day3.ClassTest.service.impl;

import day3.ClassTest.MyUnit.ConnectManager;
import day3.ClassTest.UserInfo.UserInfo;
import day3.ClassTest.UserInfo.UserOperation;
import day3.ClassTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplProxy implements UserService {

    @Autowired
    private UserService UserService;

    @Autowired
    private ConnectManager connectManager;
    @Override
    public void addUser(UserInfo user, UserOperation userOperation) {

    }
}
