package org.example.service.commands.menu;

import org.example.Bot;
import org.example.database.Database;

public class MenuCommandHello extends AbstractMenuCommand {

    public static final String TEXT_TO_SEND_COM_HELLO = "Привет, добро пожаловать в наш бот." + System.lineSeparator() +
            "Если вы хотите тренировать умножение отправьте команду " + Bot.MULTIPLY + " ," + System.lineSeparator() +
            "если деление, то команду " + Bot.DIVISION + " ." + System.lineSeparator() +
            "если текстовую задачу из сборника Кенгуру, то команду " + Bot.KANG_TASK + " ." + System.lineSeparator() +
            "Хорошей тренировки!";

    public MenuCommandHello(String identifier, String description) {
        super(identifier, description,false);
        super.textToSend = TEXT_TO_SEND_COM_HELLO;
    }
}