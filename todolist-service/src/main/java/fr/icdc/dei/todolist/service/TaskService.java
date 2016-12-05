package fr.icdc.dei.todolist.service;

import java.util.Date;
import java.util.List;
import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskService {

	List<Task> list();

	Task add(Task task);

	List<Task> listNotEndedTasksOfUser(long userId);

	List<Task> listNotEndedTasksInIntervalOfUser(long userId, Date beginningIntervalDate, Date endingIntervalDate);

	void endUserTasksEndingInInterval(long userId, Date beginningIntervalDate, Date endingIntervalDate);

	
}
