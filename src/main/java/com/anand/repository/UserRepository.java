package com.anand.repository;

import com.anand.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
    Users findByUsername(String username);
    Users findByUsernameAndPassword(String username,String password);
}
