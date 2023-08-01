package kswelder.com.github.bot.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kswelder.com.github.bot.models.Task;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long>{

}
