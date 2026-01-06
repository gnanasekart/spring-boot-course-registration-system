package com.example.spring.boot.course.registration.system.repository;

import com.example.spring.boot.course.registration.system.model.CourseRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry, Integer> {
}
