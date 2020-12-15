package com.leenayoung.service;

import com.leenayoung.repository.CommunityRepository;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityServiceImplTest {

    CommunityServiceImpl categoryService;
    CommunityRepository categoryRepo;

    @Before
    public void prepTest(){
        Community community = new Community();
        community.setName("ani");
        categoryRepo.save(community);
    }

    @Test
    public void insertCategory() {
        Community community = new Community();
        community.setName("ani");
        int result = categoryService.insertCategory(community);
        assertEquals( -1 , result);
    }


}