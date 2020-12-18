package com.leenayoung.service;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepo;


    @Before
    public void beforeTest(){

        User user = new User();
        user.setId("user");
        user.setPassword("user");
        user.setName("user");
        String pwConfirm = "user";
//        user1.setJoinDate(new Date().setTime(123123););
        userServiceImpl.insertUser(user, pwConfirm);

        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");
        user1.setName("user1");
        String pwConfirm1 = "user1";
//        user1.setJoinDate(new Date().setTime(123123););
        userServiceImpl.insertUser(user1, pwConfirm1);

        User user2 = new User();
        user2.setId("user2");
        user2.setPassword("user2");
        user2.setName("user2");
        String pwConfirm2 = "user2";
        userServiceImpl.insertUser(user2, pwConfirm2);

        User user3 = new User();
        user3.setId("user3");
        user3.setPassword("user3");
        user3.setName("user3");
        String pwConfirm3 = "user3";
        userServiceImpl.insertUser(user3, pwConfirm3);
    }

    @Test
    public void passwordEncoderTest() {
        User user = new User();
        user.setId("passwordEncoder");
        user.setPassword("password");
        user.setName("인코더");
        String pwConfirm = "password";
        if(userRepo.findById(user.getId()).isPresent()){
            userRepo.deleteById(user.getId());
        }
        userServiceImpl.insertUser(user, pwConfirm);
        String result = userRepo.findById("passwordEncoder").get().getPassword();
        assertEquals(user.getPassword(),result);
    }

    @Test
    public void insertUser() {
        User user1 = new User();
        user1.setId("admin");
        user1.setPassword("admin");
        user1.setName("관리자");
        user1.setRole(Role.ROLE_ADMIN);
        String pwConfirm = "admin";
        if(userRepo.findById(user1.getId()) != null) {
            userServiceImpl.deleteUser(user1);
        }

        int result = userServiceImpl.insertUser(user1, pwConfirm);

        assertEquals(1, result );
    }

//    @Test
//    public void updateUser() {
//
//        User user2 = new User();
//        user2.setId("user2");
//        user2.setPassword("user2222");
//
//        userServiceImpl.updateUserPassword(user2);
//
//        User result = userRepo.findById("user2").get();
//
//        assertEquals(user2.getPassword(), result.getPassword());
//    }

    @Test
    public void deleteUser() {
        User user3 = new User();
        user3.setId("user");
        user3.setPassword("user");
        user3.setName("user");
        String pwConfirm="user";

        int result = userServiceImpl.deleteUser(user3);
        assertEquals(1, result);

    }

    @Test
    public void isInputEmpty() {
        User user = new User();
        user.setId("");
        user.setPassword("dd");
        user.setName("");

        Assertions.assertTrue(userServiceImpl.isInputEmpty(user));
    }

    @Test
    public void inputUser() {
        for (int i = 1; i <= 50; i++) {
            User user = new User();
            user.setId("member" + i);
            user.setPassword("1234");
            user.setName("이재복" + i);
            userServiceImpl.insertUser(user, "1234");
        }
    }
}