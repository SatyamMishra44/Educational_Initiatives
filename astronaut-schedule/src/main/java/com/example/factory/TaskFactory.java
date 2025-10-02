package com.example.factory;

import com.example.model.Task;
import com.example.model.Priority;

import java.time.LocalTime;
import java.util.UUID;

public class TaskFactory {

    // Create a task with description, start/end time, and priority
    public static Task createTask(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        Task task = new Task(description, startTime, endTime, priority); // use constructor
        return task;
    }
}
