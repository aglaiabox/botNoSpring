package org.example.service.commands.menu;

import org.example.database.Database;
import org.example.service.TaskService;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class OperationCommandMenu implements IBotCommand {

    private String identifier;
    private String description;
    protected String textToSend;
    boolean keepActiveTask;
    Database database;

    OperationCommandMenu(String identifier, String description, Database database, boolean keepActiveTask) {
        super();
        this.description = description;
        this.identifier = identifier;
        this.database = database;
        this.keepActiveTask = keepActiveTask;
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
        answer.setText(textToSend);
        answer.setChatId(message.getChatId());
        System.out.println("point was chosen");

        if (!keepActiveTask){
            database.mapa.remove(message.getChatId());
        }

        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            System.out.println("Exception: "+e.getMessage());
            //логируем сбой Telegram Bot API, используя commandName и userName
        }


    }
}
