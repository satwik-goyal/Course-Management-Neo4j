package dev.margrie.src.repositories;

import dev.margrie.src.models.Lesson;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface LessonRepository extends Neo4jRepository<Lesson , Long> {
    @Query("Match (:Course {identifier: $identifier})<-[:BELONGS_TO]-(lesson:Lesson) RETURN lesson")
    List<Lesson> findLessonsByCourseIdentifier(String identifier);
}
