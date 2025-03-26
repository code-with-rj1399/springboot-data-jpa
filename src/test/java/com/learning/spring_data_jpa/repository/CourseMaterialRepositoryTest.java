package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import com.learning.spring_data_jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(Course.builder()
                        .title("Java")
                        .credit(100)
                        .build())
                .url("http://java.com")
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        courseMaterialList.stream().forEach(System.out::println);
    }

}