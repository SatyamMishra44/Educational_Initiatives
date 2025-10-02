package com.example.model;

import java.time.LocalTime;
import java.util.UUID;

public class Task {
    private UUID id;                  // Unique ID
    private String description;       // Task description
    private Priority priority;        // Task priority
    private LocalTime startTime;      // Task start time
    private LocalTime endTime;        // Task end time
    private TaskStatus status;        // Task status: PENDING, IN_PROGRESS, COMPLETED

    // Constructor for adding a new task
    public Task(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.status = TaskStatus.PENDING; // default value
    }

    // Empty constructor (optional)
    public Task() {}

    // Getters and Setters
    public UUID getId() { return id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]"
                + " (" + status + ")";
    }
}
