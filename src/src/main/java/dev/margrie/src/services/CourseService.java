package dev.margrie.src.services;

import dev.margrie.src.models.Course;
import dev.margrie.src.repositories.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseByIdentifier(String Identifier){
        return courseRepository.findCourseByIdentifier(Identifier).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }
}
