package dev.margrie.src.controllers;


import dev.margrie.src.models.Course;
import dev.margrie.src.objects.CourseDTO;
import dev.margrie.src.services.CourseService;
import dev.margrie.src.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;
    private final LessonService lessonService;

    public CourseController(CourseService courseService , LessonService lessonService){
        this.courseService = courseService;
        this.lessonService = lessonService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Course>> courseIndex(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }
    @GetMapping("/{identifier}")

    public ResponseEntity<CourseDTO> courseDetails(@PathVariable String identifier){
        Course course = courseService.getCourseByIdentifier(identifier);

        CourseDTO responseCourse = new CourseDTO(course.getIdentifier() , course.getTitle() , course.getTeacher());

        responseCourse.setLessons(lessonService.findLessonsByCourseIdentifier(course.getIdentifier()));

        return new ResponseEntity<>(responseCourse,HttpStatus.OK);
    }

}
