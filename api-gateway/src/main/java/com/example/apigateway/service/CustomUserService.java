package com.example.apigateway.service;

import com.example.apigateway.bean.UserBean;
import com.example.apigateway.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUser");
        UserBean user = userRepository.getUserByUsername(username);
        System.out.println(user.getUsername());
        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, new ArrayList<>());
    }

//    private List<GrantedAuthority> getGrantedAuthorities(UserBean user){
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
////    TODO : add this back in for user roles
////    authorities.add(new SimpleGrantedAuthority(user.getUserRole().getName()));
//
//        return authorities;
//    }
}