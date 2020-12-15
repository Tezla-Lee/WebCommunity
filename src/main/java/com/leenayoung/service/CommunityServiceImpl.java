package com.leenayoung.service;

import com.leenayoung.repository.CommunityRepository;

public class CommunityServiceImpl {

    private CommunityRepository categoryRepo;

    public int insertCategory(Community community) {

        if(categoryRepo.findByName(community.getName())!=null){
            categoryRepo.save(community);
            return 1;
        } else {
            System.out.println("이미 존재하는 이름입니다.");
            return -1;
        }

    }
}
