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
    public int insertUser(User user, String pwConfirm) {

        if(isInputEmpty(user)){
            return -1;
        } else if(isPwConfirmDifferent(user, pwConfirm)){
            return -2;
        } else if(isIdOverlap(user)){
            return -3;
        } else {
            userRepo.save(user);
            return 1;
        }
    }

    public boolean isInputEmpty(User user) {

        return user.getId().length() == 0
                || user.getPassword().length() == 0
                 || user.getName().length() == 0 ;
    }

    public boolean isPwConfirmDifferent(User user, String pwConfirm) {

        return !user.getPassword().equals(pwConfirm);
    }

    public boolean isIdOverlap(User user) {
        return userRepo.findById(user.getId()).isPresent();
    }


    @Override
    public int updateUserPassword(User user) {
        if(userRepo.findById(user.getId()).isPresent()){
            User findUser = userRepo.findById(user.getId()).get();
            findUser.setPassword(user.getPassword());
            userRepo.save(findUser);
            return 1;
        } else {
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
            return -1;
        }


    }

    @Override
    public User getUser(User user) {
        return userRepo.findById(user.getId()).get();
    }

}
