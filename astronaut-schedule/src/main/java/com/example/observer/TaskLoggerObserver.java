package com.example.observer;

import com.example.model.Task;

public class TaskLoggerObserver implements TaskObserver {

    @Override
    public void update(Task task, String message) {
        // Simple console logging
        System.out.println("[TaskLogger] Task ID: " + task.getId() + " | " + message);
    }

    @Override
    public void onTaskAdded(Task task) {

    }

    @Override
    public void onTaskUpdated(Task task) {

    }

    @Override
    public void onTaskDeleted(Task task) {

    }
}
