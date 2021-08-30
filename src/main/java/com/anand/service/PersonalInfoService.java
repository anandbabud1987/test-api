package com.anand.service;

import com.anand.entity.PersonalInfo;
import com.anand.mapper.PersonalInfoMapper;
import com.anand.model.UpdatePersonalRequest;
import com.anand.repository.PersonalInfoRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class PersonalInfoService {

    PersonalInfoRepository personalInfoRepository;

    PersonalInfoService(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    public void updatePersonalInfo(Long uuid, UpdatePersonalRequest updatePersonalRequest) {
        PersonalInfo existingResult = personalInfoRepository.findByUuid(uuid);
        if(!nonNull(existingResult)){
            personalInfoRepository.save(PersonalInfoMapper.mapToData(uuid, updatePersonalRequest));
        }
        else {
            existingResult.setName(updatePersonalRequest.getName());
            existingResult.setPhone(updatePersonalRequest.getPhone());
            existingResult.setEmail(updatePersonalRequest.getEmail());
            personalInfoRepository.save(existingResult);
        }
    }


    public PersonalInfo findById(Long uuid) {
        return personalInfoRepository.findByUuid(uuid);
    }
}
