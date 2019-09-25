package com.nebulosa.auth.dao;

import com.nebulosa.auth.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRep extends JpaRepository<Course, Integer> {

    Course findByIdAndIdCat(Integer id, Integer idCat);

}
