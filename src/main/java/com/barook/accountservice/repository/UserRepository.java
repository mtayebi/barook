package com.barook.accountservice.repository;

import com.barook.accountservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
