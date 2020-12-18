package com.leenayoung.repository;

import com.leenayoung.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    public User findByIdAndPassword(String id, String password);

    public User findByIdAndName(String id, String name);


}
