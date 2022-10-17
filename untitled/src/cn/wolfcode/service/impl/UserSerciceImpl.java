package cn.wolfcode.service.impl;

import cn.wolfcode.dao.UserDao;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerciceImpl implements UserService {

    //引入dao层
    @Autowired
    UserDao userMapper ;

    @Override
    public int getUserCount() {
      return userMapper.select();

    }
}
