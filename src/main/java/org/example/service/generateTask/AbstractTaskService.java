package org.example.service.generateTask;

import org.example.database.Database;
import org.example.model.AbstractTask;
import org.example.model.GeneratedTask;

public abstract class AbstractTaskService {
    Database database;

    public AbstractTaskService(Database database) {
        this.database = database;
    }


    public abstract AbstractTask giveMeATask(Long chatId);

}
