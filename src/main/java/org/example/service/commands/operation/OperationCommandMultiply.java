package org.example.service.commands.operation;

import org.example.database.Database;
import org.example.service.generateTask.MultiplyTaskService;

public class OperationCommandMultiply extends AbstractOperationCommand {

    public OperationCommandMultiply(String identifier, String description) {
        super(identifier, description);
        super.abstractTaskService = new MultiplyTaskService();

    }

}
