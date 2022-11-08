package org.example.service;

import org.example.database.Database;

public class MultiplyService extends TaskService {

    public MultiplyService(Database database){
        super(database);

    }

    @Override
    void createNewTask(Long chatId) {
        int intFirst = (int) (Math.random() * (10 - 3)) +3;
        int intSecond = (int) (Math.random() * (10 - 3)) +3;
        int res = intFirst*intSecond;

        String taskQuest = intFirst+" * "+intSecond;
        String correctAnswer = Integer.toString(res);
        new Task(taskQuest, correctAnswer, chatId, database);
    }
}
