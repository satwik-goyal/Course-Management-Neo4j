package dev.margrie.src.repositories;

import dev.margrie.src.models.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CourseRepository extends Neo4jRepository<Course, Long> {

}
