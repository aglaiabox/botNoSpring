package org.example.service;

import org.example.database.Database;

public abstract class TaskService {
//    public static final TaskService INSTANCE = new TaskService();


    Database database;

    public TaskService(Database database){
        this.database = database;
    }

    public String getTask(Long chatId) {
        createNewTask(chatId);

        return database.mapa.get(chatId).task;
    }

    abstract void createNewTask(Long chatId);
}
