package hexlet.code.services.implementation;

import hexlet.code.dto.TaskStatusDto;
import hexlet.code.model.TaskStatus;
import hexlet.code.repository.TaskStatusRepository;
import hexlet.code.services.TaskStatusService;

public class TaskStatusServiceImpl implements TaskStatusService {
    private final TaskStatusRepository taskStatusRepository;

    public TaskStatusServiceImpl(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    public TaskStatus createNewStatus(TaskStatusDto statusDto) {
        final TaskStatus taskStatus = new TaskStatus();
        taskStatus.setName(statusDto.getName());
        return taskStatusRepository.save(taskStatus);
    }

    @Override
    public TaskStatus updateStatus(long id, TaskStatusDto statusDto) {
        final TaskStatus taskStatusToUpdate = taskStatusRepository.findById(id).get();
        taskStatusToUpdate.setName(statusDto.getName());
        return taskStatusRepository.save(taskStatusToUpdate);
    }
}
