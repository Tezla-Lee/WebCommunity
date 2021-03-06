package com.leenayoung.service;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public int insertUser(User user, String pwConfirm) {

        if(isInputEmpty(user)){
            return -1;
        } else if(isPwConfirmDifferent(user, pwConfirm)){
            return -2;
        } else if(isIdOverlap(user)){
            return -3;
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
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


//    @Override
//    public int updateUserPassword(User user) {
//        if(userRepo.findById(user.getId()).isPresent()){
//            User findUser = userRepo.findById(user.getId()).get();
//
//            if (encoder.matches(user.getPassword(), findUser.getPassword())){
//                findUser.setPassword(encoder.encode(user.getPassword()));
//                userRepo.save(findUser);
//                return 1;
//            }
//                return -1;
//
//        } else {
//                return -1;
//        }
//    }

    @Override
    public int deleteUser(User user) {

        User findUser = userRepo.findByIdAndName(user.getId(), user.getName());

        if(findUser != null ){
            if (encoder.matches(user.getPassword(), findUser.getPassword())) {
                userRepo.delete(findUser);
                return 1;
            }
             return -1;
        } else {
            return -1;
        }
    }

    @Override
    public User getUser(User user) {
        return userRepo.findById(user.getId()).get();
    }

}
