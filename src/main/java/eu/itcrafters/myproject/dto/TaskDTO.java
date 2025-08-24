package eu.itcrafters.myproject.dto;

import java.time.LocalDate;

public class TaskDTO {
    //public Integer id;
    public String title;
    public String description;
    public LocalDate dueDate;
    public String priority;
    public String status;
    public Integer createdById; // optional
}