package com.leenayoung.service;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepo;

    public int insertUser(User user) {
        if(userRepo.findById(user.getId()).isPresent()){
            System.out.println("중복 id");
            return -1;
        } else {
            userRepo.save(user);
            return 1;
        }
    }

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

    public int deleteUser(User user) {
        if(userRepo.findByIdAndPasswordAndName(user.getId(),user.getPassword(),user.getName())
            != null ){
            User findUser = userRepo.findByIdAndPasswordAndName(user.getId(),user.getPassword(),user.getName());
            userRepo.delete(findUser);
            return 1;
        } else {
            System.out.println("삭제할할 id가 없다");
            return -1;
        }


    }

//    public int login(User user, HttpSession session) {
//        User findUser = userRepo.findByIdAndPassword(user.getId(), user.getPassword());
////        HttpSession session = request.getSession();
//
//        if(user != null) {
//            session.setAttribute("user", user);
//            System.out.println("로그인 성공");
//            return 1;
//        } else {
//            System.out.println("id와 password 가 맞지 않습니다");
//            return -1;
//        }
//
//
//    }
//
//    public int logout(User user, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.invalidate();
//        return 1;
//    }



}
