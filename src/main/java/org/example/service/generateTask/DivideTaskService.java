package org.example.service.generateTask;

import org.example.database.Database;
import org.example.model.AbstractTask;
import org.example.model.GeneratedTask;
import org.example.model.TypeOfGeneratedTask;
import org.example.model.UserBot;

public class DivideTaskService extends AbstractTaskService {

    public DivideTaskService(Database database) {
        super(database);
    }

    @Override
    public GeneratedTask giveMeATask(Long chatId) {
        UserBot userBot = database.getUserFromDatabase(chatId);
        GeneratedTask generatedTaskOfUser = userBot.getActualGeneratedTask();

        if (generatedTaskOfUser != null && generatedTaskOfUser.getTypeOfGeneratedTask().equals(TypeOfGeneratedTask.DIVIDE)) {
            return database.getUserFromDatabase(chatId).getActualGeneratedTask();
        } else {
            return createNewTask(chatId);
        }
    }

    public GeneratedTask createNewTask(Long chatId) {
        int intFirst = (int) (Math.random() * (9 - 3)) + 3;
        int intSecond = (int) (Math.random() * (9 - 3)) + 3;
        int res = intFirst * intSecond;
        String problem = res + " / " + intSecond;
        String correctAnswer = Integer.toString(intFirst);
        GeneratedTask generatedTask = new GeneratedTask(problem, correctAnswer, TypeOfGeneratedTask.DIVIDE);
        database.addGeneratedTaskToUser(generatedTask, chatId);
        return generatedTask;
    }
}