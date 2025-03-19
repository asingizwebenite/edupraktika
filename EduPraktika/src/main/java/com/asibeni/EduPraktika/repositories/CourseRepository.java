package com.asibeni.EduPraktika.repositories;

import com.asibeni.EduPraktika.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepository  extends JpaRepository<Course, Integer> {
    Optional<Course> findByName(String name);

}
