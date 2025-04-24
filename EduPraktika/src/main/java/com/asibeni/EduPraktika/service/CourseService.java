package com.asibeni.EduPraktika.service;


import com.asibeni.EduPraktika.model.Course;
import com.asibeni.EduPraktika.model.User;
import com.asibeni.EduPraktika.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursesByCreator(User creator) {
        return courseRepository.findByCreator(creator);
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public boolean deleteCourseById(int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

  }