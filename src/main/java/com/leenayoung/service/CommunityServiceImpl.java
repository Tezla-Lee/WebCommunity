package com.leenayoung.service;

import com.leenayoung.model.Community;
import com.leenayoung.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepo;

    @Override
    public int insertCommunity(Community community) {

        if(communityRepo.findByName(community.getName())==null){
            communityRepo.save(community);
            return 1;
        } else {
            System.out.println("이미 존재하는 이름입니다.");
            return -1;
        }
    }

    @Override
    public int updateCommunity(Community community) {

        if(communityRepo.findBySeq(community.getSeq())!= null) {
            Community findCommunity = communityRepo.findBySeq(community.getSeq());
            findCommunity.setName(community.getName());
            communityRepo.save(findCommunity);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteCommunity(Community community) {

        if (communityRepo.findBySeq(community.getSeq()) != null) {

            communityRepo.delete(community);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public List<Community> getCommunityList() {

        return  (List<Community>) communityRepo.findAll();
    }
}
