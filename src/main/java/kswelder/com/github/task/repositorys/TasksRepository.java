package kswelder.com.github.task.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kswelder.com.github.task.models.Task;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long>{
    Task findByName(String name);
}
