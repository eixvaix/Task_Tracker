package eu.itcrafters.myproject.controller;

import eu.itcrafters.myproject.dto.TaskDTO;
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
    public List<TaskDTO> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TaskDTO get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable Integer id, @RequestBody TaskDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}