package hexlet.code.services;

import hexlet.code.dto.TaskDto;
import hexlet.code.model.Task;


public interface TaskService {
    Task createNewTask(TaskDto taskDto);
    Task updateTask(long id, TaskDto taskDto);
}