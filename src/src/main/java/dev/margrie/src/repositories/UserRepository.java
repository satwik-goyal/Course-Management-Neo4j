package dev.margrie.src.repositories;

import dev.margrie.src.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User , Long> {

    Optional<User> findUserByUsername(String username);
}
