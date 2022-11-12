package org.example.service.commands.operation;

import org.example.service.MultiplyService;
import org.example.service.TaskService;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class OperationCommand implements IBotCommand {

    private String identifier;
    private String description;
    protected TaskService taskService;

    OperationCommand (String identifier, String description) {
        super();
        this.description = description;
        this.identifier = identifier;
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
        SendMessage answer = new SendMessage();
        answer.setText(taskService.getTask(message.getChatId()));
        answer.setChatId(message.getChatId());
        System.out.println("task was send");


        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            System.out.println("Exception: "+e.getMessage());
            //логируем сбой Telegram Bot API, используя commandName и userName
        }




    }
}
