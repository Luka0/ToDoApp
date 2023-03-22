package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	TaskDAO taskDao;

	public Task getTaskById(Long id) {
		return taskDao.getTaskById(id);
	}

	public List<Task> getAllTasks() {
		return taskDao.getAllTasks();
	}

	public int insertTask(Task task) {
		return taskDao.insertTask(task);
	}

	public int deleteTaskById(Long id) {
		return taskDao.deleteTaskById(id);
	}

	public int deleteAllTasks() {
		return taskDao.deleteAllTasks();
	}

	public int deleteTaskByDescription(String description) {
		return taskDao.deleteTaskByDescription(description);
	}
	
}
