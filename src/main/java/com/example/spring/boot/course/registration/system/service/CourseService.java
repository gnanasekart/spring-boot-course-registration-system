package com.example.spring.boot.course.registration.system.service;

import com.example.spring.boot.course.registration.system.model.Course;
import com.example.spring.boot.course.registration.system.model.CourseRegistry;
import com.example.spring.boot.course.registration.system.repository.CourseRegistryRepo;
import com.example.spring.boot.course.registration.system.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry sa = new CourseRegistry(name, emailId, courseName);
        courseRegistryRepo.save(sa);
    }
}
