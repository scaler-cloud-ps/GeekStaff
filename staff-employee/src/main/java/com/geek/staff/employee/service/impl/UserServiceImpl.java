package com.geek.staff.employee.service.impl;

import com.geek.staff.employee.dao.UserMapper;
import com.geek.staff.employee.entity.User;
import com.geek.staff.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        return userMapper.userInfo();
    }
}
