package com.rest1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest1.entity.Course;

public interface CourseService {
public  List<Course> getCourses();
public Course addCourse(Course course);
public Course updateCourse(Course course);
public void deleteCourse(long parseLong);

}
