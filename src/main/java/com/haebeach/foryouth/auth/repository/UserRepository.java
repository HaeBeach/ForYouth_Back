package com.haebeach.foryouth.auth.repository;

import com.haebeach.foryouth.auth.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findById(String id);

}
