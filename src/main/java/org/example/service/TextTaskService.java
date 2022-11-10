package org.example.service;

import org.example.database.Database;

public class TextTaskService extends TaskService{
    Database database;
    public TextTaskService(Database database) {
        super(database);
    }

    @Override
    void createNewTask(Long chatId) {

    }
}
