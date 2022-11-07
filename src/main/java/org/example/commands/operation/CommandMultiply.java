package org.example.commands.operation;

import org.example.service.MultiplyService;

public class CommandMultiply extends OperationCommand {

        public CommandMultiply(String identifier, String description) {
                super(identifier, description);
                super.taskService = new MultiplyService();

        }

}
