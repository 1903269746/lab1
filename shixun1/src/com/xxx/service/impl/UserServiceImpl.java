//package com.xxx.service.impl;
//
//import com.xxx.dao.UserDao;
//import com.xxx.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//    //引入Dao层
//    @Autowired
//    UserDao userMapper;
//    @Override
//    public int getUserCount() {
//        return userMapper.select();
//    }
//}
package com.xxx.service.impl;

import com.xxx.dao.UserDao;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //引入dao层
    @Autowired
    UserDao userMapper ;

    @Override
    public int getUserCount() {
        return userMapper.select();

    }
}

