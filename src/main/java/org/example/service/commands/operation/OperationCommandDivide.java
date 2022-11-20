package org.example.service.commands.operation;

import org.example.service.generateTask.DivideTaskService;

public class OperationCommandDivide extends AbstractOperationCommand {
    public OperationCommandDivide(String identifier, String description) {
        super(identifier, description);
        super.abstractTaskService = new DivideTaskService();
    }

}