package org.example.database;

import org.example.service.Task;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public static final Database DATABASE = new Database();
    public Map <Long, Task> mapa;

    public Database() {
        this.mapa = new HashMap<>();
    }

    public void addToMapa (Task task){
        mapa.put(task.chatId, task);
    }

//    public Task getTaskByChatId(Long chatId){
//        return mapa.get(chatId);
//    }

}
