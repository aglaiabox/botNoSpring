package org.example;

import org.example.database.Database;
import org.example.model.UserBot;
import org.example.service.ActiveTaskService;
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


    final String BOT_NAME;
    final String BOT_USERNAME;
    final String BOT_TOKEN;


    public Bot(String botName, String botUsername, String botToken) {
        super();
        BOT_NAME = botName;
        BOT_USERNAME = botUsername;
        BOT_TOKEN = botToken;

        register(new MenuCommandHello("hello", "???????????????? ???????????? ?????????????? ???? ??????????????????"));

        register(new OperationCommandMultiply("multiply", "?????????????? ???? ??????????????????"));
        register(new OperationCommandDivide("division", "?????????????? ???? ??????????????"));
        register(new OperationCommandKang("kangaroo", "?????????????? ??????????????"));

//        register(new OperationCommandA("/a", "???????????? ?????????? ??",database));


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
        SendMessage answer = new SendMessage();

        ActiveTaskService ats = new ActiveTaskService();

        String text = ats.checkAnAnswer(update);

        answer.setText(text);
        answer.setChatId(msgChatId.toString());
        try {
            execute(answer);

        } catch (TelegramApiException e) {
            //???????????????? ???????? Telegram Bot API, ?????????????????? userName
            System.out.println("TelegramApiException e: " + e.getMessage());
        }

    }


}

