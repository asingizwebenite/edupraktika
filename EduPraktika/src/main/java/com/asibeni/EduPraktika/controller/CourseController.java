package com.asibeni.EduPraktika.controller;

import com.asibeni.EduPraktika.model.Course;
import com.asibeni.EduPraktika.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8095")
@RequestMapping("/edupraktika")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public void saveCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course updatedCourseData) {
        Optional<Course> optionalCourse = courseService.getCourseById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();

            course.setName(updatedCourseData.getName());
            course.setInformation(updatedCourseData.getInformation());

            course.setVideoUrl(updatedCourseData.getVideoUrl());

            Course savedCourse = courseService.addCourse(course);
            return ResponseEntity.ok(savedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        boolean deleted = courseService.deleteCourseById(id);
        if (deleted) {
            return ResponseEntity.ok("Course deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
