package com.example.observer;

import com.example.model.Task;

public interface TaskSubject {
    void registerObserver(TaskObserver observer);
    void removeObserver(TaskObserver observer);
    void notifyTaskAdded(Task task);
    void notifyTaskUpdated(Task task);
    void notifyTaskDeleted(Task task);
}
