package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Student;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    //using JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentNameByEmail(String email);

    //using native sql query
    @Query(
            value = "select * from student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentsByEmailUsingNativeSQLQuery(String email);

    //using native query with parameters
    @Query(
            value = "select * from student s where s.email_address = :email",
            nativeQuery = true
    )
    Student getStudentsByEmailUsingNativeSQLQueryWithNativeNamedParam(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(
            nativeQuery = true,
            value = "update Student set first_name = ?1 where email_address = ?2"
    )
    int updateStudentNameByEmailId(String name, String emailId);
}
