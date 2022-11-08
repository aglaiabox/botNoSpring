package org.example.commands.menu;

import org.example.database.Database;
import org.example.service.MultiplyService;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandHello extends OperationCommandMenu {

    public CommandHello(String identifier, String description, Database database) {
        super(identifier, description, database, false);
        super.textToSend = "Привет, добро пожаловать в наш бот. \n" +
                "Если вы хотите тренировать умножение отправьте команду /multiply ,\n " +
                "если деление, то команду /division . \nХорошей тренировки";
    }
}