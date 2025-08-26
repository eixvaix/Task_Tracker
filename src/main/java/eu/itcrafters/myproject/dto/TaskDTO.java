package eu.itcrafters.myproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(name = "Task")
public class TaskDTO {

    @Schema(example = "1", description = "Task ID (server-generated)")
    private Integer id;

    @Schema(example = "Write documentation", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(example = "Prepare README and API usage docs")
    private String description;

    @Schema(type = "string", format = "date", example = "2025-09-15")
    private LocalDate dueDate;

    @Schema(example = "high", allowableValues = {"low","medium","high"})
    private String priority;

    @Schema(example = "open", allowableValues = {"open","in_progress","done"})
    private String status;

    @Schema(description = "Creator user ID", example = "1")
    private Integer createdById;

    // --- getters & setters ---

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getCreatedById() { return createdById; }
    public void setCreatedById(Integer createdById) { this.createdById = createdById; }
}