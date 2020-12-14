package com.leenayoung.service;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepo;


    @Before
    public void beforeTest(){
        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");
        user1.setRole("user");
        user1.setName("user");
//        user1.setJoinDate(new Date().setTime(123123););
        userServiceImpl.insertUser(user1);

        User user2 = new User();
        user2.setId("user2");
        user2.setPassword("user2");
        user2.setRole("user");
        user2.setName("user2");
        userServiceImpl.insertUser(user2);

        User user3 = new User();
        user3.setId("user3");
        user3.setPassword("user3");
        user3.setRole("user");
        user3.setName("user3");
        userServiceImpl.insertUser(user3);
    }

    @Test
    public void insertUser() {
        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");
        user1.setRole("user");
        user1.setName("user");

        int result = userServiceImpl.insertUser(user1);

        assertEquals(-1, result );
    }

    @Test
    public void updateUser() {

        User user2 = new User();
        user2.setId("user2");
        user2.setPassword("user2222");

        userServiceImpl.updateUserPassword(user2);

        User result = userRepo.findById("user2").get();

        assertEquals(user2.getPassword(), result.getPassword());
    }

    @Test
    public void deleteUser() {
        User user3 = new User();
        user3.setId("user3");
        user3.setPassword("user3");
        user3.setName("user3");

        userServiceImpl.deleteUser(user3);


        boolean result = userRepo.findById(user3.getId()).isPresent();

        assertFalse(result);

    }

    @Test
    public void login() {
    }

    @Test
    public void logout() {
    }
}