package org.example.service.commands.operation;

import org.example.database.Database;
import org.example.model.AbstractTask;
import org.example.model.UserBot;
import org.example.service.generateTask.AbstractTaskService;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractOperationCommand implements IBotCommand {

    private String identifier;
    private String description;
    protected AbstractTaskService abstractTaskService;
    Database database;

    AbstractOperationCommand(String identifier, String description, Database database) {
        super();
        this.description = description;
        this.identifier = identifier;
        this.database = database;
    }

    @Override
    public String getCommandIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {

        UserBot userBot = database.getUserFromDatabase(message.getChatId());
        System.out.println(userBot.getChatId());

        SendMessage answer = new SendMessage();
        AbstractTask task = abstractTaskService.giveMeATask(message.getChatId());
        answer.setText(task.getProblem());
        answer.setChatId(message.getChatId());

        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            System.out.println("Exception: " + e.getMessage());
            //логируем сбой Telegram Bot API, используя commandName и userName
        }

    }
}
