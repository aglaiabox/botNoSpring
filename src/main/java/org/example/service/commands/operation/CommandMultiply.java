package org.example.service.commands.operation;

import org.example.database.Database;
import org.example.service.MultiplyService;

public class CommandMultiply extends OperationCommand {

        public CommandMultiply(String identifier, String description, Database database) {
                super(identifier, description);
                super.taskService = new MultiplyService(database);

        }

}
