package com.leenayoung.repository;

import com.leenayoung.model.Community;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityRepositoryTest {

    @Autowired
    CommunityRepository categoryRepo;

    @Before
    public void prepareTest() {
        Community community1 = new Community();
        community1.setName("Category1");
        categoryRepo.save(community1);
    }



    @Test
    public void findByName() {
        Community result = categoryRepo.findByName("Category1");
        assertEquals("Category1", result.getName() );
    }
}