package org.example.service.generateTask;

import org.example.model.AbstractTask;
import org.example.model.GeneratedTask;
import org.example.model.TypeOfGeneratedTask;
import org.example.model.UserBot;

public class DivideTaskService extends AbstractTaskService {

    public DivideTaskService() {
        super();
    }

    @Override
    public AbstractTask giveMeATask(Long chatId) {
        UserBot userBot = database.getUserFromDatabase(chatId);
        AbstractTask actualTask = userBot.getActualTask();


        if (actualTask != null && actualTask.getClass().equals(GeneratedTask.class) && ((GeneratedTask) actualTask).getTypeOfGeneratedTask().equals(TypeOfGeneratedTask.DIVIDE)) {
            return database.getUserFromDatabase(chatId).getActualTask();
        } else {
            return generateNewTask(chatId);
        }
    }

    public GeneratedTask generateNewTask(Long chatId) {
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