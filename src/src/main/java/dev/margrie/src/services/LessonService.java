package dev.margrie.src.services;

import dev.margrie.src.models.Lesson;
import dev.margrie.src.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> findLessonsByCourseIdentifier(String identifier){
        return lessonRepository.findLessonsByCourseIdentifier(identifier);

    }
}
