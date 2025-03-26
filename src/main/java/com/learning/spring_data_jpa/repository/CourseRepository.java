package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContaining(String string, PageRequest pageRequest);
}
