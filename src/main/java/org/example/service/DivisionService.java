package org.example.service;

public class DivisionService extends TaskService {

    public DivisionService(){

    }

    @Override
    void createNewTask(Long chatId) {
        int intFirst = (int) (Math.random() * (9 - 3)) +3;
        int intSecond = (int) (Math.random() * (9 - 3)) +3;
        int res = intFirst*intSecond;
        super.task = new Task(chatId);
        super.task.task = res+" / "+intSecond;
        super.task.correctAnswer = Integer.toString(intSecond);
    }
}