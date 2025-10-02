package com.example.observer;

import com.example.model.Task;

public interface TaskObserver {
    void update(Task task, String message);

    void onTaskAdded(Task task);
    void onTaskUpdated(Task task);
    void onTaskDeleted(Task task);
}
