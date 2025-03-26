package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Course;
import com.learning.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        List<Course> courses = List.of(
                Course.builder()
                        .title("DBA")
                        .build(),
                Course.builder()
                        .title("MySQL")
                        .build()
        );
        Teacher teacher = Teacher.builder()
                .firstName("J.K")
                .lastName("M")
                .courses(courses).build();
        teacherRepository.save(teacher);
        printTeachers();
    }

    @Test
    public void printTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(System.out::println);
    }

}