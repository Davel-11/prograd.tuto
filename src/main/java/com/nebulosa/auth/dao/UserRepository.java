package com.nebulosa.auth.dao;

import com.nebulosa.auth.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<UserInfo, Integer> { }



