package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import com.learning.spring_data_jpa.entity.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepositoryFetchingSpecificColumns extends JpaRepository<Course, Long> {
    @Query("select c.title from Course c")
    List<String> fetchCourseNames();

    @Query("select c.courseId, c.title from Course c")
    List<CourseProjection> fetchCourseNamesIds();
}
