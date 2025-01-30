package taskList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import taskList.TaskAlreadyExistsException;
import taskList.TaskList;
import taskList.TaskNotFoundException;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    private final LocalDate ANY_DEADLINE = LocalDate.of(2023, 4, 5);
    private final LocalDate ANY_OTHER_DEADLINE = LocalDate.of(2025, 1, 29);
    private final String ANY_TASK = "Nettoyer plancher";
    private final String ANY_OTHER_TASK = "Sortir les poubelles";
    private TaskList taskList;

    @BeforeEach
    public void createTaskList(){
        taskList = new TaskList();
    }

    @Test
    public void givenNoTask_whenGettingTasks_thenListIsEmpty(){
        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

        assertTrue(tasks.isEmpty());
    }

//    @Test
//    public void givenATask_whenGettingTasksWithSameDeadline_thenReturnTheTask(){
//        taskList.addTask(ANY_TASK, ANY_DEADLINE);
//
//        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);
//
//        assertEquals(1, tasks.size());
//        assertTrue(tasks.contains(ANY_TASK));
//    }

    @Test
    public void givenATask_whenGettingTasksWithDifferentDeadline_thenListIsEmpty(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_OTHER_DEADLINE);

        assertTrue(tasks.isEmpty());
    }

    @Test
    public void givenMultipleTaskWithDifferentDeadline_whenGettingTasksWithDeadline_thenReturnTasksWithDeadline(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);
        taskList.addTask(ANY_OTHER_TASK, ANY_OTHER_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(ANY_TASK));
    }

    @Test
    public void givenMultipleTaskWithSameDeadline_whenGettingTasksWithDeadline_thenReturnAllTasks(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);
        taskList.addTask(ANY_OTHER_TASK, ANY_DEADLINE);
        int tasksNumber = 2;

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);

        assertEquals(tasksNumber, tasks.size());
        assertTrue(tasks.contains(ANY_TASK));
        assertTrue(tasks.contains(ANY_OTHER_TASK));
    }

    @Test
    public void givenATask_whenAddingSameTaskWithSameDeadline_thenThrowTaskAlreadyExistsException(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);

        Executable addSameTask = () -> taskList.addTask(ANY_TASK, ANY_DEADLINE);

        assertThrows(TaskAlreadyExistsException.class, addSameTask);
    }

//    @Test
//    public void givenAnAddedTask_whenRemovingSameTask_thenListForDeadlineIsEmpty(){
//        taskList.addTask(ANY_TASK, ANY_DEADLINE);
//
//        taskList.removeTask(ANY_TASK, ANY_DEADLINE);
//
//        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);
//        assertTrue(tasks.isEmpty());
//    }

    @Test
    public void givenMultipleAddedTasks_whenRemovingATask_thenRemoveOnlyTheTask(){
        taskList.addTask(ANY_TASK, ANY_DEADLINE);
        taskList.addTask(ANY_OTHER_TASK, ANY_DEADLINE);
        int remainingTasksNumber = 1;

        taskList.removeTask(ANY_TASK, ANY_DEADLINE);

        List<String> tasks = taskList.getTasksToDoByDeadline(ANY_DEADLINE);
        assertEquals(remainingTasksNumber, tasks.size());
        assertTrue(tasks.contains(ANY_OTHER_TASK));
    }

    @Test
    public void givenNoTask_whenRemovingATask_thenThrowTaskNotFoundException(){
        Executable removeTask = () -> taskList.removeTask(ANY_TASK, ANY_DEADLINE);

        assertThrows(TaskNotFoundException.class, removeTask);
    }

}
