package com.leenayoung.service;

import com.leenayoung.model.Community;
import com.leenayoung.repository.CommunityRepository;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityServiceImplTest {

    @Autowired
    CommunityServiceImpl communityService;

    @Autowired
    CommunityRepository communityRepository;

    @Before
    public void prepTest(){
        Community community = new Community();
        community.setName("ani");
        communityRepository.save(community);
    }

    @Test
    public void insertCommunity() {
        Community community = new Community();
        community.setName("ani");
        int result = communityService.insertCommunity(community);
        assertEquals( -1 , result);
    }

}