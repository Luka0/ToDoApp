package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")	// connects the backend with the frontend port so you can access backend endpoints using axios in React
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("getTaskById")
	public Task getTaskById(@RequestParam Long id) {
		return taskService.getTaskById(id);
	}
	
	@GetMapping("getAllTasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@PostMapping("insertTask")
	public int insertTask(@RequestBody Task task) {
		return taskService.insertTask(task); // returns number of rows affected
	}
	
	@DeleteMapping("deleteTaskById")
	public int deleteTaskById(@RequestParam Long id) {
		return taskService.deleteTaskById(id);
	}
	
	@DeleteMapping("deleteAllTasks")
	public int deleteAllTasks() {
		return taskService.deleteAllTasks();
	}
	
	@DeleteMapping("deleteTaskByDescription")
	public int deleteTaskByDescription(@RequestParam String description) {
		// na frontu je zabranjeno da dodas 2 taska s istim opisom tak da nikad neces brisat vise od jednog retka

		return taskService.deleteTaskByDescription(description);
	}
}
