package org.example.service.generateTask;

import org.example.database.Database;
import org.example.model.GeneratedTask;
import org.example.model.TypeOfGeneratedTask;
import org.example.model.UserBot;

public class MultiplyTaskService extends AbstractTaskService {

    public MultiplyTaskService(Database database) {
        super(database);

    }

    @Override
    public GeneratedTask giveMeATask(Long chatId) {
        UserBot userBot = database.getUserFromDatabase(chatId);
        GeneratedTask generatedTaskOfUser = userBot.getActualGeneratedTask();

        if (generatedTaskOfUser!=null && generatedTaskOfUser.getTypeOfGeneratedTask().equals(TypeOfGeneratedTask.MULTIPLY)) {
            return database.getUserFromDatabase(chatId).getActualGeneratedTask();
        } else {
            return createNewTask(chatId);
        }
    }


     GeneratedTask createNewTask(Long chatId) {
        int intFirst = (int) (Math.random() * (10 - 3)) + 3;
        int intSecond = (int) (Math.random() * (10 - 3)) + 3;
        int res = intFirst * intSecond;

        String problem = intFirst + " * " + intSecond;
        String correctAnswer = Integer.toString(res);
        GeneratedTask generatedTask = new GeneratedTask(problem, correctAnswer, TypeOfGeneratedTask.MULTIPLY);
        database.addGeneratedTaskToUser(generatedTask, chatId);
        return generatedTask;
    }
}
