package com.leenayoung.config;

import com.leenayoung.model.User;
import com.leenayoung.repository.UserRepository;
import net.bytebuddy.asm.MemberRemoval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<User> findUser = userRepo.findById(username);
        if(findUser.isEmpty()) {
            throw new UsernameNotFoundException(username + "사용자가 없습니다.");
        } else {
            User user = findUser.get();
            return new SecurityUser(user);
        }
    }
}
