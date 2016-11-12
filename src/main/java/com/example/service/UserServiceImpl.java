package com.example.service;

import com.example.model.Roles;
import com.example.model.User;
import com.example.repository.RoleRep;
import com.example.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRep userRep;
    @Autowired
    private RoleRep roleRep;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Roles> roles = new ArrayList<>();
        roles.add(roleRep.getOne(1L));
        user.setUser_role(roles);
        userRep.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRep.findByUserName(userName);
    }
}
