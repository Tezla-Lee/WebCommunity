package com.leenayoung.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        // 사이트간 요청 위조를 비활성화 시킨다
        security.csrf().disable();
//        security.authorizeRequests().antMatchers("/").permitAll();

        security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess");

        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/main");

        security.exceptionHandling().accessDeniedPage("/accessDenied");

    }
}
