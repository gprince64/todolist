-- TaskServiceTest
-- testlistThreeLastTasks
-- ID_ACCOUNT_TYPE = 1L
INSERT INTO TA_ACCOUNT_TYPE(label) VALUES('FREE');
-- ID_USER = 1L
INSERT INTO user(name, USER_TYPE) VALUES('testNameUser', 'USER_FREE');
-- ID_CATEGORY = 1L
INSERT INTO category(name) VALUES('testNameCategory');
-- ID_TASK = 1L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask1DB', 1);
-- ID_TASK = 2L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask2DB', 1);
-- ID_TASK = 3L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask3DB', 1);
-- testAddTaskWithLessThanTenTasksForFreeUser
-- ID_USER = 2L
INSERT INTO user(name, USER_TYPE) VALUES('AddTaskWithLessThanTenTasksForFreeUser', 'USER_FREE');
--testListAllTasksNotEndedDifferentFromListTasksNotEndedInInterval
--testEndAllTasksNotEndedReturnedInInterval
-- Interval = 15/11 --> 20/11
-- ID_USER = 3L
INSERT INTO user(name, USER_TYPE) VALUES('testListAllTasksNotEndedDifferentFromListTasksNotEndedInInterval', 'USER_FREE');
-- ID_TASK = 4L
INSERT INTO task(label, id_user, previsionalEndingDate) VALUES('TaskNotEndedInInterval1', 3, '2016-11-15 18:19:03');
-- ID_TASK = 5L
INSERT INTO task(label, id_user, previsionalEndingDate) VALUES('TaskNotEndedInInterval2', 3, '2016-11-15 18:19:03');
-- ID_TASK = 6L
INSERT INTO task(label, id_user, previsionalEndingDate) VALUES('TaskNotEndedNotInInterval', 3, '2016-11-10 18:19:03');
-- ID_TASK = 7L
INSERT INTO task(label, id_user, previsionalEndingDate, endingDate) VALUES('TaskEndedInInterval', 3, '2016-11-10 18:19:03', '2016-11-17 18:19:03');

