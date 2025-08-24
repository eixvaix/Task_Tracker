package eu.itcrafters.myproject.repository;

import eu.itcrafters.myproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}