package com.leenayoung.repository;

import com.leenayoung.model.Community;
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

    @Test
    public void prepareTest() {
        for (int i = 1; i <= 50; i++) {
            Community community = new Community();
            community.setName("커뮤니티" + i);
            communityRepo.save(community);
        }
    }


    @Test
    public void findByName() {
        Community result = communityRepo.findByName("Community1");
        assertEquals("Community1", result.getName());
    }

    @Test
    public void findBySeq() {
        Community findCommunity = communityRepo.findByName("Community1");
        Long findSeq = findCommunity.getSeq();
        Community findBySeqCommunity = communityRepo.findBySeq(findSeq);
        assertEquals("Community1", findBySeqCommunity.getName());
    }

}