package com.rest1.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest1.entity.Course;
import com.rest1.service.CourseService;
import com.rest1.service.CourseServiceImpl;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "hii";
	}

	// get the courses
	@GetMapping( "/courses" )
	public List<Course> getCourses() {
		return courseService.getCourses();
	}
	//post the courses
	@PostMapping("/courses")
	public Course addCours(@RequestBody Course cours) {
		return this.courseService.addCourse(cours);
	}
	//put the  Courses
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseId) {
		try {
		   this.courseService.deleteCourse(Long.parseLong(courseId));
		   return new ResponseEntity<>(HttpStatus.OK);
		}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

}
