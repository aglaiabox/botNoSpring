package org.example.service.generateTask;

import org.example.database.Database;
import org.example.model.*;

public class KangTaskService extends AbstractTaskService {
    public KangTaskService(Database database) {
        super(database);
    }

    @Override
    public KangTask giveMeATask(Long chatId) {
        KangTask kangTask = database.getKangTaskByInd(1);
//        int indexOdTheCurrentKandTask = database.getUserFromDatabase(chatId).getIndexOfCurrentKangTask();
//        KangTask kangTask = database.getKangTaskByInd(indexOdTheCurrentKandTask);
//        if (kangTask == null){
//            throw new RuntimeException("There is no task");
//        }
        return kangTask;
    }
}
