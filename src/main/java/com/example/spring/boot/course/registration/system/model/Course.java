package com.example.spring.boot.course.registration.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String trainer;
    private int durationInWeeks;

}
