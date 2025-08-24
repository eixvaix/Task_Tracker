package eu.itcrafters.myproject.service;

import eu.itcrafters.myproject.dto.TaskDTO;
import eu.itcrafters.myproject.entity.AppUser;
import eu.itcrafters.myproject.entity.Task;
import eu.itcrafters.myproject.repository.AppUserRepository;
import eu.itcrafters.myproject.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final AppUserRepository userRepo;

    public TaskService(TaskRepository taskRepo, AppUserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    public Task findById(Integer id) {
        return taskRepo.findById(id).orElseThrow();
    }

    public Task create(TaskDTO dto) {
        Task t = new Task();
        t.setTitle(dto.title);
        t.setDescription(dto.description);
        t.setDueDate(dto.dueDate);
        t.setPriority(dto.priority);
        t.setStatus(dto.status);
        if (dto.createdById != null) {
            AppUser u = userRepo.findById(dto.createdById).orElseThrow();
            t.setCreatedBy(u);
        }
        return taskRepo.save(t);
    }

    public Task update(Integer id, TaskDTO dto) {
        Task t = findById(id);
        if (dto.title != null) t.setTitle(dto.title);
        if (dto.description != null) t.setDescription(dto.description);
        if (dto.dueDate != null) t.setDueDate(dto.dueDate);
        if (dto.priority != null) t.setPriority(dto.priority);
        if (dto.status != null) t.setStatus(dto.status);
        if (dto.createdById != null) {
            AppUser u = userRepo.findById(dto.createdById).orElseThrow();
            t.setCreatedBy(u);
        }
        return taskRepo.save(t);
    }

    public void delete(Integer id) {
        taskRepo.deleteById(id);
    }
}