package org.example.auto.service;

import org.example.auto.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //    @Autowired//根据类型找到对应的接口
    //    private UserDao userDao;

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("service执行");
        userDao.add();
    }
}
