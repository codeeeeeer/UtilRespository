package com.test.actions.interfaces.impl;

import com.test.actions.interfaces.UserService;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/16 16:18
 */
public class UserServiceImpl implements UserService {
    public boolean updateUserInfo(String name) {
        System.out.println("update user information");
        return true;
    }
}
