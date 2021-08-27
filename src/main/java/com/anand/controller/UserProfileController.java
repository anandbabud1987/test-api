package com.anand.controller;


import com.anand.model.CreateUserRequest;
import com.anand.model.CreateUserResponse;
import com.anand.model.LoginRequest;
import com.anand.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.anand.constants.WebConstants.*;
import static java.util.Objects.nonNull;

@RestController
public class UserProfileController {
    Logger logger= LoggerFactory.getLogger(UserProfileController.class);
    private UserProfileService userProfileService;

    @Autowired
    UserProfileController(UserProfileService userProfileService){
        this.userProfileService=userProfileService;
    }

    @PostMapping(value = REGISTER,consumes = "application/json",produces = "application/json")
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest createUserRequest){
        try {
            if(nonNull(userProfileService.findByUsername(createUserRequest.getUsername()))){
                logger.warn("username already exists");
                return new CreateUserResponse("username already exists",false);
            }
            userProfileService.createUser(createUserRequest);
            logger.warn("username created");
        } catch (Exception e) {
            logger.error("Error occurred while creating the user",e);
            return new CreateUserResponse("Error occurred while creating the user",false);
        }
        return new CreateUserResponse("User created",true);
    }

    @PostMapping(value = LOGIN,consumes = "application/json")
    public ResponseEntity userLogin(@RequestBody @Valid LoginRequest loginRequest){
        try {
            if(nonNull(userProfileService.doLogin(loginRequest))){
                logger.warn("login success");
                return ResponseEntity.ok("Login is successfull");
            }
        } catch (Exception e) {
            logger.error("Error occurred while login",e);
            logger.warn("login failed");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        logger.warn("login failed");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
