package com.example.spring.boot.course.registration.system.controller;

import com.example.spring.boot.course.registration.system.model.Course;
import com.example.spring.boot.course.registration.system.model.CourseRegistry;
import com.example.spring.boot.course.registration.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500"})
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourses() {;
        return courseService.getAllCourses();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents() {
        return courseService.enrolledStudents();
    }

    @PostMapping("courses/register")
    public String enrollCourse(
            @RequestParam("name") String name,
            @RequestParam("courseName") String courseName,
            @RequestParam("emailId") String emailId
    ) {
        courseService.enrollCourse(name, emailId, courseName);
        return "success";
    }
}
