package com.learning.spring_data_jpa.entity;


import lombok.Data;

/*

This projection interface is used to fetch only specific columns from the databse.
You neeed to use this as return type in repository.
 */
public interface CourseProjection {
    Long getCourseId();
    String getTitile();
}
