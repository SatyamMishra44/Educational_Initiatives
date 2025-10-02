package com.example.manager;

import com.example.factory.TaskFactory;
import com.example.model.Priority;
import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.observer.TaskObserver;
import com.example.observer.TaskSubject;
import com.example.exceptions.InvalidTaskException;
import com.example.exceptions.TaskNotFoundException;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager implements TaskSubject {
    private final Map<UUID, Task> taskMap = new HashMap<>();
    private final List<TaskObserver> observers = new ArrayList<>();

    // Observer methods
    @Override
    public void registerObserver(TaskObserver observer) { observers.add(observer); }
    @Override
    public void removeObserver(TaskObserver observer) { observers.remove(observer); }
    @Override
    public void notifyTaskAdded(Task task) { observers.forEach(o -> o.onTaskAdded(task)); }
    @Override
    public void notifyTaskUpdated(Task task) { observers.forEach(o -> o.onTaskUpdated(task)); }
    @Override
    public void notifyTaskDeleted(Task task) { observers.forEach(o -> o.onTaskDeleted(task)); }

    // Add Task with conflict validation
    public Task addTask(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        if (description == null || description.trim().isEmpty())
            throw new InvalidTaskException("Task description cannot be empty.");

        // Check for time conflicts
        for (Task t : taskMap.values()) {
            if (!(endTime.isBefore(t.getStartTime()) || startTime.isAfter(t.getEndTime()))) {
                throw new InvalidTaskException("Time conflict with task: " + t.getDescription());
            }
        }

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        taskMap.put(task.getId(), task);
        notifyTaskAdded(task);
        return task;
    }

    // Remove task
    public void removeTask(UUID id) {
        Task task = getTask(id);
        taskMap.remove(id);
        notifyTaskDeleted(task);
    }

    // Get task by ID
    public Task getTask(UUID id) {
        Task task = taskMap.get(id);
        if (task == null) throw new TaskNotFoundException("Task with ID " + id + " not found.");
        return task;
    }

    // Update task status
    public void updateStatus(UUID id, TaskStatus status) {
        Task task = getTask(id);
        task.setStatus(status);
        notifyTaskUpdated(task);
    }

    // Update task priority
    public void updatePriority(UUID id, Priority priority) {
        Task task = getTask(id);
        task.setPriority(priority);
        notifyTaskUpdated(task);
    }

    // Get all tasks sorted by start time (ascending)
    public List<Task> getAllTasksSortedByStartTime() {
        return taskMap.values().stream()
                .sorted(Comparator.comparing(Task::getStartTime))
                .collect(Collectors.toList());
    }

    // Get tasks by status
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskMap.values().stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());
    }

    // Get tasks by priority
    public List<Task> getTasksByPriority(Priority priority) {
        return taskMap.values().stream()
                .filter(t -> t.getPriority() == priority)
                .collect(Collectors.toList());
    }
}
