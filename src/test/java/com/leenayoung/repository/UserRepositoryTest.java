package com.leenayoung.repository;

import com.leenayoung.model.Role;
import com.leenayoung.model.User;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepo;

    @Before
    public void prepareTest() {
        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");
        user1.setRole(Role.ROLE_MEMBER);
        user1.setName("user");
        userRepo.save(user1);
    }

    @Test
    public void findByIdAndPassword() {

        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");

        User findUser = userRepo.findByIdAndPassword("user1", "user1");

        assertEquals(findUser.getId(), user1.getId());

    }

    @Test
    public void findByIdAndPasswordAndName() {
        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");
        user1.setName("user");

        User findUser = userRepo.findByIdAndPasswordAndName(user1.getId(), user1.getPassword(), user1.getName());

        assertEquals(findUser.getId(), user1.getId());
    }
}