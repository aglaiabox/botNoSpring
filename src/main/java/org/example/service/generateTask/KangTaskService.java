package org.example.service.generateTask;

import org.example.model.*;

public class KangTaskService extends AbstractTaskService {
    public KangTaskService() {
        super();
    }

    @Override
    public KangTask giveMeATask(Long chatId) {

        UserBot userBot = database.getUserFromDatabase(chatId);
        KangTask kangTask = database.getKangTaskByInd(userBot.getIndexOfCurrentKangTask());
        userBot.setActualTask(kangTask);

        return kangTask;
    }

}
