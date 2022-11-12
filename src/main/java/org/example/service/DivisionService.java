package org.example.service;

import org.example.database.Database;
import org.example.model.Task;

public class DivisionService extends TaskService {

    public DivisionService(Database database){
        super(database);

    }

    @Override
    void createNewTask(Long chatId) {
        int intFirst = (int) (Math.random() * (9 - 3)) +3;
        int intSecond = (int) (Math.random() * (9 - 3)) +3;
        int res = intFirst*intSecond;
        String taskQuest = res+" / "+intSecond;
        String correctAnswer = Integer.toString(intFirst);
        new Task(taskQuest, correctAnswer, chatId, database);
        }
}