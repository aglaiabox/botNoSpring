package org.example.service.commands.operation;

import org.example.database.Database;
import org.example.service.generateTask.MultiplyTaskService;

public class OperationCommandMultiply extends AbstractOperationCommand {

    public OperationCommandMultiply(String identifier, String description, Database database) {
        super(identifier, description, database);
        super.abstractTaskService = new MultiplyTaskService(database);

    }

}
