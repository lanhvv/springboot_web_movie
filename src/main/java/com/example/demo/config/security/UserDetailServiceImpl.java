package com.example.demo.config.security;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.stream.Collectors;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //cung cấp cho authentication để biết cách lấy dữ liệu
    // có username, passowrd, role thì có thể compare rồi
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userDB = this.userRepo.findByEmail(email);
        if (!ObjectUtils.isEmpty(userDB)) {
            return new org.springframework.security.core.userdetails.User(
                    userDB.getEmail(),
                    userDB.getPassword(),
                    userDB.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getSlug())).collect(Collectors.toSet())
            );
        } else {
            throw new UsernameNotFoundException(email);
        }
    }
}
