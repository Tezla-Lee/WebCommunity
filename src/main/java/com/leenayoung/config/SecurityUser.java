package com.leenayoung.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User { //security.core.userdetails.user

    public SecurityUser(com.leenayoung.model.User user) {
        super(user.getId(),
                "{noop}"+user.getPassword()
                , AuthorityUtils.createAuthorityList(user.getRole().toString()));

    }
}
