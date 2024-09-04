package com.springboot.repository;



import com.springboot.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByName(String name);
}
