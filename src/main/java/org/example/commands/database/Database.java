package org.example.commands.database;

import org.example.service.Task;

import java.util.HashMap;
import java.util.Map;

public class Database {
    Database database = new Database();

    Map <Long, Task> mapa = new HashMap<>();

    void addToMapa (Task task){
        mapa.put(task.chatId, task);
    }
}
