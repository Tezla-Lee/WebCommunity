package com.leenayoung.repository;

import com.leenayoung.model.Community;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityRepositoryTest {

    @Autowired
    CommunityRepository communityRepo;

    @Before
    public void prepareTest() {
        Community Community1 = new Community();
        Community1.setName("Community1");
        communityRepo.save(Community1);
    }



    @Test
    public void findByName() {
        Community result = communityRepo.findByName("Community1");
        assertEquals("Community1", result.getName() );
    }

    @Test
    public void findBySeq() {
        Community findCommunity = communityRepo.findBySeq(1L);
        assertEquals("Community1", findCommunity.getName());
    }

}