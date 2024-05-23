package com.siferga.back2Xperience.repository;

import com.siferga.back2Xperience.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
