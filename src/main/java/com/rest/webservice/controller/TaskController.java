package com.rest.webservice.controller;

import com.rest.webservice.model.MainTask;
import com.rest.webservice.model.Task;
import com.rest.webservice.model.TestError;
import com.rest.webservice.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;
    private static Logger log = Logger.getLogger("Solution");

    @PutMapping("{id}")
    public ResponseEntity<?> updateTask(@RequestBody MainTask task , @PathVariable("id") long id) {
            if(task.getDescription() == null || task.getDescription().length() == 0){
                return  new ResponseEntity<TestError>(new TestError("Task description is required",400 ), HttpStatus.BAD_REQUEST);
            }
        Optional<Task> tasks = taskRepo.findById(id);
            if(!tasks.isPresent()){
                return  new ResponseEntity<TestError>(new TestError("Cannot find task with given id",404 ), HttpStatus.NOT_FOUND);

            }else {
                Task test =  tasks.get();

                test.setDescription(task.getDescription());
                test.setPriority(task.getPriority());
                taskRepo.save(test);

            }
        return  new ResponseEntity<MainTask>(task, HttpStatus.OK);

    }

}
