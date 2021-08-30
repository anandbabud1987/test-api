package com.anand.service;

import com.anand.entity.Users;
import com.anand.mapper.UsersMapper;
import com.anand.model.CreateUserRequest;
import com.anand.model.LoginRequest;
import com.anand.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserProfileService {
    private UserRepository userRepository;

    UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void createUser(CreateUserRequest createUserRequest) throws Exception {
        Users users = UsersMapper.mapToUsers(createUserRequest);
        userRepository.save(users);
    }

    public Users doLogin(LoginRequest loginRequest) {
        return userRepository.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
    }


}
