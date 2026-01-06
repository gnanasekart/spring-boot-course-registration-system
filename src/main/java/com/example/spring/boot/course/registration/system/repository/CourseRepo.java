package com.example.spring.boot.course.registration.system.repository;

import com.example.spring.boot.course.registration.system.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, String> {
}
