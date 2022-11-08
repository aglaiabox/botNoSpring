package org.example.commands.operation;

import org.example.database.Database;
import org.example.service.DivisionService;

public class CommandDivision extends OperationCommand {
    public CommandDivision(String identifier, String description, Database database) {
        super(identifier, description);
        super.taskService = new DivisionService(database);
    }

}