package com.rest.webservice.repo;

import com.rest.webservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskRepo extends JpaRepository<Task, Long> {
}
