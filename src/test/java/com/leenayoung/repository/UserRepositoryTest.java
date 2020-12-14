package com.leenayoung.repository;

import com.leenayoung.model.User;
import org.aspectj.lang.annotation.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepo;

    @Before("")
    public void beforeTest() {
        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");

    }

    @Test
    void findByIdAndPassword() {
        userRepo.findByIdAndPassword("ee", "ee");

    }
}