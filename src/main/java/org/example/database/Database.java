package org.example.database;

import org.example.model.Task;
import org.example.model.TextTasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
    public static final Database DATABASE = new Database();
    public Map <Long, Task> mapa;
    public ArrayList <TextTasks> TextTastsList;

    public Database() {
        this.mapa = new HashMap<>();
    }

    public void addToMapa (Task task){
        mapa.put(task.chatId, task);
    }



//    public Task getTaskByChatId(Long chatId){
//        return mapa.get(chatId);
//    }

    private void addTextTastsToDataBase(){
        String textTask = "Андрей купил в магазине 20 тетрадей, 2 альбома для рисования, несколько карандашей по 6 р. 20 коп. и несколько ластиков по 4 рубля. Ему сказали, что в кассу следует уплатить 55 рублей 65 копеек. Андрей попросил пересчитать стоимость покупки и ошибка была устранена. Как Андрей догадался, что она была допущена?\n\n" +
                "К сожалению, у этой задачи нет простого ответа, который мог бы проверить робот. Поэтому если ты думаешь, что решил и хочешь посмотреть ответ, напиши слово answer";
        String help = "Это задание на четность и нечетность, подумай в эту сторону";
        String answer = "Количество и цена всех его покупок были четными, а результат - не четным.";
        String correctAnswer = "answer";
    }

}
