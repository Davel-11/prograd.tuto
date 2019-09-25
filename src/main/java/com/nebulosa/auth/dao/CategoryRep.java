package com.nebulosa.auth.dao;

import com.nebulosa.auth.model.Category;
import com.nebulosa.auth.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRep extends JpaRepository<Category, Integer> {


}
