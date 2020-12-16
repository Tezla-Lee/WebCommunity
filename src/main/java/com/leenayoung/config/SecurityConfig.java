package com.leenayoung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BoardUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        // 사이트간 요청 위조를 비활성화 시킨다
        security.csrf().disable();
        security.authorizeRequests().antMatchers("/").permitAll();

        security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess",true);

        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/home");

        security.exceptionHandling().accessDeniedPage("/accessDenied");

        security.userDetailsService(userDetailsService);

    }
}
