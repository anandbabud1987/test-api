package com.anand.controller;

import com.anand.entity.PersonalInfo;
import com.anand.model.PersonalInfoResponse;
import com.anand.model.UpdatePersonalInfoResponse;
import com.anand.model.UpdatePersonalRequest;
import com.anand.service.PersonalInfoService;
import com.anand.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.anand.constants.WebConstants.USERS;
import static java.util.Objects.nonNull;

@RestController
public class PersonalInformationController {
    Logger logger = LoggerFactory.getLogger(PersonalInformationController.class);

    PersonalInfoService personalInfoService;
    UserProfileService userProfileService;

    @Autowired
    PersonalInformationController(PersonalInfoService personalInfoService, UserProfileService userProfileService) {
        this.personalInfoService = personalInfoService;
        this.userProfileService = userProfileService;
    }

    @PostMapping(value = USERS, consumes = "application/json", produces = "application/json")
    public UpdatePersonalInfoResponse updatePersonalInfo(@RequestBody @Valid UpdatePersonalRequest updatePersonalRequest, @PathVariable("uuid") Long uuid) {
        try {

            personalInfoService.updatePersonalInfo(uuid, updatePersonalRequest);
            logger.warn("username created");
        } catch (Exception e) {
            logger.error("Error occurred while updating personal info", e);
            return new UpdatePersonalInfoResponse("Error occurred while updating personal info", false);
        }
        return new UpdatePersonalInfoResponse("User updated", true);
    }

    @GetMapping(value = USERS, produces = "application/json")
    public PersonalInfoResponse getPersonalInfo(@PathVariable("uuid") Long uuid) {
        try {

            PersonalInfo personalInfo = personalInfoService.findById(uuid);

            if (nonNull(personalInfo)) {
                return new PersonalInfoResponse(personalInfo.getName(), personalInfo.getEmail(), personalInfo.getPhone());

            }
        } catch (Exception e) {
            logger.error("Error occurred while getting personal info", e);
        }
        return new PersonalInfoResponse();
    }
}
