package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Guardian;
import com.learning.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*

Ideally we shouldn't use @SpringBootTest annotation for testing repository layer,
instead we should use @DataJpaTest which will flush the data once test gets executed.
But here we need that data, so that it can be printed in other tests
 */
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("rajesh@gmail.com")
                .firstName("Rajesh")
                .lastName("D")
                .build();
        studentRepository.save(student);
        studentRepository.save(Student.builder()
                        .emailId("student_with_no_name@gmail.com")
                        .build());
    }

    @Test
    public void saveStudentWithGuardian(){
        Student student = Student.builder()
                .emailId("ramesh@gmail.com")
                .firstName("Ramesh")
                .lastName("D")
                .guardian(Guardian.builder()
                        .email("guardian1@email.com")
                        .name("ramesh1")
                        .mobile("8872342")
                        .build())
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public void printStudentsByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Rajesh");
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public void printStudentsByFirstNameContaningAPrefix(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("Ra");
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public void printStudentsByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("ramesh1");
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public void printGetStudentsByEmail(){
        Student student = studentRepository.getStudentsByEmail("rajesh@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentNameByEmail(){
        String studentName = studentRepository.getStudentNameByEmail("rajesh@gmail.com");
        System.out.println(studentName);
    }

    @Test
    public void print_getStudentsByEmailUsingNativeSQLQuery(){
        Student student = studentRepository.getStudentsByEmailUsingNativeSQLQuery("rajesh@gmail.com");
        System.out.println(student);
    }

    @Test
    public void print_getStudentsByEmailUsingNativeSQLQueryWithNativeNamedParam(){
        Student student = studentRepository.getStudentsByEmailUsingNativeSQLQueryWithNativeNamedParam("rajesh@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        int affectedUpdates = studentRepository.updateStudentNameByEmailId("Rakesh", "rajesh@gmail.com");
        System.out.println(affectedUpdates);
    }
}