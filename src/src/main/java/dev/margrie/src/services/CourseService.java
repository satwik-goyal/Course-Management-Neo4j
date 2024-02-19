package dev.margrie.src.services;

import dev.margrie.src.models.Course;
import dev.margrie.src.repositories.CourseRepository;
import org.springframework.stereotype.Service;

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
}
