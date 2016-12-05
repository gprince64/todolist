package fr.icdc.dei.todolist.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icdc.dei.todolist.persistence.dao.TaskDao;
import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.service.TaskService;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public List<Task> list() {
		return taskDao.findAll();
	}

	@Override
	public Task add(Task task) {
		if(task.getUser().getTasks().size() < 10)
			return taskDao.save(task);
		return null;
	}
	
	public List<Task> listNotEndedTasksOfUser(long userId){
		List<Task> tasks = taskDao.findAllByUserId(userId);
		List<Task> tasksOk = new ArrayList<Task>();
		for(Task task : tasks){
			if (taskIsNotEnded(task))
				tasksOk.add(task);
		}
		return tasksOk;
	}
	
	public 	List<Task> listNotEndedTasksInIntervalOfUser(long userId, Date beginningIntervalDate, Date endingIntervalDate){
		List<Task> tasks = taskDao.findAllByUserId(userId);
		List<Task> tasksOk = new ArrayList<Task>();
		for(Task task : tasks){
			if(taskIsNotEnded(task) && taskPrevisionalEndingDateIsInInterval(task, beginningIntervalDate, endingIntervalDate))
				tasksOk.add(task);
		}
		return tasksOk;
	}

	private boolean taskPrevisionalEndingDateIsInInterval(Task task, Date beginningIntervalDate, Date endingIntervalDate) {
		if(beginningIntervalDate.before(task.getPrevisionalEndingDate()) && endingIntervalDate.after(task.getPrevisionalEndingDate()))
			return true;
		else
			return false;
	}

	private boolean taskIsNotEnded(Task task) {
		return task.getEndingDate() == null;
	}
	
	public void endUserTasksEndingInInterval(long userId, Date beginningIntervalDate, Date endingIntervalDate){
		endTasksList(listNotEndedTasksInIntervalOfUser(userId, beginningIntervalDate, endingIntervalDate));
	}

	private void endTasksList(List<Task> tasks) {
		for(Task task : tasks){
			endTask(task);
		}
	}

	private void endTask(Task task) {
		task.setEndingDate(Calendar.getInstance().getTime());
		taskDao.save(task);	
	}




}
