package org.example.commands.operation;

import org.example.service.DivisionService;

public class CommandDivision extends OperationCommand {
    public CommandDivision(String identifier, String description) {
        super(identifier, description);
        super.taskService = new DivisionService();
    }

}