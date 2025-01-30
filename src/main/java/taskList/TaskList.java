package taskList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskList {
    private final HashMap<LocalDate, List<String>> tasksByDeadline = new HashMap<>();
    public List<String> getTasksToDoByDeadline(LocalDate deadline) {
        return tasksByDeadline.getOrDefault(deadline, new ArrayList<>());
    }

    public void addTask(String task, LocalDate deadline) {
        List<String> tasksForDeadline = getTasksToDoByDeadline(deadline);
        if (tasksForDeadline.contains(task))
            throw new TaskAlreadyExistsException();

        tasksForDeadline.add(task);
        tasksByDeadline.put(deadline, tasksForDeadline);
    }

    public void removeTask(String task, LocalDate deadline) {
        List<String> tasksForDeadline = getTasksToDoByDeadline(deadline);
        if(!tasksForDeadline.contains(task))
            throw new TaskNotFoundException();

        tasksForDeadline.remove(task);
    }
}
