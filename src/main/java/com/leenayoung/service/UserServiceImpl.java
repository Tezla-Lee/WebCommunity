package com.leenayoung.service;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public int insertUser(User user) {
        if(userRepo.findById(user.getId()).isPresent()){
            System.out.println("중복 id");
            return -1;
        } else {
            userRepo.save(user);
            return 1;
        }
    }

    @Override
    public int updateUserPassword(User user) {
        if(userRepo.findById(user.getId()).isPresent()){
            User findUser = userRepo.findById(user.getId()).get();
            findUser.setPassword(user.getPassword());
            userRepo.save(findUser);
            return 1;
        } else {
            System.out.println("수정할 id가 없다");
            return -1;
        }
    }

    @Override
    public int deleteUser(User user) {
        if(userRepo.findByIdAndPasswordAndName(user.getId(),user.getPassword(),user.getName())
            != null ){
            User findUser = userRepo.findByIdAndPasswordAndName(user.getId(),user.getPassword(),user.getName());
            userRepo.delete(findUser);
            return 1;
        } else {
            System.out.println("삭제할 id가 없다");
            return -1;
        }


    }

    @Override
    public User getUser(User user) {
        return userRepo.findById(user.getId()).get();
    }

}
