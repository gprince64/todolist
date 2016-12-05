package fr.icdc.dei.todolist.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.persistence.dao.UserDao;
import fr.icdc.dei.todolist.service.TaskService;

@Controller
@RequestMapping("/tasks")
@SessionAttributes("")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	 private UserDao userDao;
	
	private Date beginningIntervalDate;
	private Date endingIntervalDate;
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ModelAndView listTasks() {
	        ModelAndView page = new ModelAndView("Tasks");
	        page.addObject("tasks", taskService.list());
	        return page;
	}
	
	@RequestMapping(value = "/findTasks", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView page = new ModelAndView("userForm");
        page.addObject("users", userDao.findAll());
        return page;
	}
	
	@RequestMapping(value = "/findTasks", method = RequestMethod.POST)
    public ModelAndView listNotEndedTasksInIntervalOfUser(@RequestParam long userId, @RequestParam Date beginningIntervalDate, @RequestParam Date endingIntervalDate) {
        this.beginningIntervalDate = beginningIntervalDate;
        this.endingIntervalDate = endingIntervalDate;

        ModelAndView page = new ModelAndView("NotEndedTasksOfUser");
        page.addObject("tasks", taskService.listNotEndedTasksInIntervalOfUser(userId, beginningIntervalDate, endingIntervalDate));
        page.addObject("userId", userId);
        page.addObject("user", userDao.findOne(userId));
        return page;
	}
	
	@RequestMapping(value = "/endTasks/{userId}", method = RequestMethod.POST)
    private ModelAndView finishAllTasksOfSelectedUserEndingInPeriod(@PathVariable long userId) {
        taskService.endUserTasksEndingInInterval(userId, beginningIntervalDate, endingIntervalDate);
        return new ModelAndView("redirect:" + "/tasks");

}

}
