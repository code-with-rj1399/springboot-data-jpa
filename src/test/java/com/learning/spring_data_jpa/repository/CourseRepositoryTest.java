package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import com.learning.spring_data_jpa.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @BeforeAll
    public void addData(){
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(Course.builder()
                        .title("Java")
                        .credit(100)
                        .build())
                .url("http://java.com")
                .build();
        courseMaterialRepository.save(courseMaterial);

        courseMaterial = CourseMaterial.builder()
                .course(Course.builder()
                        .title("Springboot")
                        .credit(1001)
                        .build())
                .url("http://java-spt.com")
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        courses.forEach(System.out::println);
    }


}