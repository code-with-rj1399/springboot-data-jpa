package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import com.learning.spring_data_jpa.entity.CourseMaterial;
import com.learning.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveCourseWithTeacher(){
        Course mbaCourse = Course.builder()
                .title("MBA")
                .teacher(Teacher.builder()
                        .firstName("J.K")
                        .lastName("S")
                        .build())
//                .courseMaterial(CourseMaterial.builder()
//                        .url("http://url/of/mba")
//                        .build())
                .credit(100)
                .build();
        courseRepository.save(mbaCourse);
        printCourses();
    }

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        courses.forEach(System.out::println);
    }


}