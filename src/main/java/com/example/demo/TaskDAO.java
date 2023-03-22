package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAO {

	@Autowired
	JdbcTemplate jdbc;
	
	public Task getTaskById(Long id) {
		try {			
			String sql = "SELECT * FROM tasks WHERE id="+id;
			List<Task> tasks = jdbc.query(sql, new TaskRowMapper());
			return tasks.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Task> getAllTasks() {
		try {			
			String sql = "SELECT * FROM tasks;";
			List<Task> tasks = jdbc.query(sql, new TaskRowMapper());
			return tasks;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int insertTask(Task task) {	//returns number of rows affected
		try {			
			String sql = "INSERT INTO tasks (description) VALUES (?);";
			return jdbc.update(sql, task.description);
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int deleteTaskById(Long id) { //returns number of rows affected
		try {			
			String sql = "DELETE FROM tasks WHERE id=?;";
			return jdbc.update(sql, id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int deleteAllTasks() {
		try {			
			String sql = "DELETE from tasks;";
			return jdbc.update(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	public int deleteTaskByDescription(String description) {
		try {			
			String sql = "DELETE FROM tasks WHERE description=?;";
			return jdbc.update(sql, description);
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
