package com.lucasangelo.todosimple.repositories;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucasangelo.todosimple.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    // Optional<Task> findById(Long id);
    // query prontas spring boot
    List<Task> findByUser_id(Long id);

    // Jpql
    // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    // List<Task> qualquerNome(@Param("id") Long id);
    
    // query nativa
    // @Query(value = "SELECT * FROM task t Where t.user_id = :id", nativeQuery = true)
    // List<Task> findByUser_id(@Param("id") Long id);

}
