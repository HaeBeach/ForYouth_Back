//package com.haebeach.foryouth.auth.service;
//
//import com.haebeach.foryouth.auth.entity.User;
//import com.haebeach.foryouth.auth.repository.UserRepository;
//import com.haebeach.foryouth.auth.security.UserInfoUserDetails;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@NoArgsConstructor
//public class UserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userList = userRepository.findById(username);
//        return userList.map(user -> new UserInfoUserDetails(user))
//                .orElseThrow(() -> new UsernameNotFoundException("user not found : " + username));
//    }
//
//}
