package com.rest1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest1.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1, "java", "Java Basic"));
		list.add(new Course(2, "python", "Python Basics"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		 list.forEach(e->{
			 if(e.getId()==course.getId()) {
				 e.setTitle(course.getTitle());
				 e.setDescription(course.getDescription());
			 }
		 });
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}


}
