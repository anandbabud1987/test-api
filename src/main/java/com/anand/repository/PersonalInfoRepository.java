package com.anand.repository;

import com.anand.entity.PersonalInfo;
import org.springframework.data.repository.CrudRepository;

public interface PersonalInfoRepository extends CrudRepository<PersonalInfo,Long> {

    PersonalInfo findByUuid(Long uuid);
}
