package org.example.service.commands.operation;

import org.example.database.Database;
import org.example.service.generateTask.KangTaskService;

public class OperationCommandKang extends AbstractOperationCommand {

    public OperationCommandKang(String identifier, String description, Database database) {
        super(identifier, description, database);
        super.abstractTaskService = new KangTaskService(database);
    }
}
