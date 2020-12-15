package com.leenayoung.service;

import com.leenayoung.model.Community;

import java.util.List;

public interface CommunityService {
    int insertCommunity(Community community);

    int updateCommunity(Community community);

    int deleteCommunity(Community community);

    Community getCommunity(Community community);

    List<Community> getCommunityList();
}
