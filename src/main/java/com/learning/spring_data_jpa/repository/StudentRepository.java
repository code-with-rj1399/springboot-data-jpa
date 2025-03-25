package com.learning.spring_data_jpa.repository;

import com.learning.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String prefix);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);
}
