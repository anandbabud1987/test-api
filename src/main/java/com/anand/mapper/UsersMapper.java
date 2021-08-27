package com.anand.mapper;

import com.anand.entity.Users;
import com.anand.model.CreateUserRequest;

public class UsersMapper {
    public static Users mapToUsers(CreateUserRequest createUserRequest) {
        return new Users(createUserRequest.getUsername(),createUserRequest.getPassword());
    }
}
