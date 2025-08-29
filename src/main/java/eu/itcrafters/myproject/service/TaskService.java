package eu.itcrafters.myproject.service;

import eu.itcrafters.myproject.dto.TaskDTO;
import eu.itcrafters.myproject.entity.AppUser;
import eu.itcrafters.myproject.entity.Task;
import eu.itcrafters.myproject.infrastructure.rest.exception.DataNotFoundException;
import eu.itcrafters.myproject.repository.AppUserRepository;
import eu.itcrafters.myproject.repository.TaskRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final AppUserRepository userRepo;

    public TaskService(TaskRepository taskRepo, AppUserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    // ---------- Mapping ----------

    private TaskDTO toDto(Task t) {
        TaskDTO dto = new TaskDTO();
        dto.setId(t.getId());
        dto.setTitle(t.getTitle());
        dto.setDescription(t.getDescription());
        dto.setDueDate(t.getDueDate());
        dto.setPriority(t.getPriority());
        dto.setStatus(t.getStatus());
        dto.setCreatedById(t.getCreatedBy() != null ? t.getCreatedBy().getId() : null);
        return dto;
    }

    private void apply(Task t, TaskDTO dto) {
        if (dto.getTitle() != null) t.setTitle(dto.getTitle());
        if (dto.getDescription() != null) t.setDescription(dto.getDescription());
        if (dto.getDueDate() != null) t.setDueDate(dto.getDueDate());
        if (dto.getPriority() != null) t.setPriority(dto.getPriority());
        if (dto.getStatus() != null) t.setStatus(dto.getStatus());
        if (dto.getCreatedById() != null) {
            AppUser u = userRepo.findById(dto.getCreatedById())
                    .orElseThrow(() -> new DataNotFoundException("User not found: " + dto.getCreatedById()));
            t.setCreatedBy(u);
        }
    }

    // ---------- API methods ----------

    @Transactional(readOnly = true)
    public List<TaskDTO> findAll() {
        return taskRepo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskDTO findById(Integer id) {
        Task t = taskRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Task not found: " + id));
        return toDto(t);
    }

    @Transactional
    public TaskDTO create(TaskDTO dto) {
        Task t = new Task();
        apply(t, dto);
        return toDto(taskRepo.save(t));
    }

    @Transactional
    public TaskDTO update(Integer id, TaskDTO dto) {
        Task t = taskRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Task not found: " + id));
        apply(t, dto);
        return toDto(taskRepo.save(t));
    }

    @Transactional
    public void delete(Integer id) {
        try {
            taskRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new DataNotFoundException("Task not found: " + id);
        }
    }
}