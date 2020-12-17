package com.leenayoung.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User { //security.core.userdetails.user

    private com.leenayoung.model.User user;

    public SecurityUser(com.leenayoung.model.User user) {
        super(user.getId(),
                user.getPassword()
                , AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public com.leenayoung.model.User getUser() {
        return user;
    }
}
