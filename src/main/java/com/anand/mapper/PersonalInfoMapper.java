package com.anand.mapper;

import com.anand.entity.PersonalInfo;
import com.anand.model.UpdatePersonalRequest;

public class PersonalInfoMapper {
    public static PersonalInfo mapToData(Long uuid, UpdatePersonalRequest updatePersonalRequest) {
        return new PersonalInfo(uuid,updatePersonalRequest.getName(),updatePersonalRequest.getEmail(),updatePersonalRequest.getPhone());
    }
}
