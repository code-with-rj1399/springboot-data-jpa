package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import com.learning.spring_data_jpa.entity.CourseProjection;
import com.learning.spring_data_jpa.entity.Teacher;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryFetchingSpecificColumnsTest {

    @Autowired
    private CourseRepositoryFetchingSpecificColumns courseRepositoryFetchingSpecificColumns;

    @Autowired
    private CourseRepository courseRepository;


    public void addCourses(){
        Course mbaCourse = Course.builder()
                .title("MBA")
                .teacher(Teacher.builder()
                        .firstName("J.K")
                        .lastName("S")
                        .build())
                .credit(100)
                .build();
        courseRepository.save(mbaCourse);
    }

    @Test
    public void test_fetchOnlyCourseNames(){
        addCourses();
        for (String courseTitle : courseRepositoryFetchingSpecificColumns.fetchCourseNames()) {
            System.out.println(courseTitle);
        }
    }

    @Test
    public void test_fetchCourseNamesIdsUsingProjection(){
        addCourses();
        for (CourseProjection courseProjection : courseRepositoryFetchingSpecificColumns.fetchCourseNamesIds()) {
            System.out.println(courseProjection);
        }
    }

}