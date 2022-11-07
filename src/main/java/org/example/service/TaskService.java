package org.example.service;

public abstract class TaskService {
//    public static final TaskService INSTANCE = new TaskService();

    Task task;

    public String getTask(Long chatId) {
        createNewTask(chatId);

        return task.task;
    }

    public String getCorrectAnswer() {
        return task.correctAnswer;
    }

    abstract void createNewTask(Long chatId);
}
