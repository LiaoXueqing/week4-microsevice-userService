package com.thoughtworks.training.xueqing.todoservice.repository;

import com.thoughtworks.training.xueqing.todoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    User findOneByName(String name);
    Optional<User> findByNameEquals(String name);
}
