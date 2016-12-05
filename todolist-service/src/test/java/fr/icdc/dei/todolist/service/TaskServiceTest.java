package fr.icdc.dei.todolist.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.collections.CollectionUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.User;
import fr.icdc.dei.todolist.persistence.entity.UserFree;

public class TaskServiceTest extends AbstractServiceTest {
	
	private static final String TASK_LABEL = "taskLabel";

	private final static Task task = new Task();
	private final static User user = new UserFree();
	private final static long USER_ID_INTERVAL_TESTS = 3L;
	private final static int INTERVAL_YEAR = 2016;
	private final static int INTERVAL_MONTH = 10;
	private final static int INTERVAL_BEGINNING_DAY = 15;
	private final static int INTERVAL_ENDING_DAY = 20;
	private static Date BEGINNING_INTERVAL_DATE;
	private static Date ENDING_INTERVAL_DATE;


	

	@Autowired
	private TaskService taskService;
	
	@BeforeClass
	public static void setUp() {
		task.setLabel(TASK_LABEL);
		user.setId(2L);
		task.setUser(user);

	    Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(INTERVAL_YEAR, INTERVAL_MONTH, INTERVAL_BEGINNING_DAY);
		BEGINNING_INTERVAL_DATE = calendar.getTime();
		calendar.set(INTERVAL_YEAR, INTERVAL_MONTH, INTERVAL_ENDING_DAY);
		ENDING_INTERVAL_DATE = calendar.getTime();
	    }


	@Test
	public void testListTasks() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.list()));
	}
	
	@Test
	public void testAddTaskSucceedWithLessThanTenTasksForFreeUser() {
		assertNotNull(taskService.add(task));
	}
	
	@Test
	public void testListAllTasksNotEndedDifferentFromListTasksNotEndedInInterval(){
		assertNotEquals(taskService.listNotEndedTasksOfUser(USER_ID_INTERVAL_TESTS).size(), taskService.listNotEndedTasksInIntervalOfUser(USER_ID_INTERVAL_TESTS, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE).size());
	}
	
	@Test
	public void testNotEndedTasksAreReturnedInInterval(){
		assertNotEquals(0, taskService.listNotEndedTasksInIntervalOfUser(USER_ID_INTERVAL_TESTS, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE).size());
	}

	@Test
	public void testAllTasksReturnedInIntervalAreNotEnded(){
		for(Task task : taskService.listNotEndedTasksInIntervalOfUser(USER_ID_INTERVAL_TESTS, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE))
			assertNull(task.getEndingDate());
	}
	
	@Test
	public void testEndAllTasksNotEndedReturnedInInterval(){
		taskService.endUserTasksEndingInInterval(3L, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE);
		assertEquals(0, taskService.listNotEndedTasksInIntervalOfUser(USER_ID_INTERVAL_TESTS, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE).size());
	}
}
	
