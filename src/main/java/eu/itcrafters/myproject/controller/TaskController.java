package eu.itcrafters.myproject.controller;

import eu.itcrafters.myproject.dto.TaskDTO;
import eu.itcrafters.myproject.entity.Task;
import eu.itcrafters.myproject.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Task one(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Task create(@RequestBody TaskDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Integer id, @RequestBody TaskDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}