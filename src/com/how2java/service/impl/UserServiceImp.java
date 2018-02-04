package com.how2java.service.impl;

import com.how2java.mapper.UserMapper;
import com.how2java.pojo.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User query(int id) {
        User user = userMapper.query(id);
        return user;
    }

    @Override
    public int count() {
        return userMapper.count();
    }
}
