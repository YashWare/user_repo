package com.UMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UMS.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
