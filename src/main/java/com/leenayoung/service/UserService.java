package com.leenayoung.service;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public void insertUser(User user) {
        if(userRepo.findById(user.getId()).isPresent()){
            System.out.println("중복 id");
        } else {
            userRepo.save(user);
        }
    }

    public void updateUser(User user) {
        userRepo.findById(user.getId());
        userRepo.save(user);
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public int login(User user, HttpServletRequest request) {
        User findUser = userRepo.findByIdAndPassword(user.getId(), user.getPassword());
        HttpSession session = request.getSession();

        if(user != null) {
            session.setAttribute("user", user);
            System.out.println("로그인 성공");
            return 1;
        } else {
            System.out.println("id와 password 가 맞지 않습니다");
            return -1;
        }


    }

    public int logout(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return 1;
    }



}
