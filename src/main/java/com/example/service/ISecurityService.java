package com.example.service;

public interface ISecurityService {

    String findLoggedInUserName();

    void autoLogin(String userName, String password);

}
