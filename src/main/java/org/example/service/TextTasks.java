package org.example.service;

public class TextTasks {
    String task;
    String correctAnswer;
    String fullAnswer;

    String help;

    public TextTasks(String task, String fullAnswer, String help, String correctAnswer) {
        this.task = task;
        this.fullAnswer = fullAnswer;
        this.correctAnswer = correctAnswer;
        this.help = help;
    }
}
