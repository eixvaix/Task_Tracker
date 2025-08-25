package eu.itcrafters.myproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class TaskDTO {

    @Schema(example = "Write documentation")
    public String title;

    @Schema(example = "Add full project README")
    public String description;

    @Schema(type = "string", format = "date", example = "2025-09-01")
    public LocalDate dueDate;

    @Schema(example = "high", allowableValues = {"low","medium","high"})
    public String priority;

    @Schema(example = "open", allowableValues = {"open","in_progress","done"})
    public String status;

    @Schema(description = "Creator user ID", example = "1")
    public Integer createdById; // optional
}