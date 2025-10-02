package com.example.cli;

import com.example.model.Priority;
import com.example.model.TaskStatus;
import com.example.manager.TaskManager;
import com.example.model.Task;
import com.example.observer.TaskLoggerObserver;


import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TaskCLI {

    private final TaskManager taskManager;
    private final Scanner scanner;

    public TaskCLI() {
        this.taskManager = new TaskManager();
        this.taskManager.registerObserver(new TaskLoggerObserver()); // add logging observer
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Welcome to the Astronaut Task Scheduler CLI ===");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> filterByStatus();
                case 6 -> filterByPriority();
                case 0 -> {
                    running = false;
                    System.out.println("Exiting Task Scheduler. Goodbye!");
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Task");
        System.out.println("2. List All Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Filter Tasks by Status");
        System.out.println("6. Filter Tasks by Priority");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void addTask() {
        try {
            System.out.print("Enter task description: ");
            String description = scanner.nextLine();

            System.out.print("Enter start time (HH:mm): ");
            LocalTime startTime = LocalTime.parse(scanner.nextLine().trim());

            System.out.print("Enter end time (HH:mm): ");
            LocalTime endTime = LocalTime.parse(scanner.nextLine().trim());


            System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
            Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

            Task task = taskManager.addTask(description, startTime, endTime, priority);
            System.out.println("Task added successfully with ID: " + task.getId());
        } catch (Exception e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }


    private void listTasks() {
        List<Task> tasks = taskManager.getAllTasksSortedByStartTime(); // updated
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }


    private void updateTask() {
        System.out.print("Enter Task ID: ");
        UUID id = UUID.fromString(scanner.nextLine());

        System.out.print("Update (1: Status, 2: Priority): ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.print("Enter new status (PENDING, IN_PROGRESS, COMPLETED): ");
            TaskStatus status = TaskStatus.valueOf(scanner.nextLine().toUpperCase());
            taskManager.updateStatus(id, status);
            System.out.println("Task status updated.");
        } else if (option == 2) {
            System.out.print("Enter new priority (LOW, MEDIUM, HIGH): ");
            Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
            taskManager.updatePriority(id, priority);
            System.out.println("Task priority updated.");
        } else {
            System.out.println("Invalid option.");
        }
    }

    private void deleteTask() {
        System.out.print("Enter Task ID: ");
        UUID id = UUID.fromString(scanner.nextLine());
        taskManager.removeTask(id); // updated
        System.out.println("Task deleted.");
    }


    private void filterByStatus() {
        System.out.print("Enter status (PENDING, IN_PROGRESS, COMPLETED): ");
        TaskStatus status = TaskStatus.valueOf(scanner.nextLine().toUpperCase());

        List<Task> tasks = taskManager.getTasksByStatus(status);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found with status: " + status);
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private void filterByPriority() {
        System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
        Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

        List<Task> tasks = taskManager.getTasksByPriority(priority);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found with priority: " + priority);
        } else {
            tasks.forEach(System.out::println);
        }
    }
}
