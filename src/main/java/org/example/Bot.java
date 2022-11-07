package org.example;

import org.example.commands.database.Database;
import org.example.commands.operation.CommandDivision;
import org.example.commands.operation.CommandMultiply;
import org.example.commands.menu.CommandHello;
import org.example.service.TaskService;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingCommandBot {
    Database database = new Database();

     final String BOT_NAME;
     final String BOT_USERNAME;
    final String BOT_TOKEN;
//    TaskService taskService = new TaskService();


    public Bot (String botName, String botUsername, String botToken){
        super();
        BOT_NAME = botName;
        BOT_USERNAME = botUsername;
        BOT_TOKEN = botToken;
//        register(new IBotCommand() {
//            @Override
//            public String getCommandIdentifier() {
//                return "sart";
//            }
//
//            @Override
//            public String getDescription() {
//                return "null";
//            }
//
//            @Override
//            public void processMessage(AbsSender absSender, Message message, String[] strings) {
//                MultiplyService multiplyService = new MultiplyService();
//                SendMessage answer = new SendMessage();
//                answer.setText("You are wellcome");
//                answer.setChatId(message.getChatId());
//                System.out.println("Answer is creating right now");
//                try {
//                    execute(answer);
//                } catch (TelegramApiException e) {
//                    //логируем сбой Telegram Bot API, используя userName
//                    System.out.println("somthing wrong: " + e.getMessage());
//                }
//            }
//        });
        register(new CommandHello("hello", "Начинаем решать примеры на умножение"));

        register(new CommandMultiply("multiply", "Задания на умножение"));
        register(new CommandDivision("division", "Задания на деление"));


    }
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        Long msgChatId = msg.getChatId();
        String userName = getBotUsername();
        SendMessage answer = new SendMessage();
        String text = "We have got your message: \n\n\""+ msg.getText()+"\" \n and we are thinking about it.";
        if (msg.getFrom().getId()==Long.parseLong("5654062987") ) {
            text = text+"\nVeronica I LOVE U";
        };
        if (msg.getFrom().getId()==Long.parseLong("452028459") ) {
            text = text+"\nAglaia, do U test me again?";
        };

//                getFirstName().equalsIgnoreCase("Ника")) text = text+"\nVeronica I LOVE U";
        answer.setText(text);
        answer.setChatId(msgChatId.toString());
        System.out.println("Answer is creating right now");
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя userName
            System.out.println("somthing wrong: " + e.getMessage());
        }

        System.out.println(update);
    }


    
}

