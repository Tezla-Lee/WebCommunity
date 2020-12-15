package com.leenayoung.service;

import com.leenayoung.model.Community;
import com.leenayoung.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl {

    @Autowired
    private CommunityRepository communityRepo;

    public int insertCommunity(Community community) {

        if(communityRepo.findByName(community.getName())==null){
            communityRepo.save(community);
            return 1;
        } else {
            System.out.println("이미 존재하는 이름입니다.");
            return -1;
        }
    }

//    public int updateCommunity(Community community) {
//
//        if(communityRepo.findById(community.getNumber())!= null) {
//
//        }
//
//        Community findCommunity = communityRepo.findById(community.getNumber());
//
//        findCommunity.setName(co);
//
//    }
}
