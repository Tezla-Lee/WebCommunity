package com.leenayoung.service;

import com.leenayoung.model.Community;
import com.leenayoung.repository.CommunityRepository;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityServiceImplTest {

    @Autowired
    CommunityServiceImpl communityService;

    @Autowired
    CommunityRepository communityRepo;


    @Test
    public void insertCommunity() {
        Community community = new Community();
        community.setName("ani");
        int result = communityService.insertCommunity(community);
        assertEquals( 1 , result);
    }

    @Test
    public void updateCommunity() {
        Community community = new Community();
        community.setName("수정");
        communityRepo.save(community);

        Community findCommunity = communityRepo.findByName("수정");

        findCommunity.setName("update");

        communityService.updateCommunity(findCommunity);
        findCommunity = communityRepo.findByName("update");
        assertEquals("update", findCommunity.getName());

    }

    @Test
    public void deleteCommunity() {
        Community community = new Community();
        community.setName("삭제");
        communityRepo.save(community);

        communityService.deleteCommunity(community);

        assertNull( communityRepo.findByName("삭제"));
    }

    @Test
    public void getCommunityList() {

        List<Community> list = (List<Community>)communityRepo.findAll();
        List<Community> communityList = communityService.getCommunityList();



        assertEquals( list.size(), communityList.size());
    }


}