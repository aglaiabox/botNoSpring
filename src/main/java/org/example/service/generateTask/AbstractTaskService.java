package org.example.service.generateTask;

import org.example.database.Database;
import org.example.model.AbstractTask;
import org.example.model.GeneratedTask;

public abstract class AbstractTaskService {
    Database database = Database.getInstance();

    public AbstractTaskService() {
    }

// отвечает за выдачу задания
    public abstract AbstractTask giveMeATask(Long chatId);

    // отвечает за проверку ответа
    public boolean checkAnswer(Long chatId, String answer) {
        AbstractTask abstractTask = database.getUserFromDatabase(chatId).getActualTask();
        if (answer.equalsIgnoreCase(abstractTask.getCorrectAnswer())) return true;
        return false;
    }
}
