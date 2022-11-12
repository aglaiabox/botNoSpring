package org.example.model;

import org.example.database.Database;

public class Task {
    public String task;
    String correctAnswer;
    public Long chatId;

    public Task(String task, String correctAnswer,
                Long chatId,
                Database database) {
        this.task = task;
        this.correctAnswer = correctAnswer;
        this.chatId = chatId;
        database.addToMapa(this);
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
