package org.example.service.commands.menu;

import org.example.database.Database;

public class CommandHello extends OperationCommandMenu {

    public CommandHello(String identifier, String description, Database database) {
        super(identifier, description, database, false);
        super.textToSend = "Привет, добро пожаловать в наш бот. \n" +
                "Если вы хотите тренировать умножение отправьте команду /multiply ,\n " +
                "если деление, то команду /division . \nХорошей тренировки";
    }
}