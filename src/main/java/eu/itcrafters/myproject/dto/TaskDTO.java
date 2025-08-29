package eu.itcrafters.myproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Schema(name = "Task")
public class TaskDTO {

    @Schema(
            description = "Task ID",
            type = "integer",
            format = "int32",
            accessMode = Schema.AccessMode.READ_ONLY, // <-- hiding "id" field
            example = "1"                             // <-- showing example "1" for "id"
    )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // <-- forbitten to show '"id" field' in POST
    private Integer id;

    @Schema(example = "Write documentation", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(example = "Prepare README and API usage docs")
    private String description;

    @Schema(type = "string", format = "date", example = "2025-09-15")
    private LocalDate dueDate;

    @Schema(example = "high", allowableValues = {"low", "medium", "high"})
    private String priority;

    @Schema(example = "open", allowableValues = {"open", "in_progress", "done"})
    private String status;

    @Schema(description = "Creator user ID", example = "1")
    private Integer createdById;

}