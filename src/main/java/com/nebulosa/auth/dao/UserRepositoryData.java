package com.nebulosa.auth.dao;

import com.nebulosa.auth.model.UserInfo;
import org.springframework.data.repository.Repository;


public interface UserRepositoryData extends Repository<UserInfo, Integer> {

    UserInfo findByEmail(String email);
}
