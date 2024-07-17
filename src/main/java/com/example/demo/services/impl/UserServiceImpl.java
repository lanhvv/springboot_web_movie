package com.example.demo.services.impl;

import com.example.demo.config.exception.policy.BusinessLogicException;
import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.dto.mapper.ToDoUserMapper;
import com.example.demo.dto.request.LoginDTORQ;
import com.example.demo.dto.request.RegisterDTORQ;
import com.example.demo.dto.response.UserDTORS;
import com.example.demo.repositories.RoleRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.CommonTableService;
import com.example.demo.services.UserService;
import com.example.demo.utils.MessageUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final CommonTableService commonTableService;
    private final JwtTokenProvider jwtTokenProvider;
    private final ToDoUserMapper toDoUserMapper;

    public UserServiceImpl(
            BCryptPasswordEncoder passwordEncoder,
            UserRepo userRepo,
            RoleRepo roleRepo,
            CommonTableService commonTableService,
            JwtTokenProvider jwtTokenProvider,
            ToDoUserMapper toDoUserMapper
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.commonTableService = commonTableService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.toDoUserMapper = toDoUserMapper;
    }

    @Transactional
    @Override
    public void register(RegisterDTORQ userDTORQ) {
        User user = this.userRepo.findByEmail(userDTORQ.getEmail());
        Set<Role> roles = userDTORQ.getRole().stream()
                .map(role -> {
                    Role roleDB = this.roleRepo.findBySlug(role);
                    if (ObjectUtils.isEmpty(roleDB)) {
                        throw new BusinessLogicException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), MessageUtils.ROLE_NOT_EXITS, HttpStatus.BAD_REQUEST, role);
                    }
                    return roleDB;
                }).collect(Collectors.toSet());


        if (!ObjectUtils.isEmpty(user)) {
            throw new BusinessLogicException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), MessageUtils.EMAIL_EXITS, HttpStatus.BAD_REQUEST);
        }

        User userRegister = new User(
                userDTORQ.getEmail(),
                this.passwordEncoder.encode(userDTORQ.getPassword()),
                userDTORQ.getName(),
                roles
            );
        this.commonTableService.setInfoCommonTableNew(userRegister, userRegister.getEmail());
        this.userRepo.save(userRegister);
    }

    @Transactional
    @Override
    public UserDTORS login(LoginDTORQ loginDTORQ) {
        User user = this.userRepo.findByEmail(loginDTORQ.getEmail());
        if (ObjectUtils.isEmpty(user)) {
            throw new BusinessLogicException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), MessageUtils.USER_LOGIN_NOT_EXITS, HttpStatus.BAD_REQUEST);
        }
        if (!this.passwordEncoder.matches(loginDTORQ.getPassword(), user.getPassword())) {
            throw new BusinessLogicException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), MessageUtils.PASSWORD_INVALID, HttpStatus.BAD_REQUEST);
        }
        UserDTORS userDTORS = this.toDoUserMapper.UserToUserDTORS(user);
        userDTORS.setToken(this.jwtTokenProvider.generateToken(user.getEmail()));
        return userDTORS;
    }
}
