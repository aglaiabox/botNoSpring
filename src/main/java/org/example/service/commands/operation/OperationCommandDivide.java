package org.example.service.commands.operation;

import org.example.database.Database;
import org.example.service.generateTask.DivideTaskService;

public class OperationCommandDivide extends AbstractOperationCommand {
    public OperationCommandDivide(String identifier, String description, Database database) {
        super(identifier, description, database);
        super.abstractTaskService = new DivideTaskService(database);
    }

}