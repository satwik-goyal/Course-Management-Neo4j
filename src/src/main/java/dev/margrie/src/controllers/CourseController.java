package dev.margrie.src.controllers;


import dev.margrie.src.models.Course;
import dev.margrie.src.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Course>> courseIndex(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }
}
