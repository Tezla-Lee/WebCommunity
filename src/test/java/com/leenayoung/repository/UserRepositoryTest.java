package com.leenayoung.repository;

import com.leenayoung.model.User;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
import javax.persistence.Temporal;

import static org.junit.jupiter.api.Assertions.*;

=======
>>>>>>> 03e94a487009bab716b0cdde2810129d79b8409c
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
        user1.setRole("user");
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