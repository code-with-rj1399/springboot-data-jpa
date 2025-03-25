package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String prefix);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //JPQL  java persistence query language
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentsByEmail(String email);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentNameByEmail(String email);

    @Query(
            value = "select * from student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentsByEmailUsingNativeSQLQuery(String email);
}
