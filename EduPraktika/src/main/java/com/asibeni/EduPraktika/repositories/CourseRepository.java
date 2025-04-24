package com.asibeni.EduPraktika.repositories;

import com.asibeni.EduPraktika.model.Course;
import com.asibeni.EduPraktika.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CourseRepository  extends JpaRepository<Course, Integer> {
    List<Course> findByName(String name);
    Optional<Course> findById(int id);
    List<Course> findByCreator(User creator);
    void deleteById(int id);

}
