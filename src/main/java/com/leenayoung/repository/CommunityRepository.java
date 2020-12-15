package com.leenayoung.repository;

import org.springframework.data.repository.CrudRepository;

public interface CommunityRepository extends CrudRepository<Community, Long> {

    public Community findByName(String name);
}
