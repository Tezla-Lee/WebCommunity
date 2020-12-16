package com.leenayoung.service;

import com.leenayoung.model.User;

public interface UserService {
    int insertUser(User user, String pwConfirm);

    int updateUserPassword(User user);

    int deleteUser(User user);

    User getUser(User user);
}
