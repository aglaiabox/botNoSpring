package org.example.model;

public class TextTasks {
    String task;
    String a1;
    String a2;
    String a3;
    String a4;

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
