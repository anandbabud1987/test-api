package com.anand.service;

import com.anand.entity.PersonalInfo;
import com.anand.mapper.PersonalInfoMapper;
import com.anand.model.UpdatePersonalRequest;
import com.anand.repository.PersonalInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoService {

    PersonalInfoRepository personalInfoRepository;

    PersonalInfoService(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    public void updatePersonalInfo(Long uuid, UpdatePersonalRequest updatePersonalRequest) {
        personalInfoRepository.save(PersonalInfoMapper.mapToData(uuid, updatePersonalRequest));
    }


    public PersonalInfo findById(Long uuid) {
        return personalInfoRepository.findByUuid(uuid);
    }
}
