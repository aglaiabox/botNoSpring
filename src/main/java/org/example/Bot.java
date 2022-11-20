package org.example;

import org.example.database.Database;
import org.example.model.UserBot;
import org.example.service.commands.operation.OperationCommandDivide;
import org.example.service.commands.operation.OperationCommandKang;
import org.example.service.commands.operation.OperationCommandMultiply;
import org.example.service.commands.menu.MenuCommandHello;
import org.example.model.AbstractTask;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingCommandBot {
    public static final String MULTIPLY = "/multiply";
    public static final String DIVISION = "/division";
    public static final String KANG_TASK = "/kangaroo";
    public static final String TRY_AGAIN = "Try again";
    public static final String RIGHT_ANSWER = "Great job! You are right!" + System.lineSeparator() +
            " What do you want next:" + System.lineSeparator() +
            MULTIPLY + System.lineSeparator() + DIVISION + System.lineSeparator() + KANG_TASK;
    public static final String DON_T_HAVE_AN_ACTIVE_TASK = "You don't have an active task. PLease tell me /hello for getting one";
    public static final String VERONICA_HI = "Veronica, hi! ";
    public static final String VERONICA_I_LOVE_U = "Post Scriptum: I LOVE U";
    public static final String VERONICAs_ID = "5654062987";
    public static final String HI_THERE = ", hi there and welcome! my name is Math bot and I'm ready to give your new interesting math tasks!";

    Database database = Database.getInstance();

    final String BOT_NAME;
    final String BOT_USERNAME;
    final String BOT_TOKEN;


    public Bot(String botName, String botUsername, String botToken) {
        super();
        BOT_NAME = botName;
        BOT_USERNAME = botUsername;
        BOT_TOKEN = botToken;

        register(new MenuCommandHello("hello", "Начинаем решать примеры на умножение", database));

        register(new OperationCommandMultiply("multiply", "Задания на умножение", database));
        register(new OperationCommandDivide("division", "Задания на деление", database));
        register(new OperationCommandKang("kangaroo", "Задания Кенгуру", database));

//        register(new OperationCommandA("/a", "выбран ответ а",database));


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


        String text = "";
        if (database.isUserHaveActualGeneratedTask(msgChatId)) {
            AbstractTask abstractTask = database.getUserFromDatabase(msgChatId).getActualGeneratedTask();

            if (msg.getText().equalsIgnoreCase(abstractTask.getCorrectAnswer())) {
                text = RIGHT_ANSWER;

                database.getUserFromDatabase(msgChatId).setActualGeneratedTask(null);
            } else {
                text = TRY_AGAIN;
            }

        } else {
            text = DON_T_HAVE_AN_ACTIVE_TASK;
            if (msg.getFrom().getId() == Long.parseLong(VERONICAs_ID)) {
                text = VERONICA_HI + text + System.lineSeparator() + VERONICA_I_LOVE_U;
            }
            ;
//        if (msg.getFrom().getId()==Long.parseLong("452028459") ) {
//            text = text+"\nAglaia, do U test me again?";
//        };
        }


        answer.setText(text);
        answer.setChatId(msgChatId.toString());
        try {
            execute(answer);

        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя userName
            System.out.println("TelegramApiException e: " + e.getMessage());
        }

        System.out.println(update);
    }


}

