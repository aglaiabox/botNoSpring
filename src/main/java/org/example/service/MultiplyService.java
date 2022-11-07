package org.example.service;

public class MultiplyService extends TaskService {

    public MultiplyService(){

    }

    @Override
    void createNewTask(Long chatId) {
        int intFirst = (int) (Math.random() * (10 - 3)) +3;
        int intSecond = (int) (Math.random() * (10 - 3)) +3;
        int res = intFirst*intSecond;
        super.task = new Task(chatId);
        super.task.task = intFirst+" * "+intSecond;
        super.task.correctAnswer = Integer.toString(res);
    }
}
