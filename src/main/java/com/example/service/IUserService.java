package com.example.service;

import com.example.model.User;

public interface IUserService {

    void save(User user);

    User findByUserName(String userName);
}
